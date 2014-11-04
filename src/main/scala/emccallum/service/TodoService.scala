package emccallum.service

import io.dropwizard.setup.{Environment, Bootstrap}
import com.massrelevance.dropwizard.ScalaApplication
import com.massrelevance.dropwizard.bundles.ScalaBundle
import emccallum.resource.TodoResource
import org.eclipse.jetty.servlets.CrossOriginFilter
import javax.servlet.{Filter, DispatcherType}
import java.util
import com.sun.jersey.api.core.ResourceConfig

object TodoService extends ScalaApplication[TodoServiceConfiguration] {
  def initialize(bootstrap: Bootstrap[TodoServiceConfiguration]) {
    bootstrap.addBundle(new ScalaBundle)
  }

  override def run(configuration: TodoServiceConfiguration, environment: Environment): Unit = {
    addCorsHeader(environment)
    environment.jersey().register(new TodoResource())
    environment.jersey().property(ResourceConfig.PROPERTY_CONTAINER_RESPONSE_FILTERS, classOf[Filter])
  }

  private def addCorsHeader(environment: Environment) {
    val filter = environment.servlets().addFilter("CORS", classOf[CrossOriginFilter])
    filter.addMappingForUrlPatterns(util.EnumSet.allOf(classOf[DispatcherType]), true, "/*")
    filter.setInitParameter("allowedOrigins", "*")
    filter.setInitParameter("allowedMethods", "GET,PUT,POST,DELETE,OPTIONS,HEAD,PATCH")
  }
}