package com.example.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 4000)
	private String content;
	
	@Column(length = 255)
	private String writer;
	
	private LocalDateTime regDate = LocalDateTime.now();
	
	private int star;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book bookid;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "writer_id")
	private Member memberid;
}
