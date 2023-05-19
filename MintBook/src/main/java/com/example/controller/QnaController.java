package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Member;
import com.example.model.Qna;
import com.example.model.DTO.QnaRequestDTO;
import com.example.service.MemberService;
import com.example.service.QnaService;

@RestController
public class QnaController {

	@Autowired
	QnaService qnaService;
	
	@Autowired
	MemberService memberService;
	
	//Qna 등록
	@PostMapping("/api/add/Qna/{id}")
	public ResponseEntity addQna(@PathVariable("id") int id, @RequestBody QnaRequestDTO dto) {
		
		Member member = memberService.findById(id);
		
		Qna newQ = new Qna();
		
		newQ.setMemberid(member);
		newQ.setTitle(dto.getTitle());
		newQ.setContent(dto.getTitle());
		
		Qna result = qnaService.save(newQ);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
