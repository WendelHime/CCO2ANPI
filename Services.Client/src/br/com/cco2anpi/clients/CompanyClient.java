/**
 * 
 */
package br.com.cco2anpi.clients;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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
//    @Test
    public static ResponseEntity<BaseResponse<Company>> insert(Company company) {
//	Company company = new Company();
//	company.setCnpj("000000");
//	company.setSocialReason("teste");
//	ComplexBuilding complexBuilding = new ComplexBuilding();
//	complexBuilding.setNumber("1");
//	company.setComplexBuilding(ComplexBuildingClient.getComplexBuilding(complexBuilding).getBody());
//	company.setBusinessHours("" + "-" + "");
//	company.setMaximumTemperature(20.05);
//	company.setAirConditionerHours("" + "-" + "");
//	company.setEmployers(new HashSet<>(0));
//	assertEquals(Company.class, new RestTemplate()
//		.postForEntity(REST_SERVICE_URI + "/Company/insert.json", company, Company.class).getBody().getClass());

	return new RestTemplate().exchange(REST_SERVICE_URI + "/Company/insert.json", HttpMethod.POST, new HttpEntity<>(company),
		new ParameterizedTypeReference<BaseResponse<Company>>() {
		});
    }

    /**
     * Method used to update data
     * 
     * @param company
     *            company to be updated
     * @return company updated
     */
    public static ResponseEntity<BaseResponse<Company>> update(Company company) {
	return new RestTemplate().exchange(REST_SERVICE_URI + "/Company/update.json", HttpMethod.POST, new HttpEntity<>(company),
			new ParameterizedTypeReference<BaseResponse<Company>>() {
			});
    }
    /**
     * Method used to delete company
     * 
     * @param company
     *            company to be deleted
     * @return status
     */
    public static ResponseEntity<BaseResponse<Boolean>> delete(User user) {
	return new RestTemplate().exchange(REST_SERVICE_URI + "/Company/delete.json", HttpMethod.POST, new HttpEntity<>(company),
			new ParameterizedTypeReference<BaseResponse<Boolean>>() {
				});
    }

    /**
     * Method used to get all companys
     * 
     * @return return all companys
     */
    public static ResponseEntity<BaseResponse<Company[]>> getAllCompanies() {
		return new RestTemplate().exchange(REST_SERVICE_URI + "/Company/getAllUsers.json", HttpMethod.GET, null,
				new ParameterizedTypeReference<BaseResponse<Company[]>>() {
				});
	}
    /**
     * Method used to get all companys
     * 
     * @return return all companys
     */
    public static ResponseEntity<BaseResponse<Company>> getUser(Company company) {
	return new RestTemplate().exchange(REST_SERVICE_URI + "/Company/getUser.json", HttpMethod.POST,
		new HttpEntity<>(company), new ParameterizedTypeReference<BaseResponse<Company>>() {
		});
    }
}
