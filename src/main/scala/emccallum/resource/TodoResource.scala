package emccallum.resource

import javax.ws.rs.core.{MediaType, Response}
import javax.ws.rs._
import java.net.URI
import emccallum.representations.{TodosRepresentation, TodoRepresentation, NewTodoRepresentation}
import emccallum.model.Todo

@Path("/")
@Consumes(Array(MediaType.APPLICATION_JSON))
@Produces(Array(MediaType.APPLICATION_JSON))
class TodoResource() {

  @GET
  def retrieve(): Response = {
    Response.ok().entity(TodosRepresentation(Seq.empty)).build()
  }

  @POST
  def create(newTodo: NewTodoRepresentation): Response = {
    val todo = Todo(newTodo.title)
    Response.created(URI.create("")).entity(TodoRepresentation(todo)).build()
  }

  @DELETE
  def delete(title: String): Response = {
    Response.noContent().build()
  }

}
