package emccallum.repositories

import emccallum.model.Todo

class TodoRepository {

  var todos: Seq[Todo] = Seq.empty

  def retrieveAll(): Seq[Todo] = todos

}
