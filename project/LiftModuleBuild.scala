import sbt._
import sbt.Keys._

object LiftModuleBuild extends Build {

  val liftVersion = SettingKey[String]("liftVersion", "Version number of the Lift Web Framework")

  val liftEdition = SettingKey[String]("liftEdition", "Lift Edition (short version number to append to artifact name)")

  val project = Project("lift-scrollax-module", file("."))

  lazy val baseSettings = Defaults.defaultSettings

  lazy val parentSettings = baseSettings ++ Seq(
    publishArtifact in Compile := false
  )

  /*
  lazy val myBuildInfoSettings = buildInfoSettings ++ Seq(
          sourceGenerators in Compile <+= buildInfo,
          buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion)//,
          //buildInfoPackage := "net.liftmodules.FoBo.lib"
      )
  */

  lazy val defaultSettings = baseSettings ++ Seq(description := "Scrollax", parallelExecution in Test := false)

}
