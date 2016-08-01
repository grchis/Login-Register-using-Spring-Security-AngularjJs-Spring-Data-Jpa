package com.security.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.security.endpoint.model.ContactDetailsModel;
import com.security.service.ContactDetailsService;

@RestController
public class ContactDetailsServiceEndpoint {

	@Autowired
	private ContactDetailsService contactDetailsService;

	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public void saveContactDetails(@RequestBody ContactDetailsModel contactDetails) {
		contactDetailsService.saveContactDetails(contactDetails);
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ContactDetailsModel getContactDetails() {
		return contactDetailsService.getContactDetails();
	}
}
