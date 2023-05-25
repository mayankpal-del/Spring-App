package com.dynamo.repository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.dynamo.dbentitiy.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
////import com.amazonaws.services.dynamodbv2.model.AttributeValue;
//import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
//import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
//import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
//import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
//import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
//import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;
//import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
@Repository
public class MovieRepository {
//    private final DynamoDbClient dynamoDbClient;
    private final String tableName = "movies";

    @Autowired
    private DynamoDBMapper dynamoDBMapper;
//    public MovieRepository(DynamoDbClient dynamoDbClient) {
//        this.dynamoDbClient = dynamoDbClient;
//    }
//    public Movie save(Movie movie) {
//        Map<String, AttributeValue> itemValues = new HashMap<>();
//        itemValues.put("imdb_title_id", AttributeValue.builder().s(movie.getImdb_title_id()).build());
//        itemValues.put("title", AttributeValue.builder().s(movie.getTitle()).build());
//        itemValues.put("original_title", AttributeValue.builder().s(movie.getOriginal_title()).build());
//        itemValues.put("year", AttributeValue.builder().s(movie.getYear()).build());
//        itemValues.put("date_published", AttributeValue.builder().s(movie.getDate_published()).build());
//        itemValues.put("genre", AttributeValue.builder().s(movie.getGenre()).build());
//        itemValues.put("duration", AttributeValue.builder().s(movie.getDuration()).build());
//        itemValues.put("country", AttributeValue.builder().s(movie.getCountry()).build());
//        itemValues.put("language", AttributeValue.builder().s(movie.getLanguage()).build());
//        itemValues.put("director", AttributeValue.builder().s(movie.getDirector()).build());
//        itemValues.put("writer", AttributeValue.builder().s(movie.getWriter()).build());
//        itemValues.put("production_company", AttributeValue.builder().s(movie.getProduction_company()).build());
//        itemValues.put("actors", AttributeValue.builder().s(movie.getActors()).build());
//        itemValues.put("description", AttributeValue.builder().s(movie.getDescription()).build());
//        itemValues.put("avg_vote", AttributeValue.builder().s(movie.getAvg_vote()).build());
//        itemValues.put("votes", AttributeValue.builder().s(movie.getVotes()).build());
//        itemValues.put("budget", AttributeValue.builder().s(movie.getBudget()).build());
//        itemValues.put("usa_gross_income", AttributeValue.builder().s(movie.getUsa_gross_income()).build());
//        itemValues.put("worldwide_gross_income", AttributeValue.builder().s(movie.getWorldwide_gross_income()).build());
//        itemValues.put("metascore", AttributeValue.builder().s(movie.getMetascore()).build());
//        itemValues.put("reviews_from_users", AttributeValue.builder().s(movie.getReviews_from_users()).build());
//        itemValues.put("reviews_from_critics", AttributeValue.builder().s(movie.getReviews_from_critics()).build());
//
//        PutItemRequest request = PutItemRequest.builder()
//                .tableName("movies")
//                .item(itemValues)
//                .build();
//
//        dynamoDbClient.putItem(request);
//        return movie;
//    }

        public Movie save(Movie movie){
        dynamoDBMapper.save(movie);
        return movie;
    }

    public List<Movie> saveAll(List<Movie> bookList){
        dynamoDBMapper.batchSave(bookList);
        return bookList;
    }

    public Movie findById(String id){
        return dynamoDBMapper.load(Movie.class, id);
    }

    public List<Movie> findAll(){
        return dynamoDBMapper.scan(Movie.class, new DynamoDBScanExpression());
    }

//    public String update(String id, Movie movie){
//        dynamoDBMapper.save(movie,
//                new DynamoDBSaveExpression()
//                        .withExpectedEntry("id",
//                                new ExpectedAttributeValue(
//                                        new AttributeValue().withS(id)
//                                )));
//        return id;
//    }

    public String delete(String id){
        Movie book = dynamoDBMapper.load(Movie.class, id);
        dynamoDBMapper.delete(book);
        return "Movie deleted successfully:: "+id;
    }


}
