package com.example.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "qna")
public class Qna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 500)
	private String title;
	
	@Column(length = 4000)
	private String content;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "writer")
	private Member memberid;
	
	private LocalDateTime regDate = LocalDateTime.now();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "qnaid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Comment> comments;
	
}
