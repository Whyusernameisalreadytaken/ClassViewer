lazy val commonSettings = Seq(
  organization := "org.glavo",
  scalaVersion := "2.12.4"
)

lazy val root = (project in file("."))
  .settings(
    name := "ClassViewer",
    version := "4.0-SNAPSHOT",
    commonSettings
  ).dependsOn(gui)


lazy val jfx4s = (project in file("jfx4s"))
  .settings(
    name := "jfx4s",
    version := "0.1",
    commonSettings
  )

lazy val gui = (project in file("gui"))
  .settings(
    name := "ClassViewer-gui",
    version := "4.0",
    mainClass in assembly := Some("org.glavo.viewer.gui.Viewer"),
    commonSettings
  ).dependsOn(jfx4s, utils, common)

lazy val common = (project in file("common"))
  .settings(
    name := "ClassViewer-common",
    version := "4.0",
    commonSettings
  ).dependsOn(utils)

lazy val utils = (project in file("utils"))
  .settings(
    name := "ClassViewer-utils",
    version := "0.1",
    libraryDependencies += "org.fusesource.jansi" % "jansi" % "1.17",
    commonSettings
  )