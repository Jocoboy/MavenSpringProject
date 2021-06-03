package edu.zstu.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "multi_food_activity_fileattach")
public class MultiActivityFileAttachEntity extends BaseEntity {
	//	private int ActivityID;
	//	private int FileID;
	
	private FoodActivityEntity foodActivity;
	private FileAttachEntity fileAttach;
	
	@ManyToOne(targetEntity=FoodActivityEntity.class)
	@Cascade(value = {CascadeType.REFRESH })
	@JoinColumn(name = "ActivityID")
	@JsonBackReference
	public FoodActivityEntity getFoodActivity() {
		return foodActivity;
	}
	public void setFoodActivity(FoodActivityEntity foodActivity) {
		this.foodActivity = foodActivity;
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
	
	
}
