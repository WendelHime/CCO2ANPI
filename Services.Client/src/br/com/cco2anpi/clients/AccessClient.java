/**
 * 
 */
package br.com.cco2anpi.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.cco2anpi.models.Access;
import br.com.cco2anpi.models.Access;

/**
 * @author wotan
 *
 */
public class AccessClient {
    public static final String REST_SERVICE_URI = "http://localhost:8080/Services";

    /**
     * Method used to send a post to insert access
     * 
     * @param access
     *            access to be inserted
     * @return return access filled
     */
    public static ResponseEntity<Access> insert(Access access) {
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/Access/insert.json", access,
			Access.class);
    }

    /**
     * Method used to update data
     * 
     * @param access
     *            access to be updated
     * @return access updated
     */
    public static ResponseEntity<Access> update(Access access) {
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/Access/update.json", access,
		Access.class);
    }

    /**
     * Method used to delete access
     * 
     * @param access
     *            access to be deleted
     * @return status
     */
    public static ResponseEntity<Boolean> delete(Access access) {
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/Access/delete.json", access,
		Boolean.class);
    }

    /**
     * Method used to get all all building sets
     * 
     * @return return all all building sets
     */
    public static ResponseEntity<Access[]> getAllAccess() {
	return new RestTemplate().getForEntity(REST_SERVICE_URI + "/Access/getAllAccess.json",
		Access[].class);
    }
    /**
     * Method used to get one building set
     * 
     * @return return one building set
     */
    public static ResponseEntity<Access> getAccess(Access access) {
	return new RestTemplate().getForEntity(REST_SERVICE_URI + "/Access/getAccess.json",
		Access.class);
    }
}
