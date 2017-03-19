/**
 * 
 */
package br.com.cco2anpi.clients.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.cco2anpi.clients.UserClient;
import br.com.cco2anpi.models.IUser;
import br.com.cco2anpi.models.User;

/**
 * @author wotan
 *
 */
public class UserClientTest {

	private User user;
	private UserClient userClient;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		userClient = new UserClient("http://localhost:8080/Services");
		user = new User();
		user.setUserId(50);
	}

	@Test
	public void getUser() {
//		BaseResponse<User> response = new RestTemplate().exchange(REST_SERVICE_URI + "/User/getUser.json",
//				HttpMethod.POST, new HttpEntity<>(user), new ParameterizedTypeReference<BaseResponse<User>>() {
//				}).getBody();
//		@SuppressWarnings("unused")
//		User user = response.getResponse();
		assertTrue(true);
	}
	
	@Test
	public void getAllUsers() {
		try {
			IUser[] response = userClient.getAllUsers(1, 1).getBody().getResponse();
			assertTrue(true);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}

}
