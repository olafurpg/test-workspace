inThisBuild(
  Vector(
    scalaVersion := "2.12.10",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
    libraryDependencies += "com.lihaoyi" %% "utest" % "0.7.1" % Test,
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test,
    testFrameworks += new TestFramework("utest.runner.Framework"),
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v"),
    addCompilerPlugin(
      "org.scalameta" % "semanticdb-scalac" % "4.2.5" cross CrossVersion.full
    )
  )
)

lazy val a = project
  .settings(
    libraryDependencies ++= List(
      "org.scalameta" % "semanticdb-scalac-core" % "4.2.5" cross CrossVersion.full,
      "com.lihaoyi" %% "os-lib" % "0.4.2",
      "com.lihaoyi" %% "pprint" % "0.5.6",
      "com.lihaoyi" %% "ujson" % "0.8.0",
      "org.scalameta" %% "scalameta" % "4.2.5"
    )
  )
