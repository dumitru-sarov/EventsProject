//package com.events.entities;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="users")
//public class Users {
//	
//	static public String loggedUser;
//	
//	@Id
//	private String username;
//	private String firstname;
//	private String lastname;
//	private String password;
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Events> events = new ArrayList<Events>();
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Comments> comments = new ArrayList<Comments>(); 
//	public List<Events> getEvents() {
//		return events;
//	}
//	public void setEvents(List<Events> events) {
//		this.events = events;
//	}
//	public List<Comments> getComments() {
//		return comments;
//	}
//	public void setComments(List<Comments> comments) {
//		this.comments = comments;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getFirstname() {
//		return firstname;
//	}
//	public void setFirstname(String firstname) {
//		this.firstname = firstname;
//	}
//	public String getLastname() {
//		return lastname;
//	}
//	public void setLastname(String lastname) {
//		this.lastname = lastname;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	
//}
