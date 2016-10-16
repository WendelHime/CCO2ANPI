/**
 * 
 */
package br.com.cco2anpi.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

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
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/Access/insert.json", access, Access.class);
    }

    /**
     * Method used to update data
     * 
     * @param access
     *            access to be updated
     * @return access updated
     */
    public static ResponseEntity<Access> update(Access access) {
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/Access/update.json", access, Access.class);
    }

    /**
     * Method used to delete access
     * 
     * @param access
     *            access to be deleted
     * @return status
     */
    public static ResponseEntity<Boolean> delete(Access access) {
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/Access/delete.json", access, Boolean.class);
    }

    /**
     * Method used to get all access
     * 
     * @return return all access
     */
    public static ResponseEntity<Access[]> getAllAccess() {
	return new RestTemplate().getForEntity(REST_SERVICE_URI + "/Access/getAllAccess.json", Access[].class);
    }

    /**
     * Method used to get one access
     * 
     * @return return one access
     */
    public static ResponseEntity<Access> getAccess(Access access) {
	return new RestTemplate().getForEntity(REST_SERVICE_URI + "/Access/getAccess.json", Access.class);
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
    public static ResponseEntity<Access[]> getAccessByTypeAndDate(Integer type, String dateInit, String dateEnd) {
	MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
	map.add("parameters", type.toString());
	map.add("parameters", dateInit);
	map.add("parameters", dateEnd);

	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/Access/getAccessByTypeAndDate.json", map,
		Access[].class);
    }
}
