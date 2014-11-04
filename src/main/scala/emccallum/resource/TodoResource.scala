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
      .header("Access-Control-Allow-Origin", "*")
      .header("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Authorization")
      .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
      .entity("helllo")
      .build()
  }

}
