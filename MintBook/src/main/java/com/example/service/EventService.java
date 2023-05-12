package com.example.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Event;
import com.example.model.DTO.EventRequestDTO;
import com.example.repository.EventRepository;

import jakarta.transaction.Transactional;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepository;


	public List<Event> findAll() {
		return eventRepository.findAll();
	}


	public Event save(Event addE) {
		return eventRepository.save(addE);
	}


	public Event findById(int id) {
		return eventRepository.findById(id).get();
	}


	public Event update(int id, String imgPath, String listimgPath, String title, LocalDate startDate,
			LocalDate endDate) {
		Event event = eventRepository.findById(id).get();
		Event result = event.update(imgPath, listimgPath, title, startDate, endDate);
		return result;
	}


	public void delete(int id) {
		eventRepository.deleteById(id);
		
	}

}
