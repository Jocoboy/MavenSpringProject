package edu.zstu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "food_collect")
public class FoodCollectEntity extends BaseEntity {
	
	private UserEntity user;
	private FoodEntity food;
	private boolean isStar;
	
	@ManyToOne(targetEntity = UserEntity.class)
	@Cascade(value = {CascadeType.REFRESH })
	@JoinColumn(name = "UserID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	@ManyToOne(targetEntity = FoodEntity.class)
	@Cascade(value = {CascadeType.REFRESH })
	@JoinColumn(name = "FoodID")
	public FoodEntity getFood() {
		return food;
	}
	public void setFood(FoodEntity food) {
		this.food = food;
	}
	
	@Column(name="Star")
	public boolean isStar() {
		return isStar;
	}
	public void setStar(boolean isStar) {
		this.isStar = isStar;
	}
	
	
}
