package emccallum.repositories

import org.specs2.mutable.Specification
import emccallum.model.Todo

class TodoRepositorySpec extends Specification {

  "TodoRepository" should {

    "return all todos" in {
      // Given
      val repository = new TodoRepository
      repository.todos = Seq(Todo("title"))

      // When
      val todos = repository.retrieveAll()

      // Then
      todos shouldEqual Seq(Todo("title"))
    }

    "add a new todo" in {
      // Given
      val repository = new TodoRepository
      repository.todos = Seq.empty
      val expectedTodo = Todo("some-title")

      // When
      repository.addTodo(expectedTodo)

      // Then
      repository.todos shouldEqual Seq(expectedTodo)
    }
  }

}
