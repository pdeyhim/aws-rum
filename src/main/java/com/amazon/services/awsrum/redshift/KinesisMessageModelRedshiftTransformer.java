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



import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.amazon.services.awsrum.kinesis.KinesisMessageModel;
import com.amazonaws.services.kinesis.connectors.KinesisConnectorConfiguration;
import com.amazonaws.services.kinesis.connectors.redshift.RedshiftTransformer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.gson.Gson;

/**
 * Custom transformer used by the {@link S3ManifestExecutor} and {@link RedshiftBasicExecutor} to convert
 * {@link KinesisMessageModel} records to delimited Strings used by Redshift copy.
 */
public class KinesisMessageModelRedshiftTransformer extends RedshiftTransformer<KinesisMessageModel> {
    private final char delim;
    Gson gson = new Gson();
    CsvMapper mapper = new CsvMapper();
    CsvSchema schema = mapper.schemaFor(KinesisMessageModel.class); // schema from 'Pojo' definition

    /**
     * Creates a new KinesisMessageModelRedshiftTransformer.
     * @param config The configuration containing the Redshift data delimiter
     */
    public KinesisMessageModelRedshiftTransformer(KinesisConnectorConfiguration config) {
        super(KinesisMessageModel.class);
        delim = config.REDSHIFT_DATA_DELIMITER;
    }

    @Override
    public String toDelimitedString(KinesisMessageModel record) {
    	
    	String str="";
		try {
			str = IOUtils.toString(mapper.writer(schema).writeValueAsBytes(record), "UTF-8");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("csv: "+str);
    	return str;
    }

}
