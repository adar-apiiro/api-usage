import com.twitter.finagle.Http
import com.twitter.finagle.http.{Request, Response}
import com.twitter.util.{Await, Future}
import com.twitter.finagle.http.path._
import com.twitter.finagle.http.service.RoutingService

object FinagleServer extends App {
  val service = RoutingService.byMethodAndPathObject[Request] {
    case (Method.Get, Root / "hello") =>
      Service.mk { _: Request =>
        Future.value(Response(Version.Http11, Status.Ok, Buf.Utf8("Hello, Finagle!")))
      }
  }

  val server = Http.serve(":8080", service)
  Await.ready(server)
}
