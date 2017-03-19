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
import br.com.cco2anpi.models.Company;

/**
 * @author wotan Class used to make connection with company the services
 */
public class CompanyClient {

	private String restURLEndpoint;

	/**
	 * Constructor client
	 * 
	 * @param restURLEndpoint
	 *            URL of the service
	 */
	public CompanyClient(String restURLEndpoint) {
		this.restURLEndpoint = restURLEndpoint;
	}

	/**
	 * Method used to send a post to insert company
	 * 
	 * @param company
	 *            company to be inserted
	 * @return return company filled
	 */
	// @Test
	public ResponseEntity<BaseResponse<Company>> insert(Company company) {
		return new RestTemplate().exchange(restURLEndpoint + "/Company/insert.json", HttpMethod.POST,
				new HttpEntity<>(company), new ParameterizedTypeReference<BaseResponse<Company>>() {
				});
	}

	/**
	 * Method used to update data
	 * 
	 * @param company
	 *            company to be updated
	 * @return company updated
	 */
	public ResponseEntity<BaseResponse<Company>> update(Company company) {
		return new RestTemplate().exchange(restURLEndpoint + "/Company/update.json", HttpMethod.POST,
				new HttpEntity<>(company), new ParameterizedTypeReference<BaseResponse<Company>>() {
				});
	}

	/**
	 * Method used to delete company
	 * 
	 * @param company
	 *            company to be deleted
	 * @return status
	 */
	public ResponseEntity<BaseResponse<Boolean>> delete(Company company) {
		return new RestTemplate().exchange(restURLEndpoint + "/Company/delete.json", HttpMethod.POST,
				new HttpEntity<>(company), new ParameterizedTypeReference<BaseResponse<Boolean>>() {
				});
	}

	/**
	 * Method used to get all companys
	 * 
	 * @return return all companys
	 */
	public ResponseEntity<BaseResponse<Company[]>> getAllCompanies() {
		return new RestTemplate().exchange(restURLEndpoint + "/Company/getAllUsers.json", HttpMethod.GET, null,
				new ParameterizedTypeReference<BaseResponse<Company[]>>() {
				});
	}

	/**
	 * Method used to get all companys
	 * 
	 * @return return all companys
	 */
	public ResponseEntity<BaseResponse<Company>> getUser(Company company) {
		return new RestTemplate().exchange(restURLEndpoint + "/Company/getUser.json", HttpMethod.POST,
				new HttpEntity<>(company), new ParameterizedTypeReference<BaseResponse<Company>>() {
				});
	}
}
