package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cartid;
	
	private int quantity;
	
	private int price;
	
	@Column(length = 255)
	private String buyer;
	
	@Column(length = 255)
	private String buyerEmail;
	
	@Column(length = 255)
	private String buyerAddress;
	
	@Column(length = 100)
	private String status;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member memberid;
	
	@Column(length = 50)
	private String orderNum;
}
