name := "ferris-http-microservice"

organization := "com.ferris"

version := "0.0.3"

scalaVersion := "2.12.1"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV = "2.4.16"
  val akkaHttpV = "10.0.1"
  val ferrisV = "0.0.1"
  Seq(
    "com.typesafe.akka" %% "akka-actor"           % akkaV,
    "com.typesafe.akka" %% "akka-stream"          % akkaV,
    "com.typesafe.akka" %% "akka-http-core"       % akkaHttpV,
    "com.typesafe.akka" %% "akka-http"            % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-testkit"    % akkaHttpV,
    "com.ferris"        %% "ferris-json-utils"    % ferrisV
  )
}
