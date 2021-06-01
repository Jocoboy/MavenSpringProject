package edu.zstu.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "food_activity")
public class FoodActivityEntity extends BaseEntity {
	

//	private int UserID;
//	private int FileID;
	
	private String Title;
	private String Location;
	private Date StartDate;
	private Date EndDate;
	private String DetailLocation;
	private String Description;
	
	@Column(name = "Title")
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	
	@Column(name = "Location")
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}

	@Column(name = "StartDate")
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	
	
	@Column(name = "EndDate")
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	
	
	@Column(name = "DetailLocation")
	public String getDetailLocation() {
		return DetailLocation;
	}
	public void setDetailLocation(String detailLocation) {
		DetailLocation = detailLocation;
	}
	
	@Column(name = "Description")
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
}
