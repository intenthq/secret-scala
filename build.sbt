import sbt.Keys.scalaVersion

ThisBuild / organization     := "com.intenthq"
ThisBuild / organizationName := "Intent HQ"

lazy val scala212 = "2.12.12"
lazy val scala213 = "2.13.3"
lazy val supportedScalaVersions = List(scala213, scala212)

lazy val root = (project in file("."))
  .settings(
    name := "scala-secret",
    libraryDependencies += Dependencies.weaver,
    scalaVersion := scala213,
    crossScalaVersions := supportedScalaVersions
  )

testFrameworks += new TestFramework("weaver.framework.TestFramework")

publishTo := Some("GitHub Package Registry (intenthq/scala-secret)" at "https://maven.pkg.github.com/intenthq/scala-secret")
credentials ++= scala.util.Properties
  .envOrNone("GITHUB_TOKEN")
  .map(githubToken => Credentials("GitHub Package Registry", "maven.pkg.github.com", "_", githubToken))
