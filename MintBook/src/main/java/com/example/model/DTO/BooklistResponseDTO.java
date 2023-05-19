package com.example.model.DTO;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Order;

import com.example.model.Book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooklistResponseDTO {

	private int id;
	private String isbn;
	private int hit;
	private String bookName;
	private String author;
	private String authorInfo;
	private String publisher;
	private LocalDate pubDate;
	private int price;
	private String bookInfo;
	private String img;
	private int genre;
	
	public BooklistResponseDTO(Book book) {
		this.bookName = book.getBookName();
		this.author = book.getAuthor();
		this.authorInfo = book.getAuthorInfo();
		this.publisher = book.getPublisher();
		this.pubDate = book.getPubDate();
		this.price = book.getPrice();
		this.bookInfo = book.getBookInfo();
		this.img = book.getImg();
		this.hit = book.getHit();
		this.id = book.getId();
		this.genre = book.getGenre();
	}

	//장르별 베스트셀러
	public Page<BooklistResponseDTO> toDtoList(Page<Book> genrebestlist) {
		Page<BooklistResponseDTO> bookDtoList = genrebestlist.map(m -> 
		BooklistResponseDTO.builder()
							.bookName(m.getBookName())
							.author(m.getAuthor())
							.authorInfo(m.getAuthorInfo())
							.publisher(m.getPublisher())
							.pubDate(m.getPubDate())
							.price(m.getPrice())
							.bookInfo(m.getBookInfo())
							.img(m.getImg())
							.hit(m.getHit())
							.id(m.getId())
							.genre(m.getGenre())
							.build());
		return bookDtoList;
	}

	//검색결과 리스트
	public Page<BooklistResponseDTO> searchtoDto(Page<Book> bookList) {
		Page<BooklistResponseDTO> searchDtoList = bookList.map(m->
							BooklistResponseDTO.builder()
							.bookName(m.getBookName())
							.author(m.getAuthor())
							.isbn(m.getIsbn())
							.authorInfo(m.getAuthorInfo())
							.publisher(m.getPublisher())
							.pubDate(m.getPubDate())
							.price(m.getPrice())
							.bookInfo(m.getBookInfo())
							.img(m.getImg())
							.hit(m.getHit())
							.id(m.getId())
							.genre(m.getGenre())
							.build());
		return searchDtoList;
	}
	
	

}
