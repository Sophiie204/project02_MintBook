package com.example.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 255)
	private String buyer;
	
	@Column(length = 255)
	private String buyerEmail;
	
	@Column(length = 255)
	private String buyerAddress;
	
	@Column(length = 100)
	private String status;
	
	@Column(length = 50)
	private String orderNum;
	
	private LocalDateTime orderDate = LocalDateTime.now();
	
	private String payMethod;
	
	private String pg;
	
	private int totalPrice;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member memberid;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "orderid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Orderitem> orderitems;
	
}
