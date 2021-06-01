package edu.zstu.entity;

import java.sql.Date;
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
	
	private UserEntity user;
	private FileAttachEntity fileAttach;

	private List<FileAttachEntity> fileAttachList;
	private int postNum;
	
	@OneToOne
	@Cascade(value = {CascadeType.REFRESH })
	@JoinColumn(name = "FileID")
	public FileAttachEntity getFileAttach() {
		return fileAttach;
	}
	public void setFileAttach(FileAttachEntity fileAttach) {
		this.fileAttach = fileAttach;
	}
	
	@ManyToOne(targetEntity = UserEntity.class)
	@Cascade(value = {CascadeType.REFRESH })
	@JoinColumn(name = "UserID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	
	@OneToMany
	@Cascade(value = {CascadeType.ALL })
	@JoinColumn(name = "FileID")
	@OrderBy("StepNo ASC")
	public List<FileAttachEntity> getFileAttachList() {
		return fileAttachList;
	}
	public void setFileAttachList(List<FileAttachEntity> fileAttachList) {
		this.fileAttachList = fileAttachList;
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
