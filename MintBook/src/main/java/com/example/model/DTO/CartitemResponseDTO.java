package com.example.model.DTO;

import com.example.model.Book;
import com.example.model.Cart;
import com.example.model.Cartitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartitemResponseDTO {

	private int id;
	private Cart cartid;
	private Book bookid;
	private int count;
	
	public CartitemResponseDTO(Cartitem entity) {
		this.id = entity.getId();
		this.cartid = entity.getCartid();
		this.bookid = entity.getBookid();
		this.count = entity.getCount();
	}
}
