import Dependencies._

lazy val mainDependencies = Seq(
  catsCore
)

lazy val testDependencies = Seq(
  scalaTest,
  scalaCheck
).map(_ % Test)

lazy val `scalaplayground` = (project in file(".")).
  settings(
    name := "scalaplayground",
    inThisBuild(List(
      organization := "fpa",
      scalaVersion := "2.12.6",
      version      := "0.1.0"
    )),
    addCompilerPlugin(kindProjector),
    libraryDependencies ++= mainDependencies ++ testDependencies
  )

scalacOptions := Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-Ypartial-unification"

)