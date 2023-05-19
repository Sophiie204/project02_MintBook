package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Member;
import com.example.model.Order;
import com.example.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	//장바구니 담기
	public Member findMember(Integer id) {
		return memberRepository.findById(id).get();
	}

	public Member findById(int memberid) {
		return memberRepository.findById(memberid).get();
	}

	public Member findById(Member member) {
		return memberRepository.findById(member);
	}

	public Member findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}



	//------------------------------------------------------
//	public Member findByCartid(int cartid) {
//		return memberRepository.findById(cartid).get();
//	}
}
