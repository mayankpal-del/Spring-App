package com.dynamo.controllers;


import java.util.List;

import com.dynamo.services.MovieService;
//import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dynamo.dbentitiy.Movie;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
@RequestMapping("api/movies")
public class MovieController {
    private static Logger logger = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    private MovieService movieService;

    @PostMapping("/importCsv")
    public List<Movie>importCsv(){
        return movieService.readCsv();
    }



    @PostMapping
    public Movie save(@RequestBody Movie movie){
        logger.info("save movie " + this.getClass().getName());
        return movieService.save(movie);
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable(value = "id") String id){
        logger.info("find movie by id" + this.getClass().getName());
        return movieService.findById(id);
    }

    @GetMapping
    public List<Movie> findAll(){
        logger.info("findAll books " + this.getClass().getName());
        return movieService.findAll();
    }

//    @PutMapping("/{id}")
//    public String update(@PathVariable(value = "id") String id,
//                         @RequestBody Movie movie){
//        logger.info("update movie " + this.getClass().getName());
//        return movieService.update(id, movie);
//    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") String id){
        logger.info("delete movie " + this.getClass().getName());
        return movieService.delete(id);
    }
}
