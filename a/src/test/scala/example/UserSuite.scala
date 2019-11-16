package example

import org.junit.Test


class UserSuite {

  @Test
  def susan(): Unit= {
    val user = User("Susan")
    println(user)
    assert(user.name.startsWith("Susan"))
  }

  @Test
  def john(): Unit = {
    val user = User("John")
    println(user)
    assert(user.name.startsWith("John"))
  }
}
