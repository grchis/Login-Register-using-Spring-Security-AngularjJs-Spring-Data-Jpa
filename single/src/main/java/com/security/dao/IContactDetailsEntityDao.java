package com.security.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.security.entity.ContactDetailsEntity;

public interface IContactDetailsEntityDao extends JpaRepository<ContactDetailsEntity, Serializable> {

	@Query(name = "ContactDetailsEntity.findContactDetailsByEmail")
	ContactDetailsEntity findByEmail(@Param(value = "email") String email);

}
