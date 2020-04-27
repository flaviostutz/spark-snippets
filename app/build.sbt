logLevel := Level.Debug

name := "app"
version := "1.0"
scalaVersion := "2.11.0"

val sparkVersion = "2.4.5"

assemblyJarName in assembly := "app.jar"

libraryDependencies ++= Seq(
  // "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  // "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
  // "org.apache.spark" %% "spark-hive" % sparkVersion % "provided",
  // "org.apache.spark" %% "spark-mllib" % sparkVersion % "provided",
  // "org.apache.spark" %% "spark-graphx" % sparkVersion % "provided",
  // "org.apache.spark" %% "spark-streaming" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-avro" % sparkVersion,
  "org.apache.spark" %% "spark-sql-kafka-0-10" % sparkVersion
  // "org.apache.spark" %% "spark-streaming-kafka-assembly" % "1.6.3"
)

//https://community.cloudera.com/t5/Community-Articles/Creating-fat-jars-for-Spark-Kafka-Streaming-using-sbt/ta-p/246691
assemblyMergeStrategy in assembly := {
    case "META-INF/services/org.apache.spark.sql.sources.DataSourceRegister" => MergeStrategy.concat
    case PathList("com",   "esotericsoftware", xs @ _*) => MergeStrategy.last
    case PathList("com",   "squareup", xs @ _*) => MergeStrategy.last
    case PathList("com",   "sun", xs @ _*) => MergeStrategy.last
    case PathList("com",   "thoughtworks", xs @ _*) => MergeStrategy.last
    case PathList("commons-beanutils", xs @ _*) => MergeStrategy.last
    case PathList("commons-cli", xs @ _*) => MergeStrategy.last
    case PathList("commons-collections", xs @ _*) => MergeStrategy.last
    case PathList("commons-io", xs @ _*) => MergeStrategy.last
    case PathList("io",    "netty", xs @ _*) => MergeStrategy.last
    case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
    case PathList("javax", "xml", xs @ _*) => MergeStrategy.last
    case PathList("org",   "apache", xs @ _*) => MergeStrategy.last
    case PathList("org",   "codehaus", xs @ _*) => MergeStrategy.last
    case PathList("org",   "fusesource", xs @ _*) => MergeStrategy.last
    case PathList("org",   "mortbay", xs @ _*) => MergeStrategy.last
    case PathList("org",   "tukaani", xs @ _*) => MergeStrategy.last
    case PathList("xerces", xs @ _*) => MergeStrategy.last
    case PathList("xmlenc", xs @ _*) => MergeStrategy.last
    case "about.html" => MergeStrategy.rename
    case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
    case "META-INF/mailcap" => MergeStrategy.last
    case "META-INF/mimetypes.default" => MergeStrategy.last
    case "plugin.properties" => MergeStrategy.last
    case "log4j.properties" => MergeStrategy.last
    case x =>
        val oldStrategy = (assemblyMergeStrategy in assembly).value
        oldStrategy(x)
}