package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Book;
import com.example.model.Order;
import com.example.model.Orderitem;

public interface OrderitemRepository extends JpaRepository<Orderitem, Integer> {

	List<Orderitem> findAllByOrderid(Order order);

	List<Book> findBookidByIdIn(List<Orderitem> orderitemlist);


}
