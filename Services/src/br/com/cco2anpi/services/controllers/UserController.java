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

import br.com.cco2anpi.models.BaseResponse;
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
	@RequestMapping(value = "getAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<BaseResponse<IUser[]>> getAllUsers() {
		startTime = System.currentTimeMillis();
		IUser[] usersDB = userRepository.getAllUsers();
		BaseResponse<IUser[]> baseResponse = new BaseResponse<>();
		baseResponse.setMessage("Ok");
		baseResponse.setStatusCode(HttpStatus.OK.value());
		baseResponse.setResponse(usersDB);
		baseResponse.setElapsed_ms(this.calculateElapsedTime(startTime));
		return new ResponseEntity<BaseResponse<IUser[]>>(baseResponse, HttpStatus.OK);
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
		startTime = System.currentTimeMillis();
		BaseResponse<IUser> baseResponse = new BaseResponse<>();
		if (userRepository.exists(user)) {
			baseResponse.setResponse(userRepository.getUser(user.getUserId()));
			baseResponse.setMessage("Ok");
			baseResponse.setStatusCode(HttpStatus.OK.value());
			baseResponse.setElapsed_ms(this.calculateElapsedTime(startTime));
			return new ResponseEntity<BaseResponse<IUser>>(baseResponse, HttpStatus.OK);
		}
		baseResponse.setMessage("Not found");
		baseResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		baseResponse.setResponse(new User());
		baseResponse.setElapsed_ms(this.calculateElapsedTime(startTime));
		return new ResponseEntity<BaseResponse<IUser>>(baseResponse, HttpStatus.OK);
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
		startTime = System.currentTimeMillis();
		BaseResponse<IUser> baseResponse = new BaseResponse<>();
		if (userRepository.exists(user)) {
			baseResponse.setResponse(new User());
			baseResponse.setMessage("Conflict");
			baseResponse.setStatusCode(HttpStatus.CONFLICT.value());
			baseResponse.setElapsed_ms(this.calculateElapsedTime(startTime));
			return new ResponseEntity<BaseResponse<IUser>>(baseResponse, HttpStatus.CONFLICT);
		}
		baseResponse.setMessage("Created");
		baseResponse.setStatusCode(HttpStatus.CREATED.value());
		baseResponse.setResponse(userRepository.insert(user));
		baseResponse.setElapsed_ms(this.calculateElapsedTime(startTime));
		return new ResponseEntity<BaseResponse<IUser>>(baseResponse, new HttpHeaders(), HttpStatus.OK);
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
		startTime = System.currentTimeMillis();
		BaseResponse<IUser> baseResponse = new BaseResponse<>();
		if (userRepository.exists(user)) {
			baseResponse.setResponse(userRepository.update(user));
			baseResponse.setMessage("Ok");
			baseResponse.setStatusCode(HttpStatus.OK.value());
			baseResponse.setElapsed_ms(this.calculateElapsedTime(startTime));
			return new ResponseEntity<BaseResponse<IUser>>(baseResponse, new HttpHeaders(), HttpStatus.OK);
		}
		baseResponse.setMessage("Not found");
		baseResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		baseResponse.setResponse(new User());
		baseResponse.setElapsed_ms(this.calculateElapsedTime(startTime));
		return new ResponseEntity<BaseResponse<IUser>>(baseResponse, HttpStatus.OK);
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
		startTime = System.currentTimeMillis();
		BaseResponse<Boolean> baseResponse = new BaseResponse<>();
		if (userRepository.exists(user)) {
			baseResponse.setResponse(userRepository.delete(user));
			baseResponse.setMessage("Ok");
			baseResponse.setStatusCode(HttpStatus.OK.value());
			baseResponse.setElapsed_ms(this.calculateElapsedTime(startTime));
			return new ResponseEntity<BaseResponse<Boolean>>(baseResponse, new HttpHeaders(), HttpStatus.NO_CONTENT);
		}
		baseResponse.setMessage("Not found");
		baseResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		baseResponse.setResponse(false);
		baseResponse.setElapsed_ms(this.calculateElapsedTime(startTime));
		return new ResponseEntity<BaseResponse<Boolean>>(HttpStatus.OK);
	}
}
