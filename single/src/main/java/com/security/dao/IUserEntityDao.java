package com.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.security.entity.LoginUserEntity;

public interface IUserEntityDao extends JpaRepository<LoginUserEntity, Long> {
	@Query(name = "LoginUserEntity.loadUserByUsername")
	LoginUserEntity loadUserByUsername(@Param("username") String username);
}
