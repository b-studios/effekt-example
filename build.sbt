lazy val scala = project
  .in(file("scala-effekt"))
  .settings(moduleName := "scala")
  .settings(name := "scala-effekt")
  .settings(scalaSettings: _*)

lazy val dotty = project
  .in(file("dotty-effekt"))
  .settings(moduleName := "dotty")
  .settings(name := "dotty-effekt")
  .settings(dottySettings: _*)

lazy val commonSettings = Seq(
  resolvers += Resolver.sonatypeRepo("snapshots"),
  resolvers += "Sonatype OSS Snapshots" at
    "https://oss.sonatype.org/content/repositories/releases",

  initialCommands in console := "import effekt._; import helloWorld._;"
)

lazy val scalaSettings = commonSettings ++ Seq(

  scalaVersion := "2.12.4",

  libraryDependencies ++= Seq(
    "de.b-studios" %% "effekt" % "0.3-SNAPSHOT",
    "de.b-studios" %% "effekt-effects" % "0.3-SNAPSHOT"
  )
)
lazy val dottySettings = commonSettings ++ Seq(

  scalaVersion := "0.4.0-RC1",

  // this project uses the dotty variant of Effekt in a slightly older version
  libraryDependencies ++= Seq("de.b-studios" % "effekt_0.4" % "0.1.1-SNAPSHOT")
)
