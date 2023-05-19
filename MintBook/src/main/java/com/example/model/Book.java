package com.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 255, nullable = false)
	private String bookName;
	
	@Column(length = 100)
	private String author;
	
	@Column(length = 4000)
	private String authorInfo;
	
	@Column(length = 4000)
	private String bookInfo;
	
	private String img;
	
	private int price;
	
	private String publisher;
	
	private LocalDate pubDate;
	
	private LocalDateTime regDate = LocalDateTime.now();
	
	@Column(length = 255)
	private String isbn;
	
	private int hit;
	
	private int genre;
	
	private int star;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "bookid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Review> reviews;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "bookid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Editorpick> editorpicks;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "bookid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Eventbook> eventbooks;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "bookid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Wishlist> whishlists;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "bookid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Cartitem> cartitems;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "bookid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Orderitem> orderitems;

	public Book update(String bookName, String author, String bookInfo, String authorInfo, int genre, String img,
			String isbn, int price, String publisher, LocalDate pubDate) {
		this.bookName = bookName;
		this.author = author;
		this.bookInfo = bookInfo;
		this.authorInfo = authorInfo;
		this.genre = genre;
		this.img = img;
		this.isbn = isbn;
		this.price = price;
		this.publisher = publisher;
		this.pubDate = pubDate;
		return this;
	}
}
