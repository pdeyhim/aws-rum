
package com.amazon.services.awsrum.kinesis;

import javax.annotation.Generated;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "userId",
    "propertyId",
    "propertyLocation",
    "action",
    "timestamp"
})
@DynamoDBTable(tableName = "browsermetrics")
public class KinesisMessageModel {

    /**
     * 
     */
    @JsonProperty("userId")
    private String userId;
    /**
     * 
     */
    @JsonProperty("propertyId")
    private Double propertyId;
    /**
     * 
     */
    @JsonProperty("propertyLocation")
    private String propertyLocation;
    /**
     * 
     */
    @JsonProperty("action")
    private String action;
    /**
     * 
     */
    @JsonProperty("timestamp")
    private Double timestamp;

    /**
     * 
     */
    @JsonProperty("userId")
    @DynamoDBAttribute
    public String getUserId() {
        return userId;
    }

    /**
     * 
     */
    @JsonProperty("userId")
    @DynamoDBAttribute
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 
     */
    @JsonProperty("propertyId")
    @DynamoDBAttribute
    public Double getPropertyId() {
        return propertyId;
    }

    /**
     * 
     */
    @JsonProperty("propertyId")
    @DynamoDBAttribute
    public void setPropertyId(Double propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * 
     */
    @JsonProperty("propertyLocation")
    @DynamoDBAttribute
    public String getPropertyLocation() {
        return propertyLocation;
    }

    /**
     * 
     */
    @JsonProperty("propertyLocation")
    @DynamoDBAttribute
    public void setPropertyLocation(String propertyLocation) {
        this.propertyLocation = propertyLocation;
    }

    /**
     * 
     */
    @JsonProperty("action")
    @DynamoDBAttribute
    public String getAction() {
        return action;
    }

    /**
     * 
     */
    @JsonProperty("action")
    @DynamoDBAttribute
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * 
     */
    @JsonProperty("timestamp")
    @DynamoDBAttribute
    public Double getTimestamp() {
        return timestamp;
    }

    /**
     * 
     */
    @JsonProperty("timestamp")
    @DynamoDBAttribute
    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

}
