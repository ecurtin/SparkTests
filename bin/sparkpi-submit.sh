#!/usr/bin/env bash

"$SPARK_HOME"/bin/spark-submit \
  --class "org.framebit.sparkpi.SparkPi" \
  --master yarn \
  --deploy-mode cluster \
  target/scala-2.11/SparkPi-assembly-0.1.0-SNAPSHOT.jar