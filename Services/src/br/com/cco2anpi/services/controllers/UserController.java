/**
 * 
 */
package br.com.cco2anpi.services.controllers;

import java.util.HashMap;
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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.cco2anpi.models.Access;
import br.com.cco2anpi.models.BaseResponse;
import br.com.cco2anpi.models.IAccess;
import br.com.cco2anpi.models.IUser;
import br.com.cco2anpi.models.PagedResponse;
import br.com.cco2anpi.models.TypeEnum;
import br.com.cco2anpi.models.User;
import br.com.cco2anpi.repository.AccessRepository;
import br.com.cco2anpi.repository.IAccessRepository;
import br.com.cco2anpi.repository.UserRepository;

/**
 * @author wotan
 *
 */

@Controller
@EnableWebMvc
@RequestMapping("User/*")
public class UserController extends BaseController
{

    /**
     * Method used to get all users
     * 
     * @return array of users
     */
    @Transactional(readOnly = true)
    @RequestMapping(value = "getUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<PagedResponse<List<IUser>>> getUsers(@RequestParam("pageSize") int pageSize,
	    @RequestParam("offset") int offset)
    {
	UserRepository userRepository = new UserRepository("hibernate.cfg.xml");
	startTime = System.currentTimeMillis();
	HashMap<String, Object> response = userRepository.getAllUsers(offset, pageSize);
	return okResponse((List<IUser>) response.get("users"), "Ok", HttpStatus.OK.value(),
		(Integer) response.get("total"), pageSize, offset);
    }

    /**
     * Method used to get user
     * 
     * @param user
     *            object user
     * @return user filled
     */
    @RequestMapping(value = "getUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<BaseResponse<IUser>> getUser(@RequestBody User user)
    {
	UserRepository userRepository = new UserRepository("hibernate.cfg.xml");
	startTime = System.currentTimeMillis();
	if (userRepository.exists(
		user)) { return okResponse(userRepository.getUser(user.getUserId()), "Ok", HttpStatus.OK.value()); }
	return okResponse(new User(), "Not found", HttpStatus.NOT_FOUND.value());
    }

    /**
     * Method used to insert user
     * 
     * @param user
     *            to be inserted
     * @return user filled
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<BaseResponse<IUser>> insert(@RequestBody User user, @RequestBody int typeUser)
    {
	try
	{
	    UserRepository userRepository = new UserRepository("hibernate.cfg.xml");
	    startTime = System.currentTimeMillis();
	    TypeEnum typeUsr = TypeEnum.getValue(typeUser);
	    if (TypeEnum.getValue(user.getType()) == TypeEnum.CLERK && typeUsr == TypeEnum.SYNDIC)
	    {
		if (userRepository.exists(user)) return okResponse(new User(), "Conflict", HttpStatus.CONFLICT.value());
		return okResponse(userRepository.insert(user), "Created", HttpStatus.CREATED.value());
	    }
	    else if (TypeEnum.getValue(user.getType()) == TypeEnum.COMPANY
		    && (typeUsr == TypeEnum.SYNDIC || typeUsr == TypeEnum.CLERK))
	    {
		if (userRepository.exists(user)) return okResponse(new User(), "Conflict", HttpStatus.CONFLICT.value());
		return okResponse(userRepository.insert(user), "Created", HttpStatus.CREATED.value());
	    }
	}
	catch (Exception ex)
	{

	}
	User usr = null;
	return okResponse(usr, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
		HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    /**
     * Method used to update user
     * 
     * @param user
     *            to be updated
     * @return user updated
     */
    @RequestMapping(value = "update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<BaseResponse<IUser>> update(@RequestBody User user)
    {
	UserRepository userRepository = new UserRepository("hibernate.cfg.xml");
	startTime = System.currentTimeMillis();
	if (userRepository
		.exists(user)) { return okResponse(userRepository.update(user), "Ok", HttpStatus.ACCEPTED.value()); }
	return okResponse(new User(), "Not found", HttpStatus.NOT_FOUND.value());
    }

    /**
     * Method used to delete user
     * 
     * @param user
     *            to be deleted
     * @return status
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<BaseResponse<Boolean>> delete(@RequestBody User user)
    {
	UserRepository userRepository = new UserRepository("hibernate.cfg.xml");
	startTime = System.currentTimeMillis();
	if (userRepository.exists(
		user)) { return okResponse(userRepository.delete(user), "No content", HttpStatus.NO_CONTENT.value()); }
	return okResponse(false, "Not found", HttpStatus.NOT_FOUND.value());
    }

    /**
     * Method used to insert access
     * 
     * @param access
     *            to be inserted
     * @return access inserted
     */
    @RequestMapping(value = "insertAccess", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<BaseResponse<IAccess>> insertAccess(@RequestBody Access access)
    {
	IAccessRepository accessRepository = new AccessRepository("hibernate.cfg.xml");
	try
	{
	    return okResponse(accessRepository.insert(access), "Created", HttpStatus.CREATED.value());
	}
	catch (Exception ex)
	{
	    return okResponse(new Access(), "Conflict or exception: " + ex.getMessage(), HttpStatus.CONFLICT.value());
	}
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
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "getAccessByTypeAndDate", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<PagedResponse<List<IAccess>>> getAccessByTypeAndDate(
	    @RequestParam("type") Integer type, @RequestParam("dateInit") String dateInit,
	    @RequestParam("dateEnd") String dateEnd, @RequestParam("typeUser") int typeUser,
	    @RequestParam("pageSize") int pageSize, @RequestParam("offset") int offset)
    {
	/**
	 * This function don't need to be checked because the key value from the
	 * access list is access
	 */
	try
	{
	    TypeEnum typeUsr = TypeEnum.getValue(typeUser);
	    if (typeUsr == TypeEnum.SYNDIC || typeUsr == TypeEnum.CLERK)
	    {
		IAccessRepository accessRepository = new AccessRepository("hibernate.cfg.xml");
		HashMap<String, Object> response = accessRepository.getAccessByTypeAndDate(type, dateInit, dateEnd,
			pageSize, offset);
		return okResponse((List<IAccess>) response.get("access"), "Ok", HttpStatus.OK.value(),
			(int) response.get("total"), pageSize, offset);
	    }
	}
	catch (Exception ex)
	{

	}
	List<IAccess> access = null;
	return okResponse(access, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
		HttpStatus.INTERNAL_SERVER_ERROR.value(), 0, pageSize, offset);
    }

    /**
     * Method used to get all access
     * 
     * @return all access
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "getAccess", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<PagedResponse<List<IAccess>>> getAccess(@RequestParam("typeUser") int typeUser,
	    @RequestParam("pageSize") int pageSize, @RequestParam("offset") int offset)
    {
	try
	{
	    TypeEnum typeUsr = TypeEnum.getValue(typeUser);
	    if (typeUsr == TypeEnum.SYNDIC || typeUsr == TypeEnum.CLERK)
	    {
		IAccessRepository accessRepository = new AccessRepository("hibernate.cfg.xml");
		HashMap<String, Object> returned = accessRepository.getAllAccess(pageSize, offset);
		return okResponse((List<IAccess>) returned.get("access"), "Ok", HttpStatus.OK.value(),
			(int) returned.get("total"), pageSize, offset);
	    }
	}
	catch (Exception ex)
	{

	}
	List<IAccess> access = null;
	return okResponse(access, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
		HttpStatus.INTERNAL_SERVER_ERROR.value(), 0, pageSize, offset);
    }

}
