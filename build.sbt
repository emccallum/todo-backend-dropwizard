import sbtassembly.Plugin.AssemblyKeys._

assemblySettings

name := "hello-dropwizard"

scalaVersion := "2.10.2"

resolvers ++= Seq(
   "Coda Hale repo" at "http://repo.codahale.com/"
 )

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "io.dropwizard" % "dropwizard-core" % "0.7.1",
  "com.massrelevance" %% "dropwizard-scala" % "0.7.1"
)

mainClass in assembly := Some("com.hellodropwizard.service.SimpleService")
