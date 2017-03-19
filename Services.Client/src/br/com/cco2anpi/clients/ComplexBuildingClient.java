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
import br.com.cco2anpi.models.ComplexBuilding;

/**
 * @author wotan
 *
 */
public class ComplexBuildingClient {

	private String restURLEndpoint;

	/**
	 * Constructor client
	 * 
	 * @param restURLEndpoint
	 *            URL of the service
	 */
	public ComplexBuildingClient(String restURLEndpoint) {
		this.restURLEndpoint = restURLEndpoint;
	}

	/**
	 * Method used to send a post to insert complexBuilding
	 * 
	 * @param complexBuilding
	 *            complexBuilding to be inserted
	 * @return return complexBuilding filled
	 */
	public ResponseEntity<BaseResponse<ComplexBuilding>> insert(ComplexBuilding complexBuilding) {
		return new RestTemplate().exchange(restURLEndpoint + "/ComplexBuilding/insert.json", HttpMethod.POST,
				new HttpEntity<>(complexBuilding), new ParameterizedTypeReference<BaseResponse<ComplexBuilding>>() {
				});
	}

	/**
	 * Method used to update data
	 * 
	 * @param complexBuilding
	 *            complexBuilding to be updated
	 * @return complexBuilding updated
	 */
	public ResponseEntity<BaseResponse<ComplexBuilding>> update(ComplexBuilding complexBuilding) {
		return new RestTemplate().exchange(restURLEndpoint + "/ComplexBuilding/update.json", HttpMethod.POST,
				new HttpEntity<>(complexBuilding), new ParameterizedTypeReference<BaseResponse<ComplexBuilding>>() {
				});
	}

	/**
	 * Method used to delete complexBuilding
	 * 
	 * @param complexBuilding
	 *            complexBuilding to be deleted
	 * @return status
	 */
	public ResponseEntity<BaseResponse<Boolean>> delete(ComplexBuilding complexBuilding) {
		return new RestTemplate().exchange(restURLEndpoint + "/ComplexBuilding/delete.json", HttpMethod.POST,
				new HttpEntity<>(complexBuilding), new ParameterizedTypeReference<BaseResponse<Boolean>>() {
				});
	}

	/**
	 * Method used to get all all building sets
	 * 
	 * @return return all all building sets
	 */
	public ResponseEntity<BaseResponse<ComplexBuilding[]>> getAllBuildingSets() {
		return new RestTemplate().exchange(restURLEndpoint + "/ComplexBuilding/getAllBuildingSets.json", HttpMethod.GET,
				null, new ParameterizedTypeReference<BaseResponse<ComplexBuilding[]>>() {
				});
	}

	/**
	 * Method used to get one building set
	 * 
	 * @return return one building set
	 */
	public ResponseEntity<BaseResponse<ComplexBuilding>> getComplexBuilding(ComplexBuilding complexBuilding) {
		return new RestTemplate().exchange(restURLEndpoint + "/ComplexBuilding/getComplexBuilding.json",
				HttpMethod.POST, new HttpEntity<>(complexBuilding),
				new ParameterizedTypeReference<BaseResponse<ComplexBuilding>>() {
				});
	}
}
