package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Book;
import com.example.model.Cart;
import com.example.model.Cartitem;
import com.example.model.DTO.CartitemRequestDTO;

public interface CartitemRepository extends JpaRepository<Cartitem, Integer> {

	//addItemToCart
	Cartitem findByCartidAndBookid(int cartid, int itemid);

	//addItemToCart2
	Cartitem findByCartidAndBookid(Cart cart, Book book);

	//장바구니 아이템 목록----------------------------------

	List<Cartitem> findAllByCartid(Cart cart);

	List<Cartitem> findByCartid(Cart cart);

	void deleteAllByIdIn(List<Integer> lists);

	//장바구니에 아이템 추가(여러개)
	List<Cartitem> findAllByCartidAndBookidIn(Cart cart, List<Book> books);

	CartitemRequestDTO save(CartitemRequestDTO newDto);

	Cartitem findByCartidAndBookid(Cart cart, int bookid);
	


}
