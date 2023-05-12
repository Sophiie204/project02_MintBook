package com.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "members")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 100 ,unique = true)
	private String email;
	
	@Column(length = 255)
	private String password;
	
	@Column(length = 10)
	private String gender;
	
	@Column(length = 255)
	private String address;
	
	@Column(length = 255)
	private String addDetail;
	
	private int age;
	
	@Column(length = 255)
	private String name;
	
	private String phone;
	
	private LocalDate birth;
	
	private LocalDateTime joinDate = LocalDateTime.now();
	
	private boolean isAdmin;
	
	private int point;
	
	private int cash;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "memberid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Review> reviews;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "memberid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Wishlist> whishlists;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "memberid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Cart carts;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "memberid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Order> orders;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "memberid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Point> points;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "memberid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Qna> qnas;

	@JsonManagedReference
	@OneToMany(mappedBy = "memberid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Cash> cashes;
}
