package com.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.entity.UserRolesEntity;

public interface IUserRolesEntityDao extends JpaRepository<UserRolesEntity, Long> {

}
