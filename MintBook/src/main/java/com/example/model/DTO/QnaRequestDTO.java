package com.example.model.DTO;

import java.time.LocalDateTime;

import com.example.model.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QnaRequestDTO {

	//private Member memberid;
	private String title;
	private String content;
}
