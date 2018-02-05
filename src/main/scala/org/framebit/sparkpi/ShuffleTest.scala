package org.framebit.sparkpi

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

import scala.util.Random

object ShuffleTest {
  def main(args: Array[String]) {

    val n = if(args.nonEmpty) args(0).toInt else Int.MaxValue

    val spark = SparkSession.builder.appName("ShuffleTest").getOrCreate()

    val states = Seq(
      "Alabama",
      "Alaska",
      "Arizona",
      "Arkansas",
      "California",
      "Colorado",
      "Connecticut",
      "Delaware",
      "Florida",
      "Georgia",
      "Hawaii",
      "Idaho",
      "Illinois",
      "Indiana",
      "Iowa",
      "Kansas",
      "Kentucky",
      "Louisiana",
      "Maine",
      "Maryland",
      "Massachusetts",
      "Michigan",
      "Minnesota",
      "Mississippi",
      "Missouri",
      "Montana",
      "Nebraska",
      "Nevada",
      "New Hampshire",
      "New Jersey",
      "New Mexico",
      "New York",
      "North Carolina",
      "North Dakota",
      "Ohio",
      "Oklahoma",
      "Oregon",
      "Pennsylvania",
      "Rhode Island",
      "South Carolina",
      "South Dakota",
      "Tennessee",
      "Texas",
      "Utah",
      "Vermont",
      "Virginia",
      "Washington",
      "West Virginia",
      "Wisconsin",
      "Wyoming"
    )

    val rand = new Random(System.currentTimeMillis())
    val numbers: RDD[Int] = spark.sparkContext.parallelize(0 until n)

    val set: RDD[(String, Double)] = numbers.map(_ => {
        val state = states(rand.nextInt(states.length))
        (state, Random.nextDouble())
      }
    )

    val shuffled = set.groupBy(tuple => tuple._1)

    val count = shuffled.count()

    println(s"Count is $count")

    spark.stop()
  }
}
