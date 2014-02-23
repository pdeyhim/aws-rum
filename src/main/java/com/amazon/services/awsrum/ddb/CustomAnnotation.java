package com.amazon.services.awsrum.ddb;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.jsonschema2pojo.Annotator;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;


public class CustomAnnotation  implements Annotator {
	
	
	String tableName;
	String hashKey;
	String rangeKey;
	
	public CustomAnnotation(String configFile){
		
		InputStream configStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(configFile);

        if (configStream == null) {
            String msg = "Could not find resource " + configFile + " in the classpath";
            throw new IllegalStateException(msg);
        }
        Properties properties = new Properties();
        try {
            properties.load(configStream);
            configStream.close();
        } catch (IOException e) {
            String msg = "Could not load properties file " + configFile + " from classpath";
            throw new IllegalStateException(msg, e);
        }
        
		this.tableName = properties.getProperty("dynamoDBDataTableName");
		this.hashKey = properties.getProperty("dynamoDBKey");
		this.rangeKey = properties.getProperty("dynamoDBRangeKey");
		
		System.out.println("table name: "+tableName+" hashKey: "+hashKey);
	}
	
	public void anyGetter(JMethod arg0) {
		
	}

	public void anySetter(JMethod arg0) {
		// TODO Auto-generated method stub
		
	}

	public void enumCreatorMethod(JMethod arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.name());
		
	}

	public void enumValueMethod(JMethod arg0) {
		// TODO Auto-generated method stub
		
		
	}

	public boolean isAdditionalPropertiesSupported() {
		// TODO Auto-generated method stub
		return false;
	}

	public void propertyField(JFieldVar arg0, JDefinedClass arg1, String arg2,
			JsonNode arg3) {
		// TODO Auto-generated method stub
		
	}

	public void propertyInclusion(JDefinedClass arg0, JsonNode arg1) {
		// TODO Auto-generated method stub
		
	}

	public void propertyOrder(JDefinedClass clazz, JsonNode arg1) {
		// TODO Auto-generated method stub
		clazz.annotate(DynamoDBTable.class).param("tableName", tableName);
		
	}

	public void propertySetter(JMethod arg0, String arg1) {
		// TODO Auto-generated method stub]]
		if (arg1.equals(hashKey)){
			arg0.annotate(DynamoDBHashKey.class);
		}else{
		arg0.annotate(DynamoDBAttribute.class);
		}
	}

	public void propertyGetter(JMethod arg0, String arg1) {
		//arg0.annotate(DynamoDBTable.class).param("parviz", "parviz");
		if (arg1.equals(hashKey)){
			arg0.annotate(DynamoDBHashKey.class);
		}
		if (arg1.equals(rangeKey)){
			arg0.annotate(DynamoDBRangeKey.class);
		}
		else{
		arg0.annotate(DynamoDBAttribute.class);
		}
	}
		
	

}
