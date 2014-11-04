package emccallum.resource

import javax.ws.rs.core.Response
import javax.ws.rs.{Path, GET}
import javax.ws.rs.core.Response.ResponseBuilder

@Path("/")
class TodoResource() {

  @GET
  def sayHello(): Response = {
    Response
      .ok()
      .entity("helllo")
      .build()
  }

}
