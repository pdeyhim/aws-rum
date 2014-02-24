#!/bin/sh

if [ ! -f target/amazon-rum-dynamodb-0.0.1-SNAPSHOT-jar-with-dependencies.jar  ]; then
    echo "First time using this tool. Generating the required packages"
    mvn compile assembly:single
fi

echo "Generating Data model and repackaging"
java -cp target/amazon-rum-dynamodb-0.0.1-SNAPSHOT-jar-with-dependencies.jar:conf/ com.amazon.services.awsrum.utils.GenerateKinesisMessageModel $1
mvn compile assembly:single
