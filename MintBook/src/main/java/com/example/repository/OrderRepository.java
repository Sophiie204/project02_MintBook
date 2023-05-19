package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Member;
import com.example.model.Order;
import com.example.model.DTO.OrderAdminDTO;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	Order findByMemberid(Member member);

	Page<Order> findByBuyerContainingOrStatusContainingOrOrderNumContaining(String buyer, String status,
			String orderNum, Pageable pageable);

	Page<Order> findAllByMemberid(Member member, Pageable pageable);



}
