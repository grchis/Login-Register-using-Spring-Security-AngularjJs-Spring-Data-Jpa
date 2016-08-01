package com.security.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.security.dao.IUserEntityDao;
import com.security.entity.LoginUserEntity;
import com.security.entity.UserRolesEntity;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserEntityDao userEntityDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginUserEntity userEntity = userEntityDao.loadUserByUsername(username);
		Assert.notNull(userEntity, "ERROR");
		List<GrantedAuthority> authorities = buildUserAuthority(userEntity.getUserRoles());
		return new User(userEntity.getUsername(), userEntity.getPassword(), authorities);

	}

	private List<GrantedAuthority> buildUserAuthority(List<UserRolesEntity> userRoles) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (UserRolesEntity role : userRoles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		List<GrantedAuthority> authoritiesList = new ArrayList<GrantedAuthority>(authorities);
		return authoritiesList;
	}

}
