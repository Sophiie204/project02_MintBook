package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "member_id")
	private Member memberid;
	
	private int count; //카트에 담긴 총 상품 개수
	
	@JsonManagedReference
	@OneToMany(mappedBy = "cartid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Cartitem> cartitems;
	
	public static Cart createCart(Member memberid) {
		Cart cart = new Cart();
		cart.setMemberid(memberid);
		return cart;
	}
	
}
