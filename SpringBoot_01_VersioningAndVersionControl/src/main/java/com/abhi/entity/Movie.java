package com.abhi.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import lombok.Data;

@Entity
@Data
public class Movie {

	@Id
	@SequenceGenerator(name = "movie_seq", sequenceName = "mid_sequence", initialValue = 300000000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
	private Integer mid;
	@Column(length = 20)
	private String mname;
	@Column(length = 20)
	private String year;
	private Float rating;
	// Working with files
	@Lob
	private byte[] photos;
	@Lob
	private char[] resume;

	private LocalDateTime localDateTime;
	private LocalTime localTime;
	private LocalDate localDate;

	@Version
	private Integer updatedCount;

	@CreationTimestamp
	@Column(insertable = true, updatable = false)
	private LocalDateTime serviceOptedOn;

	@UpdateTimestamp
	@Column(insertable = false, updatable = true)
	private LocalDateTime lastelyUpdateon;
}
