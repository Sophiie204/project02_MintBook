package com.example.model.DTO;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;

import com.example.model.Book;
import com.example.model.Cart;
import com.example.model.Cartitem;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartitemRequestDTO {

//	private String cartid;
	
	private String bookid;
	
	private int count;
}
