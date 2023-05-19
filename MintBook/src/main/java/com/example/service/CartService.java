package com.example.service;

import java.util.Map;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Book;
import com.example.model.Cart;
import com.example.model.Cartitem;
import com.example.model.Member;
import com.example.repository.BookRepository;
import com.example.repository.CartRepository;
import com.example.repository.CartitemRepository;

import jakarta.transaction.Transactional;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CartitemRepository cartitemRepository;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BookService bookService;

	
	public Cart findById(int cartid) {
		return cartRepository.findById(cartid).get();
	}


	public Cart save(Cart addCart) {
		return cartRepository.save(addCart);
	}


	public Cart findByMemberid(Member member) {
		return cartRepository.findByMemberid(member);
	}


	public Cart findByMemberid(int id) {
		return cartRepository.findByMemberid(id);
	}


	public void addCart(Member member, Book newBook, int amount) {
		Cart cart = cartRepository.findByMemberid(member.getId());
		Book book = bookRepository.findBookById(newBook.getId());
		Cartitem cartitem = cartitemRepository.findByCartidAndBookid(cart.getId(), book.getId());
		
		cartitem = Cartitem.createCartItem(cart, book, amount);
		cartitemRepository.save(cartitem);
	}


	public void delete(Cart cart) {
		cartRepository.delete(cart);
		
	}

	
}
