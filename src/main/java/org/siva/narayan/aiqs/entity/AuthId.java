package org.siva.narayan.aiqs.entity;

import java.io.Serializable;

public class AuthId implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;

	private String authority;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
