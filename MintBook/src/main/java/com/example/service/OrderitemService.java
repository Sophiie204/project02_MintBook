package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Book;
import com.example.model.Order;
import com.example.model.Orderitem;
import com.example.repository.OrderitemRepository;

@Service
public class OrderitemService {

	@Autowired
	OrderitemRepository orderitemRepository;

	public void save(Orderitem orderitem) {
		orderitemRepository.save(orderitem);
		
	}

	public List<Orderitem> findAllByOrderid(Order order) {
		return orderitemRepository.findAllByOrderid(order);
	}

	public List<Book> findBookidByIdIn(List<Orderitem> orderitemlist) {
		return orderitemRepository.findBookidByIdIn(orderitemlist);
	}

}
