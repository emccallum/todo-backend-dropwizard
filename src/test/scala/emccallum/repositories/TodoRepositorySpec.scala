package emccallum.repositories

import org.specs2.mutable.Specification
import emccallum.model.Todo
import java.util.UUID

class TodoRepositorySpec extends Specification {

  "TodoRepository" should {

    "return all todos" in {
      // Given
      val repository = new TodoRepository
      val todoId = UUID.randomUUID
      val expectedTodo = Todo(todoId, "some-title", "some-url")
      repository.todos = Seq(expectedTodo)

      // When
      val todos = repository.retrieveAll()

      // Then
      todos shouldEqual Seq(expectedTodo)
    }

    "add a new todo" in {
      // Given
      val repository = new TodoRepository
      repository.todos = Seq.empty
      val todoId = UUID.randomUUID
      val expectedTodo = Todo(todoId, "some-title", "some-url")

      // When
      repository.addTodo(expectedTodo)

      // Then
      repository.todos shouldEqual Seq(expectedTodo)
    }
  }

}
