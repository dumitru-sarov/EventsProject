package com.events.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.events.entities.Comments;
import com.events.entities.Events;
//import com.events.repository.CommentRepo;
//import com.events.repository.EventsRepo;
//import com.events.services.CommentServices;
import com.events.services.EventsService;



@RestController
@CrossOrigin()
public class CreateEventController {

	@Autowired
	private EventsService eventService;
	
//	@Autowired
//	private CommentServices commentService;
	
	
	@GetMapping("allEvent")
	public ArrayList<Events> allEvents() {
		return eventService.findAllEvents();
	}
	
	@GetMapping("eventById/{id}")
	public Events getEventById(@PathVariable int id) {
		return eventService.eventById(id);
	}
	
//	@GetMapping("findJoinComments/{eventid}")
//	public HashMap<Events, ArrayList<Comments>>  findJoinComments(@PathVariable int eventid){
//		HashMap<Events, ArrayList<Comments>> eventInfo = new HashMap<Events, ArrayList<Comments>>();
//		eventInfo.put(eventService.findEventComment(eventid), commentService.findAllComments(eventid));
//		return eventInfo;
//	}
	
	@PostMapping("saveEvent")
	public void saveEvent(@RequestBody Events event) {
		eventService.saveEvent(event);
	}
	
	@PutMapping("updateEvent/{eventid}")
	public void updateEvent(@RequestBody Events event, @PathVariable int eventid) {
		eventService.updateEvent(event, eventid);
	}
	
	@DeleteMapping("deleteEvent/{eventid}")
	public void deleteEvent(@PathVariable int eventid) {
		eventService.deleteEvent(eventid);
	}
}

