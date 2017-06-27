package emccallum.resource

import javax.ws.rs.core.{MediaType, Response}
import javax.ws.rs._
import java.net.URI
import emccallum.representations.{TodoRepresentation, NewTodoRepresentation, TodosRepresentation}
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
    val todo = Todo(newTodo.title, "some-url")
    todoRepository.addTodo(todo)
    Response.created(URI.create("")).entity(TodoRepresentation(todo)).build()
  }

  @DELETE
  def deleteAll(): Response = {
    todoRepository.deleteAll()
    Response.noContent().build()
  }

}
