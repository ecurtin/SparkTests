package org.framebit.sparkpi

import org.apache.spark.sql.SparkSession
import scala.math.random

object SparkPi {
  def main(args: Array[String]) {
    val spark = SparkSession.builder.appName("SparkPi").getOrCreate()

    val slices = 100
    val n = math.min(100000L * slices, Int.MaxValue).toInt
    val count = spark.sparkContext.parallelize(1 until n, slices).map { i =>
      val x = random * 2 - 1
      val y = random * 2 - 1
      if ((x * x) + (y * y) <= 1) 1 else 0
    }.reduce(_ + _)
    val piApproximate = 4.0 * count / (n - 1)
    println(piApproximate)
    spark.stop()
  }
}
