package edu.zstu.enity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class FoodEnity extends BaseEnity {
	
	
	private int User_ID;
	private int File_ID;
	private String FoodName;
	private String Deploy_Date;
	private String Food_Material;
	private int Steps;
	private int Likes;
	
	private List<FoodStepEnity> FoodStepList;
	
	@ManyToOne(targetEntity = UserEnity.class)
	@Cascade(value = {CascadeType.REFRESH })
	@JoinColumn(name="User_ID")
	public int getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}
	
	@ManyToOne(targetEntity = FileAttachEnity.class)
	@Cascade(value = {CascadeType.REFRESH })
	@JoinColumn(name="File_ID")
	public int getFile_ID() {
		return File_ID;
	}

	public void setFile_ID(int file_ID) {
		File_ID = file_ID;
	}

	
	
	@Column(name="Food_Name")
	public String getFoodName() {
		return FoodName;
	}

	public void setFoodName(String foodName) {
		FoodName = foodName;
	}

	@Column(name="Deploy_Date")
	public String getDeploy_Date() {
		return Deploy_Date;
	}

	public void setDeploy_Date(String deploy_Date) {
		Deploy_Date = deploy_Date;
	}

	@Column(name="Food_Material")
	public String getFood_Material() {
		return Food_Material;
	}

	public void setFood_Material(String food_Material) {
		Food_Material = food_Material;
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

	public List<FoodStepEnity> getFoodStepList() {
		return FoodStepList;
	}

	public void setFoodStepList(List<FoodStepEnity> foodStepList) {
		FoodStepList = foodStepList;
	}



	
	
}
