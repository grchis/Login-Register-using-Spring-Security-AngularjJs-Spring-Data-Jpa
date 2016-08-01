package com.security.controller;

import com.security.endpoint.model.ContactDetailsModel;

public interface IContactDetailsController {

	void saveContactDetails(ContactDetailsModel contactDetails, String email);

	void deleteContactDetails();

	void editContactDetails();

	ContactDetailsModel getContactDetails(String name);
	
	
}
