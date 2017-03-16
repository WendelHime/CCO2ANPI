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
	public static final String REST_SERVICE_URI = "http://localhost:8080/Services";

	/**
	 * Method used to send a post to insert complexBuilding
	 * 
	 * @param complexBuilding
	 *            complexBuilding to be inserted
	 * @return return complexBuilding filled
	 */
	public static ResponseEntity<BaseResponse<ComplexBuilding>> insert(ComplexBuilding complexBuilding) {
		return new RestTemplate().exchange(REST_SERVICE_URI + "/ComplexBuilding/insert.json", HttpMethod.POST,
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
	public static ResponseEntity<BaseResponse<ComplexBuilding>> update(ComplexBuilding complexBuilding) {
		return new RestTemplate().exchange(REST_SERVICE_URI + "/ComplexBuilding/update.json", HttpMethod.POST,
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
	public static ResponseEntity<BaseResponse<Boolean>> delete(ComplexBuilding complexBuilding) {
		return new RestTemplate().exchange(REST_SERVICE_URI + "/ComplexBuilding/delete.json", HttpMethod.POST,
				new HttpEntity<>(complexBuilding), new ParameterizedTypeReference<BaseResponse<Boolean>>() {
				});
	}

	/**
	 * Method used to get all all building sets
	 * 
	 * @return return all all building sets
	 */
	public static ResponseEntity<BaseResponse<ComplexBuilding[]>> getAllBuildingSets() {
		return new RestTemplate().exchange(REST_SERVICE_URI + "/ComplexBuilding/getAllBuildingSets.json",
				HttpMethod.GET, null, new ParameterizedTypeReference<BaseResponse<ComplexBuilding[]>>() {
				});
	}

	/**
	 * Method used to get one building set
	 * 
	 * @return return one building set
	 */
	public static ResponseEntity<BaseResponse<ComplexBuilding>> getComplexBuilding(ComplexBuilding complexBuilding) {
		return new RestTemplate().exchange(REST_SERVICE_URI + "/ComplexBuilding/getComplexBuilding.json",
				HttpMethod.POST, new HttpEntity<>(complexBuilding),
				new ParameterizedTypeReference<BaseResponse<ComplexBuilding>>() {
				});
	}
}
