package scala.emccallum.resource

import javax.ws.rs.core.Response
import javax.ws.rs.{Path, GET}

@Path("/")
class TodoResource() {

  @GET
  def sayHello(): Response =
    Response.ok().header("access-control-allow-origin", "*").header("access-control-allow-headers", true).build()

}
