#!/bin/sh
if [ ! -f target/amazon-rum-dynamodb-0.0.1-SNAPSHOT-jar-with-dependencies.jar  ]; then
    echo "First time using this tool. Generating the required packages"
    mvn compile assembly:single
fi
echo "Generating the message model from your scheman\n"
java -cp target/amazon-rum-dynamodb-0.0.1-SNAPSHOT-jar-with-dependencies.jar:conf/ com.amazon.services.awsrum.utils.GenerateKinesisMessageModel
echo "re-packaging\n"
mvn compile assembly:single
echo "Running DDB Connector"
java -cp target/amazon-rum-dynamodb-0.0.1-SNAPSHOT-jar-with-dependencies.jar:conf/ com.amazon.services.awsrum.ddb.DynamoDBExecutor
