package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.MovieRepository;
import com.example.demo.database.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/movie")
@Slf4j
public class MovieApi {

    @Autowired 
    private MovieRepository movieRepository;
    
    /**
     * http://localhost:8080/movie/all
     */
    @GetMapping(value = { "/all" }, produces = "application/json")
    public List<Movie> getAllMovies() {

        List<Movie> movies = movieRepository.findAll();

        return movies;

    }
    
    /**
     * http://localhost:8080/movie/find/1
     */
    @GetMapping(value = { "/find/{id}" }, produces = "application/json")
    public Movie getMovieById(@PathVariable("id") String id) {

        Optional<Movie> movie = movieRepository.findById(Long.valueOf(id));

        if(movie.isPresent()){
            return movie.get();
        }
        return null;
    }


    /**
     * POST http://localhost:8080/movie/add
     * 
     * 
    {
        "title": "movie4",
        "release": 2023,
        "rating": 5
    }
     */
    @PostMapping(value = { "/add" }, produces = "application/json")
    public Movie addNewMovie(final @RequestBody(required = true) Movie newMovie) {

        Movie saved = movieRepository.saveAndFlush(newMovie);
        Long newId = saved.getId();
        log.info("New ID: " + newId);
        Optional<Movie> movie = movieRepository.findById(newId);

        if(movie.isPresent()){
            return movie.get();
        }
        return null;
    }
}
