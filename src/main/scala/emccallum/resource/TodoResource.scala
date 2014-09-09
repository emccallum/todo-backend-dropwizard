package emccallum.resource

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@Path("/")
class TodoResource(val defaultName: String) {

  @GET
  def sayHello(): Response =
    Response.ok().build()

}