package emccallum.representations

import com.fasterxml.jackson.annotation.JsonProperty
import emccallum.model.Todo

case class TodosRepresentation(private val todos: Seq[Todo]) {
  @JsonProperty("todos")
  lazy val todoRepresentations = todos.map(TodoRepresentation)
}
