/**
 * 
 */
package br.com.cco2anpi.systemBuildingControl.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.cco2anpi.models.BaseResponse;
import br.com.cco2anpi.models.Company;
import br.com.cco2anpi.models.PagedResponse;

/**
 * @author wotan
 *
 */
@Controller
@EnableWebMvc
@RequestMapping("Company/*")
public class CompanyController extends BaseController
{

    /**
     * Method used to standard page User
     * 
     * @return view index
     */
    @RequestMapping("/")
    public ModelAndView index()
    {
	return new ModelAndView("/Companies/index");
    }

    /**
     * Method used to insert company
     * 
     * @param cnpj
     *            cnpj of the company
     * @param socialReason
     *            social reason
     * @param businessHours
     *            business hours
     * @param maximumTemperature
     *            maximum temperature
     * @param airconditionerHours
     *            air conditioner hours
     * @return object company
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<Company>> insert(@RequestParam("cnpj") String cnpj,
	    @RequestParam("socialReason") String socialReason, @RequestParam("businessHours") String businessHours,
	    @RequestParam("maximumTemperature") Double maximumTemperature,
	    @RequestParam("airconditionerHours") String airconditionerHours)
    {
	Company company = new Company();
	company.setCnpj(cnpj);
	company.setSocialReason(socialReason);
	company.setBusinessHours(businessHours);
	company.setMaximumTemperature(maximumTemperature);
	company.setAirConditionerHours(airconditionerHours);
	BaseResponse<Company> baseResponse = companyClient.insert(company, 1).getBody();
	return okResponse(baseResponse.getResponse(), baseResponse.getMessage(), baseResponse.getStatusCode());
    }

    /**
     * Method used to update company
     * 
     * @param company
     *            company to be changed
     * @return company changed
     */
    @RequestMapping(value = "update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<Company>> update(@RequestBody Company company)
    {
	BaseResponse<Company> baseResponse = companyClient.update(company).getBody();
	return okResponse(baseResponse.getResponse(), baseResponse.getMessage(), baseResponse.getStatusCode());
    }

    /**
     * Method used to delete company
     * 
     * @param company
     *            company to be deleted
     * @return boolean response
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<Boolean>> delete(@RequestBody Company company)
    {
	BaseResponse<Boolean> baseResponse = companyClient.delete(company).getBody();
	return okResponse(baseResponse.getResponse(), baseResponse.getMessage(), baseResponse.getStatusCode());
    }

    /**
     * Method used to get companies
     * 
     * @param pageSize
     *            limit of the query
     * @param offset
     *            offset
     * @return list of companies
     */
    @Transactional(readOnly = true)
    @RequestMapping(value = "getCompanies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<PagedResponse<List<Company>>> getCompanies(
	    @RequestParam("pageSize") int pageSize, @RequestParam("offset") int offset)
    {
	try
	{
	    PagedResponse<Company[]> response = companyClient.getAllCompanies(pageSize, offset).getBody();
	    return okResponse(Arrays.asList(response.getResponse()), response.getMessage(), response.getStatusCode(),
		    response.getTotal(), response.getPageSize(), response.getOffset());
	}
	catch (Exception ex)
	{
	    // TODO Auto-generated catch block
	    ex.printStackTrace();
	}
	return okResponse(new ArrayList<Company>(), "Not found", HttpStatus.NOT_FOUND.value(), 0, 0, 0);
    }

    /**
     * Method used to get company
     * 
     * @param id
     *            id of the user
     * @return object user if exists
     */
    @Transactional(readOnly = true)
    @RequestMapping(value = "getCompany", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<BaseResponse<Company>> getUser(@RequestParam("id") int id)
    {
	try
	{
	    Company company = new Company();
	    company.setId(id);
	    BaseResponse<Company> response = companyClient.getCompany(company).getBody();
	    return okResponse(response.getResponse(), response.getMessage(), response.getStatusCode());
	}
	catch (Exception ex)
	{
	    // TODO Auto-generated catch block
	    ex.printStackTrace();
	}
	return okResponse(new Company(), "Not found", HttpStatus.NOT_FOUND.value());
    }

}
