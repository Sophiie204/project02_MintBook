package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.Notice;
import com.example.repository.NoticeRepository;

@Service
public class NoticeService {

	@Autowired
	NoticeRepository noticeRepository;
	
	public Page<Notice> findAll(Pageable pageable) {
		return noticeRepository.findAll(pageable);
	}

	public Notice findById(int id) {
		return noticeRepository.findById(id).get();
	}

}
