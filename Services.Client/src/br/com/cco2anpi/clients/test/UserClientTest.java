/**
 * 
 */
package br.com.cco2anpi.clients.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import br.com.cco2anpi.models.BaseResponse;
import br.com.cco2anpi.models.User;

/**
 * @author wotan
 *
 */
public class UserClientTest {

	private User user;
	private String REST_SERVICE_URI;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		REST_SERVICE_URI = "http://localhost:8080/Services";
		user = new User();
		user.setUserId(50);
	}

	@Test
	public void getUser() {
		BaseResponse<User> response = new RestTemplate().exchange(REST_SERVICE_URI + "/User/getUser.json",
				HttpMethod.POST, new HttpEntity<>(user), new ParameterizedTypeReference<BaseResponse<User>>() {
				}).getBody();
		@SuppressWarnings("unused")
		User user = response.getResponse();
		assertTrue(true);
	}

}
