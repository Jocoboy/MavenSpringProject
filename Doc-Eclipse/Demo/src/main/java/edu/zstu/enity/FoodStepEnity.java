package edu.zstu.enity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class FoodStepEnity extends BaseEnity {
	
	private int Food_ID;
	private int File_ID;
	private int Step_No;
	private String Step_Desc;
	
	@OneToMany
	@Cascade(value = { CascadeType.ALL })
	@JoinColumn(name="Food_ID")
	@OrderBy("Step_No ASC")
	public int getFood_ID() {
		return Food_ID;
	}
	public void setFood_ID(int food_ID) {
		Food_ID = food_ID;
	}
	
	@OneToMany
	@Cascade(value = { CascadeType.ALL })
	@JoinColumn(name="File_ID")
	@OrderBy("Step_No ASC")
	public int getFile_ID() {
		return File_ID;
	}
	public void setFile_ID(int file_ID) {
		File_ID = file_ID;
	}
	
	@Column(name="Step_No")
	public int getStep_No() {
		return Step_No;
	}
	public void setStep_No(int step_No) {
		Step_No = step_No;
	}
	
	@Column(name="Step_Desc")
	public String getStep_Desc() {
		return Step_Desc;
	}
	public void setStep_Desc(String step_Desc) {
		Step_Desc = step_Desc;
	}
}
