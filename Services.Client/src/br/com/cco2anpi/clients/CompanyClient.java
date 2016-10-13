/**
 * 
 */
package br.com.cco2anpi.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.cco2anpi.models.Company;

/**
 * @author wotan Class used to make connection with company the services
 */
public class CompanyClient {
    public static final String REST_SERVICE_URI = "http://localhost:8080/Services";

    /**
     * Method used to send a post to insert company
     * 
     * @param company
     *            company to be inserted
     * @return return company filled
     */
    public static ResponseEntity<Company> insert(Company company) {
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/Company/insert.json", company, Company.class);
    }

    /**
     * Method used to update data
     * 
     * @param company
     *            company to be updated
     * @return company updated
     */
    public static ResponseEntity<Company> update(Company company) {
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/Company/update.json", company, Company.class);
    }

    /**
     * Method used to delete company
     * 
     * @param company
     *            company to be deleted
     * @return status
     */
    public static ResponseEntity<Boolean> delete(Company company) {
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/Company/delete.json", company, Boolean.class);
    }

    /**
     * Method used to get all companys
     * 
     * @return return all companys
     */
    public static ResponseEntity<Company[]> getAllCompanies() {
	return new RestTemplate().getForEntity(REST_SERVICE_URI + "/Company/getAllCompanies.json", Company[].class);
    }
    /**
     * Method used to get all companys
     * 
     * @return return all companys
     */
    public static ResponseEntity<Company> getCompany(Company company) {
	return new RestTemplate().getForEntity(REST_SERVICE_URI + "/Company/getCompany.json", Company.class);
    }
}
