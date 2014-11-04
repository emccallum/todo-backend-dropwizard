package emccallum.resource

import javax.ws.rs.core.{MediaType, Response}
import javax.ws.rs._
import java.net.URI
import com.fasterxml.jackson.annotation.JsonProperty
import emccallum.model.Todo

@Path("/")
@Consumes(Array(MediaType.APPLICATION_JSON))
@Produces(Array(MediaType.APPLICATION_JSON))
class TodoResource() {

  @GET
  def retrieve(): Response = {
    Response.ok().entity("helllo").build()
  }

  @POST
  def create(newTodo: TodoRepresentation): Response = {
    Response.created(URI.create("")).build()
  }

}

case class TodoRepresentation(private val todo: Todo) {
  @JsonProperty("title")
  lazy val title = todo.title
}
