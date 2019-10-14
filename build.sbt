inThisBuild(
  Vector(
    scalaVersion := "2.12.10",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
    libraryDependencies += "com.lihaoyi" %% "utest" % "0.7.1" % Test,
    testFrameworks += new TestFramework("utest.runner.Framework")
  )
)
