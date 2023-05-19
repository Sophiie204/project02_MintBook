package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Book;
import com.example.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {


	//리뷰 페이지 목록(최신순)
	//Page<Review> findAllByBookid(int id, Pageable pageable);

	Page<Review> findAllByBookid(Book book, Pageable pageable);

}
