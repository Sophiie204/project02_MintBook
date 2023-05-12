package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Book;
import com.example.model.Member;
import com.example.model.Review;
import com.example.model.DTO.ReviewRequestDTO;
import com.example.model.DTO.ReviewResponseDTO;
import com.example.repository.MemberRepository;
import com.example.repository.ReviewRepository;
import com.example.service.BookService;
import com.example.service.MemberService;
import com.example.service.ReviewService;

import ch.qos.logback.core.model.Model;

@RestController
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BookService bookService;
	
	
	//리뷰등록
	@PostMapping("/api/add/review")
	public ResponseEntity addReview(@RequestParam("id") int id, @RequestBody ReviewRequestDTO dto) {
		
		Book book = bookService.findById(id);
		Member member = memberService.findById(Integer.parseInt(dto.getMemberid()));
		
		Review addReview = new Review();
		addReview.setMemberid(member);
		addReview.setBookid(book);
		addReview.setWriter(dto.getWriter());
		addReview.setStar(dto.getStar());
		addReview.setContent(dto.getContent());
		
		Review result = reviewService.save(addReview);
		
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	//리뷰 목록&페이징
	@GetMapping("/api/get/review")
	public ResponseEntity getReview(Model model, @RequestParam("id") int id,
									@PageableDefault(size=10, sort="regDate", direction=Sort.Direction.DESC) Pageable pageable) {
		
		Book book = bookService.findById(id);
		Page<Review> newReviewList = reviewService.findAllByBookid(book, pageable);
		Page<ReviewResponseDTO> dto = new ReviewResponseDTO().toDtoList(newReviewList);
		return new ResponseEntity<>(newReviewList, HttpStatus.OK);
	}
	
}
