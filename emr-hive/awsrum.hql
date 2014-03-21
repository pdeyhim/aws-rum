add jar s3://emrtools/hive/jsonserde/json-serde.jar;

SET kinesis.nodata.timeout=1;
SET hive.exec.dynamic.partition = true;
SET hive.exec.dynamic.partition.mode = nonstrict;

create table if not exists browsertiming (loadEventEnd double,
loadEventStart double,
domComplete double,
domContentLoadedEventEnd double,
domContentLoadedEventStart double,
domInteractive double, 
domLoading double, 
responseEnd double ,
responseStart double, 
requestStart double, 
secureConnectionStart double, 
connectEnd double, 
connectStart double, 
domainLookupEnd double, 
domainLookupStart double,
fetchStart double, 
redirectEnd double, 
redirectStart double, 
unloadEventEnd double,
unloadEventStart double,
navigationStart double,
platform String,
language string,
uuid string,
mtime double) ROW FORMAT SERDE 'org.openx.data.jsonserde.JsonSerDe'
STORED BY 'com.amazon.emr.kinesis.hive.KinesisStorageHandler'
TBLPROPERTIES("kinesis.stream.name"="$KINESISSTREAM");

create table if not exists S3_PARTITIONED_TABLE (loadEventEnd double,
loadEventStart double,
domComplete double,
domContentLoadedEventEnd double,
domContentLoadedEventStart double,
domInteractive double, 
domLoading double, 
responseEnd double ,
responseStart double, 
requestStart double, 
secureConnectionStart double, 
connectEnd double, 
connectStart double, 
domainLookupEnd double, 
domainLookupStart double,
fetchStart double, 
redirectEnd double, 
redirectStart double, 
unloadEventEnd double,
unloadEventStart double,
navigationStart double,
platform String,
language string,
uuid string,
mtime string) PARTITIONED BY (year string, month string, day string ) ROW FORMAT SERDE 'org.openx.data.jsonserde.JsonSerDe' location "$S3_DATA_LOCATION";

insert into table S3_PARTITIONED_TABLE partition (year,month,day) select *,YEAR(from_unixtime(cast(mtime/1000 as bigint))),MONTH(from_unixtime(cast(mtime/1000 as bigint))),DAY(from_unixtime(cast(mtime/1000 as bigint))) from browsertiming;