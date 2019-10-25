package com.events.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.events.entities.Comments;
import com.events.entities.Events;
import com.events.repository.CommentRepo;
import com.events.repository.EventsRepo;
import com.events.services.EventsService;

@RestController
public class CreateEventController {

	@Autowired
	private EventsService eventService;
	
	@Autowired 
	private EventsRepo eventRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	
	@GetMapping("findJoinComments/{eventid}")
	public HashMap<Events, ArrayList<Comments>>  findJoinComments(@PathVariable int eventid){
		HashMap<Events, ArrayList<Comments>> eventInfo = new HashMap<Events, ArrayList<Comments>>();
		eventInfo.put(eventRepo.findByEventid(eventid), commentRepo.findCommentsByEvent(eventid));
		return eventInfo;
	}
	
	@GetMapping("findJoinComments")
	public ArrayList<Events> ind(){
		return eventRepo.findEventComments();
	}
}

