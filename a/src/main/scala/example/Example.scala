package example

import scala.meta.internal.io.PathIO

case class Foo(a: Int, b: String, c: List[Foo])

object Util extends App {
  def b = 42
  def bar = 56
  def foo[T: Ordering](x: T): Int = 42
  pprint.log(PathIO.workingDirectory)
  pprint.log(Foo(1, "", Nil))
  pprint.log(Foo(1, "", Nil))
}
