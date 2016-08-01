package com.security.controller;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.security.dao.IContactDetailsEntityDao;
import com.security.dao.IUserEntityDao;
import com.security.endpoint.model.ContactDetailsModel;
import com.security.entity.ContactDetailsEntity;
import com.security.entity.LoginUserEntity;

@Component
public class ContactDetailsController implements IContactDetailsController {

	@Autowired
	private IContactDetailsEntityDao contactEntityDao;

	@Autowired
	private IUserEntityDao userEntityDao;

	@Override
	public void saveContactDetails(ContactDetailsModel contactDetails, String email) {
		LoginUserEntity userEntity = userEntityDao.loadUserByUsername(email);
		ContactDetailsEntity contactDetailsEntity = buildContactDetailsEntity(contactDetails, userEntity);
		contactEntityDao.saveAndFlush(contactDetailsEntity);
	}

	@Override
	public ContactDetailsModel getContactDetails(String email) {
		ContactDetailsEntity details = contactEntityDao.findByEmail(email);
		Assert.assertNotNull("No contact details found ", details);
		return buildContactDetailsDto(details);
	}

	@Override
	public void deleteContactDetails() {
		// TODO Auto-generated method stub

	}

	@Override
	public void editContactDetails() {
		// TODO Auto-generated method stub

	}

	private ContactDetailsEntity buildContactDetailsEntity(ContactDetailsModel contactDetails,
			LoginUserEntity userEntity) {
		ContactDetailsEntity contactDetailsEntity = new ContactDetailsEntity();
		contactDetailsEntity.setCity(contactDetails.getCity());
		contactDetailsEntity.setCountry(contactDetails.getCountry());
		contactDetailsEntity.setPhone(contactDetails.getPhone());
		contactDetailsEntity.setStreetName(contactDetails.getStreetName());
		contactDetailsEntity.setStreetNumber(contactDetails.getStreetNumber());
		contactDetailsEntity.setWebsite(contactDetails.getWebsite());
		contactDetailsEntity.setUserEntity(userEntity);
		return contactDetailsEntity;

	}

	private ContactDetailsModel buildContactDetailsDto(ContactDetailsEntity details) {
		ContactDetailsModel contactDetailsModel = new ContactDetailsModel();
		contactDetailsModel.setCity(details.getCity());
		contactDetailsModel.setCountry(details.getCountry());
		contactDetailsModel.setPhone(details.getPhone());
		contactDetailsModel.setStreetName(details.getStreetName());
		contactDetailsModel.setStreetNumber(details.getStreetNumber());
		contactDetailsModel.setWebsite(details.getWebsite());
		return contactDetailsModel;
	}

}
