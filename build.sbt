sbtPlugin       := true

sbtVersion := "1.1.0"

organization  := "com.oni"

name := "sbt-tunnel"

version := "0.1.0-SNAPSHOT"

scalaVersion  := "2.12.3"

crossScalaVersions := Seq("2.11.11", "2.12.3")

val circeVersion = "0.9.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "4.0.2" % "test")

val latestJson4sVersion = "3.5.3"
val json4sNative = "org.json4s" %% "json4s-native" % latestJson4sVersion

libraryDependencies += json4sNative

scalacOptions in Test ++= Seq("-Yrangepos")

resolvers += Resolver.sonatypeRepo("releases")

//libraryDependencies ++= Seq(
//  "com.lihaoyi" %% "utest" % "0.4.4" % "test",
//  "org.scala-lang" % "scala-compiler" % scalaVersion.value % "provided"
//)

// resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.4"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"

val AkkaVersion = "2.5.6"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % AkkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-typed" % AkkaVersion,
  "com.lightbend.akka" %% "akka-stream-alpakka-file" % "0.11"
)

//testFrameworks += new TestFramework("utest.runner.Framework")

//unmanagedSourceDirectories in Test += baseDirectory(_ / "src" / "test" / "resources").value

// Sonatype
publishArtifact in Test := false

publishTo := version { (v: String) =>
  Some("releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
}.value

/*
pomExtra := (
  <url>https://github.com/objectnirvana/sbt-tunnel</url>
    <licenses>
      <license>
        <name>MIT license</name>
        <url>http://www.opensource.org/licenses/mit-license.php</url>
      </license>
    </licenses>
    <scm>
      <url>git://github.com/objectnirvana/sbt-tunnel.git</url>
      <connection>scm:git://github.com/objectnirvana/sbt-tunnel.git</connection>
    </scm>
    <developers>
      <developer>
        <id>michaeldmccray</id>
        <name>Michael McCray</name>
        <url>https://github.com/MichaelDMcCray</url>
      </developer>
    </developers>
  )
*/