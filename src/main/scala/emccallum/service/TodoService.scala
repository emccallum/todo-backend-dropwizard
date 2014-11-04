package emccallum.service

import io.dropwizard.setup.{Environment, Bootstrap}
import com.massrelevance.dropwizard.ScalaApplication
import com.massrelevance.dropwizard.bundles.ScalaBundle
import emccallum.resource.TodoResource
import org.eclipse.jetty.servlets.CrossOriginFilter

object TodoService extends ScalaApplication[TodoServiceConfiguration] {
  def initialize(bootstrap: Bootstrap[TodoServiceConfiguration]) {
    bootstrap.addBundle(new ScalaBundle)
  }

  override def run(configuration: TodoServiceConfiguration, environment: Environment): Unit = {
    environment.jersey().register(new TodoResource())
    addCorsHeader(environment)
  }

  private def addCorsHeader(environment: Environment) {
    val filter = environment.servlets().addFilter("CORS", classOf[CrossOriginFilter])
    filter.setInitParameter("allowedOrigins", "*")
    filter.setInitParameter("allowedMethods", "GET,PUT,POST,DELETE,OPTIONS,HEAD,PATCH")
  }
}