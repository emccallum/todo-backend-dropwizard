package emccallum.service

import io.dropwizard.setup.{Environment, Bootstrap}
import com.massrelevance.dropwizard.ScalaApplication
import com.massrelevance.dropwizard.bundles.ScalaBundle
import emccallum.resource.TodoResource

object TodoService extends ScalaApplication[TodoServiceConfiguration] {
  def initialize(bootstrap: Bootstrap[TodoServiceConfiguration]) {
    bootstrap.addBundle(new ScalaBundle)
  }

  override def run(configuration: TodoServiceConfiguration, environment: Environment): Unit = {
    environment.jersey().register(new TodoResource())
  }
}