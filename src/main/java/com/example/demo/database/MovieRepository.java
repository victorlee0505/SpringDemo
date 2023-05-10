package com.example.demo.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.database.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    
}
