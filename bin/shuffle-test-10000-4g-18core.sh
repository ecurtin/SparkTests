#!/usr/bin/env bash

"$SPARK_HOME"/bin/spark-submit \
  --class org.framebit.sparkpi.ShuffleTest \
  --executor-memory 4g \
  --total-executor-cores 18 \
  target/scala-2.11/SparkPi-assembly-0.1.0-SNAPSHOT.jar \
  10000