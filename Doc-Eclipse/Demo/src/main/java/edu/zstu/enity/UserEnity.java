package edu.zstu.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "system_user")
public class UserEnity extends BaseEnity {

	private String Username;
	private String Password;
	private String Salt;
	private String Remark;

	
	@NotBlank
	@Column(name="Username")
	public String getUsername() {
		return Username;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}

	@Column(name="Password")
	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	@Column(name="Salt")
	public String getSalt() {
		return Salt;
	}

	public void setSalt(String Salt) {
		this.Salt = Salt;
	}

	@Column(name="Remark")
	public String getRemark() {
		return Remark;
	}

	public void setRemark(String Remark) {
		this.Remark = Remark;
	}
}
