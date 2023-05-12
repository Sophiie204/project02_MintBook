package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Cart;
import com.example.model.Member;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	//장바구니 추가하기
	Cart findByMemberid(int id);

	//멤버 id로 해당 멤버의 장바구니 찾기
	Cart findCartByMemberid(int id);

	Cart findByMemberid(Member member);

	List<Cart> findAllByMemberid(Member member);

}
