package emccallum.resource

import org.specs2.mutable.Specification
import emccallum.representations.{TodoRepresentation, NewTodoRepresentation}
import emccallum.model.Todo
import org.specs2.specification.Scope
import emccallum.repositories.TodoRepository
import org.specs2.mock.Mockito

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
      response.getEntity shouldEqual Seq.empty
    }

    "return a 201 if the POST is successful" in new TodoScope {
      // Given
      val todo = Todo(title = "todo")
      val resource = new TodoResource(todoRepository = mockTodoRepository)

      // When
      val response = resource.create(NewTodoRepresentation(title = todo.title))

      // Then
      response.getStatus shouldEqual 201
      response.getEntity shouldEqual TodoRepresentation(todo)
    }

    "return a 204 if the DELETE is successful" in new TodoScope {
      // Given
      val resource = new TodoResource(todoRepository = mockTodoRepository)
      resource.create(NewTodoRepresentation("todo"))

      // When
      val response = resource.delete("todo")

      // Then
      response.getStatus shouldEqual 204
    }

    "POSTing a todo adds a todo" in new TodoScope {
      // Given
      val resource = new TodoResource(todoRepository = mockTodoRepository)

      // When
      resource.create(NewTodoRepresentation(title = "title"))

      // Then
      there was one(mockTodoRepository).addTodo(Todo("title"))
    }

    "GET should return all todos" in new TodoScope {
      // Given
      val todo = Todo("title")
      mockTodoRepository.retrieveAll() returns Seq(todo)
      val resource = new TodoResource(todoRepository = mockTodoRepository)

      // When
      val response = resource.retrieveAll()

      // Then
      response.getEntity shouldEqual Seq(todo)
    }
  }

}
