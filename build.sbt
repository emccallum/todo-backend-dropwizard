import com.typesafe.sbt.SbtStartScript
import sbtassembly.Plugin.AssemblyKeys._
import com.typesafe.sbt.SbtStartScript.settings

assemblySettings

name := "hello-dropwizard"

scalaVersion := "2.10.2"

resolvers ++= Seq(
   "Coda Hale repo" at "http://repo.codahale.com/"
 )

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

resolvers +="Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Sonatype Release Repository" at "http://oss.sonatype.org/content/repositories/releases"

resolvers += "Bintray Repo" at "http://dl.bintray.com/scalaz/releases/"

libraryDependencies ++= Seq(
  "io.dropwizard" % "dropwizard-core" % "0.7.1",
  "com.massrelevance" %% "dropwizard-scala" % "0.7.1",
  "org.specs2" %% "specs2" % "2.4.9" % "test"
)

seq(SbtStartScript.startScriptForClassesSettings: _*)

mainClass in assembly := Some("scala.emccallum.service.TodoService")
