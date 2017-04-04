/**
 * 
 */
package br.com.cco2anpi.clients;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cco2anpi.models.BaseResponse;
import br.com.cco2anpi.models.Company;
import br.com.cco2anpi.models.Employer;
import br.com.cco2anpi.models.PagedResponse;

/**
 * @author wotan Class used to make connection with company the services
 */
public class CompanyClient
{

    private String restURLEndpoint;

    /**
     * Constructor client
     * 
     * @param restURLEndpoint
     *            URL of the service
     */
    public CompanyClient(String restURLEndpoint)
    {
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
    public ResponseEntity<BaseResponse<Company>> insert(Company company, int typeUser)
    {
	return new RestTemplate().exchange(restURLEndpoint + "/Company/insert.json?typeUser=" + typeUser,
		HttpMethod.POST, new HttpEntity<>(company), new ParameterizedTypeReference<BaseResponse<Company>>()
		{
		});
    }

    /**
     * Method used to update data
     * 
     * @param company
     *            company to be updated
     * @return company updated
     */
    public ResponseEntity<BaseResponse<Company>> update(Company company)
    {
	return new RestTemplate().exchange(restURLEndpoint + "/Company/update.json", HttpMethod.POST,
		new HttpEntity<>(company), new ParameterizedTypeReference<BaseResponse<Company>>()
		{
		});
    }

    /**
     * Method used to delete company
     * 
     * @param company
     *            company to be deleted
     * @return status
     */
    public ResponseEntity<BaseResponse<Boolean>> delete(Company company)
    {
	return new RestTemplate().exchange(restURLEndpoint + "/Company/delete.json", HttpMethod.POST,
		new HttpEntity<>(company), new ParameterizedTypeReference<BaseResponse<Boolean>>()
		{
		});
    }

    /**
     * Method used to get all companys
     * 
     * @return return all companys
     */
    public ResponseEntity<PagedResponse<Company[]>> getAllCompanies(int pageSize, int offset)
    {
	MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
	params.add("pageSize", "" + pageSize);
	params.add("offset", "" + offset);
	UriComponents uriComponents = UriComponentsBuilder
		.fromHttpUrl(restURLEndpoint + "/Company/getAllCompanies.json").queryParams(params).build();
	return new RestTemplate().exchange(uriComponents.toUriString(), HttpMethod.GET, null,
		new ParameterizedTypeReference<PagedResponse<Company[]>>()
		{
		});
    }

    /**
     * Method used to get all companys
     * 
     * @return return all companys
     */
    public ResponseEntity<BaseResponse<Company>> getCompany(Company company)
    {
	return new RestTemplate().exchange(restURLEndpoint + "/Company/getCompany.json", HttpMethod.POST,
		new HttpEntity<>(company), new ParameterizedTypeReference<BaseResponse<Company>>()
		{
		});
    }

    /**
     * Method used to send a post to insert employer
     * 
     * @param employer
     *            employer to be inserted
     * @return return employer filled
     */
    public ResponseEntity<BaseResponse<Employer>> insertEmployer(Employer employer)
    {
	return new RestTemplate().exchange(restURLEndpoint + "/Company/insertEmployer.json", HttpMethod.POST,
		new HttpEntity<>(employer), new ParameterizedTypeReference<BaseResponse<Employer>>()
		{
		});
    }

    /**
     * Method used to update data
     * 
     * @param employer
     *            employer to be updated
     * @return employer updated
     */
    public ResponseEntity<BaseResponse<Employer>> updateEmployer(Employer employer)
    {
	return new RestTemplate().exchange(restURLEndpoint + "/Company/updateEmployer.json", HttpMethod.POST,
		new HttpEntity<>(employer), new ParameterizedTypeReference<BaseResponse<Employer>>()
		{
		});
    }

    /**
     * Method used to delete employer
     * 
     * @param employer
     *            employer to be deleted
     * @return status
     */
    public ResponseEntity<BaseResponse<Boolean>> deleteEmployer(Employer employer)
    {
	return new RestTemplate().exchange(restURLEndpoint + "/Company/deleteEmployer.json", HttpMethod.POST,
		new HttpEntity<>(employer), new ParameterizedTypeReference<BaseResponse<Boolean>>()
		{
		});
    }

    /**
     * Method used to insert set
     * 
     * @param set
     *            to be inserted
     * @return set inserted
     */
    public ResponseEntity<BaseResponse<br.com.cco2anpi.models.Set>> insertSet(br.com.cco2anpi.models.Set set)
    {
	return new RestTemplate().exchange(restURLEndpoint + "/Company/insertSet.json", HttpMethod.POST,
		new HttpEntity<>(set), new ParameterizedTypeReference<BaseResponse<br.com.cco2anpi.models.Set>>()
		{
		});
    }

    /**
     * Method used to update data
     * 
     * @param set
     *            set to be updated
     * @return set updated
     */
    public ResponseEntity<BaseResponse<br.com.cco2anpi.models.Set>> updateSet(br.com.cco2anpi.models.Set set)
    {
	return new RestTemplate().exchange(restURLEndpoint + "/Company/updateSet.json", HttpMethod.POST,
		new HttpEntity<>(set), new ParameterizedTypeReference<BaseResponse<br.com.cco2anpi.models.Set>>()
		{
		});
    }

    /**
     * Method used to delete employer
     * 
     * @param set
     *            set to be deleted
     * @return status
     */
    public ResponseEntity<BaseResponse<Boolean>> deleteSet(br.com.cco2anpi.models.Set set)
    {
	return new RestTemplate().exchange(restURLEndpoint + "/Company/deleteSet.json", HttpMethod.POST,
		new HttpEntity<>(set), new ParameterizedTypeReference<BaseResponse<Boolean>>()
		{
		});
    }

}
