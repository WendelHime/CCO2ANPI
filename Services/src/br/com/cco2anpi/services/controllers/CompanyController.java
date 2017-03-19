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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.cco2anpi.models.BaseResponse;
import br.com.cco2anpi.models.Company;
import br.com.cco2anpi.models.ICompany;
import br.com.cco2anpi.models.PagedResponse;
import br.com.cco2anpi.repository.CompanyRepository;
import br.com.cco2anpi.repository.ICompanyRepository;

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
	public @ResponseBody ResponseEntity<PagedResponse<List<ICompany>>> getAllCompanies(@RequestBody int pageSize,
			@RequestBody int offset) {
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
	public @ResponseBody ResponseEntity<BaseResponse<Company>> getCompany(@RequestBody Company access) {
		ICompanyRepository companyRepository = new CompanyRepository("hibernate.cfg.xml");
		Company result = new Company(companyRepository.getCompany(access.getId()));
		if (result.getId() != null) {
			return okResponse(result, "Ok", HttpStatus.OK.value());
		}
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
	public @ResponseBody ResponseEntity<BaseResponse<ICompany>> insert(@RequestBody Company company) {
		ICompanyRepository companyRepository = new CompanyRepository("hibernate.cfg.xml");
		try {
			return okResponse(companyRepository.insert(company), "Created", HttpStatus.CREATED.value());
		} catch (Exception ex) {
			return okResponse(companyRepository.insert(company), "Conflict or exception: " + ex.getMessage(),
					HttpStatus.CONFLICT.value());
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
	public @ResponseBody ResponseEntity<BaseResponse<ICompany>> update(@RequestBody Company company) {
		ICompanyRepository companyRepository = new CompanyRepository("hibernate.cfg.xml");
		return okResponse(companyRepository.update(company), "Ok", HttpStatus.OK.value());
	}

	/**
	 * Method used to delete company
	 * 
	 * @param company
	 *            to be deleted
	 * @return status
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse<Boolean>> delete(@RequestBody Company company) {
		ICompanyRepository companyRepository = new CompanyRepository("hibernate.cfg.xml");
		return okResponse(companyRepository.delete(company), "No content", HttpStatus.NO_CONTENT.value());
	}
}
