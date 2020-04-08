import $ivy.`com.fasterxml.jackson.core:jackson-databind:2.10.2`
import com.fasterxml.jackson.core._
import com.fasterxml.jackson.databind._

class Foo {
  @scala.beans.BeanProperty
  var a: Int = _

  @scala.beans.BeanProperty
  var b: String = _

  @scala.beans.BeanProperty
  var c: Array[String] = _
}


val foo = new Foo()
foo.a = 42
foo.b ="Hello!"
foo.c = Array("a", "B")
val mapper = new ObjectMapper()

println(mapper.writeValueAsString(foo))

