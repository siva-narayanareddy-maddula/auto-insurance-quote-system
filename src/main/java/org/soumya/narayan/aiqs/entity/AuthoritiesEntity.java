package org.soumya.narayan.aiqs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "AUTHORITIES")
@IdClass(value = AuthId.class)
public class AuthoritiesEntity {

	@Id @Column(name = "USER_ID")
	private Long userId;

	@Id @Column(name = "AUTHORITY")
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
