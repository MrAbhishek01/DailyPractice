package com.abhi.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.abhi.entity.Movie;
import com.abhi.service.IService;

@Component
public class RunMethod implements CommandLineRunner {

	@Autowired
	private IService movieService;

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		/*	Movie movie = new Movie();
			movie.setMname("BBi-3");
			movie.setYear("2024");
			movie.setRating(4.2f);
			movie.setLocalDateTime(LocalDateTime.of(2013, 10, 21, 10, 50));
			movie.setLocalDate(LocalDate.of(2012, 10, 20));
			movie.setLocalTime(LocalTime.of(20, 30));
		
			System.out.println("Enter photo file path:");
			String photoPath = scanner.nextLine();
			System.out.println("Enter resume file path:");
			String resumePath = scanner.nextLine();
		
			// Read photo as byte[]
			File photoFile = new File(photoPath);
			if (photoFile.exists()) {
				try (FileInputStream fis = new FileInputStream(photoFile)) {
					movie.setPhotos(fis.readAllBytes());
				}
			} else {
				System.out.println("Photo file not found!");
			}
		
			// Read resume as char[]
			File resumeFile = new File(resumePath);
			if (resumeFile.exists()) {
				try (FileReader fileReader = new FileReader(resumeFile)) {
					char[] resumeData = new char[(int) resumeFile.length()];
					fileReader.read(resumeData);
					movie.setResume(resumeData);
				}
			} else {
				System.out.println("Resume file not found!");
			}
		
			System.out.println(movieService.insertDetails(movie));*/

		/*System.out.println("Enter movieId for the updating");
		int id = scanner.nextInt();
		System.err.println(movieService.updateDetails(id, "Hanuman", "2024"));*/
		movieService.getReport(300000000);
	}
}
