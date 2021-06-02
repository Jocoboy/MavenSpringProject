package edu.zstu.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "food_activity")
public class FoodActivityEntity extends BaseEntity {
	

//	private int UserID;
//	private int FileID;
	
	private String Title;
	private String Location;
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private String  StartDate;
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private String EndDate;
	private String DetailLocation;
	private String Description;
	
	private UserEntity user;
	private FileAttachEntity fileAttach;

//	private List<FileAttachEntity> fileAttachList;
//	private int postNum;
	
	
//	@OneToMany
//	@Cascade(value = {CascadeType.ALL })
//	@OrderBy("StepNo ASC")
//	public List<FileAttachEntity> getFileAttachList() {
//		return fileAttachList;
//	}
//	public void setFileAttachList(List<FileAttachEntity> fileAttachList) {
//		this.fileAttachList = fileAttachList;
//	}

//	public int getPostNum() {
//		return postNum;
//	}
//	public void setPostNum(int postNum) {
//		this.postNum = postNum;
//	}
	
	
	@ManyToOne(targetEntity = UserEntity.class)
	@Cascade(value = {CascadeType.REFRESH })
	@JoinColumn(name = "UserID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	@OneToOne
	@Cascade(value = {CascadeType.REFRESH })
	@JoinColumn(name = "FileID")
	public FileAttachEntity getFileAttach() {
		return fileAttach;
	}
	public void setFileAttach(FileAttachEntity fileAttach) {
		this.fileAttach = fileAttach;
	}
	



	
	
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

	@Column(name = "Startdate")
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	
	
	@Column(name = "Enddate")
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	
	
	@Column(name = "Detaillocation")
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
