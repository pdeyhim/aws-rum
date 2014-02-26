
package com.amazon.services.awsrum.kinesis;

import javax.annotation.Generated;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
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
    "connectEnd",
    "connectStart",
    "domComplete",
    "domContentLoadedEventEnd",
    "domContentLoadedEventStart",
    "domInteractive",
    "domLoading",
    "domainLookupEnd",
    "domainLookupStart",
    "fetchStart",
    "loadEventEnd",
    "loadEventStart",
    "navigationStart",
    "redirectEnd",
    "redirectStart",
    "requestStart",
    "responseEnd",
    "responseStart",
    "secureConnectionStart",
    "unloadEventEnd",
    "unloadEventStart",
    "uuid",
    "mtime",
    "useragent",
    "platform",
    "language"
})
@DynamoDBTable(tableName = "browsermetrics")
public class KinesisMessageModel {

    /**
     * 
     */
    @JsonProperty("connectEnd")
    private Double connectEnd;
    /**
     * 
     */
    @JsonProperty("connectStart")
    private Double connectStart;
    /**
     * 
     */
    @JsonProperty("domComplete")
    private Double domComplete;
    /**
     * 
     */
    @JsonProperty("domContentLoadedEventEnd")
    private Double domContentLoadedEventEnd;
    /**
     * 
     */
    @JsonProperty("domContentLoadedEventStart")
    private Double domContentLoadedEventStart;
    /**
     * 
     */
    @JsonProperty("domInteractive")
    private Double domInteractive;
    /**
     * 
     */
    @JsonProperty("domLoading")
    private Double domLoading;
    /**
     * 
     */
    @JsonProperty("domainLookupEnd")
    private Double domainLookupEnd;
    /**
     * 
     */
    @JsonProperty("domainLookupStart")
    private Double domainLookupStart;
    /**
     * 
     */
    @JsonProperty("fetchStart")
    private Double fetchStart;
    /**
     * 
     */
    @JsonProperty("loadEventEnd")
    private Double loadEventEnd;
    /**
     * 
     */
    @JsonProperty("loadEventStart")
    private Double loadEventStart;
    /**
     * 
     */
    @JsonProperty("navigationStart")
    private Double navigationStart;
    /**
     * 
     */
    @JsonProperty("redirectEnd")
    private Double redirectEnd;
    /**
     * 
     */
    @JsonProperty("redirectStart")
    private Double redirectStart;
    /**
     * 
     */
    @JsonProperty("requestStart")
    private Double requestStart;
    /**
     * 
     */
    @JsonProperty("responseEnd")
    private Double responseEnd;
    /**
     * 
     */
    @JsonProperty("responseStart")
    private Double responseStart;
    /**
     * 
     */
    @JsonProperty("secureConnectionStart")
    private Double secureConnectionStart;
    /**
     * 
     */
    @JsonProperty("unloadEventEnd")
    private Double unloadEventEnd;
    /**
     * 
     */
    @JsonProperty("unloadEventStart")
    private Double unloadEventStart;
    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("mtime")
    private Double mtime;
    @JsonProperty("useragent")
    private String useragent;
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("language")
    private String language;

    /**
     * 
     */
    @JsonProperty("connectEnd")
    @DynamoDBAttribute
    public Double getConnectEnd() {
        return connectEnd;
    }

    /**
     * 
     */
    @JsonProperty("connectEnd")
    @DynamoDBAttribute
    public void setConnectEnd(Double connectEnd) {
        this.connectEnd = connectEnd;
    }

    /**
     * 
     */
    @JsonProperty("connectStart")
    @DynamoDBAttribute
    public Double getConnectStart() {
        return connectStart;
    }

    /**
     * 
     */
    @JsonProperty("connectStart")
    @DynamoDBAttribute
    public void setConnectStart(Double connectStart) {
        this.connectStart = connectStart;
    }

    /**
     * 
     */
    @JsonProperty("domComplete")
    @DynamoDBAttribute
    public Double getDomComplete() {
        return domComplete;
    }

    /**
     * 
     */
    @JsonProperty("domComplete")
    @DynamoDBAttribute
    public void setDomComplete(Double domComplete) {
        this.domComplete = domComplete;
    }

    /**
     * 
     */
    @JsonProperty("domContentLoadedEventEnd")
    @DynamoDBAttribute
    public Double getDomContentLoadedEventEnd() {
        return domContentLoadedEventEnd;
    }

    /**
     * 
     */
    @JsonProperty("domContentLoadedEventEnd")
    @DynamoDBAttribute
    public void setDomContentLoadedEventEnd(Double domContentLoadedEventEnd) {
        this.domContentLoadedEventEnd = domContentLoadedEventEnd;
    }

    /**
     * 
     */
    @JsonProperty("domContentLoadedEventStart")
    @DynamoDBAttribute
    public Double getDomContentLoadedEventStart() {
        return domContentLoadedEventStart;
    }

    /**
     * 
     */
    @JsonProperty("domContentLoadedEventStart")
    @DynamoDBAttribute
    public void setDomContentLoadedEventStart(Double domContentLoadedEventStart) {
        this.domContentLoadedEventStart = domContentLoadedEventStart;
    }

    /**
     * 
     */
    @JsonProperty("domInteractive")
    @DynamoDBAttribute
    public Double getDomInteractive() {
        return domInteractive;
    }

    /**
     * 
     */
    @JsonProperty("domInteractive")
    @DynamoDBAttribute
    public void setDomInteractive(Double domInteractive) {
        this.domInteractive = domInteractive;
    }

    /**
     * 
     */
    @JsonProperty("domLoading")
    @DynamoDBAttribute
    public Double getDomLoading() {
        return domLoading;
    }

    /**
     * 
     */
    @JsonProperty("domLoading")
    @DynamoDBAttribute
    public void setDomLoading(Double domLoading) {
        this.domLoading = domLoading;
    }

    /**
     * 
     */
    @JsonProperty("domainLookupEnd")
    @DynamoDBAttribute
    public Double getDomainLookupEnd() {
        return domainLookupEnd;
    }

    /**
     * 
     */
    @JsonProperty("domainLookupEnd")
    @DynamoDBAttribute
    public void setDomainLookupEnd(Double domainLookupEnd) {
        this.domainLookupEnd = domainLookupEnd;
    }

    /**
     * 
     */
    @JsonProperty("domainLookupStart")
    @DynamoDBAttribute
    public Double getDomainLookupStart() {
        return domainLookupStart;
    }

    /**
     * 
     */
    @JsonProperty("domainLookupStart")
    @DynamoDBAttribute
    public void setDomainLookupStart(Double domainLookupStart) {
        this.domainLookupStart = domainLookupStart;
    }

    /**
     * 
     */
    @JsonProperty("fetchStart")
    @DynamoDBAttribute
    public Double getFetchStart() {
        return fetchStart;
    }

    /**
     * 
     */
    @JsonProperty("fetchStart")
    @DynamoDBAttribute
    public void setFetchStart(Double fetchStart) {
        this.fetchStart = fetchStart;
    }

    /**
     * 
     */
    @JsonProperty("loadEventEnd")
    @DynamoDBAttribute
    public Double getLoadEventEnd() {
        return loadEventEnd;
    }

    /**
     * 
     */
    @JsonProperty("loadEventEnd")
    @DynamoDBAttribute
    public void setLoadEventEnd(Double loadEventEnd) {
        this.loadEventEnd = loadEventEnd;
    }

    /**
     * 
     */
    @JsonProperty("loadEventStart")
    @DynamoDBAttribute
    public Double getLoadEventStart() {
        return loadEventStart;
    }

    /**
     * 
     */
    @JsonProperty("loadEventStart")
    @DynamoDBAttribute
    public void setLoadEventStart(Double loadEventStart) {
        this.loadEventStart = loadEventStart;
    }

    /**
     * 
     */
    @JsonProperty("navigationStart")
    @DynamoDBAttribute
    public Double getNavigationStart() {
        return navigationStart;
    }

    /**
     * 
     */
    @JsonProperty("navigationStart")
    @DynamoDBAttribute
    public void setNavigationStart(Double navigationStart) {
        this.navigationStart = navigationStart;
    }

    /**
     * 
     */
    @JsonProperty("redirectEnd")
    @DynamoDBAttribute
    public Double getRedirectEnd() {
        return redirectEnd;
    }

    /**
     * 
     */
    @JsonProperty("redirectEnd")
    @DynamoDBAttribute
    public void setRedirectEnd(Double redirectEnd) {
        this.redirectEnd = redirectEnd;
    }

    /**
     * 
     */
    @JsonProperty("redirectStart")
    @DynamoDBAttribute
    public Double getRedirectStart() {
        return redirectStart;
    }

    /**
     * 
     */
    @JsonProperty("redirectStart")
    @DynamoDBAttribute
    public void setRedirectStart(Double redirectStart) {
        this.redirectStart = redirectStart;
    }

    /**
     * 
     */
    @JsonProperty("requestStart")
    @DynamoDBAttribute
    public Double getRequestStart() {
        return requestStart;
    }

    /**
     * 
     */
    @JsonProperty("requestStart")
    @DynamoDBAttribute
    public void setRequestStart(Double requestStart) {
        this.requestStart = requestStart;
    }

    /**
     * 
     */
    @JsonProperty("responseEnd")
    @DynamoDBAttribute
    public Double getResponseEnd() {
        return responseEnd;
    }

    /**
     * 
     */
    @JsonProperty("responseEnd")
    @DynamoDBAttribute
    public void setResponseEnd(Double responseEnd) {
        this.responseEnd = responseEnd;
    }

    /**
     * 
     */
    @JsonProperty("responseStart")
    @DynamoDBAttribute
    public Double getResponseStart() {
        return responseStart;
    }

    /**
     * 
     */
    @JsonProperty("responseStart")
    @DynamoDBAttribute
    public void setResponseStart(Double responseStart) {
        this.responseStart = responseStart;
    }

    /**
     * 
     */
    @JsonProperty("secureConnectionStart")
    @DynamoDBAttribute
    public Double getSecureConnectionStart() {
        return secureConnectionStart;
    }

    /**
     * 
     */
    @JsonProperty("secureConnectionStart")
    @DynamoDBAttribute
    public void setSecureConnectionStart(Double secureConnectionStart) {
        this.secureConnectionStart = secureConnectionStart;
    }

    /**
     * 
     */
    @JsonProperty("unloadEventEnd")
    @DynamoDBAttribute
    public Double getUnloadEventEnd() {
        return unloadEventEnd;
    }

    /**
     * 
     */
    @JsonProperty("unloadEventEnd")
    @DynamoDBAttribute
    public void setUnloadEventEnd(Double unloadEventEnd) {
        this.unloadEventEnd = unloadEventEnd;
    }

    /**
     * 
     */
    @JsonProperty("unloadEventStart")
    @DynamoDBAttribute
    public Double getUnloadEventStart() {
        return unloadEventStart;
    }

    /**
     * 
     */
    @JsonProperty("unloadEventStart")
    @DynamoDBAttribute
    public void setUnloadEventStart(Double unloadEventStart) {
        this.unloadEventStart = unloadEventStart;
    }

    @JsonProperty("uuid")
    @DynamoDBHashKey
    @DynamoDBAttribute
    public String getUuid() {
        return uuid;
    }

    @JsonProperty("uuid")
    @DynamoDBHashKey
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @JsonProperty("mtime")
    @DynamoDBRangeKey
    public Double getMtime() {
        return mtime;
    }

    @JsonProperty("mtime")
    @DynamoDBAttribute
    public void setMtime(Double mtime) {
        this.mtime = mtime;
    }

    @JsonProperty("useragent")
    @DynamoDBAttribute
    public String getUseragent() {
        return useragent;
    }

    @JsonProperty("useragent")
    @DynamoDBAttribute
    public void setUseragent(String useragent) {
        this.useragent = useragent;
    }

    @JsonProperty("platform")
    @DynamoDBAttribute
    public String getPlatform() {
        return platform;
    }

    @JsonProperty("platform")
    @DynamoDBAttribute
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @JsonProperty("language")
    @DynamoDBAttribute
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    @DynamoDBAttribute
    public void setLanguage(String language) {
        this.language = language;
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
