package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Book;
import com.example.model.Cart;
import com.example.model.Cartitem;
import com.example.model.Member;
import com.example.repository.BookRepository;
import com.example.repository.CartRepository;
import com.example.repository.CartitemRepository;

@Service
public class CartitemService {

	@Autowired
	CartitemRepository cartitemRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	BookRepository bookRepository;

	//addItemToCart
	public Cartitem save(Cartitem cartitem) {
		return cartitemRepository.save(cartitem);
	}

	//addItemToCart2
	public Cartitem findByCartidAndBookid(Cart cart, Book book) {
		return cartitemRepository.findByCartidAndBookid(cart, book);
	}

	//장바구니 추가(여러개)

//	public Cartitem findByCartidAndBookid(Cart cart, int bookid) {
//		return cartitemRepository.findByCartidAndBookid(cart, bookid);
//	}


	



	
}
