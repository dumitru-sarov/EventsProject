package com.events.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.entities.Events;
import com.events.repository.EventsRepo;

@Service
public class EventsService {

	@Autowired
	private EventsRepo eventRepo;
	
//	public ArrayList<Events> find() {
//		return eventRepo.findEventComments();
//	}
}
