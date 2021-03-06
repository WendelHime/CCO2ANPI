/**
 * 
 */
package br.com.cco2anpi.services.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.cco2anpi.models.BaseResponse;
import br.com.cco2anpi.models.Company;
import br.com.cco2anpi.models.Employer;
import br.com.cco2anpi.models.ICompany;
import br.com.cco2anpi.models.IEmployer;
import br.com.cco2anpi.models.ISet;
import br.com.cco2anpi.models.PagedResponse;
import br.com.cco2anpi.models.TypeEnum;
import br.com.cco2anpi.repository.CompanyRepository;
import br.com.cco2anpi.repository.EmployersRepository;
import br.com.cco2anpi.repository.ICompanyRepository;
import br.com.cco2anpi.repository.IEmployerRepository;
import br.com.cco2anpi.repository.ISetRepository;
import br.com.cco2anpi.repository.SetRepository;

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
     * Method used to get all company
     * 
     * @return all companies
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "getAllCompanies", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<PagedResponse<List<ICompany>>> getAllCompanies(
	    @RequestParam("pageSize") int pageSize, @RequestParam("offset") int offset)
    {
	ICompanyRepository companyRepository = new CompanyRepository("hibernate.cfg.xml");
	HashMap<String, Object> response = companyRepository.getAllCompanies(pageSize, offset);
	return okResponse((List<ICompany>) response.get("companies"), "Ok", HttpStatus.OK.value(),
		(Integer) response.get("total"), pageSize, offset);
    }

    /**
     * Method used to get company
     * 
     * @param company
     *            to be used
     * @return company
     */
    @RequestMapping(value = "getCompany", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<BaseResponse<Company>> getCompany(@RequestBody Company access)
    {
	ICompanyRepository companyRepository = new CompanyRepository("hibernate.cfg.xml");
	Company result = new Company(companyRepository.getCompany(access.getId()));
	if (result.getId() != null) { return okResponse(result, "Ok", HttpStatus.OK.value()); }
	return okResponse(new Company(), "Not found", HttpStatus.NOT_FOUND.value());
    }

    /**
     * Method used to insert company
     * 
     * @param company
     *            to be inserted
     * @return company inserted
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<BaseResponse<ICompany>> insert(@RequestBody Company company,
	    @RequestParam("typeUser") int typeUser)
    {
	ICompanyRepository companyRepository = new CompanyRepository("hibernate.cfg.xml");
	try
	{
	    TypeEnum typeUsr = TypeEnum.getValue(typeUser);
	    if (typeUsr == TypeEnum.CLERK
		    || typeUsr == TypeEnum.SYNDIC) { return okResponse(companyRepository.insert(company), "Created",
			    HttpStatus.CREATED.value()); }
	}
	catch (Exception ex)
	{

	}
	return okResponse(new Company(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
		HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    /**
     * Method used to update company
     * 
     * @param company
     *            to be updated
     * @return company updated
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<BaseResponse<ICompany>> update(@RequestBody Company company)
    {
	ICompanyRepository companyRepository = new CompanyRepository("hibernate.cfg.xml");
	return okResponse(companyRepository.update(company), HttpStatus.ACCEPTED.getReasonPhrase(), HttpStatus.ACCEPTED.value());
    }

    /**
     * Method used to delete company
     * 
     * @param company
     *            to be deleted
     * @return status
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<BaseResponse<Boolean>> delete(@RequestBody Company company)
    {
	ICompanyRepository companyRepository = new CompanyRepository("hibernate.cfg.xml");
	return okResponse(companyRepository.delete(company), "No content", HttpStatus.NO_CONTENT.value());
    }

    /**
     * Method used to insert employer
     * 
     * @param employer
     *            to be inserted
     * @return employer inserted
     */
    @RequestMapping(value = "insertEmployer", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<BaseResponse<IEmployer>> insert(@RequestBody Employer employer)
    {
	IEmployerRepository employerRepository = new EmployersRepository("hibernate.cfg.xml");
	startTime = System.currentTimeMillis();
	try
	{
	    return okResponse(employerRepository.insert(employer), "Created", HttpStatus.CREATED.value());
	}
	catch (Exception ex)
	{
	    // TODO: Criar logger em Tools
	    return okResponse(new Employer(), "Conflict or error: " + ex.getMessage(), HttpStatus.CONFLICT.value());
	}
    }

    /**
     * Method used to update employer
     * 
     * @param employer
     *            to be updated
     * @return employer updated
     */
    @RequestMapping(value = "updateEmployer", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<BaseResponse<IEmployer>> update(@RequestBody Employer employer)
    {
	IEmployerRepository employerRepository = new EmployersRepository("hibernate.cfg.xml");
	startTime = System.currentTimeMillis();
	return okResponse(employerRepository.update(employer), "Accepted", HttpStatus.ACCEPTED.value());
    }

    /**
     * Method used to delete employer
     * 
     * @param employer
     *            to be deleted
     * @return status
     */
    @RequestMapping(value = "deleteEmployer", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<BaseResponse<Boolean>> delete(@RequestBody Employer employer)
    {
	IEmployerRepository employerRepository = new EmployersRepository("hibernate.cfg.xml");
	startTime = System.currentTimeMillis();
	return okResponse(employerRepository.delete(employer), "No content", HttpStatus.NO_CONTENT.value());
    }

    /**
     * Method used to insert Set
     * 
     * @param set
     * @return inserted set
     */
    @RequestMapping(value = "insertSet", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<BaseResponse<ISet>> insert(@RequestBody br.com.cco2anpi.models.Set set)
    {
	ISetRepository setRepository = new SetRepository("hibernate.cfg.xml");
	startTime = System.currentTimeMillis();
	try
	{
	    return okResponse(setRepository.insert(set), "Created", HttpStatus.CREATED.value());
	}
	catch (Exception ex)
	{
	    // TODO: Criar logger em Tools
	    return okResponse(new br.com.cco2anpi.models.Set(), "Conflict or error: " + ex.getMessage(),
		    HttpStatus.CONFLICT.value());
	}
    }

    /**
     * Method used to update employer
     * 
     * @param set
     *            to be updated
     * @return set updated
     */
    @RequestMapping(value = "updateSet", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<BaseResponse<ISet>> update(@RequestBody br.com.cco2anpi.models.Set set)
    {
	ISetRepository setRepository = new SetRepository("hibernate.cfg.xml");
	startTime = System.currentTimeMillis();
	return okResponse(setRepository.update(set), "Accepted", HttpStatus.ACCEPTED.value());
    }

    /**
     * Method used to delete employer
     * 
     * @param set
     *            to be deleted
     * @return status
     */
    @RequestMapping(value = "deleteSet", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<BaseResponse<Boolean>> delete(@RequestBody br.com.cco2anpi.models.Set set)
    {
	ISetRepository setRepository = new SetRepository("hibernate.cfg.xml");
	startTime = System.currentTimeMillis();
	return okResponse(setRepository.delete(set), "No content", HttpStatus.NO_CONTENT.value());
    }

}
