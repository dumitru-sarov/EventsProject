//package com.events.repository;
//
//import java.util.ArrayList;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.events.entities.Comments;
//
//@Repository
//public interface CommentRepo extends JpaRepository<Comments, Integer>{
//
//	@Query(value = "select events.eventid, comments.comment from events inner join comments "
//			     + "on events.eventid = comments.eventsid_fk",
//			nativeQuery=true)
//	public ArrayList<Comments> findEventComments();
//	
//	@Query(value = "select comment, username_fk from comments where eventsid_fk = ?1", nativeQuery=true)
//	public ArrayList<Comments> findCommentsByEvent(int eventid); 
//		
//	}
//
