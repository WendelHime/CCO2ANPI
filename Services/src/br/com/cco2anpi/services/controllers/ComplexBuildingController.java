/**
 * 
 */
package br.com.cco2anpi.services.controllers;

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

import br.com.cco2anpi.models.ComplexBuilding;
import br.com.cco2anpi.models.IComplexBuilding;

/**
 * @author wotan
 *
 */
@Controller
@EnableWebMvc
@RequestMapping("ComplexBuilding/*")
public class ComplexBuildingController extends BaseController {

    /**
     * Method used to get all building sets
     * 
     * @return all building sets array
     */
    @RequestMapping(value = "getAllBuildingSets", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<ComplexBuilding[]> getAllBuildingSets() {
	IComplexBuilding[] buildingSetsDB = complexBuildingRepository.getAllBuildingSets();
	ComplexBuilding[] buildingSets = new ComplexBuilding[buildingSetsDB.length];
	for (int i = 0; i < buildingSets.length; i++) {
	    buildingSets[i] = new ComplexBuilding(buildingSetsDB[i]);
	}
	return new ResponseEntity<ComplexBuilding[]>(buildingSets, HttpStatus.OK);
    }

    /**
     * Method used to get complex building by id
     * 
     * @param complexBuilding
     *            to be used
     * @return complex building searched
     */
    @RequestMapping(value = "getComplexBuilding", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<ComplexBuilding> getComplexBuilding(
	    @RequestBody ComplexBuilding complexBuilding) {
	ComplexBuilding result = new ComplexBuilding(
		complexBuildingRepository.getComplexBuilding(complexBuilding));
	if (result.getId() != null) {
	    return new ResponseEntity<ComplexBuilding>(result, HttpStatus.OK);
	}
	return new ResponseEntity<ComplexBuilding>(HttpStatus.NOT_FOUND);
    }

    /**
     * Method used to insert complex building
     * 
     * @param complexBuilding
     *            to be inserted
     * @return complexBuilding inserted
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<ComplexBuilding> insert(@RequestBody ComplexBuilding complexBuilding) {
	try {
	    return new ResponseEntity<ComplexBuilding>(
		    new ComplexBuilding(complexBuildingRepository.insert(complexBuilding)), HttpStatus.CREATED);
	} catch (Exception ex) {
	    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
	    headers.add("exception: ", ex.getMessage());
	    return new ResponseEntity<ComplexBuilding>(headers, HttpStatus.CONFLICT);
	}
    }

    /**
     * Method used to update complex building
     * 
     * @param complexBuilding
     *            to be updated
     * @return complexBuilding updated
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<ComplexBuilding> update(@RequestBody ComplexBuilding complexBuilding) {
	return new ResponseEntity<ComplexBuilding>(
		new ComplexBuilding(complexBuildingRepository.update(complexBuilding)), HttpStatus.OK);
    }

    /**
     * Method used to delete complex building
     * 
     * @param complexBuilding
     *            to be deleted
     * @return status
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Boolean> delete(@RequestBody ComplexBuilding complexBuilding) {
	return new ResponseEntity<Boolean>(complexBuildingRepository.delete(complexBuilding), HttpStatus.NO_CONTENT);
    }
}
