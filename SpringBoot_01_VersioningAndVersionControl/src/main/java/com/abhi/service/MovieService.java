package com.abhi.service;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.entity.Movie;
import com.abhi.repository.IJPARepoQuery;

@Service
public class MovieService implements IService {

	@Autowired
	private IJPARepoQuery query;

	@Override
	public void getReport(int id) {
		// List<Movie> movies = query.retriveMovieDetails();
		// query.findAll().forEach(System.out::println);
		// movies.forEach(System.out::println);
		Optional<Movie> byId = query.findById(id);
		if (byId.isEmpty()) {
			System.out.println("Movie with ID " + id + " not found!");
			return;
		}

		Movie movie = byId.get();
		byte[] photos = movie.getPhotos();
		char[] resume = movie.getResume();

		// Save photo and resume to files
		String photoFileName = "photo_" + movie.getMid() + ".jpg";
		String resumeFileName = "resume_" + movie.getMid() + ".txt";

		try (FileOutputStream fos = new FileOutputStream(photoFileName);
				FileWriter fw = new FileWriter(resumeFileName)) {
			fos.write(photos);
			fos.flush();
			fw.write(resume);
			fw.flush();
			System.out.println("Files saved successfully: " + photoFileName + " and " + resumeFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String insertDetails(Movie movie) {
		Movie savedMovie = query.save(movie);
		return "Movie saved with ID: " + savedMovie.getMid();
	}

	@Override
	public String updateDetails(int id, String movieName, String movieReleaseDate) {
		Movie movie = query.findById(id).orElseThrow(() -> new IllegalArgumentException("Movie not found"));
		movie.setMname(movieName);
		movie.setYear(movieReleaseDate);
		query.save(movie);
		return "Movie details updated successfully";
	}
}
