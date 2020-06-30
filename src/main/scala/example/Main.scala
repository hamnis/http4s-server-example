package example

import cats.effect.{ExitCode, IO, IOApp}
import org.http4s._
import org.http4s.implicits._
import org.http4s.netty.server.NettyServerBuilder
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.blaze.BlazeServerBuilder

object Main {
  val app = HttpRoutes
    .of[IO] {
      case req if req.method == Method.GET && req.pathInfo == "/hello" =>
        IO(Response(Status.Ok).withEntity("Hello World in " + Thread.currentThread().getName))
    }
    .orNotFound
}

object NettyTestServer extends IOApp {
  override def run(args: List[String]): IO[ExitCode] =
    NettyServerBuilder[IO].withHttpApp(Main.app).resource.use(_ => IO.never)
}

object BlazeTestServer extends IOApp {
  override def run(args: List[String]): IO[ExitCode] =
    BlazeServerBuilder[IO](concurrent.ExecutionContext.global)
      .withHttpApp(Main.app)
      .resource
      .use(_ => IO.never)

}

object EmberTestServer extends IOApp {
  override def run(args: List[String]): IO[ExitCode] =
    EmberServerBuilder
      .default[IO]
      .withPort(8080)
      .withMaxConcurrency(200) //tweak it
      .withHttpApp(Main.app)
      .build
      .use(_ => IO.never)
}
