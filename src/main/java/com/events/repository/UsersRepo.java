//package com.events.repository;
//
//import java.util.ArrayList;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
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
//	@Modifying
//	@Query(value = "Update users set username = ?2 where username = ?1", nativeQuery=true)
//	public void updateByUsername(String username, String newUsername);
//	
//	@Transactional
//	@Modifying
//	@Query(value = "delete from users where username = ?1", nativeQuery=true)
//	public void deleteByUsername(String username);
// 	
//}
