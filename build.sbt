import com.typesafe.sbt.SbtStartScript
import sbtassembly.Plugin.AssemblyKeys._
import com.typesafe.sbt.SbtStartScript.settings

scalaVersion := "2.10.2"

resolvers ++= Seq(
  "Coda Hale repo" at "http://repo.codahale.com/",
  "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
  "Sonatype Release Repository" at "http://oss.sonatype.org/content/repositories/releases",
  "Bintray Repo" at "http://dl.bintray.com/scalaz/releases/"
 )

seq(SbtStartScript.startScriptForClassesSettings: _*)

libraryDependencies ++= Seq(
  "io.dropwizard" % "dropwizard-core" % "0.7.1",
  "com.massrelevance" %% "dropwizard-scala" % "0.7.1",
  "org.specs2" %% "specs2" % "2.4.9"
)

mainClass in assembly := Some("emccallum.service.TodoService")
