/**
 * 
 */
package br.com.cco2anpi.clients;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import br.com.cco2anpi.models.Access;
import br.com.cco2anpi.models.BaseResponse;

/**
 * @author wotan
 *
 */
public class AccessClient {

	private String restURLEndpoint;

	/**
	 * Constructor client
	 * 
	 * @param restURLEndpoint
	 *            URL of the service
	 */
	public AccessClient(String restURLEndpoint) {
		this.restURLEndpoint = restURLEndpoint;
	}

	/**
	 * Method used to send a post to insert access
	 * 
	 * @param access
	 *            access to be inserted
	 * @return return access filled
	 */
	public ResponseEntity<BaseResponse<Access>> insert(Access access) {
		return new RestTemplate().exchange(restURLEndpoint + "/Access/insert.json", HttpMethod.POST,
				new HttpEntity<>(access), new ParameterizedTypeReference<BaseResponse<Access>>() {
				});
	}

	/**
	 * Method used to update data
	 * 
	 * @param access
	 *            access to be updated
	 * @return access updated
	 */
	public ResponseEntity<BaseResponse<Access>> update(Access access) {
		return new RestTemplate().exchange(restURLEndpoint + "/Access/update.json", HttpMethod.POST,
				new HttpEntity<>(access), new ParameterizedTypeReference<BaseResponse<Access>>() {
				});
	}

	/**
	 * Method used to delete access
	 * 
	 * @param access
	 *            access to be deleted
	 * @return status
	 */
	public ResponseEntity<BaseResponse<Boolean>> delete(Access access) {
		return new RestTemplate().exchange(restURLEndpoint + "/Access/delete.json", HttpMethod.POST,
				new HttpEntity<>(access), new ParameterizedTypeReference<BaseResponse<Boolean>>() {
				});
	}

	/**
	 * Method used to get all access
	 * 
	 * @return return all access
	 */
	public ResponseEntity<BaseResponse<Access[]>> getAllAccess() {
		return new RestTemplate().exchange(restURLEndpoint + "/Access/getAllAccess.json", HttpMethod.GET, null,
				new ParameterizedTypeReference<BaseResponse<Access[]>>() {
				});
	}

	/**
	 * Method used to get one access
	 * 
	 * @return return one access
	 */
	public ResponseEntity<BaseResponse<Access>> getAccess(Access access) {
		return new RestTemplate().exchange(restURLEndpoint + "/Access/getAccess.json", HttpMethod.GET,
				new HttpEntity<>(access), new ParameterizedTypeReference<BaseResponse<Access>>() {
				});
	}

	/**
	 * Method used to get access filtred
	 * 
	 * @param type
	 *            of the user
	 * @param dateInit
	 *            date init
	 * @param dateEnd
	 *            date end
	 * @return access array
	 */
	public ResponseEntity<BaseResponse<Access[]>> getAccessByTypeAndDate(Integer type, String dateInit,
			String dateEnd) {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("parameters", type.toString());
		map.add("parameters", dateInit);
		map.add("parameters", dateEnd);

		return new RestTemplate().exchange(restURLEndpoint + "/Access/getAccessByTypeAndDate.json", HttpMethod.POST,
				new HttpEntity<>(map), new ParameterizedTypeReference<BaseResponse<Access[]>>() {
				});
	}
}
