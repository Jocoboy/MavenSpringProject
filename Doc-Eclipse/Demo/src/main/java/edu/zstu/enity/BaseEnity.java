package edu.zstu.enity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEnity {
	
	protected Long ID;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return ID;
	}

	public void setId(Long ID) {
		this.ID = ID;
	}
}
