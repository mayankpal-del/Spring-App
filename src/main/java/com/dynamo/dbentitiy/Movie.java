package com.dynamo.dbentitiy;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.annotation.Contract;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@DynamoDBTable(tableName = "movies")
@Data
public class Movie {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String imdb_title_id;
    @DynamoDBAttribute
    private String title;
    @DynamoDBAttribute
    private String original_title;
    @DynamoDBAttribute
    private String year;
    @DynamoDBAttribute
    private String date_published;
    @DynamoDBAttribute
    private String genre;
    @DynamoDBAttribute
    private String duration;
    @DynamoDBAttribute
    private String country;
    @DynamoDBAttribute
    private String language;
    @DynamoDBAttribute
    private String director;
    @DynamoDBAttribute
    private String writer;
    @DynamoDBAttribute
    private String production_company;
    @DynamoDBAttribute
    private String actors;
    @DynamoDBAttribute
    private String description;
    @DynamoDBAttribute
    private String avg_vote;
    @DynamoDBAttribute
    private String votes;
    @DynamoDBAttribute
    private String budget;
    @DynamoDBAttribute
    private String usa_gross_income;
    @DynamoDBAttribute
    private String worldwide_gross_income;
    @DynamoDBAttribute
    private String metascore;
    @DynamoDBAttribute
    private String reviews_from_users;
    @DynamoDBAttribute
    private String reviews_from_critics;

//    @DynamoDbPartitionKey
//    public String getImdb_title_id() {
//        return imdb_title_id;
//    }
}


//    public void setimdb_title_id(String imdb_title_id) {
//        this.imdb_title_id = imdb_title_id;
//    }
//
//    public void settitle(String title) {
//
//        this.title = title;
//    }
//
//    public void setoriginal_title(String original_title) {
//        this.original_title = original_title;
//
//    }
//
//    public void setYear(String year) {
//        this.year = year;
//    }
//
//
//    public void setdate_published(String date_published) {
//        this.date_published = date_published;
//    }
//
//    public void setgenre(String genre) {
//        this.genre = genre;
//    }
//
//
//    public void setduration(String genre) {
//        this.genre = genre;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public void setlanguage(String language) {
//        this.language = language;
//    }
//
//    public void setDirector(String director) {
//
//        this.director = director;
//    }
//
//    public void setwriter(String writer) {
//        this.writer = writer;
//    }
//
//    public void setproduction_company(String production_company) {
//        this.production_company = production_company;
//    }
//
//    public void setactors(String actors) {
//        this.actors = actors;
//    }
//
//    public void setdescription(String description) {
//        this.description = description;
//    }
//
//    public void setavg_vote(String avg_vote) {
//        this.avg_vote = avg_vote;
//    }
//
//    public void setvotes(String votes) {
//        this.votes = votes;
//    }
//
//    public void setbudget(String budget) {
//        this.budget = budget;
//    }
//
//    public void setusa_gross_income(String usa_gross_income) {
//        this.usa_gross_income = usa_gross_income;
//    }
//
//    public void setworldwide_gross_income(String worlwide_gross_income) {
//        this.worlwide_gross_income = worlwide_gross_income;
//    }
//
//    public void setmetascore(String metascore) {
//        this.metascore = metascore;
//    }
//
//    public void setreviews_from_users(String reviews_from_users) {
//        this.reviews_from_users = reviews_from_users;
//    }
//
//    public void setreviews_from_critics(String reviews_from_critics) {
//        this.reviews_from_critics = reviews_from_critics;
//    }

//}