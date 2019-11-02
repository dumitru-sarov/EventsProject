package com.events.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="events")
public class Events {

	@Id
	@GeneratedValue
	private int eventid;
	private String title;	
	private String description;
	private String locationinfo;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	private String eventtype;
	
	public String getEventtype() {
		return eventtype;
	}
	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
