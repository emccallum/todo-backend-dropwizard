package com.hellodropwizard.service

import io.dropwizard.setup.{Environment, Bootstrap}
import com.massrelevance.dropwizard.bundles.ScalaBundle
import com.massrelevance.dropwizard.ScalaApplication
import com.hellodropwizard.service.resources.HelloWorldResource

object SimpleService extends ScalaApplication[SimpleServiceConfiguration] {
  def initialize(bootstrap: Bootstrap[SimpleServiceConfiguration]) {
    bootstrap.addBundle(new ScalaBundle)
  }

  override def run(configuration: SimpleServiceConfiguration, environment: Environment): Unit = {
    environment.jersey().register(new HelloWorldResource("elise"))
  }
}