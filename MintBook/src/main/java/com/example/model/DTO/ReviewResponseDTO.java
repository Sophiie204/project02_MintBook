package com.example.model.DTO;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import com.example.model.Review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponseDTO {
	
	private String content;
	private String writer;
	private LocalDateTime regDate;
	private int star;
	
	//리뷰목록(최신순)
	public Page<ReviewResponseDTO> toDtoList(Page<Review> newReviewList) {
		Page<ReviewResponseDTO> reviewdtolist = newReviewList.map(m->
		ReviewResponseDTO.builder()
						 .content(m.getContent())
						 .writer(m.getWriter())
						 .regDate(m.getRegDate())
						 .star(m.getStar())
						 .build());
		return reviewdtolist;
	}
	
}
