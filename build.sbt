// default scala version for all subprojects.
scalaVersion in ThisBuild := "2.11.7"

// dummy project that is just meant to illustrate the need for multiple scalaVersions
lazy val library = project.in(file("library"))

// This project won't compile unless you uncomment the scalaVersion setting.
// If you change the scalaVersion for the sbt-plugins project, however, then gen-ensime
// does not work.
lazy val plugins = project.in(file("sbt-plugins")).settings(
  sbtPlugin := true//,
  //scalaVersion := "2.10.5" // if you don't do this, the plugin project won't compile
)
