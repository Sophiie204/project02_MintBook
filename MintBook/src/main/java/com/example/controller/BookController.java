package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Book;
import com.example.model.DTO.BookRequestDTO;
import com.example.model.DTO.BooklistResponseDTO;
import com.example.model.DTO.EditorResponseDTO;
import com.example.repository.BookRepository;
import com.example.repository.EditorpickRepository;
import com.example.service.BookService;

import jakarta.transaction.Transactional;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private EditorpickRepository editorpickRepository;
	
	//관리자페이지---------------------------------------------------------------------------------------------//
	
	//도서 등록(Create)
	@PostMapping("/api/add/book")
	public ResponseEntity addBook(@RequestBody BookRequestDTO dto) {	
		bookService.addbook(dto);
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	//------------------------------------------------------------------------------------------------------//
	
	
	//메인페이지----------------------------------------------------------------------------------------------//
	
	//베스트셀러 목록(Read)
	@GetMapping("/api/get/bestseller")
	public Page<BooklistResponseDTO> bestseller(@PageableDefault(size=10, 
																 sort = "hit", 
																 direction = Sort.Direction.DESC) 
																 Pageable pageable){
		Page<BooklistResponseDTO> map = bookRepository.findAll(pageable).map(BooklistResponseDTO::new);
		return map;
	}
	
	
	//신간 목록top5(Read)
	@GetMapping("/api/get/main/new")
	public Page<BooklistResponseDTO> mainNew(@PageableDefault(size=5, 
																 sort = "regDate", 
																 direction = Sort.Direction.DESC) 
																 Pageable pageable){
		Page<BooklistResponseDTO> map = bookRepository.findAll(pageable).map(BooklistResponseDTO::new);
		return map;
	}
	
	//에디터's Pick(메인페이지 top5)
	@GetMapping("/api/get/main/editor")
	public Page<EditorResponseDTO> mainEditor(@PageableDefault(size=5, 
																 sort = "regDate", 
																 direction = Sort.Direction.DESC) 
																 Pageable pageable){
		Page<EditorResponseDTO> map = editorpickRepository.findAll(pageable).map(EditorResponseDTO::new);
		return map;
	}
	
	//--------------------------------------------------------------------------------------------------------//
	
	
	//베스트셀러 페이지-------------------------------------------------------------------------------------------//
	
	//장르별 베스트셀러(hit으로 sorting 됨)
	@GetMapping("/api/get/bestseller/genre")
	public ResponseEntity BestsellerByGenre(Model model, @RequestParam("genre") int genre,
									@PageableDefault(size=10, sort="hit", direction = Sort.Direction.DESC)
									Pageable pageable) {
		Page<Book> genrebestlist = bookRepository.findAllByGenre(genre, pageable);
		Page<BooklistResponseDTO> dto = new BooklistResponseDTO().toDtoList(genrebestlist);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	//--------------------------------------------------------------------------------------------------------//
	
	
	//이달의 신간 페이지-------------------------------------------------------------------------------------------//
	
	//이 달의 시간 전체 목록
	@GetMapping("/api/get/new")
	public Page<BooklistResponseDTO> newBooks(@PageableDefault(size=10, 
						 										sort = "regDate", 
																direction = Sort.Direction.DESC) 
																Pageable pageable){
		Page<BooklistResponseDTO> map = bookRepository.findAll(pageable).map(BooklistResponseDTO::new);
		return map;
	}
	
	//장르별 신간(regDate로 sorting)
	@GetMapping("/api/get/new/genre")
	public ResponseEntity newByGenre(Model model, @RequestParam("genre") int genre,
									@PageableDefault(size=10, sort="regDate", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<Book> genrebestlist = bookRepository.findAllByGenre(genre, pageable);
		Page<BooklistResponseDTO> dto = new BooklistResponseDTO().toDtoList(genrebestlist);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	//--------------------------------------------------------------------------------------------------------//
	
	
	//책 상세 페이지---------------------------------------------------------------------------------------------//
	
	//책 한권 정보
	@GetMapping("/api/get/book")
	public ResponseEntity bookDetail(@RequestParam("id") int id) {
		Book book = bookService.findById(id);
		
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	//--------------------------------------------------------------------------------------------------------//
	
	
	//검색 페이지---------------------------------------------------------------------------------------------//
	@GetMapping("/api/get/search")
	public ResponseEntity getSearch(Model model, 
									@PageableDefault(size=10, sort="hit", direction = Sort.Direction.DESC)
									Pageable pageable,
									@RequestParam(defaultValue = "") String searchTerm) {
		Page<Book> bookList = bookRepository.findByBookNameContainingOrAuthorContaining(searchTerm, searchTerm, pageable);
		Page<BooklistResponseDTO> searchDto = new BooklistResponseDTO().searchtoDto(bookList);
		
//		int startPage = Math.max(1, searchDto.getPageable().getPageNumber()-10);
//		int endPage = Math.min(searchDto.getTotalPages(), searchDto.getPageable().getPageNumber()+10);
//		
//		model.addAttribute("startPage",startPage);
//		model.addAttribute("endPage", endPage);
//		model.addAttribute("searchDto", searchDto);
		
		return new ResponseEntity<>(searchDto, HttpStatus.OK);
	}
	//--------------------------------------------------------------------------------------------------------//
	
	
	//관리자 페이지---------------------------------------------------------------------------------------------//
	
	//책 검색
	@GetMapping("/api/admin/get/search")
	public ResponseEntity getASearch(Model model, 
									@PageableDefault(size=10, sort="regDate", direction = Sort.Direction.DESC)
									Pageable pageable,
									@RequestParam(defaultValue = "") String searchTerm) {
		Page<Book> bookList = bookRepository.findByBookNameContainingOrAuthorContainingOrIsbnContainingOrPublisherContaining(searchTerm, searchTerm, searchTerm,searchTerm,pageable);
		Page<BooklistResponseDTO> searchDto = new BooklistResponseDTO().searchtoDto(bookList);
		
//		int startPage = Math.max(1, searchDto.getPageable().getPageNumber()-10);
//		int endPage = Math.min(searchDto.getTotalPages(), searchDto.getPageable().getPageNumber()+10);
//		
//		model.addAttribute("startPage",startPage);
//		model.addAttribute("endPage", endPage);
//		model.addAttribute("searchDto", searchDto);
		
		return new ResponseEntity<>(searchDto, HttpStatus.OK);
	}
	
	//책 수정
	@Transactional
	@PutMapping("/api/admin/book/edit")
	public ResponseEntity editBook(@RequestParam("id") int id, @RequestBody BookRequestDTO dto) {
		
		Book book = bookService.findById(id);
		
		Book result = bookService.update(id, dto.getBookName(),
											 dto.getAuthor(),
											 dto.getBookInfo(),
											 dto.getAuthorInfo(),
											 dto.getGenre(),
											 dto.getImg(),
											 dto.getIsbn(),
											 dto.getPrice(),
											 dto.getPublisher(),
											 dto.getPubDate());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	//책 삭제
	@DeleteMapping("/api/book/delete")
	public ResponseEntity deleteBook(@RequestParam("id") int id) {
		
		bookService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
