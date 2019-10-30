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
	
	public ArrayList<Events> findAllEvents() {
		return eventRepo.findAll();
	}
	
	public Events eventById(int eventid) {
		return eventRepo.findByEventid(eventid);
	}
	
	public String saveEvent(Events event) {
		eventRepo.save(event);
		return "Event Saved";
	}
	
	public void updateEvent(Events event, int eventid) {
		Events updateEvent = eventRepo.getOne(eventid);
		updateEvent.setTitle(event.getTitle());
		updateEvent.setDescription(event.getDescription());
		updateEvent.setLocationinfo(event.getLocationinfo());
		updateEvent.setDate(event.getDate());
		eventRepo.save(updateEvent);
		
	}
}
