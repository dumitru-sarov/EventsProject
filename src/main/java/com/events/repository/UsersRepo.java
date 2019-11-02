//package com.events.repository;
//
//import java.util.ArrayList;
//
//import javax.transaction.Transactional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.events.entities.Users;
//
//@Repository
//public interface UsersRepo extends JpaRepository<Users, String> {
//
//	public ArrayList<Users> findAll();
//	
//	public Users findByUsername(String username);
//	
//	@Transactional
//	public void deleteByUsername(String username);
//}
