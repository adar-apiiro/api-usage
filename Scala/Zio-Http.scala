import zio._
import zhttp.http._
import zhttp.service.Server

object ZioHttpApp extends ZIOAppDefault {
  val app = Http.collect[Request] {
    case Method.GET -> !! / "hello" => Response.text("Hello, ZIO HTTP!")
  }

  val run = Server.start(8080, app)
}
