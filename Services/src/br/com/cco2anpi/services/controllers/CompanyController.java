/**
 * 
 */
package br.com.cco2anpi.services.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.cco2anpi.models.Company;
import br.com.cco2anpi.models.ICompany;

/**
 * @author wotan
 *
 */
@Controller
@EnableWebMvc
@RequestMapping("Company/*")
public class CompanyController extends BaseController {

    /**
     * Method used to get all company
     * 
     * @return all companies
     */
    @RequestMapping(value = "getAllCompanies", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Company[]> getAllCompanies() {
	ICompany[] companiesDB = companyRepository.getAllCompanies();
	Company[] companies = new Company[companiesDB.length];
	for (int i = 0; i < companies.length; i++) {
	    companies[i] = new Company(companiesDB[i]);
	}
	return new ResponseEntity<Company[]>(companies, HttpStatus.OK);
    }

    /**
     * Method used to get company
     * 
     * @param company
     *            to be used
     * @return company
     */
    @RequestMapping(value = "getCompany", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Company> getCompany(@RequestBody Company access) {
	Company result = new Company(companyRepository.getCompany(access.getId()));
	if (result.getId() != null) {
	    return new ResponseEntity<Company>(result, HttpStatus.OK);
	}
	return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
    }

    /**
     * Method used to insert company
     * 
     * @param company
     *            to be inserted
     * @return company inserted
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Company> insert(@RequestBody Company company) {
	try {
	    return new ResponseEntity<Company>(new Company(companyRepository.insert(company)), HttpStatus.CREATED);
	} catch (Exception ex) {
	    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
	    headers.add("exception: ", ex.getMessage());
	    return new ResponseEntity<Company>(headers, HttpStatus.CONFLICT);
	}
    }

    /**
     * Method used to update company
     * 
     * @param company
     *            to be updated
     * @return company updated
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Company> update(@RequestBody Company company) {
	return new ResponseEntity<Company>(new Company(companyRepository.update(company)), HttpStatus.OK);
    }

    /**
     * Method used to delete company
     * 
     * @param company
     *            to be deleted
     * @return status
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Boolean> delete(@RequestBody Company company) {
	return new ResponseEntity<Boolean>(companyRepository.delete(company), new HttpHeaders(), HttpStatus.NO_CONTENT);
    }
}
