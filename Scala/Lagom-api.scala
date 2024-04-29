import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}
import com.lightbend.lagom.scaladsl.server.{LagomApplicationContext, LagomApplicationLoader}
import com.lightbend.lagom.scaladsl.api.Service.restCall
import com.lightbend.lagom.scaladsl.api.transport.Method
import play.api.libs.ws.ahc.AhcWSComponents

trait HelloService extends Service {
  def hello: ServiceCall[String, String]

  override final def descriptor = {
    import Service._
    named("hello-service")
      .withCalls(
        restCall(Method.GET, "/api/hello/:id", hello _)
      )
      .withAutoAcl(true)
  }
}

class HelloServiceImpl extends HelloService {
  override def hello = ServiceCall { id =>
    Future.successful(s"Hello, $id!")
  }
}

class HelloApplicationLoader extends LagomApplicationLoader {
  override def load(context: LagomApplicationContext) =
    new HelloApplication(context) with AhcWSComponents
}

abstract class HelloApplication(context: LagomApplicationContext)
  extends LagomApplication(context)
    with AhcWSComponents {
  override lazy val lagomServer = serverFor[HelloService](new HelloServiceImpl)
}
