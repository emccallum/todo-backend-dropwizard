package emccallum.resource

import javax.ws.rs.core.Response
import javax.ws.rs.{POST, Path, GET}
import java.net.URI

@Path("/")
class TodoResource() {

  @GET
  def retrieve(): Response = {
    Response.ok().entity("helllo").build()
  }

  @POST
  def create(): Response = {
    Response.created(URI.create("")).build()
  }

}
