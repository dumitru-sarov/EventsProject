package com.events.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comments {
// muhammad.shafeeq@qa.com
	@Id
	@GeneratedValue
	private int commentid;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="username_FK", referencedColumnName="username")
	private Users username_fk;
	private String comment;
	private String date;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="eventsid_fk", referencedColumnName="eventid")
	private Events events;
	
	public Users getUsername_fk() {
		return username_fk;
	}
	public void setUsername_fk(Users username_fk) {
		this.username_fk = username_fk;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Events getEventsid_fk() {
		return events;
	}
	public void setEventsid_fk(Events eventsid_fk) {
		this.events = eventsid_fk;
	}	
}
