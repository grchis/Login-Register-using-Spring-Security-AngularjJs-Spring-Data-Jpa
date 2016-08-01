package com.security.endpoint.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactDetailsModel {

	@JsonProperty(value = "country")
	private String country;

	@JsonProperty(value = "city")
	private String city;

	@JsonProperty(value = "streetName")
	private String streetName;

	@JsonProperty(value = "streetNumber")
	private String streetNumber;

	@JsonProperty(value = "website")
	private String website;

	@JsonProperty(value = "phone")
	private String phone;

	public ContactDetailsModel() {

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

}
