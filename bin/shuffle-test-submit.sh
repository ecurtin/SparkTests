#!/usr/bin/env bash

"$SPARK_HOME"/bin/spark-submit \
  --class "org.framebit.sparkpi.ShuffleTest" \
  target/scala-2.11/SparkPi-assembly-0.1.0-SNAPSHOT.jar