package com.events.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.events.entities.Events;

@Repository
public interface EventsRepo extends JpaRepository<Events, Integer>{

	
	public Events findByEventid(int eventid);

	public ArrayList<Events> findAll();

//	@Transactional
//	@Modifying
//	public void updateEvent(Events event, int eventid);
	
}
