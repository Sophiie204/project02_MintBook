package com.example.model.DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.example.model.Book;
import com.example.model.Member;
import com.example.model.Order;
import com.example.model.Orderitem;
import com.example.service.OrderService;
import com.example.service.OrderitemService;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderAdminDTO {
	
	@Autowired
	OrderitemService orderitemService;

	private List<BooksCountsDTO> booksWCount;
	
	private int id;

	private String buyer;

	private String buyerEmail;
	
	private String buyerAddress;
	
	private String status;
	
	private String orderNum;
	
	private LocalDateTime orderDate;
	
	private String payMethod;
	
	private String pg;
	
	private int totalPrice;
	
	private Member memberid;
				
}
