package com.example.model;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.DTO.CartitemRequestDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "cartitem")
public class Cartitem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cartid;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book bookid;
	
	private int count; //상품 개수
	
	
	//장바구니 추가---------------------------
	public void addCount(int count) {
		this.count += count;
	}
	
	//이건 안쓴것같은데
	public static Cartitem createCartItem(Cart cart, Book book, Integer amount) {
		Cartitem cartitem = new Cartitem();
		cartitem.setCartid(cart);
		cartitem.setBookid(book);
		cartitem.setCount(amount);
		return cartitem;
	}

	
	
}
