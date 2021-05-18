package edu.zstu.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "food_step")
public class FoodStepEnity extends BaseEnity {
	
	private int FoodID;
	private int FileID;
	private int StepNo;
	private String StepDesc;
	
//	@OneToMany(targetEntity = FoodEnity.class)
//	@Cascade(value = { CascadeType.ALL })
//	@JoinColumn(name="FoodID")
//	@OrderBy("StepNo ASC")
	public int getFoodID() {
		return FoodID;
	}
	public void setFoodID(int foodID) {
		FoodID = foodID;
	}
	
//	@OneToMany(targetEntity = FileAttachEnity.class)
//	@Cascade(value = { CascadeType.ALL })
//	@JoinColumn(name="FileID")
//	@OrderBy("StepNo ASC")
	public int getFileID() {
		return FileID;
	}
	public void setFileID(int fileID) {
		FileID = fileID;
	}
	
	@Column(name="StepNo")
	public int getStepNo() {
		return StepNo;
	}
	public void setStepNo(int stepNo) {
		StepNo = stepNo;
	}
	
	@Column(name="StepDesc")
	public String getStepDesc() {
		return StepDesc;
	}
	public void setStepDesc(String stepDesc) {
		StepDesc = stepDesc;
	}
}
