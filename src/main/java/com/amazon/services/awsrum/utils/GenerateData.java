package com.amazon.services.awsrum.utils;

import java.nio.ByteBuffer;
import java.util.Random;
import java.util.UUID;

import com.amazon.services.awsrum.kinesis.KinesisMessageModel;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kinesis.AmazonKinesisClient;
import com.amazonaws.services.kinesis.model.PutRecordRequest;
import com.amazonaws.services.kinesis.model.PutRecordResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GenerateData {

	/**
	 * @param args
	 * @throws JsonProcessingException 
	 */
	
	
	static AmazonKinesisClient kinesisClient;
	private static int j;
	
	
	private static void init() throws Exception {
    	 
		kinesisClient = new AmazonKinesisClient(new ClasspathPropertiesFileCredentialsProvider());
        	Region usEast = Region.getRegion(Regions.US_EAST_1);
			
        	kinesisClient.setEndpoint("https://kinesis.us-east-1.amazonaws.com", "kinesis", usEast.toString());
    }
	
	
	private static String generateData() throws JsonProcessingException{
		
		ObjectMapper mapper = new ObjectMapper();
		KinesisMessageModel kmodel = new KinesisMessageModel();
		
		kmodel.setConnectEnd(1.0);
		kmodel.setConnectStart(1.0);
		kmodel.setDomainLookupEnd( generateTime());
		kmodel.setDomainLookupStart(generateTime());
		kmodel.setDomComplete(generateTime());
		kmodel.setDomContentLoadedEventEnd(generateTime());
		kmodel.setDomContentLoadedEventStart(generateTime());
		kmodel.setDomInteractive(generateTime());
		kmodel.setDomLoading(generateTime());
		kmodel.setFetchStart(generateTime());
		kmodel.setLanguage("US");
		kmodel.setLoadEventEnd(generateTime());
		kmodel.setLoadEventStart(generateTime());
		kmodel.setMtime((double)System.currentTimeMillis());
		kmodel.setNavigationStart(generateTime());
		kmodel.setPlatform("test");
		kmodel.setRedirectEnd(generateTime());
		kmodel.setRedirectStart(generateTime());
		kmodel.setRequestStart(generateTime());
		kmodel.setResponseEnd(generateTime());
		kmodel.setResponseStart(generateTime());
		kmodel.setSecureConnectionStart(generateTime());
		kmodel.setUnloadEventEnd(generateTime());
		kmodel.setUnloadEventStart(generateTime());
		kmodel.setUseragent("test client");
		kmodel.setUuid(UUID.randomUUID().toString());
		
		return mapper.writeValueAsString(kmodel);
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String myStreamName = args[0];
		
		init();
		
		while(j<=10000){
			
			  int partitionKey=new Random().nextInt((5 - 1) + 1) + 1;
			
			  PutRecordRequest putRecordRequest = new PutRecordRequest();
			  putRecordRequest.setStreamName( myStreamName );
			  putRecordRequest.setData(ByteBuffer.wrap(generateData().getBytes()));
			  putRecordRequest.setPartitionKey("partitionKey_"+partitionKey);
			  PutRecordResult putRecordResult = kinesisClient.putRecord(putRecordRequest);	
			  System.out.println(putRecordResult.getSequenceNumber());
			  j++;
			
		}
		
	}
	
	
	private static Double generateTime(){
		return (double) (System.currentTimeMillis()+ new Random().nextInt(100));
	}

}
