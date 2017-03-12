/**
 * 
 */
package br.com.cco2anpi.clients;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.cco2anpi.models.BaseResponse;
import br.com.cco2anpi.models.User;

/**
 * @author wotan class used to make connection with the user services
 */
public class UserClient {

	public static final String REST_SERVICE_URI = "http://localhost:8080/Services";

	/**
	 * Method used to send a post to insert user
	 * 
	 * @param user
	 *            user to be inserted
	 * @return return user filled
	 */
	public static ResponseEntity<BaseResponse<User>> insert(User user) {
		return new RestTemplate().exchange(REST_SERVICE_URI + "/User/insert.json", HttpMethod.POST, new HttpEntity<>(user),
				new ParameterizedTypeReference<BaseResponse<User>>() {
				});
	}

	/**
	 * Method used to update data
	 * 
	 * @param user
	 *            user to be updated
	 * @return user updated
	 */
	public static ResponseEntity<BaseResponse<User>> update(User user) {
		return new RestTemplate().exchange(REST_SERVICE_URI + "/User/update.json", HttpMethod.POST, new HttpEntity<>(user),
				new ParameterizedTypeReference<BaseResponse<User>>() {
				});
	}

	/**
	 * Method used to delete user
	 * 
	 * @param user
	 *            user to be deleted
	 * @return status
	 */
	public static ResponseEntity<BaseResponse<Boolean>> delete(User user) {
		return new RestTemplate().exchange(REST_SERVICE_URI + "/User/delete.json", HttpMethod.POST, new HttpEntity<>(user),
				new ParameterizedTypeReference<BaseResponse<Boolean>>() {
				});
	}

	/**
	 * Method used to get all users
	 * 
	 * @return return all users
	 */
	public static ResponseEntity<BaseResponse<User[]>> getAllUsers() {
		return new RestTemplate().exchange(REST_SERVICE_URI + "/User/getAllUsers.json", HttpMethod.GET, null,
				new ParameterizedTypeReference<BaseResponse<User[]>>() {
				});
	}

	/**
	 * Method uset to get specific user
	 * 
	 * @param user
	 *            object user to be searched
	 * @return user filled
	 */
	public static ResponseEntity<BaseResponse<User>> getUser(User user) {
		return new RestTemplate().exchange(REST_SERVICE_URI + "/User/getUser.json", HttpMethod.POST,
				new HttpEntity<>(user), new ParameterizedTypeReference<BaseResponse<User>>() {
				});
	}

}
