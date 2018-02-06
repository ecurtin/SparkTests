#!/usr/bin/env bash

hdfs dfs -rmdir /tmp/out-test.csv

"$SPARK_HOME"/bin/spark-submit \
  --class "org.framebit.sparkpi.OutputTest" \
  target/scala-2.11/SparkPi-assembly-0.1.0-SNAPSHOT.jar \
  hdfs:///tmp/out-test.csv

hdfs dfs -cat /tmp/out-test.csv/*