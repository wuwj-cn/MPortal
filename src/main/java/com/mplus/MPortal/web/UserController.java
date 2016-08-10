package com.mplus.MPortal.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	// ------------------------
	// PUBLIC METHODS
	// ------------------------

	/**
	 * /create --> Create a new user and save it in the database.
	 * 
	 * @param email
	 *            User's email
	 * @param name
	 *            User's name
	 * @return A string describing if the user is succesfully created or not.
	 */
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
	public Result getById(String id) {
		User user = userService.findOne(id);
		return Result.sucess(user);
	}

	/**
	 * /delete --> Delete the user having the passed id.
	 * 
	 * @param id
	 *            The id of the user to delete
	 * @return A string describing if the user is succesfully deleted or not.
	 */
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

	/**
	 * /update --> Update the email and the name for the user in the database
	 * having the passed id.
	 * 
	 * @param id
	 *            The id for the user to update.
	 * @param email
	 *            The new email.
	 * @param name
	 *            The new name.
	 * @return A string describing if the user is succesfully updated or not.
	 */
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

	// ------------------------
	// PRIVATE FIELDS
	// ------------------------

	@Autowired
	private UserService userService;
}
