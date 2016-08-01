package com.security.endpoint;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.security.endpoint.model.UserModel;
import com.security.service.IAutoLoginService;
import com.security.service.UserService;

@RestController
public class RegisterServiceEndpoint {
	private final Logger logger = LoggerFactory.getLogger(RegisterServiceEndpoint.class);
	@Autowired
	private UserService userService;

	@Autowired
	private IAutoLoginService autologinService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void registerUser(@RequestBody UserModel model) {
		assertUserModel(model);
		logger.info("Registering user account with information: {}", model);
		userService.registerUser(model);
		autologinService.autologin(model.getUsername(), model.getPassword());
	}

	private void assertUserModel(UserModel model) {
		Assert.assertNotNull("The object must not be null", model);
		Assert.assertNotNull("The username must not be null", model.getPassword());
		Assert.assertNotNull("The password must not be null", model.getUsername());

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getUser(@ModelAttribute("user") UserModel model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.info("Getting user from context with username: {}", user.getUsername());
	}

}
