package edu.zstu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "activity_reserve")
public class ActivityReserveEntity extends BaseEntity {

	private UserEntity user;
	private FoodActivityEntity activity;
	private boolean isReserve;
	
	@ManyToOne(targetEntity = UserEntity.class)
	@Cascade(value = {CascadeType.REFRESH })
	@JoinColumn(name = "UserID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
	@ManyToOne(targetEntity = FoodActivityEntity.class)
	@Cascade(value = {CascadeType.REFRESH })
	@JoinColumn(name = "ActivityID")
	public FoodActivityEntity getActivity() {
		return activity;
	}
	public void setActivity(FoodActivityEntity activity) {
		this.activity = activity;
	}
	
	@Column(name="Reserve")
	public boolean isReserve() {
		return isReserve;
	}
	public void setReserve(boolean isReserve) {
		this.isReserve = isReserve;
	}

}
