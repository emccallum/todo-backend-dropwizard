package emccallum.representations

import emccallum.model.Todo
import com.fasterxml.jackson.annotation.JsonProperty

case class TodosRepresentation(@JsonProperty("todos") todos: Seq[Todo])
