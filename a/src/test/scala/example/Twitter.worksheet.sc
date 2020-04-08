import example.Test
import twitter4j.OEmbedRequest
import scala.collection.JavaConverters._
import twitter4j.Query
import twitter4j.TwitterFactory
import com.vladsch.flexmark.parser.Parser
import com.vladsch.flexmark.html.HtmlRenderer
val markdown =
  """
# Hello world!

Bullets!

* Hello
* Goodbye

TWITTER:https://twitter.com/jack/status/969234275420655616
"""

def renderHtml(markdown: String): String = {
  val node = Parser.builder().build().parse(markdown)
  val head = """<head><meta charset="UTF-8"></head>"""
  val body = HtmlRenderer.builder().build().render(node)
  head + body
}

val twitter = TwitterFactory.getSingleton

twitter.search(new Query("London Twitter")).getTweets().asScala.map(_.getText())

def getId(url: String): Long = {
  val urlID = ".*/(\\d+)$".r
  val urlID(n) = url
  n.toLong
}

def embedHtml(url: String): String = {
  twitter
    .getOEmbed(new OEmbedRequest(getId(url), url))
    .getHtml()
    .linesIterator
    .next()
}

def processMarkdown(markdown: String): String = {
  markdown.linesIterator
    .map {
      case s"TWITTER:$url" => embedHtml(url)
      case line            => line
    }
    .mkString("\n")
}

val url = "https://twitter.com/jack/status/969234275420655616"

// twitter.get
// processMarkdown(markdown)

os.list(os.pwd / "in")
  .filter(_.ext == "md")
  .map { file =>
    val text = os.read(file)
    val processed = processMarkdown(text)
    val html = renderHtml(processed)
    val filename = file.baseName + ".html"
    val target = os.pwd / "out" / filename
    os.write.over(target, html)
    file -> processed
  }

Test.helloWorld
