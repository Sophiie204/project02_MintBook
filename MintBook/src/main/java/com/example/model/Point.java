package com.example.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "point")
public class Point {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member memberid;
	
	private int prevPoint;
	
	private int changePoint;
	
	private int presentPoint;
	
	private LocalDateTime regDate = LocalDateTime.now();
	
}
