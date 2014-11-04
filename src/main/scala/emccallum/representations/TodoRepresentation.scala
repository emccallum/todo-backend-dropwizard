package emccallum.representations

import com.fasterxml.jackson.annotation.JsonProperty
import emccallum.model.Todo

case class TodoRepresentation(private val todo: Todo) {
  @JsonProperty("title")
  lazy val title = todo.title
}
