package edu.zstu.entity;

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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "food_step")
public class FoodStepEntity extends BaseEntity {
	

//	private int FoodID;
//	private int FileID;
	
	private int StepNo;
	private String StepDesc;
	

	private FoodEntity food;
	private FileAttachEntity fileAttach;
	
	@ManyToOne(targetEntity=FoodEntity.class)
	@Cascade(value = {CascadeType.REFRESH })
	@JoinColumn(name = "FoodID")
	@JsonBackReference
	public FoodEntity getFood() {
		return food;
	}
	public void setFood(FoodEntity food) {
		this.food = food;
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
	
//	@JoinColumn(name="FoodID")
//	public int getFoodID() {
//		return FoodID;
//	}
//	public void setFoodID(int foodID) {
//		FoodID = foodID;
//	}
	
//	@JoinColumn(name="FileID")
//	public int getFileID() {
//		return FileID;
//	}
//	public void setFileID(int fileID) {
//		FileID = fileID;
//	}
	
	@Column(name="Stepno")
	public int getStepNo() {
		return StepNo;
	}
	public void setStepNo(int stepNo) {
		StepNo = stepNo;
	}
	
	@Column(name="Stepdesc")
	public String getStepDesc() {
		return StepDesc;
	}
	public void setStepDesc(String stepDesc) {
		StepDesc = stepDesc;
	}
}
