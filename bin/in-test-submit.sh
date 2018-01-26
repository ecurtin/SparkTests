#!/usr/bin/env bash

rm blah.csv
hdfs dfs -rm /tmp/blah.csv

cat <<- EOF > blah.csv
1, 2
3, 4
5, 6
7, 8
9. 10
EOF

hadoop fs -copyFromLocal blah.csv hdfs:///tmp/blah.csv
hdfs dfs -cat /tmp/blah.csv

"$SPARK_HOME"/bin/spark-submit \
  --class "org.framebit.sparkpi.InputTest" \
  target/scala-2.11/SparkPi-assembly-0.1.0-SNAPSHOT.jar \
  hdfs:///tmp/blah.csv

