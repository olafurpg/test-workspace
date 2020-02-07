import twitter4j.OEmbedRequest
import twitter4j.Query
import twitter4j.TwitterFactory
import com.vladsch.flexmark.parser.Parser
import com.vladsch.flexmark.html.HtmlRenderer
import scala.collection.JavaConverters._
val markdown =
  """

# Welcome!

This is my blog.

* Bullet lists!
* Bullet lists!!

TWITTER:https://twitter.com/jack/status/969234275420655616
"""

val id = ".*/(\\d+)$".r
def getId(url: String): Long = url match {
  case id(n) => n.toLong
  case _     => throw new IllegalArgumentException(url)
}

def embedTweet(url: String): String = {
  twitter
    .getOEmbed(new OEmbedRequest(getId(url), url))
    .getHtml()
    .linesIterator
    .next()
}

def processMarkdown(markdown: String): String =
  markdown.linesIterator
    .map {
      case s"TWITTER:$url" => embedTweet(url)
      case line            => line
    }
    .mkString("\n")

def renderHtml(markdown: String): String = {
  val processed = processMarkdown(markdown)
  val parsed = Parser.builder().build().parse(processed)
  val body = HtmlRenderer.builder().build().render(parsed)
  val head = """<head><meta charset="UTF-8"></head>"""
  head + body
}

val twitter = TwitterFactory.getSingleton()

val in = os.pwd / "in"
val out = os.pwd / "out"

os.list(in)
  .filter(_.ext == "md")
  .map { file =>
    val markdown = os.read(file)
    val html = renderHtml(markdown)
    val filename = file.baseName + ".html"
    val target = out / filename
    os.write.over(target, html, createFolders = true)
    target -> html
  }

val url = "https://twitter.com/jack/status/969234275420655616"
