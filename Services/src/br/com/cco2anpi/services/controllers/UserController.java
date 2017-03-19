/**
 * 
 */
package br.com.cco2anpi.services.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.cco2anpi.models.BaseResponse;
import br.com.cco2anpi.models.IUser;
import br.com.cco2anpi.models.PagedResponse;
import br.com.cco2anpi.models.User;
import br.com.cco2anpi.repository.UserRepository;

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
	@Transactional(readOnly=true)
	@RequestMapping(value = "getAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<PagedResponse<List<IUser>>> getAllUsers(@RequestParam("pageSize") int pageSize,
			@RequestParam("offset") int offset) {
		UserRepository userRepository = new UserRepository("hibernate.cfg.xml");
		startTime = System.currentTimeMillis();
		HashMap<String, Object> response = userRepository.getAllUsers(offset, pageSize);
		return okResponse((List<IUser>) response.get("users"), "Ok", HttpStatus.OK.value(),
				(Integer) response.get("total"), pageSize, offset);
	}

	/**
	 * Method used to get user
	 * 
	 * @param user
	 *            object user
	 * @return user filled
	 */
	@RequestMapping(value = "getUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<BaseResponse<IUser>> getUser(@RequestBody User user) {
		UserRepository userRepository = new UserRepository("hibernate.cfg.xml");
		startTime = System.currentTimeMillis();
		if (userRepository.exists(user)) {
			return okResponse(userRepository.getUser(user.getUserId()), "Ok", HttpStatus.OK.value());
		}
		return okResponse(new User(), "Not found", HttpStatus.NOT_FOUND.value());
	}

	/**
	 * Method used to insert user
	 * 
	 * @param user
	 *            to be inserted
	 * @return user filled
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<BaseResponse<IUser>> insert(@RequestBody User user) {
		UserRepository userRepository = new UserRepository("hibernate.cfg.xml");
		startTime = System.currentTimeMillis();
		if (userRepository.exists(user)) {
			return okResponse(new User(), "Conflict", HttpStatus.CONFLICT.value());
		}
		return okResponse(userRepository.insert(user), "Created", HttpStatus.CREATED.value());
	}

	/**
	 * Method used to update user
	 * 
	 * @param user
	 *            to be updated
	 * @return user updated
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<BaseResponse<IUser>> update(@RequestBody User user) {
		UserRepository userRepository = new UserRepository("hibernate.cfg.xml");
		startTime = System.currentTimeMillis();
		if (userRepository.exists(user)) {
			return okResponse(userRepository.update(user), "Ok", HttpStatus.ACCEPTED.value());
		}
		return okResponse(new User(), "Not found", HttpStatus.NOT_FOUND.value());
	}

	/**
	 * Method used to delete user
	 * 
	 * @param user
	 *            to be deleted
	 * @return status
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<BaseResponse<Boolean>> delete(@RequestBody User user) {
		UserRepository userRepository = new UserRepository("hibernate.cfg.xml");
		startTime = System.currentTimeMillis();
		if (userRepository.exists(user)) {
			return okResponse(userRepository.delete(user), "No content", HttpStatus.NO_CONTENT.value());
		}
		return okResponse(false, "Not found", HttpStatus.NOT_FOUND.value());
	}
}
