package com.amazon.services.awsrum.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsonschema2pojo.CompositeAnnotator;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.rules.RuleFactory;

import com.amazon.services.awsrum.ddb.Arguments;
import com.amazon.services.awsrum.ddb.CustomAnnotation;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.kinesis.connectors.KinesisConnectorConfiguration;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.sun.codemodel.JCodeModel;

public class GenerateKinesisMessageModel {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * 
	 * 
	 */
	
	private static final Log LOG = LogFactory.getLog(GenerateKinesisMessageModel.class);
	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		
	
		String configFile = args[0];
		
		 InputStream configStream = Thread.currentThread().getContextClassLoader()
	                .getResourceAsStream(configFile);
		 
		 Properties properties = new Properties();
		 properties.load(configStream);
		 
		 KinesisConnectorConfiguration config = new KinesisConnectorConfiguration(properties,new DefaultAWSCredentialsProviderChain());
		 
		 File f = getJsonSchema(config);
		 //System.out.println(f.toURL());
		 LOG.info("Schmea file:"+f.toURL());
	
		JCodeModel codeModel = new JCodeModel();
        new SchemaMapper(new RuleFactory(new Arguments(), new CompositeAnnotator(new Jackson2Annotator(), new CustomAnnotation(configFile)), new SchemaStore()), new SchemaGenerator()).generate(codeModel, "KinesisMessageModel", "com.amazon.services.awsrum.kinesis", f.toURL()); 
     
        File sourceFileDir=new File("./src/main/java");
        codeModel.build(sourceFileDir);
      
	}
	
	private static File getJsonSchema(KinesisConnectorConfiguration configuration){
		String s3Bucket = configuration.JSON_SCHEMA_S3_BUCKET;
		String s3Key = configuration.JSON_SCHEMA_S3_KEY;
		S3Object s3object;
		File s3Schema = new File("conf/s3shema.json");
	    AmazonS3Client s3client = new AmazonS3Client(configuration.AWS_CREDENTIALS_PROVIDER);
	    try {
		   GetObjectRequest req = new GetObjectRequest(s3Bucket, s3Key);
		   s3object = s3client.getObject(req);
		   IOUtils.copy(s3object.getObjectContent(), new FileOutputStream(s3Schema));
		  
		   return s3Schema;
	    }catch (Exception e){
	    	LOG.info("Error getting schema from S3"+e.getMessage());
	    	return new File("conf/schema.json");
	    }
	    
	}

}
