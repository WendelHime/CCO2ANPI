/**
 * 
 */
package br.com.cco2anpi.clients;

import java.util.ArrayList;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cco2anpi.models.BaseResponse;
import br.com.cco2anpi.models.PagedResponse;
import br.com.cco2anpi.models.User;

/**
 * @author wotan class used to make connection with the user services
 */
public class UserClient {

	private String restURLEndpoint;

	/**
	 * Constructor client
	 * 
	 * @param restURLEndpoint
	 *            URL of the service
	 */
	public UserClient(String restURLEndpoint) {
		this.restURLEndpoint = restURLEndpoint;
	}

	/**
	 * Method used to send a post to insert user
	 * 
	 * @param user
	 *            user to be inserted
	 * @return return user filled
	 */
	public ResponseEntity<BaseResponse<User>> insert(User user) {
		return new RestTemplate().exchange(restURLEndpoint + "/User/insert.json", HttpMethod.POST,
				new HttpEntity<>(user), new ParameterizedTypeReference<BaseResponse<User>>() {
				});
	}

	/**
	 * Method used to update data
	 * 
	 * @param user
	 *            user to be updated
	 * @return user updated
	 */
	public ResponseEntity<BaseResponse<User>> update(User user) {
		return new RestTemplate().exchange(restURLEndpoint + "/User/update.json", HttpMethod.POST,
				new HttpEntity<>(user), new ParameterizedTypeReference<BaseResponse<User>>() {
				});
	}

	/**
	 * Method used to delete user
	 * 
	 * @param user
	 *            user to be deleted
	 * @return status
	 */
	public ResponseEntity<BaseResponse<Boolean>> delete(User user) {
		return new RestTemplate().exchange(restURLEndpoint + "/User/delete.json", HttpMethod.POST,
				new HttpEntity<>(user), new ParameterizedTypeReference<BaseResponse<Boolean>>() {
				});
	}

	/**
	 * Method used to get all users
	 * 
	 * @param pageSize
	 *            quantity of users
	 * @param offset
	 *            quantity to jump
	 * @return return all users
	 */
	public ResponseEntity<PagedResponse<User[]>> getAllUsers(int pageSize, int offset) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("pageSize", "" + pageSize);
		params.add("offset", "" + offset);
		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(restURLEndpoint + "/User/getAllUsers.json")
				.queryParams(params).build();
		return new RestTemplate().exchange(uriComponents.toUriString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<PagedResponse<User[]>>() {
				});
	}

	/**
	 * Method uset to get specific user
	 * 
	 * @param user
	 *            object user to be searched
	 * @return user filled
	 */
	public ResponseEntity<BaseResponse<User>> getUser(User user) {
		return new RestTemplate().exchange(restURLEndpoint + "/User/getUser.json", HttpMethod.POST,
				new HttpEntity<>(user), new ParameterizedTypeReference<BaseResponse<User>>() {
				});
	}

}
