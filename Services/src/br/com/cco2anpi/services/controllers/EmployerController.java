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

import br.com.cco2anpi.models.Employer;
import br.com.cco2anpi.models.IEmployer;

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
    public @ResponseBody ResponseEntity<Employer[]> getAllEmployers() {
	IEmployer[] employersDB = employerRepository.getAllEmployers();
	Employer[] employers = new Employer[employersDB.length];
	for (int i = 0; i < employers.length; i++) {
	    employers[i] = new Employer(employersDB[i]);
	}
	return new ResponseEntity<Employer[]>(employers, HttpStatus.OK);
    }

    /**
     * Method used to get employer
     * 
     * @param employer
     *            to be used
     * @return employer
     */
    @RequestMapping(value = "getEmployer", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Employer> getEmployer(@RequestBody Employer access) {
	Employer result = new Employer(employerRepository.getEmployer(access.getId()));
	if (result.getId() != null) {
	    return new ResponseEntity<Employer>(result, HttpStatus.OK);
	}
	return new ResponseEntity<Employer>(HttpStatus.NOT_FOUND);
    }

    /**
     * Method used to insert employer
     * 
     * @param employer
     *            to be inserted
     * @return employer inserted
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Employer> insert(@RequestBody Employer employer) {
	try {
	    return new ResponseEntity<Employer>(new Employer(employerRepository.insert(employer)), HttpStatus.CREATED);
	} catch (Exception ex) {
	    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
	    headers.add("exception: ", ex.getMessage());
	    return new ResponseEntity<Employer>(headers, HttpStatus.CONFLICT);
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
    public @ResponseBody ResponseEntity<Employer> update(@RequestBody Employer employer) {
	return new ResponseEntity<Employer>(new Employer(employerRepository.update(employer)), HttpStatus.OK);
    }

    /**
     * Method used to delete employer
     * 
     * @param employer
     *            to be deleted
     * @return status
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Boolean> delete(@RequestBody Employer employer) {
	return new ResponseEntity<Boolean>(employerRepository.delete(employer), new HttpHeaders(),
		HttpStatus.NO_CONTENT);
    }
}
