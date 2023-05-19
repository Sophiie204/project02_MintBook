package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Notice;
import com.example.model.DTO.NoticeResponseDTO;
import com.example.service.NoticeService;

@RestController
public class NoticeController {

	@Autowired
	NoticeService noticeService;
	
	//공지 목록
	@GetMapping("/api/get/notice")
	public ResponseEntity noticeList(@PageableDefault(size=10, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		
		Page<Notice> noticelist = noticeService.findAll(pageable);
		Page<NoticeResponseDTO> dto = new NoticeResponseDTO().toDtoList(noticelist);
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	//공지 상세
	@GetMapping("/api/get/notice/detail/{id}")
	public ResponseEntity noticeDetail(@PathVariable("id") int id, NoticeResponseDTO dto) {
		
		Notice notice = noticeService.findById(id);
		
		return new ResponseEntity<>(notice, HttpStatus.OK);
	}
	
	//메인 공지
	@GetMapping("/api/get/main/notice")
	public ResponseEntity mainNotice(@PageableDefault(size=1, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		
		Page<Notice> noticelist = noticeService.findAll(pageable);
		Page<NoticeResponseDTO> dto = new NoticeResponseDTO().toDtoList(noticelist);
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	
}
