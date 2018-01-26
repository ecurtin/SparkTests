package org.framebit.sparkpi

import org.apache.spark.sql.{DataFrame, SparkSession}

object OutputTest {
  def main(args: Array[String]) {
    val spark = SparkSession.builder.appName("OutputTest").getOrCreate()
    import spark.implicits._
    assert(args.length == 1)
    val stuff: DataFrame = spark.sparkContext.parallelize(Seq(11, 12, 13, 14, 15, 16, 17, 18, 19, 20)).toDF
    stuff.write.csv(args(0))
    spark.stop()
  }
}
