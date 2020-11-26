inThisBuild(
  Seq(
    organization := "org.http4s",
    crossScalaVersions := Seq("2.13.4"),
    scalaVersion := crossScalaVersions.value.head,
    testFrameworks += new TestFramework("munit.Framework"),
    addCompilerPlugin(("org.typelevel" % "kind-projector" % "0.11.1").cross(CrossVersion.full)),
    addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
 )
)

val http4sVersion = "0.21.13"
val netty = "0.2.0"
val finagle = "0.21.11-20.10.0"

libraryDependencies ++= List(
  "org.http4s" %% "http4s-ember-server" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-tomcat" % http4sVersion,
  "org.http4s" %% "http4s-core" % http4sVersion,
  "org.http4s" %% "http4s-jetty" % http4sVersion,
  "org.http4s" %% "http4s-netty-server" % netty,
  "org.http4s" %% "http4s-finagle" % finagle,
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)

fork in run := true
addCommandAlias("netty", "runMain example.NettyTestServer")
addCommandAlias("blaze", "runMain example.BlazeTestServer")
addCommandAlias("finagle", "runMain example.FinagleTestServer")
addCommandAlias("ember", "runMain example.EmberTestServer")
addCommandAlias("jetty", "runMain example.JettyTestServer")
addCommandAlias("tomcat", "runMain example.TomcatTestServer")
