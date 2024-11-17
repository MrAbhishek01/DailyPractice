package com.abhi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abhi.entity.Movie;

public interface IJPARepoQuery extends JpaRepository<Movie, Integer> {
    @Query("FROM Movie")
    List<Movie> retriveMovieDetails();
}
