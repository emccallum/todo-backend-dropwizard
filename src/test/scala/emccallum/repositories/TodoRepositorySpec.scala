package emccallum.repositories

import org.specs2.mutable.Specification
import emccallum.model.Todo

class TodoRepositorySpec extends Specification {

  "TodoRepository" should {

    "return all todos" in {
      // Given
      val repository = new TodoRepository
      repository.todos = Seq(Todo("title", "some-url"))

      // When
      val todos = repository.retrieveAll()

      // Then
      todos shouldEqual Seq(Todo("title", "some-url"))
    }

    "add a new todo" in {
      // Given
      val repository = new TodoRepository
      repository.todos = Seq.empty
      val expectedTodo = Todo("some-title", "some-url")

      // When
      repository.addTodo(expectedTodo)

      // Then
      repository.todos shouldEqual Seq(expectedTodo)
    }
  }

}
