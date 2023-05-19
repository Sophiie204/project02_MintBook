package com.example.model.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

	private List<BooksCountsDTO> booksWCount;
	
	private String buyer;
	private String buyerEmail;
	private String buyerAddress;
	private String payMethod;
	private int totalprice;
	
	//'상세페이지에서 주문'에서 쓰고 있음
	private int quantity;
}
