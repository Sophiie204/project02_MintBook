package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "order_item")
public class Orderitem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int quantity;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book bookid;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order orderid;
}
