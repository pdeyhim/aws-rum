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
package com.amazon.services.awsrum.redshift;

import com.amazon.services.awsrum.kinesis.KinesisConnectorExecutor;
import com.amazon.services.awsrum.kinesis.KinesisMessageModel;

import com.amazonaws.services.kinesis.connectors.KinesisConnectorRecordProcessorFactory;

/**
 * The Executor for the basic Redshift emitter sample.
 */
public class RedshiftBasicExecutor extends KinesisConnectorExecutor<KinesisMessageModel, byte[]> {
    private static final String CONFIG_FILE = "Redshift.properties";

    /**
     * Creates a new RedshiftBasicExecutor.
     * @param configFile The name of the configuration file to look for on the classpath
     */
    public RedshiftBasicExecutor(String configFile) {
        super(configFile);
    }

    @Override
    public KinesisConnectorRecordProcessorFactory<KinesisMessageModel, KinesisMessageModel> getKinesisConnectorRecordProcessorFactory() {
        return new KinesisConnectorRecordProcessorFactory<KinesisMessageModel,KinesisMessageModel>(new RedshiftBasicPipeline(), config);
    }

    /**
     * Main method starts and runs the RedshiftBasicExecutor.
     * @param args
     */
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Could not load PostgreSQL driver");
        }
        KinesisConnectorExecutor<KinesisMessageModel, byte[]> redshiftExecutor = new RedshiftBasicExecutor(
                CONFIG_FILE);
        redshiftExecutor.run();
    }
}
 