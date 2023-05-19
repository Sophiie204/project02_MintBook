package com.example.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Book;
import com.example.model.Cart;
import com.example.model.Cartitem;
import com.example.model.Member;
import com.example.model.DTO.CartitemRequestDTO;
import com.example.model.DTO.CartitemResponseDTO;
import com.example.repository.BookRepository;
import com.example.repository.CartRepository;
import com.example.repository.CartitemRepository;
import com.example.repository.MemberRepository;
import com.example.service.BookService;
import com.example.service.CartService;
import com.example.service.CartitemService;
import com.example.service.MemberService;

import jakarta.transaction.Transactional;

@RestController
public class CartitemController {

	@Autowired
	private CartitemService cartitemService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CartitemRepository cartitemRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	
		
	//장바구니 담기(상세페이지에서)
	@PostMapping("/api/add/cartitem/{id}")
	public ResponseEntity addCartitem(@PathVariable("id") int id,@RequestBody CartitemRequestDTO dto) {
		
		Member member = memberService.findById(id);
		Cart cart = cartService.findByMemberid(member);
//		Cart cart = cartService.findById(Integer.parseInt(dto.getCartid()));
		Book book = bookService.findById(Integer.parseInt(dto.getBookid()));
		Cartitem cartitem = cartitemService.findByCartidAndBookid(cart, book);

		//장바구니가 존재하지 않는 경우
		if(cart == null) {
			cart = Cart.createCart(member);
			cartRepository.save(cart);
		}
		
		//처음 등록되는 아이템일 경우
		if(cartitem == null) {
		
			Cartitem addCartitem = new Cartitem();
			
			addCartitem.setCartid(cart);
			addCartitem.setBookid(book);
			addCartitem.setCount(dto.getCount());
			
			Cartitem result = cartitemService.save(addCartitem);
		}
		
		//이미 등록된 아이템일 경우 수량만 증가
		else {
			Cartitem update2 = cartitem;
//			update2.setCartid(cartitem.getCartid());
			update2.setBookid(cartitem.getBookid());
			update2.addCount(dto.getCount());
			cartitemRepository.save(update2);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	//장바구니 담기(목록에서)
	@PostMapping("/api/add/cartitem2/{id}/{ids}")//memberid, bookids
	public ResponseEntity addCartitem2(@PathVariable("id") int id, @PathVariable List<Integer> ids) {
		
		Member member = memberService.findById(id);//member
		Cart cart = cartService.findByMemberid(member);//cart
		
		//[1,2,3]
		List<Integer> bookids = ids.stream().filter(Objects::nonNull).collect(Collectors.toList());
		
		//장바구니가 존재하지 않는 경우
		if(cart == null) {
			cart = Cart.createCart(member);
			cartRepository.save(cart);
		}

		//배열로 받아온 bookid값을 for문으로 꺼내서 저장
		for(int i=0 ; i<bookids.size() ; i++) {
			int bookid = bookids.get(i);
			Book book = bookService.findById(bookid);
			Cartitem cartitem = cartitemService.findByCartidAndBookid(cart, book);
			
			if(cartitem == null) {
				Cartitem newitem = new Cartitem();
				newitem.setBookid(book);
				newitem.setCartid(cart);
				newitem.setCount(1);
				cartitemService.save(newitem);
			}else {
				cartitem.setCount(cartitem.getCount()+1);
				cartitemService.save(cartitem);
			}
			
		}		
		
		return new ResponseEntity<>(HttpStatus.OK);
	 
	}
	
	
	//장바구니 추가(목록의 각 행에 있는 버튼에서)
	@PostMapping("/api/add/cartitem3/{id}/{bookid}")//memberid, bookids
	public ResponseEntity addCartitem3(@PathVariable("id") int id, @PathVariable("bookid") int bookid) {
		
		Member member = memberService.findById(id);
		Cart cart = cartService.findByMemberid(member);
		Book book = bookService.findById(bookid);
		Cartitem cartitem = cartitemService.findByCartidAndBookid(cart, book);
		
		//장바구니가 존재하지 않는 경우
		if(cart == null) {
			cart = Cart.createCart(member);
			cartRepository.save(cart);
		}

		//처음 등록되는 상품이 경우
		if(cartitem == null) {
			Cartitem newitem = new Cartitem();
			newitem.setBookid(book);
			newitem.setCartid(cart);
			newitem.setCount(1);
			cartitemService.save(newitem);
		}else {
			cartitem.setCount(cartitem.getCount()+1);
			cartitemService.save(cartitem);
		}
				
		
		return new ResponseEntity<>(HttpStatus.OK);
	 
	}
	
	
	
	//장바구니 목록
	@GetMapping("/api/get/cartitem/{id}")
	public ResponseEntity CartitemList(@PathVariable("id") int id,
									   @PageableDefault(size=10, 
								       					sort = "id", 
						       							direction = Sort.Direction.DESC) 
														Pageable pageable){
		
		Member member = memberService.findById(id);//memberid
		Cart cart = cartRepository.findByMemberid(member);//cartid
		
		Page<Cartitem> cartitems = cartitemRepository.findByCartid(cart, pageable);

		Page<CartitemResponseDTO> dto = new CartitemResponseDTO().toDtoList(cartitems);
//		List<CartitemResponseDTO> dtos = cartitems.stream().map(CartitemResponseDTO::new)
//														   .collect(Collectors.toList());
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	
	
	//장바구니 아이템 삭제(리스트)
	@Transactional
	@DeleteMapping("/api/delete/cartitem/{ids}")
	List<Integer> deleteCartitems(@PathVariable List<Integer> ids){
		// ids입력 > int형 리스트로 전환 > 리스트에 해당하는 cartitem 호출
		// dto로 ids 입력 > int형
		List<Integer> lists = ids.stream().filter(Objects::nonNull).collect(Collectors.toList());
		
		cartitemRepository.deleteAllByIdIn(lists);
		
		return lists;
	}
	
}
