package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
}
