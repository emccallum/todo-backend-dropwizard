package emccallum.resource

import org.specs2.mutable.Specification
import emccallum.representations.{TodoRepresentation, NewTodoRepresentation, TodosRepresentation }
import emccallum.model.Todo
import org.specs2.specification.Scope
import emccallum.repositories.TodoRepository
import org.specs2.mock.Mockito
import java.util.UUID

class TodoResourceSpec extends Specification with Mockito {

  trait TodoScope extends Scope {
    val mockTodoRepository = mock[TodoRepository]
    mockTodoRepository.retrieveAll() returns Seq.empty
  }

  "TodoResource" should {
    "return a 200 if the GET is successful" in new TodoScope {
      // Given
      val resource = new TodoResource(todoRepository = mockTodoRepository)

      // When
      val response = resource.retrieveAll()

      // Then
      response.getStatus shouldEqual 200
      response.getEntity shouldEqual TodosRepresentation(Seq.empty)
    }

    "return a 201 if the POST is successful" in new TodoScope {
      // Given
      val title = "todo"
      val resource = new TodoResource(todoRepository = mockTodoRepository)

      // When
      val response = resource.create(NewTodoRepresentation(title = title))

      // Then
      response.getStatus shouldEqual 201
      response.getEntity should beAnInstanceOf[TodoRepresentation]
    }

    "return a 204 if the DELETE is successful" in new TodoScope {
      // Given
      val resource = new TodoResource(todoRepository = mockTodoRepository)
      resource.create(NewTodoRepresentation("todo"))

      // When
      val response = resource.deleteAll()

      // Then
      response.getStatus shouldEqual 204
    }

    "POSTing a todo adds a todo" in new TodoScope {
      // Given
      val resource = new TodoResource(todoRepository = mockTodoRepository)

      // When
      resource.create(NewTodoRepresentation(title = "title"))

      // Then
      there was one(mockTodoRepository).addTodo(Todo(any[UUID], title = "title", url = "some-url"))
    }

    "GET should return all todos" in new TodoScope {
      // Given
      val todo = Todo(UUID.fromString("067e6162-3b6f-4ae2-a171-2470b63dff00"), "title", "some-url")
      mockTodoRepository.retrieveAll() returns Seq(todo)
      val resource = new TodoResource(todoRepository = mockTodoRepository)

      // When
      val response = resource.retrieveAll()

      // Then
      response.getEntity shouldEqual TodosRepresentation(Seq(todo))
    }

    "DELETE should remove all todos" in new TodoScope {
      // Given
      val todo = Todo(UUID.fromString("067e6162-3b6f-4ae2-a171-2470b63dff00"), "title", "some-url")
      mockTodoRepository.retrieveAll() returns Seq(todo)
      val resource = new TodoResource(todoRepository = mockTodoRepository)

      // When
      val response = resource.deleteAll()

      // Then
      there was one(mockTodoRepository).deleteAll()
    }
  }

}
