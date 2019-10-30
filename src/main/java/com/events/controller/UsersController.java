//package com.events.controller;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.events.entities.Users;
//import com.events.services.UserServices;
//
//@RestController
//@CrossOrigin
//public class UsersController {
//
//	@Autowired
//	private UserServices userService;
//	
//	@GetMapping("findAllUsers")
//	public ArrayList<Users> getUsers() {
//		return userService.findAllUsers();
//	}
//	
//	@PostMapping("saveUser")
//	public String saveUser(@RequestBody Users user) {
//		userService.saveUser(user);
//		return "User Created";
//	}
//	
//	@GetMapping("findUser/{username}")
//	public Users findUser(@PathVariable String username) {
//		return userService.findByUser(username);
//	}
//	
//	@PutMapping("updateUser/{username}/{newUsername}")
//	public String userUpdate(@PathVariable String username, @PathVariable String newUsername) {
//		userService.updateUser(username, newUsername);
//		return "User updated";
//	} 
//	
//	@DeleteMapping("deleteUser/{username}")
//	public String deleteUser(@PathVariable String username) {
//		userService.deleteUser(username);
//		return "User deleted";
//	}
//	
//}
