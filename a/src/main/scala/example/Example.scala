package example

import scala.meta.internal.io.PathIO

object Util extends App {
  pprint.log(PathIO.workingDirectory)
}
