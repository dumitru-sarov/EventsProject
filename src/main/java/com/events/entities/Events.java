package com.events.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Events {

	@Id
	@GeneratedValue
	private int eventid;
	private String title;
	private String description;
	private String locationinfo;
	private String date;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="username_FK", referencedColumnName="username")
	private Users username_fk;
	
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocationinfo() {
		return locationinfo;
	}
	public void setLocationinfo(String locationinfo) {
		this.locationinfo = locationinfo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Users getUsername_fk() {
		return username_fk;
	}
	public void setUsername_fk(Users username_fk) {
		this.username_fk = username_fk;
	}
}
