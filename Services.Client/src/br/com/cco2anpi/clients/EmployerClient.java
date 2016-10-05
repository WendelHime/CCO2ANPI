/**
 * 
 */
package br.com.cco2anpi.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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
    public static ResponseEntity<Employer> insert(Employer employer) {
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/Employer/insert.json", employer, Employer.class);
    }

    /**
     * Method used to update data
     * 
     * @param employer
     *            employer to be updated
     * @return employer updated
     */
    public static ResponseEntity<Employer> update(Employer employer) {
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/Employer/update.json", employer, Employer.class);
    }

    /**
     * Method used to delete employer
     * 
     * @param employer
     *            employer to be deleted
     * @return status
     */
    public static ResponseEntity<Boolean> delete(Employer employer) {
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/Employer/delete.json", employer, Boolean.class);
    }

    /**
     * Method used to get all employers
     * 
     * @return return all employers
     */
    public static ResponseEntity<Employer[]> getAllEmployers() {
	return new RestTemplate().getForEntity(REST_SERVICE_URI + "/Employer/getAllEmployers.json", Employer[].class);
    }
}
