package example

import org.scalatest.FunSuite
import scala.collection.mutable
import java.{util => ju}
import java.nio.file.Files

object Main extends App {
  println("HELLO WORLD!")
  println("HELLO WORLD!")
  println("HELLO WORLD!")
  println("HELLO WORLD!")
}

class BarTest extends FunSuite {

  test("foo") {
    println("YEY")

    val a = """
    |
    | class BarTest extends FunSuite {
    |
    |  test("foo") {
    |    println("YEY")
    |   Message
    |Message 2
    |Message 3
    |Message
    |
    |""".stripMargin

    val b = """
    |Message
    |Message 2
    |Message 3
    |
    |
    |""".stripMargin

    // while (true) {
    //   println(s"loop ${i.length()} ${i.length()}")
    //   i += 1
    // }
    assert(false, "ERROR")
  }
}
