import twitter4j.OEmbedRequest
import twitter4j.Query
import twitter4j.TwitterFactory
import scala.collection.JavaConverters._

val twitter = TwitterFactory.getSingleton();

twitter.getUserTimeline().asScala.head.getGeoLocation()

twitter
  .getOEmbed(
    new OEmbedRequest(
      1223655109240020992L,
      "https://twitter.com/olafurpg/status/1223655109240020992"
    )
  )
  .getHtml()

twitter
  .search()
  .search(new Query("scala metals -metal"))
  .getTweets()
  .asScala
  .map(_.getText())
