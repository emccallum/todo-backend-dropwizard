package emccallum.resource

import javax.ws.rs.core.{MediaType, Response}
import javax.ws.rs._
import java.net.URI
import emccallum.representations.{TodosRepresentation, TodoRepresentation, NewTodoRepresentation}
import emccallum.model.Todo
import emccallum.repositories.TodoRepository

@Path("/")
@Consumes(Array(MediaType.APPLICATION_JSON))
@Produces(Array(MediaType.APPLICATION_JSON))
class TodoResource(todoRepository: TodoRepository) {

  @GET
  def retrieveAll(): Response = {
    val todos = todoRepository.retrieveAll()
    Response.ok().entity(TodosRepresentation(todos)).build()
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
