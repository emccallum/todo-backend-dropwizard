package emccallum.resource

import org.specs2.mutable.Specification
import emccallum.representations.{TodoRepresentation, NewTodoRepresentation}
import emccallum.model.Todo

class TodoResourceSpec extends Specification {

  "TodoResource" should {
    "return a 200 if the GET is successful" in {
      // Given
      val resource = new TodoResource()

      // When
      val response = resource.retrieve()

      // Then
      response.getStatus shouldEqual 200
    }

    "return a 201 if the POST is successful" in {
      // Given
      val todo = Todo(title = "todo")
      val resource = new TodoResource()

      // When
      val response = resource.create(NewTodoRepresentation(title = todo.title))

      // Then
      response.getStatus shouldEqual 201
      response.getEntity shouldEqual TodoRepresentation(todo)
    }

    "return a 204 if the DELETE is successful" in {
      // Given
      val resource = new TodoResource()
      resource.create(NewTodoRepresentation("todo"))

      // When
      val response = resource.delete("todo")

      // Then
      response.getStatus shouldEqual 204
    }
  }

}
