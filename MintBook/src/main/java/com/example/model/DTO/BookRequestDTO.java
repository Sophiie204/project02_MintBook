package com.example.model.DTO;

import java.time.LocalDate;

import com.example.model.Book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDTO {
	
	private String bookName;
	private String author;
	private String authorInfo;
	private String bookInfo;
	private String img;
	private int price;
	private String publisher;
	private LocalDate pubDate;
	private String isbn;
	private int genre;
}
