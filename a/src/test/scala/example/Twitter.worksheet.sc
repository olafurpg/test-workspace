import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import com.vladsch.flexmark.util.options.MutableDataSet
import mdoc.internal.markdown.Markdown
import twitter4j.OEmbedRequest
import os.Path
import twitter4j.Query
import twitter4j.TwitterFactory
import scala.collection.JavaConverters._

def embedHtml(url: String): String = {
  val twitter = TwitterFactory.getSingleton()
  val urlID = "https://.*/(\\d+)$".r
  val id = url match {
    case urlID(id) => id.toLong
    case _         => throw new IllegalArgumentException(url)
  }
  twitter.getOEmbed(new OEmbedRequest(id, url)).getHtml()
}

def processString(markdown: String): String = {
  markdown.linesIterator
    .map {
      case s"TWITTER:$url" => embedHtml(url).linesIterator.take(1).mkString
      case line            => line
    }
    .mkString("\n")
}

def renderHtm(markdown: String): String =
  """<head><meta charset="UTF-8"></head> """ +
    HtmlRenderer
      .builder()
      .build()
      .render(Parser.builder().build().parse(markdown))

def processDirectory(in: Path, out: Path) = {
  os.walk(in)
    .filter(_.ext == "md")
    .map { markdownIn =>
      val filename = markdownIn.baseName + ".html"
      val relpath = markdownIn.relativeTo(in) / os.up / filename
      val markdownOut = out / relpath
      val markdown = os.read(markdownIn)
      val processedMarkdown = processString(markdown)
      val html = renderHtm(processedMarkdown)
      os.write.over(markdownOut, html, createFolders = true)
      markdownOut -> html
    }
}

val in = os.pwd / "in"
val out = os.pwd / "out"

processDirectory(in, out)
