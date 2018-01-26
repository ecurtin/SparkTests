package org.framebit.sparkpi

import org.apache.spark.sql.SparkSession

import scala.math.random

object InputTest {
  def main(args: Array[String]) {
    val spark = SparkSession.builder.appName("InputTest").getOrCreate()
    assert(args.length == 1)
    val csv = spark.read.csv(args(0))
    csv.show()
    spark.stop()
  }
}
