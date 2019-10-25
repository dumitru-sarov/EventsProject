package com.events.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.events.entities.Events;

@Repository
public interface EventsRepo extends JpaRepository<Events, Integer>{

	
	public Events findByEventid(int eventid);

	@Query(value = "select * from events inner join comments on events.eventid = comments.eventsid_fk",
			nativeQuery=true)
	public ArrayList<Events> findEventComments();
	
}
