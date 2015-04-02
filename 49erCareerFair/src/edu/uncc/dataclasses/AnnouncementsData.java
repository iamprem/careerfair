package edu.uncc.dataclasses;

import com.parse.ParseObject;

public class AnnouncementsData {
	int aId;
	String announcement , aTime , aDate;
	
	public AnnouncementsData(String announcement, String aTime, String aDate) {
		super();
		this.announcement = announcement;
		this.aTime = aTime;
		this.aDate = aDate;
	}
	public String getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}
	public String getaTime() {
		return aTime;
	}
	public void setaTime(String aTime) {
		this.aTime = aTime;
	}
	public String getaDate() {
		return aDate;
	}
	public void setaDate(String aDate) {
		this.aDate = aDate;
	}
	
	public String getTimeToShow(){
		StringBuilder sb = new StringBuilder();
	 	 sb.append(aDate)
	 	 .append(" , ")
	 	 .append(aTime);
	 	 
	 	 return sb.toString();
	}
	
	
	public AnnouncementsData(ParseObject o) {
		this.announcement = o.getString("a_name");
		this.aTime = o.getString("a_time");
		this.aDate = o.getString("a_date");
		
	}
	
	
	@Override
	public String toString() {
		return "Announcements [announcement=" + announcement + ", aTime="
				+ aTime + ", aDate=" + aDate + "]";
	}
	

}
