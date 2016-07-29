package com.moke.MPortal.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moke.MPortal.model.User;
import com.moke.MPortal.model.UserDao;
import com.moke.core.advice.Result;

@Controller
@RequestMapping(value="/user")
public class UserController {

	 // ------------------------
	  // PUBLIC METHODS
	  // ------------------------
	  
	  /**
	   * /create  --> Create a new user and save it in the database.
	   * 
	   * @param email User's email
	   * @param name User's name
	   * @return A string describing if the user is succesfully created or not.
	   */
	  @RequestMapping(method = RequestMethod.POST)
	  @ResponseBody
	  public Result create(@RequestBody User user) {
//	    User user = null;
	    try {
//	      user = new User(username, password);
	      userDao.save(user);
	    }
	    catch (Exception ex) {
	      return Result.failure(ex);
	    }
	    return Result.sucess(user);
	  }
	  
	  @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	  @ResponseBody
	  public Result getById(Long id) {
		  User user = userDao.findOne(id);
		  return Result.sucess(user);
	  }
	  
	  /**
	   * /delete  --> Delete the user having the passed id.
	   * 
	   * @param id The id of the user to delete
	   * @return A string describing if the user is succesfully deleted or not.
	   */
	  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	  @ResponseBody
	  public Result delete(long id) {
	    try {
	      User user = new User();
	      userDao.delete(user);
	    }
	    catch (Exception ex) {
	      return Result.failure(ex);
	    }
	    return Result.sucess("delete success");
	  }
	  
	  /**
	   * /update  --> Update the email and the name for the user in the database 
	   * having the passed id.
	   * 
	   * @param id The id for the user to update.
	   * @param email The new email.
	   * @param name The new name.
	   * @return A string describing if the user is succesfully updated or not.
	   */
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  @ResponseBody
	  public Result updateUser(@RequestBody User user) {
	    try {
//	      User user = userDao.findOne(Long.valueOf(id));
	      userDao.save(user);
	      return Result.sucess(user);
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	      return Result.failure(ex.getMessage());
	    }
	  }

	  // ------------------------
	  // PRIVATE FIELDS
	  // ------------------------

	  @Autowired
	  private UserDao userDao;
}
