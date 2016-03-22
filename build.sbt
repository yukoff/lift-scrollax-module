moduleName := "scrollax"

organization := "net.liftmodules"

version in ThisBuild := "1.0.0-SNAPSHOT"

liftVersion in ThisBuild <<= liftVersion ?? "2.6.3" // "3.0-RC1" //"2.6.3"

liftEdition in ThisBuild <<= liftVersion apply { _.substring(0,3) }

moduleName <<= (name, liftEdition) { (n, e) =>  n + "_" + e }

crossScalaVersions := Seq("2.11.7", "2.10.4", "2.9.2", "2.9.1-1", "2.9.1")

scalacOptions ++= Seq("-deprecation") // "-feature" can't be used as long as we build using 2.9.x

EclipseKeys.withSource := true

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Managed

parallelExecution in Test := false

resolvers ++= Seq(
  "Scala Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Scala" at "https://oss.sonatype.org/content/groups/scala-tools/"
)

libraryDependencies <++= (liftVersion,liftEdition,version) { (v,e,mv) =>
  "net.liftweb"      %% "lift-webkit"                       % v       % "provided" ::
  "net.liftweb"      %% "lift-testkit"                      % v       % "provided" ::
  Nil
}

libraryDependencies <++= scalaVersion { sv =>
  (sv match {
      case "2.9.2" | "2.9.1" | "2.9.1-1" => "org.specs2" %% "specs2" % "1.12.4" % "test"
      case "2.10.4" => "org.specs2" %% "specs2" % "1.14" % "test"
      case _ => "org.specs2" %% "specs2" % "3.7" % "test"
 }) ::
  (sv match {
      case "2.9.2" | "2.9.1" | "2.9.1-1" => "org.scalacheck" %% "scalacheck" % "1.10.1" % "test"
      case _ => "org.scalacheck" %% "scalacheck" % "1.13.0" % "test"
      }) ::
  Nil
}

libraryDependencies ++= {
  //"ch.qos.logback" % "logback-classic" % "1.0.0" % "provided" ::
  //"ch.qos.logback" % "logback-classic" % "1.1.6" % "provided" ::
  //"log4j" % "log4j" % "1.2.16" % "provided" ::
  Nil
}

//################################################################
//#### Publish to Sonatype
//##
//##
//################################################################
credentials += Credentials(file(Path.userHome + "/.sbt/liftmodules/.credentials") )

credentials += Credentials( file("/private/liftmodules/sonatype.credentials") )

publishTo <<= version { v: String =>
   val sonatype = "https://oss.sonatype.org/"
   if (v.trim.endsWith("SNAPSHOT"))
     Some("snapshots" at sonatype + "content/repositories/snapshots")
   else
     Some("releases" at sonatype + "service/local/staging/deploy/maven2")
   }

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { x => false }

pomExtra := (
  <url>http://yukoff.github.io/lift-scrollax-module/</url>
  <licenses>
    <license>
      <name>MIT</name>
      <url>https://raw.githubusercontent.com/yukoff/lift-scrollax-module/master/LICENSE</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:yukoff/lift-scrollax-module.git</url>
    <connection>scm:git:git@github.com:yukoff/lift-scrollax-module.git</connection>
  </scm>
  <developers>
    <developer>
      <id>yukoff</id>
      <name>Yury Buldakov</name>
      <url>https://github.com/yukoff</url>
    </developer>
  </developers>
)
