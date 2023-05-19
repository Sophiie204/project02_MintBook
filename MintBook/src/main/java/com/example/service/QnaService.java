package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Qna;
import com.example.repository.QnaRepository;

@Service
public class QnaService {

	@Autowired
	QnaRepository qnaRepository;
	
	public Qna save(Qna newQ) {
		return qnaRepository.save(newQ);
	}

}
