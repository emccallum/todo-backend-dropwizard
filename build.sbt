import sbtassembly.Plugin.AssemblyKeys._

assemblySettings

name := "hello-dropwizard"

scalaVersion := "2.10.1"

sbtVersion := "0.13.1"

resolvers ++= Seq(
   "Coda Hale repo" at "http://repo.codahale.com/"
 )

resolvers += Classpaths.typesafeReleases

addSbtPlugin("com.typesafe.sbt" %% "sbt-start-script" % "0.10.0")

libraryDependencies ++= Seq(
  "io.dropwizard" % "dropwizard-core" % "0.7.1",
  "com.massrelevance" %% "dropwizard-scala" % "0.7.1"
)

mainClass in assembly := Some("com.hellodropwizard.service.SimpleService")
