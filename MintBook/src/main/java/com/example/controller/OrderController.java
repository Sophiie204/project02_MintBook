package com.example.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Book;
import com.example.model.Cart;
import com.example.model.Cartitem;
import com.example.model.Member;
import com.example.model.Order;
import com.example.model.Orderitem;
import com.example.model.DTO.BooksCountsDTO;
import com.example.model.DTO.OrderAdminDTO;
import com.example.model.DTO.OrderDTO;
import com.example.model.DTO.OrderResponseDTO;
import com.example.model.DTO.OrderUpdateDTO;
import com.example.model.DTO.ToOrderDTO;
import com.example.repository.OrderRepository;
import com.example.service.BookService;
import com.example.service.CartService;
import com.example.service.CartitemService;
import com.example.service.MemberService;
import com.example.service.OrderService;
import com.example.service.OrderitemService;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import jakarta.transaction.Transactional;
import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@RestController
public class OrderController {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderitemService orderitemService;
	
	@Autowired
	CartitemService cartitemService;
	
	@Autowired
	OrderRepository orderRepository;
	
	
	//주문하기
	@PostMapping("/api/order/total/{id}")
	public ResponseEntity createOrder(@PathVariable("id") int id, @RequestBody OrderDTO dto) {
		
		//member
		Member member = memberService.findById(id);
		//cart
		Cart cart = cartService.findByMemberid(member);
		
		//1.판매량 업데이트
		for(int i=0;i<dto.getBooksWCount().size();i++) {
			Book book = bookService.findById(dto.getBooksWCount().get(i).getBookid());
			book.setHit(book.getHit()+dto.getBooksWCount().get(i).getCount());
			bookService.save(book);
		}
		
		//2. 주문번호 생성
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";
		  
		for(int i = 1; i <= 6; i ++) {
			subNum += (int)(Math.random() * 10);
		}
		  
		String orderId = ymd + "_" + subNum; //ex) 20200508_373063
		
		//3. Order 생성
		Order createOrder = new Order();
		createOrder.setBuyer(dto.getBuyer());
		createOrder.setBuyerEmail(member.getEmail());
		createOrder.setBuyerAddress(dto.getBuyerAddress());
		createOrder.setStatus("주문완료");
		createOrder.setOrderNum(orderId);
		createOrder.setPayMethod(dto.getPayMethod());
		createOrder.setPg("html5_inicis");
		createOrder.setTotalPrice(dto.getTotalprice());
		createOrder.setMemberid(member);
		orderService.save(createOrder);
		
		//4. Orderitem 생성
		for(int i=0;i<dto.getBooksWCount().size();i++) {
			Orderitem orderitem = new Orderitem();
			Book book = bookService.findById(dto.getBooksWCount().get(i).getBookid());
			orderitem.setBookid(book);
			orderitem.setQuantity(dto.getBooksWCount().get(i).getCount());
			orderitem.setOrderid(createOrder);
			orderitemService.save(orderitem);
		}
		

		//5. 장바구니에서 주문했을 경우, cartitem 삭제
		for(int i=0;i<dto.getBooksWCount().size();i++) {
			Book book = bookService.findById(dto.getBooksWCount().get(i).getBookid());
			Cartitem cartitem = cartitemService.findByCartidAndBookid(cart, book);
			if(cartitem != null) {
				cartitemService.deleteById(cartitem);
			}
		}

		
		return new ResponseEntity<>(dto, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	//주문목록(관리자용)
	@GetMapping("/api/get/order/all")
	public ResponseEntity AllOrderlist(@PageableDefault(size=10, sort = "orderDate", direction = Direction.DESC) 
									   Pageable pageable,
									   @RequestParam(defaultValue = "") String searchTerm) {
		Page<Order> orderlist = orderRepository.findByBuyerContainingOrStatusContainingOrOrderNumContaining(searchTerm, searchTerm, searchTerm, pageable);
		
		return new ResponseEntity<>(orderlist, HttpStatus.OK);
	}
	
		
		
//	@GetMapping("/api/get/order/all")
//	public ResponseEntity AllOrderlist(@PageableDefault(size=10, sort = "orderDate", direction = Direction.DESC) 
//									   Pageable pageable,
//									   @RequestParam(defaultValue = "") String searchTerm) {
//		
//		List<Order> orders = orderService.findAll();
//		
//		List<BooksCountsDTO> dtoList = new ArrayList<>();
//		for(int i=0;i<orders.size();i++) {
//			//주문1
//			Order order = orders.get(i);
//			//주문1에 해당하는 주문상품리스트
//			List<Orderitem> orderitems = orderitemService.findAllByOrderid(order);
//			//주문1에 해당하는 주문상품1
//			for(int j=0;j<orderitems.size();j++) {
//				Book book = orderitems.get(j).getBookid();
//				BooksCountsDTO dto = new BooksCountsDTO();
//				dto.setBookid(book.getId());
//				dto.setBookName(book.getBookName());
//				dto.setAuthor(book.getAuthor());
//				dto.setPublisher(book.getPublisher());
//				dto.setCount(orderitems.get(j).getQuantity());
//				dto.setTotal(book.getPrice()*dto.getCount());
//				dtoList.add(dto);
//			}
//		}
//		
//		List<OrderAdminDTO> admindto = new ArrayList<>();
//		for(int i=0;i<orders.size();i++) {
//			Order order = orders.get(i);
//			OrderAdminDTO dto = new OrderAdminDTO();
//			dto.setBooksWCount(dtoList);
//			dto.setId(order.getId());
//			dto.setBuyer(order.getBuyer());
//			dto.setBuyerEmail(order.getBuyerEmail());
//			dto.setBuyerAddress(order.getBuyerAddress());
//			dto.setStatus(order.getStatus());
//			dto.setOrderNum(order.getOrderNum());
//			dto.setOrderDate(order.getOrderDate());
//			dto.setPayMethod(order.getPayMethod());
//			dto.setPg(order.getPg());
//			dto.setTotalPrice(order.getTotalPrice());
//			dto.setMemberid(order.getMemberid());
//			admindto.add(dto);
//		}
//		
//		
//		
//		return new ResponseEntity<>(admindto, HttpStatus.OK);
//	}
	
	


	//주문목록(고객용)
	@GetMapping("/api/get/order/one/{id}")
	public ResponseEntity OneOrderlist(@PathVariable("id") int id, @PageableDefault(size=10, sort = "orderDate", direction = Direction.DESC) Pageable pageable) {
		
		Member member = memberService.findById(id);
		Page<Order> orderlist = orderRepository.findAllByMemberid(member, pageable);
		
		return new ResponseEntity<>(orderlist, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	//주문상세
	@GetMapping("/api/get/order/detail/{id}/{orderid}")//memberid, orderid
	public ResponseEntity orderDetail(@PathVariable("id") int id, @PathVariable("orderid") int orderid) {
		Member member = memberService.findById(id);
		Order order = orderService.findById(orderid);
		List<Orderitem> orderitemlist = orderitemService.findAllByOrderid(order);

		//주문 아이템 리스트
		List<BooksCountsDTO> dtoList = new ArrayList<>();
		for(int i=0;i<orderitemlist.size();i++) {
			Book book = orderitemlist.get(i).getBookid();
			BooksCountsDTO dto = new BooksCountsDTO();
			dto.setBookid(book.getId());
			dto.setBookName(book.getBookName());
			dto.setAuthor(book.getAuthor());
			dto.setPublisher(book.getPublisher());
			dto.setCount(orderitemlist.get(i).getQuantity());
			dto.setTotal(book.getPrice()*dto.getCount());
			dtoList.add(dto);
		}
		
		//3. 상품 주문 총액 & 배송지 정보
		OrderResponseDTO resultDto = new OrderResponseDTO();
		resultDto.setBooksWCount(dtoList);
		resultDto.setMemberName(member.getName());
		resultDto.setBuyer(order.getBuyer());
		resultDto.setAddress(order.getBuyerAddress());
		resultDto.setPhone(member.getPhone());
		resultDto.setOrderNum(order.getOrderNum());
		resultDto.setOrderDate(order.getOrderDate());
		resultDto.setArrivalDate(order.getOrderDate().plusDays(1));
		resultDto.setStatus(order.getStatus());
		resultDto.setTotalprice(order.getTotalPrice());
		resultDto.setFinalprice(order.getTotalPrice());
		resultDto.setPayMethod(order.getPayMethod());
		
		
		return new ResponseEntity<>(resultDto, HttpStatus.OK);
	}
	
	//관리자용 주문상세
	@GetMapping("/api/get/order/detail/{orderid}")//memberid, orderid
	public ResponseEntity orderDetailAdmin(@PathVariable("orderid") int orderid) {
		
		Order order = orderService.findById(orderid);
		Member member = order.getMemberid();  
		List<Orderitem> orderitemlist = orderitemService.findAllByOrderid(order);

		//주문 아이템 리스트
		List<BooksCountsDTO> dtoList = new ArrayList<>();
		for(int i=0;i<orderitemlist.size();i++) {
			Book book = orderitemlist.get(i).getBookid();
			BooksCountsDTO dto = new BooksCountsDTO();
			dto.setBookid(book.getId());
			dto.setBookName(book.getBookName());
			dto.setAuthor(book.getAuthor());
			dto.setPublisher(book.getPublisher());
			dto.setCount(orderitemlist.get(i).getQuantity());
			dto.setTotal(book.getPrice()*dto.getCount());
			dtoList.add(dto);
		}
		
		//3. 상품 주문 총액 & 배송지 정보
		OrderResponseDTO resultDto = new OrderResponseDTO();
		resultDto.setBooksWCount(dtoList);
		resultDto.setMemberName(member.getName());
		resultDto.setBuyer(order.getBuyer());
		resultDto.setAddress(order.getBuyerAddress());
		resultDto.setPhone(member.getPhone());
		resultDto.setOrderNum(order.getOrderNum());
		resultDto.setOrderDate(order.getOrderDate());
		resultDto.setArrivalDate(order.getOrderDate().plusDays(1));
		resultDto.setStatus(order.getStatus());
		resultDto.setTotalprice(order.getTotalPrice());
		resultDto.setFinalprice(order.getTotalPrice());
		resultDto.setPayMethod(order.getPayMethod());
		
		
		return new ResponseEntity<>(resultDto, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	//주문페이지 정보(장바구니에서)
	@GetMapping("/api/get/cart/wishorder/{id}/{ids}")//memberid, cartitemids
	public ResponseEntity CartToOrder(@PathVariable("id") int id, @PathVariable List<Integer> ids) {
		
		//1. 주문상품
		List<Integer> lists = ids.stream().filter(Objects::nonNull).collect(Collectors.toList());
		List<Cartitem> cartitemlist = cartitemService.findAllByIdIn(lists);
		List<Book> books = cartitemlist.stream().map(Cartitem::getBookid).collect(Collectors.toList());
		List<BooksCountsDTO> dtoList = new ArrayList<>();
		for(int i=0;i<lists.size();i++) {
			int cartitemid = lists.get(i);
			Cartitem cartitem = cartitemService.findById(cartitemid);
			Book book = cartitem.getBookid();
			BooksCountsDTO dto = new BooksCountsDTO();
			dto.setBookid(book.getId());
			dto.setBookName(book.getBookName());
			dto.setAuthor(book.getAuthor());
			dto.setPublisher(book.getPublisher());
			dto.setCartitemid(cartitemid);
			dto.setCount(cartitem.getCount());
			dto.setTotal(book.getPrice()*cartitem.getCount());
			dtoList.add(dto);
		}
		
		//2. 배송지 정보
		Member member = memberService.findById(id);
		
		//3. 상품 주문 총액
		int totalprice = 0;
		
		for(Cartitem list:cartitemlist) {
			Book book = list.getBookid();
			totalprice += list.getCount()*list.getBookid().getPrice();
		}
		
		ToOrderDTO resultDto = new ToOrderDTO();
		resultDto.setBooksWCount(dtoList);
		resultDto.setName(member.getName());
		resultDto.setBuyer(member.getName());
		resultDto.setAddress(member.getAddress());
		resultDto.setAddDetail(member.getAddDetail());
		resultDto.setPoint(member.getPoint());
		resultDto.setTotalprice(totalprice);
		resultDto.setPhone(member.getPhone());
		resultDto.setEmail(member.getEmail());
		
		return new ResponseEntity<>(resultDto, HttpStatus.OK);
	}
	
	
	
	

	//주문페이지 정보(목록에서)
	@GetMapping("/api/get/list/wishorder/{id}/{ids}")//memberid, bookids
	public ResponseEntity ListToOrder(@PathVariable("id") int id, @PathVariable List<Integer> ids) {
		
		//1. 주문상품
		List<Integer> lists = ids.stream().filter(Objects::nonNull).collect(Collectors.toList());
		List<Book> books = bookService.findAllByIdIn(lists);
		Member member = memberService.findById(id);
		
		List<BooksCountsDTO> dtoList = new ArrayList<>();
		for(int i=0;i<lists.size();i++) {
			int bookid = lists.get(i);
			Book book = bookService.findById(bookid);
			BooksCountsDTO dto = new BooksCountsDTO();
			dto.setBookid(book.getId());
			dto.setBookName(book.getBookName());
			dto.setAuthor(book.getAuthor());
			dto.setPublisher(book.getPublisher());
			dto.setCount(1);
			dto.setTotal(book.getPrice());
			dtoList.add(dto);
		}
		
		
		//2. 상품 주문 총액 & 배송지 정보
		int totalprice = 0;
		for(Book list:books) {
			totalprice += list.getPrice();
		}
		
		ToOrderDTO resultDto = new ToOrderDTO();
		resultDto.setBooksWCount(dtoList);
		resultDto.setName(member.getName());
		resultDto.setBuyer(member.getName());
		resultDto.setAddress(member.getAddress());
		resultDto.setAddDetail(member.getAddDetail());
		resultDto.setPoint(member.getPoint());
		resultDto.setTotalprice(totalprice);
		resultDto.setPhone(member.getPhone());
		resultDto.setEmail(member.getEmail());
		
		return new ResponseEntity<>(resultDto, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	//주문페이지 정보(상세페이지에서)
	@GetMapping("/api/get/detail/wishorder/{id}/{bookid}/{count}")//memberid, bookid
	public ResponseEntity DetailToOrder(@PathVariable("id") int id, @PathVariable("bookid") int bookid, @PathVariable("count") int count) {
		
		//1. 주문상품
		Book book = bookService.findById(bookid);
		Member member = memberService.findById(id);
		
		List<BooksCountsDTO> dtoList = new ArrayList<>();
		for(int i=0;i<1;i++) {
			BooksCountsDTO dto = new BooksCountsDTO();
			dto.setBookid(book.getId());
			dto.setBookName(book.getBookName());
			dto.setAuthor(book.getAuthor());
			dto.setPublisher(book.getPublisher());
			dto.setCount(count);
			dto.setTotal(book.getPrice()*dto.getCount());
			dtoList.add(dto);
		}
		
		//3. 상품 주문 총액 & 배송지 정보
		
		ToOrderDTO resultDto = new ToOrderDTO();
		resultDto.setBooksWCount(dtoList);
		resultDto.setName(member.getName());
		resultDto.setBuyer(member.getName());
		resultDto.setAddress(member.getAddress());
		resultDto.setAddDetail(member.getAddDetail());
		resultDto.setPoint(member.getPoint());
		resultDto.setTotalprice(book.getPrice()*count);
		resultDto.setPhone(member.getPhone());
		
		return new ResponseEntity<>(resultDto, HttpStatus.OK);
	}
	
	
	//주문 정보 수정(관리자용)
	@Transactional
	@PutMapping("/api/admin/order/update/{id}")
	public ResponseEntity updateOrder(@PathVariable("id") int id, @RequestBody OrderUpdateDTO dto) {
		Order order = orderService.findById(id);
		
		order.setId(order.getId());
		order.setBuyer(order.getBuyer());
		order.setBuyerEmail(order.getBuyerEmail());
		order.setStatus(dto.getStatus());
		order.setOrderNum(order.getOrderNum());
		order.setOrderDate(order.getOrderDate());
		order.setPayMethod(order.getPayMethod());
		order.setPg(order.getPg());
		order.setTotalPrice(order.getTotalPrice());
		order.setMemberid(order.getMemberid());
		order.setOrderitems(order.getOrderitems());
		orderService.save(order);
		
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	
	//1.판매량 업데이트
//	for(int i=0;i<dto.getBooksWCount().size();i++) {
//		Book book = bookService.findById(dto.getBooksWCount().get(i).getBookid());
//		book.setHit(book.getHit()+dto.getBooksWCount().get(i).getCount());
//		bookService.save(book);
//	}
	
	
	
	
	
	
	
	
	
	
	
	//----------------------------삽질의 흔적(무시하세요)---------------------------------------//
	
	
	
	
	
	
	//주문하기(1)(장바구니에서)
	@Transactional
	@PostMapping("/api/order/{id}/{ids}")//memberid, cartitemids
	public ResponseEntity addOrderCart(@PathVariable("id") int id, @PathVariable List<Integer> ids, @RequestBody OrderDTO dto) {
		
		//member
		Member member = memberService.findById(id);
		//cart
		Cart cart = cartService.findByMemberid(member);
		//ids[1,2,3]
		List<Integer> selectedids = ids.stream().filter(Objects::nonNull).collect(Collectors.toList());
		//cartitemids[{id, count},{id, count}]
		List<Cartitem> cartitemids = cartitemService.findAllByIdIn(selectedids);
		//총가격
		int totalprice = 0;
		
		
		//선택된 cartitem을 반복문 돌려서 총가격과 판매량 업데이트
		for(Cartitem cartitemlist:cartitemids) {
			Book book = cartitemlist.getBookid();
			totalprice += cartitemlist.getCount()*cartitemlist.getBookid().getPrice();
			book.setHit(book.getHit()+cartitemlist.getCount());
			bookService.save(book);
		}
		
		
		//주문번호 생성
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";
		  
		for(int i = 1; i <= 6; i ++) {
			subNum += (int)(Math.random() * 10);
		}
		  
		String orderId = ymd + "_" + subNum; //ex) 20200508_373063
		
		
		//Order 생성
		Order createOrder = new Order();
		createOrder.setBuyer(dto.getBuyer());
		createOrder.setBuyerEmail(member.getEmail());
		createOrder.setBuyerAddress(dto.getBuyerAddress());
		createOrder.setStatus("결제완료");
		createOrder.setOrderNum(orderId);
		createOrder.setPayMethod(dto.getPayMethod());
		createOrder.setPg("html5_inicis");
		createOrder.setTotalPrice(totalprice);
		createOrder.setMemberid(member);
		orderService.save(createOrder);
		
		//Orderitem 생성
		for(Cartitem cartitemlist:cartitemids) {
			Orderitem orderitem = new Orderitem();
			orderitem.setBookid(cartitemlist.getBookid());
			orderitem.setQuantity(cartitemlist.getCount());
			orderitem.setOrderid(createOrder);
			orderitemService.save(orderitem);
		}
		
		//주문한 cartitem 삭제
		cartitemService.deleteAllByIdIn(selectedids);
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	//주문하기(2)(상세페이지에서)
	@PostMapping("/api/order/one/{id}/{bookid}")
	public ResponseEntity addOrderOne(@PathVariable("id") int id, @PathVariable("bookid") int bookid, @RequestBody OrderDTO dto) {
		
		//member
		Member member = memberService.findById(id);
		//cart
		//Cart cart = cartService.findByMemberid(member);
		//book
		Book book = bookService.findById(bookid);
		//총가격
		int totalprice = 0;
		
		
		//선택된 도서의 총가격과 판매량 업데이트
		totalprice = book.getPrice()*dto.getQuantity();
		book.setHit(book.getHit()+dto.getQuantity());
		bookService.save(book);
		
		//주문번호 생성
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";
		  
		for(int i = 1; i <= 6; i ++) {
			subNum += (int)(Math.random() * 10);
		}
		  
		String orderId = ymd + "_" + subNum; //ex) 20200508_373063
		
		//Order 생성
		Order createOrder = new Order();
		createOrder.setBuyer(dto.getBuyer());
		createOrder.setBuyerEmail(member.getEmail());
		createOrder.setBuyerAddress(dto.getBuyerAddress());
		createOrder.setStatus("결제완료");
		createOrder.setOrderNum(orderId);
		createOrder.setPayMethod(dto.getPayMethod());
		createOrder.setPg("html5_inicis");
		createOrder.setTotalPrice(totalprice);
		createOrder.setMemberid(member);
		orderService.save(createOrder);
		
		//Orderitem 생성
		Orderitem neworderitem = new Orderitem();
		neworderitem.setBookid(book);
		neworderitem.setQuantity(dto.getQuantity());
		neworderitem.setOrderid(createOrder);
		orderitemService.save(neworderitem);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	//주문하기(3)(목록에서)
	@PostMapping("/api/order/list/{id}/{ids}")//memberid, bookids
	public ResponseEntity addOrderList(@PathVariable("id") int id, @PathVariable List<Integer> ids, @RequestBody OrderDTO dto) {
	
		//member
		Member member = memberService.findById(id);
		//ids[1,2,3]
		List<Integer> selectedids = ids.stream().filter(Objects::nonNull).collect(Collectors.toList());
		//cartitemids[{id, count},{id, count}]
		List<Book> bookids = bookService.findAllByIdIn(selectedids);
		//총가격
		int totalprice = 0;
		
		//선택된 bookids를 반복문 돌려서 총가격과 판매량 업데이트
		for(Book booklist:bookids) {
			totalprice += booklist.getPrice();
			booklist.setHit(booklist.getHit()+1);
			bookService.save(booklist);
		}
		
		//주문번호 생성
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";
		  
		for(int i = 1; i <= 6; i ++) {
			subNum += (int)(Math.random() * 10);
		}
		  
		String orderId = ymd + "_" + subNum; //ex) 20200508_373063
		
		
		//Order 생성
		Order createOrder = new Order();
		createOrder.setBuyer(dto.getBuyer());
		createOrder.setBuyerEmail(member.getEmail());
		createOrder.setBuyerAddress(dto.getBuyerAddress());
		createOrder.setStatus("결제완료");
		createOrder.setOrderNum(orderId);
		createOrder.setPayMethod(dto.getPayMethod());
		createOrder.setPg("html5_inicis");
		createOrder.setTotalPrice(totalprice);
		createOrder.setMemberid(member);
		orderService.save(createOrder);
		
		//Orderitem 생성
		for(Book booklist:bookids) {
			Orderitem orderitem = new Orderitem();
			orderitem.setBookid(booklist);
			orderitem.setQuantity(1);
			orderitem.setOrderid(createOrder);
			orderitemService.save(orderitem);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
