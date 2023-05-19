package com.example.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.Book;
import com.example.model.Cartitem;
import com.example.model.Orderitem;
import com.example.model.DTO.BookRequestDTO;
import com.example.model.DTO.BooklistResponseDTO;
import com.example.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	//도서 등록하기
		public void addbook(BookRequestDTO dto) {
			Book addBook = new Book();
			addBook.setBookName(dto.getBookName());
			addBook.setAuthor(dto.getAuthor());
			addBook.setAuthorInfo(dto.getAuthorInfo());
			addBook.setBookInfo(dto.getBookInfo());
			addBook.setImg(dto.getImg());
			addBook.setPrice(dto.getPrice());
			addBook.setPublisher(dto.getPublisher());
			addBook.setPubDate(dto.getPubDate());
			addBook.setIsbn(dto.getIsbn());
			addBook.setGenre(dto.getGenre());
			
			Book result =bookRepository.save(addBook);
			
		}

	//도서 개별 불러오기(장바구니담기)
	public Book findBook(Integer id) {
		return bookRepository.findById(id).get();
	}

	public Book findById(int bookid) {
		return bookRepository.findById(bookid).get();
	}

	public Book update(int id, String bookName, String author, String bookInfo, String authorInfo, int genre,
			String img, String isbn, int price, String publisher, LocalDate pubDate) {
		Book book = bookRepository.findById(id).get();
		Book result = book.update(bookName, author, bookInfo, authorInfo, genre, img, isbn, price, publisher, pubDate);
		return result;
	}

	public void delete(int id) {
		bookRepository.deleteById(id);
		
	}

	public void save(Book book) {
		bookRepository.save(book);	
	}

	public List<Book> findAllByIdIn(List<Integer> selectedids) {
		return bookRepository.findAllByIdIn(selectedids);
	}




	







	
	
	
	





	
	
}
