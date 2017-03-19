/**
 * 
 */
package br.com.cco2anpi.services.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.cco2anpi.models.Access;
import br.com.cco2anpi.models.BaseResponse;
import br.com.cco2anpi.models.IAccess;
import br.com.cco2anpi.models.PagedResponse;
import br.com.cco2anpi.repository.AccessRepository;
import br.com.cco2anpi.repository.IAccessRepository;

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
	public @ResponseBody ResponseEntity<PagedResponse<List<IAccess>>> getAllAccess(@RequestBody int pageSize,
			@RequestBody int offset) {
		IAccessRepository accessRepository = new AccessRepository("hibernate.cfg.xml");
		HashMap<String, Object> returned = accessRepository.getAllAccess(pageSize, offset);
		return okResponse((List<IAccess>) returned.get("access"), "Ok", HttpStatus.OK.value(),
				(int) returned.get("total"), pageSize, offset);
	}

	/**
	 * Method used to get access filtred
	 * 
	 * @param type
	 *            of the user
	 * @param dateInit
	 *            find access between date init and dateEnd
	 * @param dateEnd
	 *            find access between date init and dateEnd
	 * @return access array
	 */
	@RequestMapping(value = "getAccessByTypeAndDate", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<PagedResponse<List<IAccess>>> getAccessByTypeAndDate(
			@RequestBody MultiValueMap<String, String> map) {
		IAccessRepository accessRepository = new AccessRepository("hibernate.cfg.xml");
		List<String> parameters = map.get("parameters");
		HashMap<String, Object> response = accessRepository.getAccessByTypeAndDate(Integer.parseInt(parameters.get(0)),
				parameters.get(1), parameters.get(2), Integer.parseInt(parameters.get(3)),
				Integer.parseInt(parameters.get(4)));
		List<IAccess> accessDB = (List<IAccess>) response.get("access");
		return okResponse(accessDB, "Ok", HttpStatus.OK.value(), (int) response.get("total"),
				Integer.parseInt(parameters.get(3)), Integer.parseInt(parameters.get(4)));
	}

	/**
	 * Method used to get access
	 * 
	 * @param access
	 *            to be used
	 * @return access
	 */
	@RequestMapping(value = "getAccess", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse<Access>> getAccess(@RequestBody Access access) {
		IAccessRepository accessRepository = new AccessRepository("hibernate.cfg.xml");
		Access result = new Access(accessRepository.getAccess(access.getId()));
		if (result.getId() != null) {
			return okResponse(result, "Ok", HttpStatus.OK.value());
		}
		return okResponse(new Access(), "Not found", HttpStatus.NOT_FOUND.value());
	}

	/**
	 * Method used to insert access
	 * 
	 * @param access
	 *            to be inserted
	 * @return access inserted
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse<IAccess>> insert(@RequestBody Access access) {
		IAccessRepository accessRepository = new AccessRepository("hibernate.cfg.xml");
		try {
			return okResponse(accessRepository.insert(access), "Created", HttpStatus.CREATED.value());
		} catch (Exception ex) {
			return okResponse(new Access(), "Conflict or exception: " + ex.getMessage(), HttpStatus.CONFLICT.value());
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
	public @ResponseBody ResponseEntity<BaseResponse<IAccess>> update(@RequestBody Access access) {
		IAccessRepository accessRepository = new AccessRepository("hibernate.cfg.xml");
		return okResponse(accessRepository.update(access), "Accepted", HttpStatus.ACCEPTED.value());
	}

	/**
	 * Method used to delete access
	 * 
	 * @param access
	 *            to be deleted
	 * @return status
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse<Boolean>> delete(@RequestBody Access access) {
		IAccessRepository accessRepository = new AccessRepository("hibernate.cfg.xml");
		return okResponse(accessRepository.delete(access), "No content", HttpStatus.NO_CONTENT.value());
	}

}
