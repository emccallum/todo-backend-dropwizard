package emccallum.representations

import com.fasterxml.jackson.annotation.JsonProperty
import emccallum.model.Todo

case class TodoRepresentation(private val todo: Todo) {
  @JsonProperty("id")
  lazy val id = todo.id

  @JsonProperty("title")
  lazy val title = todo.title

  @JsonProperty("completed")
  lazy val completed = todo.completed

  @JsonProperty("url")
  lazy val url = todo.url
}
