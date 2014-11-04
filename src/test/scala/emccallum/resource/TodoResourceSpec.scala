package emccallum.resource

import org.specs2.mutable.Specification
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
      val todo = Todo("hello")
      val resource = new TodoResource()

      // When
      val response = resource.create(TodoRepresentation(todo))

      // Then
      response.getStatus shouldEqual 201
    }
  }

}
