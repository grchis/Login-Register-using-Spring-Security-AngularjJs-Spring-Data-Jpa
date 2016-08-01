package com.security.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@NamedQueries({
		@NamedQuery(name = "LoginUserEntity.loadUserByUsername", query = "SELECT c FROM LoginUserEntity c WHERE "
				+ "c.username = :username") })

@Entity
@Table(name = "USER_TABLE")
public class LoginUserEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ENABLED")
	private boolean enabled;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "userEntity")
	private List<UserRolesEntity> userRoles = new ArrayList<UserRolesEntity>();

	@OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL)
	private ContactDetailsEntity employeeDetail;

	public LoginUserEntity() {

	}

	public LoginUserEntity(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<UserRolesEntity> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRolesEntity> userRoles) {
		this.userRoles = userRoles;
	}

}
