# SparkTests
Some convenient tests for basic Spark functionality.

## Usage
```bash
export SPARK_HOME=/path/to/your/spark/installation
```
And then choose from the scripts in `bin` to run individual tests.

- SparkPi - compute heavy, no I/O  
- InputTest - puts a dataset of the numbers 1 through 10 in HDFS and then accesses it from Spark  
- OutputTest - generates numbers 20 - 30 and outputs to HDFS  
- ShuffleTest - builds a dataset of size Int.MaxValue - 1 consisting of random US State name and a random double for each row.
Runs a groupBy() on the state name then a count() to manifest it.
