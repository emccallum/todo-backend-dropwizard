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
  }

}
