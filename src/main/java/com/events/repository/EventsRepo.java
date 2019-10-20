package com.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.events.entities.Events;

public interface EventsRepo extends JpaRepository<Events, Integer>{

}
