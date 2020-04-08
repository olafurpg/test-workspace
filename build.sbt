def scala212 = "2.12.11"
inThisBuild(
  Vector(
    scalaVersion := scala212,
    scalacOptions += "-Yrangepos"
  )
)

lazy val b = project
  .settings(
    scalaVersion := scala212
  )
lazy val a = project
  .settings(
    scalaVersion := scala212,
    testFrameworks += new TestFramework("utest.runner.Framework"),
    testFrameworks += new TestFramework("munit.Framework"),
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v"),
    resolvers += Resolver.bintrayRepo("cibotech", "public"),
    libraryDependencies ++= List(
      "com.swoval" % "file-tree-views" % "2.1.3",
      "org.scalatest" %% "scalatest" % "3.1.0" % Test,
      "org.scalameta" %% "munit" % "0.7.2" % Test,
      "org.scalameta" %% "mdoc" % "2.1.1",
      "com.lihaoyi" %% "utest" % "0.7.1" % Test,
      "com.novocode" % "junit-interface" % "0.11" % Test,
      "com.lihaoyi" %% "os-lib" % "0.4.2",
      "com.lihaoyi" %% "pprint" % "0.5.6",
      "com.lihaoyi" %% "ujson" % "0.8.0",
      "org.twitter4j" % "twitter4j-core" % "4.0.7",
      "org.scalameta" %% "scalameta" % "4.2.5"
    )
  )
