<<<<<<< HEAD
package edu.uncc.dataclasses;

import java.io.Serializable;
import java.util.Date;

import com.parse.ParseObject;

public class Event implements Serializable {
	
	int event_id;
	String eventName ,eventDate ,eventTime,eventDetail , eventVenue, contactPerson , contact ,contactEmail;
	
	
	
	public Event(String eventName, String eventDate, String eventTime,
			String eventDetail, String eventVenue ,String contactPerson , String contact) {
		super();
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.eventDetail = eventDetail;
		this.eventVenue = eventVenue;
		this.contactPerson = contactPerson;
		this.contact = contact;
		this.contactEmail = contactEmail;
	}
	
	public Event(ParseObject o) {
		this.eventName = o.getString("event_name");
		this.eventTime = o.getString("event_time");
		this.eventDetail = o.getString("event_detail");
		this.eventVenue = o.getString("event_venue");
		this.contactPerson = o.getString("contact_person");
		this.contact = o.getString("contact_number");
		this.eventDate = o.getString("event_date");
		this.contactEmail = o.getString("contact_email");
	}
	
	
	
	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String geteventDate() {
		return eventDate;
	}
	public void seteventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getEventDetail() {
		return eventDetail;
	}
	public void setEventDetail(String eventDetail) {
		this.eventDetail = eventDetail;
	}
	public String getEventVenue() {
		return eventVenue;
	}
	public void setEventVenue(String eventVenue) {
		this.eventVenue = eventVenue;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getTimeToShow(){
		StringBuilder sb = new StringBuilder();
	 	 sb.append(eventDate)
	 	 .append(" , ")
	 	 .append(eventTime);
	 	 
	 	 return sb.toString();
	}
	public String getContactToShow(){
		StringBuilder sb = new StringBuilder();
	 	 sb.append(contactPerson)
	 	 .append(" , ")
	 	 .append(contact);
	 	 
	 	 return sb.toString();
	}

	@Override
	public String toString() {
		return "Event [eventName=" + eventName + ", eventDate=" + eventDate
				+ ", eventTime=" + eventTime + ", eventDetail=" + eventDetail
				+ ", eventVenue=" + eventVenue + ", contactPerson="
				+ contactPerson + ", contact=" + contact + ", contactEmail="
				+ contactEmail + "]";
	}
	
	
	
	

}
=======
package edu.uncc.dataclasses;

import java.io.Serializable;

import com.parse.ParseObject;

public class Event implements Serializable {
	
	int event_id;
	String eventName ,eventDate ,eventTime,eventDetail , eventVenue, contactPerson , contact;
	
	
	
	public Event(String eventName, String eventDate, String eventTime,
			String eventDetail, String eventVenue ,String contactPerson , String contact) {
		super();
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.eventDetail = eventDetail;
		this.eventVenue = eventVenue;
		this.contactPerson = contactPerson;
		this.contact = contact;
	}
	
	public Event(ParseObject o) {
		this.eventName = o.getString("event_name");
		this.eventTime = o.getString("event_time");
		this.eventDetail = o.getString("event_detail");
		this.eventVenue = o.getString("event_venue");
		this.contactPerson = o.getString("contact_person");
		this.contact = o.getString("contact_number");
		this.eventDate = o.getString("event_date");
	}
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String geteventDate() {
		return eventDate;
	}
	public void seteventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getEventDetail() {
		return eventDetail;
	}
	public void setEventDetail(String eventDetail) {
		this.eventDetail = eventDetail;
	}
	public String getEventVenue() {
		return eventVenue;
	}
	public void setEventVenue(String eventVenue) {
		this.eventVenue = eventVenue;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getTimeToShow(){
		StringBuilder sb = new StringBuilder();
	 	 sb.append(eventDate)
	 	 .append(" , ")
	 	 .append(eventTime);
	 	 
	 	 return sb.toString();
	}
	public String getContactToShow(){
		StringBuilder sb = new StringBuilder();
	 	 sb.append(contactPerson)
	 	 .append(" , ")
	 	 .append(contact);
	 	 
	 	 return sb.toString();
	}
	
	@Override
	public String toString() {
		return "Event [eventName=" + eventName + ", eventDate=" + eventDate
				+ ", eventTime=" + eventTime + ", eventDetail=" + eventDetail
				+ ", eventVenue=" + eventVenue + ", contactPerson="
				+ contactPerson + ", contact=" + contact + "]";
	}
	
	
	

}
>>>>>>> 2c5d44b1cd7214fe649610cbee13a2224612ef77
