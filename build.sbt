inThisBuild(
  Vector(
    scalaVersion := "2.12.10"
  )
)

lazy val a = project
  .settings(
    addCompilerPlugin(
      "org.scalameta" % "semanticdb-scalac" % "4.2.5" cross CrossVersion.full
    ),
    javaOptions += s"-Duser.dir=${baseDirectory.in(ThisBuild).value}",
    testFrameworks += new TestFramework("utest.runner.Framework"),
    testFrameworks += new TestFramework("munit.Framework"),
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v"),
    resolvers += Resolver.bintrayRepo("cibotech", "public"),
    libraryDependencies ++= List(
      "com.swoval" % "file-tree-views" % "2.1.3",
      "com.cibo" %% "evilplot" % "0.6.3",
      "org.scalatest" %% "scalatest" % "3.1.0" % Test,
      "org.scalameta" %% "munit" % "0.4.3" % Test,
      "com.lihaoyi" %% "utest" % "0.7.1" % Test,
      "com.novocode" % "junit-interface" % "0.11" % Test,
      "org.scalameta" % "semanticdb-scalac-core" % "4.2.5" cross CrossVersion.full,
      "com.lihaoyi" %% "os-lib" % "0.4.2",
      "com.lihaoyi" %% "pprint" % "0.5.6",
      "com.lihaoyi" %% "ujson" % "0.8.0",
      "org.twitter4j" % "twitter4j-core" % "4.0.7",
      "org.scalameta" %% "scalameta" % "4.2.5"
    )
  )
