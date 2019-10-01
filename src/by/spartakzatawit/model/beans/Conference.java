package by.spartakzatawit.model.beans;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import by.spartakzatawit.constants.Constants;

public class Conference {
	private int id;
	private String title;
	private String descr;
	private String place;
	private Date date;
	private List<Event> events;
	
	public Conference() {
		super();
	}
	
	public Conference(String title, String descr, String place, String date) throws ParseException {
		super();
		this.title = title;
		this.descr = descr;
		this.place = place;
		setDate(date);
	}
	
	public Conference(int id, String title, String descr, String place, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.descr = descr;
		this.place = place;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescr() {
		return descr;
	}
	
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	public String getPlace() {
		return place;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setDate(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_PATTERN);
		java.util.Date tempDate = format.parse(date);
		this.date = new Date(tempDate.getTime());
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
}
