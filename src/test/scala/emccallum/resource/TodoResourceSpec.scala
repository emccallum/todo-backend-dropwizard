package emccallum.resource

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
      response.getMetadata.get("Access-Control-Allow-Origin").get(0) shouldEqual "*"
      response.getMetadata.get("Access-Control-Allow-Headers").get(0) shouldEqual "origin, content-type, accept, authorization"
    }
  }

}
