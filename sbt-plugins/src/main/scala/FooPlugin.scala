package foo

import sbt._
import sbt.Keys._

object FooPlugin extends AutoPlugin {
  override def projectSettings = Seq(
    libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1200-jdbc41"
  )
}
