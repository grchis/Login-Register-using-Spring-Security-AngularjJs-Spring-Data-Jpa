package com.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "CONTACT_DETAILS")
@NamedQueries({
    @NamedQuery(name="ContactDetailsEntity.findContactDetailsByEmail",
                query="SELECT c FROM ContactDetailsEntity c WHERE c.userEntity.username = :email")
}) 
public class ContactDetailsEntity {
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "userEntity"))
	private Long id;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STREET_NAME")
	private String streetName;

	@Column(name = "STREET_NUMBER")
	private String streetNumber;

	@Column(name = "WEBSITE")
	private String website;

	@Column(name = "PHONE")
	private String phone;

	@OneToOne
	@PrimaryKeyJoinColumn
	private LoginUserEntity userEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LoginUserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(LoginUserEntity userEntity) {
		this.userEntity = userEntity;
	}

}
