package emccallum.model

import java.util.UUID

case class Todo(id: UUID, title: String, url: String, completed: Boolean = false) { }
