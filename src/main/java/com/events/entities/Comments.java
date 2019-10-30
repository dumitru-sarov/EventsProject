//package com.events.entities;
//
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="comments")
//public class Comments {
//// muhammad.shafeeq@qa.com
//	@Id
//	@GeneratedValue
//	private int commentid;
//	private String comment;
//	private String date;
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Events event;
//	
//	public String getComment() {
//		return comment;
//	}
//	public void setComment(String comment) {
//		this.comment = comment;
//	}
//	public String getDate() {
//		return date;
//	}
//	public void setDate(String date) {
//		this.date = date;
//	}
//
//}
