package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Member;
import com.example.model.Order;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	Member findById(Member member);

	Member findById(String memberid);

	Member findByEmail(String email);
}
