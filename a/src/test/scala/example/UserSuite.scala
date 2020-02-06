package example

import utest._

object Test {
  def helloWorld(): Unit = {
    System.out.println("Hello world!")
  }
}

class MUnitSuite extends munit.FunSuite {
  test("hello-world") {
    Test.helloWorld()
  }
}

object UtestSuite extends TestSuite {
  def sleep() = Thread.sleep(100)
  override val tests = utest.Tests {
    test("hello-world") {
      Test.helloWorld()
    }
  }
}

class JUnitSuite {
  @org.junit.Test
  def helloWorld(): Unit = {
    Test.helloWorld()
  }
}

class ScalatestSuite extends org.scalatest.funsuite.AnyFunSuite {

  test("hello-world") {
    Test.helloWorld()
  }

}
