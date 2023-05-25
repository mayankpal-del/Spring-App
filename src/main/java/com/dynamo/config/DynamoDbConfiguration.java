package com.dynamo.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.PropertySource;




import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;


//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import org.springframework.context.annotation.PropertySource;
//import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
//import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
//import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

@Configuration
@PropertySource("classpath:application-local.properties")
public class DynamoDbConfiguration {

    @Value("${aws.dynamodb.endpoint}")
    private String dynamoDbEndpoint;
    @Value("${aws.dynamodb.accessKey}")
    private String awsAccessKey;
    @Value("${aws.dynamodb.secretKey}")
    private String awsSecretKey;


    @Bean
    public DynamoDBMapper dynamoDBMapper(){
        return new DynamoDBMapper(amazonDynamoDb());
    }


    private AmazonDynamoDB amazonDynamoDb() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(dynamoDbEndpoint, "us-east-1"))
                .withCredentials(amazonDynamoDBCredentials()).build();
    }
    private AWSCredentialsProvider amazonDynamoDBCredentials() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
    }
}

//    @Bean
//    public DynamoDbClient dynamoDbClient(){
//        return DynamoDbClient.builder()
//                .region(Region.of("us-east-1"))
//                .endpointOverride(URI.create("http://localhost:8000"))
//                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("fakeMyKeyId","fakeSecretAccessKey")))
//                .build();

//    private AmazonDynamoDB amazonDynamoDb() {
//        return AmazonDynamoDBClientBuilder.standard()
//                .withCredentials(new AwsStaticCredentialsProvider(new BasicAwsCredentials(accessKey,secretKey)))
//                .withEndpointConfiguration(
//                        new AwsClientBuilder.EndpointConfiguration(endpoint, region))
//                .build();


//    }
//    @Bean
//    public DynamoDBMapper dynamoDBMapper(DynamoDbClient dynamoDbClient){
//        return new DynamoDBMapper((AmazonDynamoDB) dynamoDbClient, DynamoDBMapperConfig.DEFAULT);
//    }
//
//}
