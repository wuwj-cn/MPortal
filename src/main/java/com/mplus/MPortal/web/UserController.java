package com.mplus.MPortal.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mplus.MPortal.model.User;
import com.mplus.MPortal.service.UserService;
import com.mplus.core.advice.Result;

@Controller
@RequestMapping(value = "/users")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Result create(@RequestBody User user) {
		// User user = null;
		try {
			// user = new User(username, password);
			userService.save(user);
		} catch (Exception ex) {
			return Result.failure(ex);
		}
		return Result.sucess(user);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Result getById(@PathVariable String id) {
		User user = userService.findOne(id);
		return Result.sucess(user);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public Result delete(long id) {
		try {
			User user = new User();
			userService.delete(user);
		} catch (Exception ex) {
			return Result.failure(ex);
		}
		return Result.sucess("delete success");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateUser(@RequestBody User user) {
		try {
			// User user = userService.findOne(Long.valueOf(id));
			userService.save(user);
			return Result.sucess(user);
		} catch (Exception e) {
			logger.error("/users/"+user.getId(), e);
			return Result.failure(e.getMessage());
		}
	}

}
