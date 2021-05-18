package edu.zstu.enity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "food")
public class FoodEnity extends BaseEnity {
	
	
	private int UserID;
	private int FileID;
	private String FoodName;
	private String DeployDate;
	private String FoodMaterial;
	private int Steps;
	private int Likes;
	
	private List<FoodStepEnity> FoodStepList;
	
	
	@OneToMany(targetEntity = FoodStepEnity.class)
	@Cascade(value = {CascadeType.ALL })
	@OrderBy("StepNo ASC")
	public List<FoodStepEnity> getFoodStepList() {
		return FoodStepList;
	}

	public void setFoodStepList(List<FoodStepEnity> foodStepList) {
		FoodStepList = foodStepList;
	}

	
//	@ManyToOne(targetEntity = UserEnity.class)
//	@Cascade(value = {CascadeType.REFRESH })
//	@JoinColumn(name="UserID")
	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}
	
//	@ManyToOne(targetEntity = FileAttachEnity.class)
//	@Cascade(value = {CascadeType.REFRESH })
//	@JoinColumn(name="FileID")
	public int getFileID() {
		return FileID;
	}

	public void setFileID(int fileID) {
		FileID = fileID;
	}

	
	
	@Column(name="FoodName")
	public String getFoodName() {
		return FoodName;
	}

	public void setFoodName(String foodName) {
		FoodName = foodName;
	}

	@Column(name="DeployDate")
	public String getDeployDate() {
		return DeployDate;
	}

	public void setDeployDate(String deployDate) {
		DeployDate = deployDate;
	}

	@Column(name="FoodMaterial")
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
