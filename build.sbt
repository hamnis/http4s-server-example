inThisBuild(
  Seq(
    organization := "org.http4s",
    crossScalaVersions := Seq("2.13.5"),
    scalaVersion := crossScalaVersions.value.head,
    testFrameworks += new TestFramework("munit.Framework"),
    addCompilerPlugin(("org.typelevel" % "kind-projector" % "0.11.3").cross(CrossVersion.full)),
    addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
 )
)

val http4sVersion = "0.21.22"
val netty = "0.3.0"
val finagle = "0.21.22-21.3.0"

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

run / fork := true
addCommandAlias("netty", "runMain example.NettyTestServer")
addCommandAlias("blaze", "runMain example.BlazeTestServer")
addCommandAlias("finagle", "runMain example.FinagleTestServer")
addCommandAlias("ember", "runMain example.EmberTestServer")
addCommandAlias("jetty", "runMain example.JettyTestServer")
addCommandAlias("tomcat", "runMain example.TomcatTestServer")
