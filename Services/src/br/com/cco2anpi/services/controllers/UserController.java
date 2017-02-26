/**
 * 
 */
package br.com.cco2anpi.services.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.cco2anpi.models.IUser;
import br.com.cco2anpi.models.User;

/**
 * @author wotan
 *
 */

@Controller
@EnableWebMvc
@RequestMapping("User/*")
public class UserController extends BaseController {

	/**
	 * Method used to get all users
	 * 
	 * @return array of users
	 */
	@RequestMapping(value = "getAllUsers", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<User[]> getAllUsers() {
		IUser[] usersDB = userRepository.getAllUsers();
		User[] users = new User[usersDB.length];
		for (int i = 0; i < users.length; i++) {
			users[i] = new User(usersDB[i]);
		}
		return new ResponseEntity<User[]>(users, HttpStatus.OK);
	}

	/**
	 * Method used to get user
	 * 
	 * @param user
	 *            object user
	 * @return user filled
	 */
	@RequestMapping(value = "getUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<User> getUser(@RequestBody User user) {
		if (userRepository.exists(user)) {
			return new ResponseEntity<User>(new User(userRepository.getUser(user.getId())), HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Method used to insert user
	 * 
	 * @param user
	 *            to be inserted
	 * @return user filled
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<User> insert(@RequestBody User user) {
		if (userRepository.exists(user)) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<User>(new User(userRepository.insert(user)), new HttpHeaders(), HttpStatus.CREATED);
	}

	/**
	 * Method used to update user
	 * 
	 * @param user
	 *            to be updated
	 * @return user updated
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<User> update(@RequestBody User user) {
		if (userRepository.exists(user)) {
			return new ResponseEntity<User>(new User(userRepository.update(user)), new HttpHeaders(), HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Method used to delete user
	 * 
	 * @param user
	 *            to be deleted
	 * @return status
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Boolean> delete(@RequestBody User user) {
		if (userRepository.exists(user)) {
			return new ResponseEntity<Boolean>(userRepository.delete(user), new HttpHeaders(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}
}
