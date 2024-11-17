package com.abhi.service;

import com.abhi.entity.Movie;

public interface IService {
    void getReport(int id);
    
    String insertDetails(Movie movie);
    String updateDetails(int id, String movieName, String movieReleaseDate);
}
