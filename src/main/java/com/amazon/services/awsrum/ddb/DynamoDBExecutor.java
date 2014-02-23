/*
 * Copyright 2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Amazon Software License (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/asl/
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazon.services.awsrum.ddb;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import com.amazon.services.awsrum.kinesis.KinesisConnectorExecutor;
import com.amazon.services.awsrum.kinesis.KinesisMessageModel;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.kinesis.connectors.KinesisConnectorRecordProcessorFactory;




/**
 * The Executor for the DynamoDB emitter sample.
 */
public class DynamoDBExecutor extends KinesisConnectorExecutor<KinesisMessageModel,Map<String,AttributeValue>> {

    private static String configFile = "DynamoDBSample.properties";

    /**
     * Creates a new DynamoDBExcecutor.
     * @param configFile The name of the configuration file to look for on the classpath.
     */
    public DynamoDBExecutor(String configFile) {
        super(configFile);
    }

    @Override
    public KinesisConnectorRecordProcessorFactory<KinesisMessageModel, KinesisMessageModel> getKinesisConnectorRecordProcessorFactory() {
        return new KinesisConnectorRecordProcessorFactory<KinesisMessageModel,KinesisMessageModel>(
                new DynamoDBMessageModelPipeline(), config);
    }

    /**
     * Main method starts and runs the DynamoDBExecutor.
     * @param args
     * @throws IOException 
     * @throws MalformedURLException 
     * @throws ClassNotFoundException 
     */
    public static void main(String[] args) throws MalformedURLException, IOException, ClassNotFoundException {
    	KinesisConnectorExecutor<KinesisMessageModel, Map<String,AttributeValue>> dynamoDBExecutor = new DynamoDBExecutor(configFile);
        dynamoDBExecutor.run();
    }
}
