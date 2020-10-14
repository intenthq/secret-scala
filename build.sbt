ThisBuild / scalaVersion     := "2.13.3"
ThisBuild / organization     := "com.intenthq"
ThisBuild / organizationName := "Intent HQ"

lazy val root = (project in file("."))
  .settings(
    name := "scala-secret",
    libraryDependencies += Dependencies.weaver
  )

testFrameworks += new TestFramework("weaver.framework.TestFramework")

publishTo := Some("GitHub Package Registry" at "https://maven.pkg.github.com/intenthq/scala-secret")
credentials ++= scala.util.Properties
  .envOrNone("GITHUB_TOKEN")
  .map(githubToken => Credentials("GitHub Package Registry", "maven.pkg.github.com", "_", githubToken))
