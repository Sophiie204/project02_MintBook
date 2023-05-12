package com.example.model.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequestDTO {

	private String title;
	private String listimgPath;
	private String imgPath;
	private LocalDate startDate;
	private LocalDate endDate;
	
}
