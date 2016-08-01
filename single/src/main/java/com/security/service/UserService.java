package com.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.security.dao.IUserEntityDao;
import com.security.dao.IUserRolesEntityDao;
import com.security.endpoint.model.UserModel;
import com.security.entity.LoginUserEntity;
import com.security.entity.UserRolesEntity;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserEntityDao userEntityDao;

	@Autowired
	private IUserRolesEntityDao userRolesDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void registerUser(UserModel userModel) {
		register(userModel);
	}

	private void register(UserModel userModel) {
		LoginUserEntity userEntity = userEntityDao.loadUserByUsername(userModel.getUsername());
		Assert.isNull(userEntity, "The user is already registered");
		userEntity = userEntityDao.saveAndFlush(createUserEntity(userModel));
		createUserRoles(userEntity);
	}

	private LoginUserEntity createUserEntity(UserModel userModel) {
		LoginUserEntity userEntity = new LoginUserEntity();
		userEntity.setEnabled(true);
		userEntity.setUsername(userModel.getUsername());
		userEntity.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
		return userEntity;
	}

	private void createUserRoles(LoginUserEntity userEntity) {
		List<UserRolesEntity> roles = new ArrayList<UserRolesEntity>();
		UserRolesEntity role = new UserRolesEntity();
		role.setRole("ROLE_USER");
		roles.add(role);
		role.setUserEntity(userEntity);
		userRolesDao.save(role);
	}

}
