package com.example.model.DTO;

import org.springframework.data.domain.Page;

import com.example.model.Book;
import com.example.model.Cart;
import com.example.model.Cartitem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
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

	public Page<CartitemResponseDTO> toDtoList(Page<Cartitem> cartitems) {
		Page<CartitemResponseDTO> cartitemDtoList = cartitems.map(m-> 
		CartitemResponseDTO.builder()
						.id(m.getId())
						.cartid(m.getCartid())
						.bookid(m.getBookid())
						.count(m.getCount())
						.build());
		return cartitemDtoList;
	}
}
