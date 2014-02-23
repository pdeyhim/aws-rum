package com.amazon.services.awsrum.utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.jsonschema2pojo.CompositeAnnotator;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.rules.RuleFactory;

import com.amazon.services.awsrum.ddb.Arguments;
import com.amazon.services.awsrum.ddb.CustomAnnotation;
import com.sun.codemodel.JCodeModel;

public class GenerateKinesisMessageModel {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		String configFile = "DynamoDBSample.properties";
		
		JCodeModel codeModel = new JCodeModel();
      
        
        File schemaFile = new File("conf/browserschema.json");
          
        new SchemaMapper(new RuleFactory(new Arguments(), new CompositeAnnotator(new Jackson2Annotator(), new CustomAnnotation(configFile)), new SchemaStore()), new SchemaGenerator()).generate(codeModel, "KinesisMessageModel", "com.amazon.services.awsrum.kinesis", schemaFile.toURL()); 
       
        File sourceFileDir=new File("./src/");

        codeModel.build(sourceFileDir);
        //File sourceFile=new File(sourceFileDir,"com/amazon/services/awsrum/kinesis/KinesisMessageModel.java");
      
	}

}
