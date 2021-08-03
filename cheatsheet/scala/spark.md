# Dropping records with unwanted values (DataFrame)
drop() // drops rows that contain null or NaN values in any column and returns a new DataFrame
drop("all") // drops rows that contain null or NaN values in all columns and returns a new DataFrame
drop(Array("id", "name")) // drops rows that contain null or NaN values in the specified columns and returns a new DataFrame.
~https://www.coursera.org/learn/scala-spark-big-data 

# setting PATH for Scala and Spark
export PATH = $PATH:/path_to_scala_dir/bin
export PATH = $PATH:/path_to_spark_dir/bin
source ~/.bashrc