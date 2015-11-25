package org.soumya.narayan.aiqs.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "LOGIN_CREDENTIALS")
public class LoginCredentialsEntity {

	@Id
	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "PAASSWORD")
	private String password;

	@Column(name = "LOGIN_STATUS")
	private int loginStatus;

	@Column(name = "LOGIN_TIME")
	private Timestamp loginTime;

	@Column(name = "LOGIN_IP")
	private String loginIp;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

}
