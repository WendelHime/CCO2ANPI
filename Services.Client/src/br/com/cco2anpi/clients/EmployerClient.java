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
	public static final String REST_SERVICE_URI = "http://localhost:8080/Services";

	/**
	 * Method used to send a post to insert employer
	 * 
	 * @param employer
	 *            employer to be inserted
	 * @return return employer filled
	 */
	public static ResponseEntity<BaseResponse<Employer>> insert(Employer employer) {
		return new RestTemplate().exchange(REST_SERVICE_URI + "/Employer/insert.json", HttpMethod.POST,
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
	public static ResponseEntity<BaseResponse<Employer>> update(Employer employer) {
		return new RestTemplate().exchange(REST_SERVICE_URI + "/Employer/update.json", HttpMethod.POST,
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
	public static ResponseEntity<BaseResponse<Boolean>> delete(Employer employer) {
		return new RestTemplate().exchange(REST_SERVICE_URI + "/Employer/delete.json", HttpMethod.POST,
				new HttpEntity<>(employer), new ParameterizedTypeReference<BaseResponse<Boolean>>() {
				});
	}

	/**
	 * Method used to get all employers
	 * 
	 * @return return all employers
	 */
	public static ResponseEntity<BaseResponse<Employer[]>> getAllEmployers() {
		return new RestTemplate().exchange(REST_SERVICE_URI + "/User/getAllEmployers.json", HttpMethod.GET, null,
				new ParameterizedTypeReference<BaseResponse<Employer[]>>() {
				});
	}
}
