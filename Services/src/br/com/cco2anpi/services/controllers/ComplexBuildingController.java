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
import br.com.cco2anpi.models.ComplexBuilding;
import br.com.cco2anpi.models.IComplexBuilding;
import br.com.cco2anpi.models.PagedResponse;
import br.com.cco2anpi.repository.ComplexBuildingRepository;
import br.com.cco2anpi.repository.IComplexBuildingRepository;

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
	public @ResponseBody ResponseEntity<PagedResponse<List<IComplexBuilding>>> getAllBuildingSets(
			@RequestBody int pageSize, @RequestBody int offset) {
		IComplexBuildingRepository complexBuildingRepository = new ComplexBuildingRepository("hibernate.cfg.xml");
		startTime = System.currentTimeMillis();
		HashMap<String, Object> response = complexBuildingRepository.getAllBuildingSets(pageSize, offset);
		return okResponse((List<IComplexBuilding>) response.get("buildingSets"), "Ok", HttpStatus.OK.value(),
				(Integer) response.get("total"), pageSize, offset);
	}

	/**
	 * Method used to get complex building by id
	 * 
	 * @param complexBuilding
	 *            to be used
	 * @return complex building searched
	 */
	@RequestMapping(value = "getComplexBuilding", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse<ComplexBuilding>> getComplexBuilding(
			@RequestBody ComplexBuilding complexBuilding) {
		IComplexBuildingRepository complexBuildingRepository = new ComplexBuildingRepository("hibernate.cfg.xml");
		startTime = System.currentTimeMillis();
		ComplexBuilding result = new ComplexBuilding(complexBuildingRepository.getComplexBuilding(complexBuilding));
		if (result.getId() != null) {
			return okResponse(result, "Ok", HttpStatus.OK.value());
		}
		return okResponse(new ComplexBuilding(), "Not found", HttpStatus.NOT_FOUND.value());
	}

	/**
	 * Method used to insert complex building
	 * 
	 * @param complexBuilding
	 *            to be inserted
	 * @return complexBuilding inserted
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse<IComplexBuilding>> insert(
			@RequestBody ComplexBuilding complexBuilding) {
		IComplexBuildingRepository complexBuildingRepository = new ComplexBuildingRepository("hibernate.cfg.xml");
		startTime = System.currentTimeMillis();
		try {
			return okResponse(complexBuildingRepository.insert(complexBuilding), "Created", HttpStatus.CREATED.value());
		} catch (Exception ex) {
			return okResponse(new ComplexBuilding(), "Conflict or error: " + ex.getMessage(),
					HttpStatus.CONFLICT.value());
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
	public @ResponseBody ResponseEntity<BaseResponse<IComplexBuilding>> update(
			@RequestBody ComplexBuilding complexBuilding) {
		IComplexBuildingRepository complexBuildingRepository = new ComplexBuildingRepository("hibernate.cfg.xml");
		startTime = System.currentTimeMillis();
		return okResponse(complexBuildingRepository.update(complexBuilding), "Ok", HttpStatus.OK.value());
	}

	/**
	 * Method used to delete complex building
	 * 
	 * @param complexBuilding
	 *            to be deleted
	 * @return status
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse<Boolean>> delete(@RequestBody ComplexBuilding complexBuilding) {
		IComplexBuildingRepository complexBuildingRepository = new ComplexBuildingRepository("hibernate.cfg.xml");
		startTime = System.currentTimeMillis();
		return okResponse(complexBuildingRepository.delete(complexBuilding), "No content",
				HttpStatus.NO_CONTENT.value());
	}
}
