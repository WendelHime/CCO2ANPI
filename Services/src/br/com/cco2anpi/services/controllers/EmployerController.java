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
import br.com.cco2anpi.models.Employer;
import br.com.cco2anpi.models.IEmployer;
import br.com.cco2anpi.models.PagedResponse;
import br.com.cco2anpi.repository.EmployersRepository;
import br.com.cco2anpi.repository.IEmployerRepository;

/**
 * @author wotan
 *
 */
@Controller
@EnableWebMvc
@RequestMapping("Employer/*")
public class EmployerController extends BaseController {

	/**
	 * Method used to get all employer
	 * 
	 * @return all employers
	 */
	@RequestMapping(value = "getAllEmployers", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<PagedResponse<List<IEmployer>>> getAllEmployers(@RequestBody int pageSize,
			@RequestBody int offset) {
		IEmployerRepository employerRepository = new EmployersRepository("hibernate.cfg.xml");
		startTime = System.currentTimeMillis();
		HashMap<String, Object> response = employerRepository.getAllEmployers(offset, pageSize);
		return okResponse((List<IEmployer>) response.get("employers"), "Ok", HttpStatus.OK.value(),
				(Integer) response.get("total"), pageSize, offset);
	}

	/**
	 * Method used to get employer
	 * 
	 * @param employer
	 *            to be used
	 * @return employer
	 */
	@RequestMapping(value = "getEmployer", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse<Employer>> getEmployer(@RequestBody Employer access) {
		EmployersRepository employerRepository = new EmployersRepository("hibernate.cfg.xml");
		startTime = System.currentTimeMillis();
		Employer result = new Employer(employerRepository.getEmployer(access.getId()));
		if (result.getId() != null) {
			return okResponse(result, "Ok", HttpStatus.OK.value());
		}
		return okResponse(result, "Not found", HttpStatus.NOT_FOUND.value());
	}

	/**
	 * Method used to insert employer
	 * 
	 * @param employer
	 *            to be inserted
	 * @return employer inserted
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse<IEmployer>> insert(@RequestBody Employer employer) {
		EmployersRepository employerRepository = new EmployersRepository("hibernate.cfg.xml");
		startTime = System.currentTimeMillis();
		try {
			return okResponse(employerRepository.insert(employer), "Created", HttpStatus.CREATED.value());
		} catch (Exception ex) {
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
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse<IEmployer>> update(@RequestBody Employer employer) {
		EmployersRepository employerRepository = new EmployersRepository("hibernate.cfg.xml");
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
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse<Boolean>> delete(@RequestBody Employer employer) {
		EmployersRepository employerRepository = new EmployersRepository("hibernate.cfg.xml");
		startTime = System.currentTimeMillis();
		return okResponse(employerRepository.delete(employer), "No content", HttpStatus.NO_CONTENT.value());
	}
}
