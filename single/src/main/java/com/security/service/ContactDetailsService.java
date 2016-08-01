package com.security.service;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.security.controller.IContactDetailsController;
import com.security.endpoint.model.ContactDetailsModel;

@Component
public class ContactDetailsService {

	@Autowired
	private IContactDetailsController contactDetailsController;

	public void saveContactDetails(ContactDetailsModel contactDetails) {
		assertContactDetails(contactDetails);
		contactDetailsController.saveContactDetails(contactDetails,
				SecurityContextHolder.getContext().getAuthentication().getName());
	}

	public ContactDetailsModel getContactDetails() {
		return contactDetailsController
				.getContactDetails(SecurityContextHolder.getContext().getAuthentication().getName());
	}

	private void assertContactDetails(ContactDetailsModel contactDetails) {
		Assert.assertNotNull("Contact details must not be null", contactDetails);
		Assert.assertNotNull("City must not be null", contactDetails.getCity());
		Assert.assertNotNull("Country must not be null", contactDetails.getCountry());
		Assert.assertNotNull("Phone number must not be null", contactDetails.getPhone());
		Assert.assertNotNull("Street name must not be null", contactDetails.getStreetName());
		Assert.assertNotNull("Street number must not be null", contactDetails.getStreetNumber());

	}

}
