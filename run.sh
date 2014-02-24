#!/bin/sh
if [ ! -f target/amazon-rum-dynamodb-0.0.1-SNAPSHOT-jar-with-dependencies.jar  ]; then
    echo "First time using this tool. Generating the required packages"
    mvn compile assembly:single
fi
echo "Running DDB Connector"
java -cp target/amazon-rum-dynamodb-0.0.1-SNAPSHOT-jar-with-dependencies.jar:conf/ $1
