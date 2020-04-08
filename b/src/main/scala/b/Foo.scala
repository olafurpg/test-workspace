object Main {

  def main(args: Array[String]) {

    val name: Option[String] = Some("Rob")

    name match {
      case None    => println("Hello <unknown>")
      case Some(x) => println(s"Hello $x")
    }
  }
}
