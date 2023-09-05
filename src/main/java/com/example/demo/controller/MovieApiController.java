package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.model.MovieResponse;
import com.example.demo.controller.model.Response;
import com.example.demo.database.MovieRepository;
import com.example.demo.database.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MovieApiController implements MovieApi {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public ResponseEntity<MovieResponse> add(@Valid com.example.demo.controller.model.Movie movie) {

        Movie mov = movieToDbEntity(movie);
        Movie saved = movieRepository.saveAndFlush(mov);
        Long newId = saved.getId();
        log.info("New ID: " + newId);
        Optional<Movie> optResult = movieRepository.findById(newId);
        com.example.demo.database.entity.Movie result;
        Response status = Response.NO;
        if (optResult.isPresent()) {
            result = optResult.get();
            movie.setId(result.getId());
            status = Response.YES;
        }

        MovieResponse res = MovieResponse.builder().movie(movie).response(status).build();

        return ResponseEntity.ok(res);
    }

    @Override
    public ResponseEntity<MovieResponse> all() {
        List<Movie> movies = movieRepository.findAll();
        List<com.example.demo.controller.model.Movie> moviesRes = new ArrayList<com.example.demo.controller.model.Movie>();
        for (Movie movie : movies) {
            moviesRes.add(movieFromDbEntity(movie));
        }
        MovieResponse res = MovieResponse.builder().movies(moviesRes).response(Response.YES).build();
        return ResponseEntity.ok(res);
    }

    @Override
    public ResponseEntity<MovieResponse> find(String id) {
        Optional<Movie> movie = movieRepository.findById(Long.valueOf(id));

        if (movie.isPresent()) {
            return ResponseEntity.ok(MovieResponse.builder().movie(movieFromDbEntity(movie.get())).response(Response.YES).build());
        }
        return ResponseEntity.ok(MovieResponse.builder().response(Response.NO).build());
    }

    private Movie movieToDbEntity(com.example.demo.controller.model.Movie movie) {
        return Movie.builder().title(movie.getTitle()).release(movie.getRelease()).rating(movie.getRating()).build();
    }

    private com.example.demo.controller.model.Movie movieFromDbEntity(Movie movie) {
        return com.example.demo.controller.model.Movie.builder().title(movie.getTitle()).release(movie.getRelease())
                .rating(movie.getRating()).build();
    }
}
