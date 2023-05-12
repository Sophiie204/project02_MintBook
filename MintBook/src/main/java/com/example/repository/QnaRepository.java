package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Qna;

public interface QnaRepository extends JpaRepository<Qna, Integer> {

}
