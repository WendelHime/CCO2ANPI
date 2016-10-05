/**
 * 
 */
package br.com.cco2anpi.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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
    public static ResponseEntity<ComplexBuilding> insert(ComplexBuilding complexBuilding) {
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/ComplexBuilding/insert.json", complexBuilding,
		ComplexBuilding.class);
    }

    /**
     * Method used to update data
     * 
     * @param complexBuilding
     *            complexBuilding to be updated
     * @return complexBuilding updated
     */
    public static ResponseEntity<ComplexBuilding> update(ComplexBuilding complexBuilding) {
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/ComplexBuilding/update.json", complexBuilding,
		ComplexBuilding.class);
    }

    /**
     * Method used to delete complexBuilding
     * 
     * @param complexBuilding
     *            complexBuilding to be deleted
     * @return status
     */
    public static ResponseEntity<Boolean> delete(ComplexBuilding complexBuilding) {
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/ComplexBuilding/delete.json", complexBuilding,
		Boolean.class);
    }

    /**
     * Method used to get all all building sets
     * 
     * @return return all all building sets
     */
    public static ResponseEntity<ComplexBuilding[]> getAllBuildingSets() {
	return new RestTemplate().getForEntity(REST_SERVICE_URI + "/ComplexBuilding/getAllBuildingSets.json",
		ComplexBuilding[].class);
    }
}
