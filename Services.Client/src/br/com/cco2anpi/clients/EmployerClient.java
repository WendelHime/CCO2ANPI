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
import br.com.cco2anpi.models.Employer;

/**
 * @author wotan Class used to make connection with employer the services
 */
public class EmployerClient {

	private String restURLEndpoint;

	/**
	 * Constructor client
	 * 
	 * @param restURLEndpoint
	 *            URL of the service
	 */
	public EmployerClient(String restURLEndpoint) {
		this.restURLEndpoint = restURLEndpoint;
	}

	/**
	 * Method used to send a post to insert employer
	 * 
	 * @param employer
	 *            employer to be inserted
	 * @return return employer filled
	 */
	public ResponseEntity<BaseResponse<Employer>> insert(Employer employer) {
		return new RestTemplate().exchange(restURLEndpoint + "/Employer/insert.json", HttpMethod.POST,
				new HttpEntity<>(employer), new ParameterizedTypeReference<BaseResponse<Employer>>() {
				});
	}

	/**
	 * Method used to update data
	 * 
	 * @param employer
	 *            employer to be updated
	 * @return employer updated
	 */
	public ResponseEntity<BaseResponse<Employer>> update(Employer employer) {
		return new RestTemplate().exchange(restURLEndpoint + "/Employer/update.json", HttpMethod.POST,
				new HttpEntity<>(employer), new ParameterizedTypeReference<BaseResponse<Employer>>() {
				});
	}

	/**
	 * Method used to delete employer
	 * 
	 * @param employer
	 *            employer to be deleted
	 * @return status
	 */
	public ResponseEntity<BaseResponse<Boolean>> delete(Employer employer) {
		return new RestTemplate().exchange(restURLEndpoint + "/Employer/delete.json", HttpMethod.POST,
				new HttpEntity<>(employer), new ParameterizedTypeReference<BaseResponse<Boolean>>() {
				});
	}

	/**
	 * Method used to get all employers
	 * 
	 * @return return all employers
	 */
	public ResponseEntity<BaseResponse<Employer[]>> getAllEmployers() {
		return new RestTemplate().exchange(restURLEndpoint + "/User/getAllEmployers.json", HttpMethod.GET, null,
				new ParameterizedTypeReference<BaseResponse<Employer[]>>() {
				});
	}
}
