ThisBuild / organization := "io.github.olegych"
ThisBuild / organizationName := "OlegYch"
ThisBuild / organizationHomepage := Some(url("https://github.com/OlegYch"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/OlegYch/enumeratum-scalafix"),
    "scm:git@github.com:OlegYch/enumeratum-scalafix.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id    = "OlegYch",
    name  = "Aleh Aleshka",
    email = "olegych@tut.by",
    url   = url("https://github.com/OlegYch")
  )
)

ThisBuild / description := "Scalafix migration from scala.Enumeration to enumeratum."
ThisBuild / licenses := Seq("BSD-style" -> url("http://www.opensource.org/licenses/bsd-license.php"))
ThisBuild / homepage := Some(url("https://github.com/OlegYch/scala-dzi"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishMavenStyle := true
ThisBuild / publishTo := sonatypePublishToBundle.value
ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org"
ThisBuild / sonatypeProfileName := "OlegYch"

import ReleaseTransformations._
ThisBuild / versionScheme := Some("early-semver")
releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  releaseStepCommandAndRemaining("publishSigned"),
  releaseStepCommand("sonatypeBundleRelease"),
  setNextVersion,
  commitNextVersion,
  pushChanges
)
