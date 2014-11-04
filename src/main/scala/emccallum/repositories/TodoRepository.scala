package emccallum.repositories

import emccallum.model.Todo

class TodoRepository {

  private var todos: Seq[Todo] = Seq.empty

  def retrieveAll(): Seq[Todo] = ???

}
