package com.example.model.DTO;

import com.example.model.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDTO {

	private String content;
	private String writer;
	private int star;
	private String bookid;
	private String memberid;
}
