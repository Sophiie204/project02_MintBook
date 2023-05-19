package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;

import com.example.model.Book;
import com.example.model.Cartitem;
import com.example.model.DTO.BooklistResponseDTO;

public interface BookRepository extends JpaRepository<Book, Integer> {

	//베스트셀러
	Page<BooklistResponseDTO> findByGenre(int genre, Pageable pageable);

	//베스트셀러(카테고리 엔티티)
	Page<Book> findAllByGenre(int genre, PageRequest pageRequest);

	//장바구니 추가(한개)
	Book findBookById(int id);

	List<Book> findAllByIdIn(List<Integer> lists); //혹시 오류나면 얘 고쳐보기!

	//장르별 베스트셀러(sort by hit)
	Page<Book> findAllByGenre(int genre, Pageable pageable);

	//검색결과페이지(혹시 오류나면 Bookname으로 고쳐보기)
	Page<Book> findByBookNameContainingOrAuthorContaining(String bookName, String author, Pageable pageable);

	//관리자 검색결과페이지
	Page<Book> findByBookNameContainingOrAuthorContainingOrIsbnContainingOrPublisherContaining(String bookName,
			String author, String isbn, String publisher, Pageable pageable);







	

	
}
