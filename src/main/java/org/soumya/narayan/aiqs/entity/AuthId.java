package org.soumya.narayan.aiqs.entity;

import java.io.Serializable;

public class AuthId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;

	private String authority;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
