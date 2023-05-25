package com.dynamo.services;
import com.dynamo.dbentitiy.Movie;
import com.dynamo.repository.MovieRepository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Data;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

@Service
public class MovieService {
    private static Logger logger = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    private MovieRepository movieRepository;

    public Movie save(Movie movie){
        logger.info("save movie " + this.getClass().getName());
        return movieRepository.save(movie);
    }
    public List<Movie> readCsv() {
        List<Movie> movies = new ArrayList<>();


//        public String[] readCsv(){
//        String[] record =new String[20];
        try {
            Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\maypal\\Downloads\\movies.csv"));
            CSVReader csvReader = new CSVReader(reader);
            String[] rec;
            while ((rec = csvReader.readNext()) != null) {
                Movie movie = new Movie();
                movie.setImdb_title_id(rec[0]);

                movie.setTitle(rec[1]);
                movie.setOriginal_title(rec[2]);
                movie.setYear(rec[3]);
                movie.setDate_published(rec[4]);
                movie.setGenre(rec[5]);
                movie.setDuration(rec[6]);
                movie.setCountry(rec[7]);
                movie.setLanguage(rec[8]);
                movie.setDirector(rec[9]);
                movie.setWriter(rec[10]);
                movie.setProduction_company(rec[11]);
                movie.setActors(rec[12]);
                movie.setDescription(rec[13]);
                movie.setAvg_vote(rec[14]);
                movie.setVotes(rec[15]);
                movie.setBudget(rec[16]);
                movie.setUsa_gross_income(rec[17]);
                movie.setWorldwide_gross_income(rec[18]);
                movie.setMetascore(rec[19]);
                movie.setReviews_from_users(rec[20]);
                movie.setReviews_from_critics(rec[21]);
                movieRepository.save(movie);
                movies.add(movie);
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    public List<Movie> saveAll(List<Movie> movieList){
        logger.info("save movie " + this.getClass().getName());
        return  movieRepository.saveAll(movieList);
    }

    public Movie findById(String id){
        logger.info("find movie by id" + this.getClass().getName());
        return movieRepository.findById(id);
    }

    public List<Movie> findAll(){
        logger.info("findAll movies " + this.getClass().getName());
        return movieRepository.findAll();
    }

//    public String update(String id, Movie movie){
//        logger.info("update movie " + this.getClass().getName());
//        return movieRepository.update(id, movie);
//    }

    public String delete(String id){
        logger.info("Edit Configurations… movie " + this.getClass().getName());
        return movieRepository.delete(id);
    }

}
