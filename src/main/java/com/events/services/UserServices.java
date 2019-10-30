//package com.events.services;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.events.entities.Users;
//import com.events.repository.UsersRepo;
//
//@Service
//public class UserServices {
//	
//	@Autowired
//	private UsersRepo userRepo;
//	
//	public ArrayList<Users> findAllUsers() {
//		return userRepo.findAll();
//	}
//	
//	public void saveUser(Users user) {
//		userRepo.save(user);
//	}
//	
//	public Users findByUser(String username) {
//		return userRepo.findByUsername(username);
//	}
//	
//	public void updateUser(String username, String newUsername) {
//		userRepo.updateByUsername(username, newUsername);
//	}
//	
//	public void deleteUser(String username) {
//		userRepo.deleteByUsername(username);
//	}
//}
