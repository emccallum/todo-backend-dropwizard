package emccallum.representations

import com.fasterxml.jackson.annotation.JsonProperty

case class NewTodoRepresentation(@JsonProperty("title") title: String)
