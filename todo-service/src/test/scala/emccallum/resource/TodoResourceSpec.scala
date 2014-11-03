package scala.emccallum.resource

import org.specs2.mutable.Specification

class TodoResourceSpec extends Specification {

  "TodoResource" should {
    "include cross origin headers in the response for a GET request" in {
      // Given
      val resource = new TodoResource()

      // When
      val response = resource.sayHello()

      // Then
      response.getStatus shouldEqual 200
      response.getMetadata.get("access-control-allow-origin").get(0) shouldEqual "*"
      response.getMetadata.get("access-control-allow-headers").get(0) shouldEqual true
    }
  }

}
