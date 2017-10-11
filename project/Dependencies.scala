import sbt._

object Dependencies {
  lazy val sparkVersion = "2.1.1"

  lazy val sparkCore = "org.apache.spark" %% "spark-core"  % sparkVersion % "provided"
  lazy val sparkSql = "org.apache.spark" %% "spark-sql"  % sparkVersion % "provided"

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.3"
}
