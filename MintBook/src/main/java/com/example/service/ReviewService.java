package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.Book;
import com.example.model.Review;
import com.example.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	ReviewRepository reviewRepository;

	public Review save(Review addReview) {
		return reviewRepository.save(addReview);
	}

	//리뷰 페이지 목록(최신순)
//	public Page<Review> findAllByBookid(int id, Pageable pageable) {
//		return reviewRepository.findAllByBookid(id, pageable);
//	}

	public Page<Review> findAllByBookid(Book book, Pageable pageable) {
		return reviewRepository.findAllByBookid(book, pageable);
	}

}
