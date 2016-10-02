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

import br.com.cco2anpi.models.Access;
import br.com.cco2anpi.models.IAccess;

/**
 * @author wotan
 *
 */
@Controller
@EnableWebMvc
@RequestMapping("Access/*")
public class AccessController extends BaseController {

    /**
     * Method used to get all access
     * 
     * @return all access
     */
    @RequestMapping(value = "getAllAccess", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Access[]> getAllAccess() {
	IAccess[] accessDB = accessRepository.getAllAccess();
	Access[] access = new Access[accessDB.length];
	for (int i = 0; i < access.length; i++) {
	    access[i] = new Access(accessDB[i]);
	}
	return new ResponseEntity<Access[]>(access, HttpStatus.OK);
    }

    /**
     * Method used to get access
     * 
     * @param access
     *            to be used
     * @return access
     */
    @RequestMapping(value = "getAccess", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Access> getAccess(@RequestBody Access access) {
	Access result = new Access(accessRepository.getAccess(access.getId()));
	if (result.getId() != null) {
	    return new ResponseEntity<Access>(result, HttpStatus.OK);
	}
	return new ResponseEntity<Access>(HttpStatus.NOT_FOUND);
    }

    /**
     * Method used to insert access
     * 
     * @param access
     *            to be inserted
     * @return access inserted
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Access> insert(@RequestBody Access access) {
	try {
	    return new ResponseEntity<Access>(new Access(accessRepository.insert(access)), HttpStatus.CREATED);
	} catch (Exception ex) {
	    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
	    headers.add("exception: ", ex.getMessage());
	    return new ResponseEntity<Access>(headers, HttpStatus.CONFLICT);
	}
    }

    /**
     * Method used to update access
     * 
     * @param access
     *            to be updated
     * @return access updated
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Access> update(@RequestBody Access access) {
	return new ResponseEntity<Access>(new Access(accessRepository.update(access)), HttpStatus.OK);
    }

    /**
     * Method used to delete access
     * 
     * @param access
     *            to be deleted
     * @return status
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Boolean> delete(@RequestBody Access access) {
	return new ResponseEntity<Boolean>(accessRepository.delete(access), new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

}
