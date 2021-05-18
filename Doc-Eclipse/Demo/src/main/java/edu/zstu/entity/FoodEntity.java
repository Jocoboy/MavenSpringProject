package edu.zstu.entity;

import java.util.Date;
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
@Table(name = "food")
public class FoodEntity extends BaseEntity {
	

//	private int UserID;
//	private int FileID;

	private String FoodName;
	private Date DeployDate;
	private String FoodMaterial;
	private int Steps;
	private int Likes;
	
	private UserEntity user;
	private FileAttachEntity fileAttach;
	private List<FoodStepEntity> FoodStepList;
	
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
	
	
	@OneToMany
	@Cascade(value = {CascadeType.ALL })
	@JoinColumn(name = "FoodID")
	@OrderBy("StepNo ASC")
	public List<FoodStepEntity> getFoodStepList() {
		return FoodStepList;
	}

	public void setFoodStepList(List<FoodStepEntity> foodStepList) {
		FoodStepList = foodStepList;
	}

	
//	@JoinColumn(name="UserID")
//	public int getUserID() {
//		return UserID;
//	}
//
//	public void setUserID(int userID) {
//		UserID = userID;
//	}
//	
//	@JoinColumn(name="FileID")
//	public int getFileID() {
//		return FileID;
//	}
//
//	public void setFileID(int fileID) {
//		FileID = fileID;
//	}

	
	
	@Column(name="Foodname")
	public String getFoodName() {
		return FoodName;
	}

	public void setFoodName(String foodName) {
		FoodName = foodName;
	}

	@Column(name="Deploydate")
	public Date getDeployDate() {
		return DeployDate;
	}

	public void setDeployDate(Date deployDate) {
		DeployDate = deployDate;
	}

	@Column(name="Foodmaterial")
	public String getFoodMaterial() {
		return FoodMaterial;
	}

	public void setFoodMaterial(String foodMaterial) {
		FoodMaterial = foodMaterial;
	}

	@Column(name="Steps")
	public int getSteps() {
		return Steps;
	}

	public void setSteps(int steps) {
		Steps = steps;
	}

	@Column(name="Likes")
	public int getLikes() {
		return Likes;
	}

	public void setLikes(int likes) {
		Likes = likes;
	}




	
	
}
