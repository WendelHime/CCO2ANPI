/**
 * 
 */
package br.com.cco2anpi.systemBuildingControl.controllers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.cco2anpi.models.BaseResponse;
import br.com.cco2anpi.models.IUser;
import br.com.cco2anpi.models.PagedResponse;
import br.com.cco2anpi.models.User;
import br.com.cco2anpi.tools.Crypto;

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
     * Method used to standard page User
     * 
     * @return view index
     */
    @RequestMapping("index")
    public ModelAndView index()
    {
	return new ModelAndView("/Users/index");
    }

    /**
     * Method used to insert user
     * 
     * @param username
     *            username
     * @param password
     *            password
     * @param name
     *            name
     * @param cpf
     *            cpf
     * @param type
     *            type of the user
     * @return User filled
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<BaseResponse<User>> insert(@RequestParam("username") String username,
	    @RequestParam("password") String password, @RequestParam("name") String name,
	    @RequestParam("cpf") String cpf, @RequestParam("type") int type)
    {
	User user = new User();
	user.setUsername(username);
	try
	{
	    user.setSalt(Crypto.generateRandomSalt());
	    user.setPassword(Crypto.encrypt(password, user.getSalt()));
	}
	catch (UnsupportedEncodingException | DataLengthException | IllegalStateException
		| InvalidCipherTextException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	user.setName(name);
	user.setCpf(cpf);
	user.setType(type);
	return okResponse(userClient.insert(user, 1).getBody().getResponse(), "Ok", HttpStatus.OK.value());
    }

    /**
     * Method used to realize update
     * 
     * @param userToBeUpdated
     *            user to be updated
     * @return user changed
     */
    @RequestMapping(value = "update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<BaseResponse<User>> update(@RequestBody User userToBeUpdated)
    {
	User user = new User(userToBeUpdated);
	IUser authentication = new User(userClient.authentication(user).getBody().getResponse());
	try
	{
	    if (Crypto.decrypt(authentication.getPassword(), authentication.getSalt()) != Crypto
		    .decrypt(user.getPassword(), authentication.getSalt()))
	    {
		user.setSalt(Crypto.generateRandomSalt());
		user.setPassword(Crypto.encrypt(user.getPassword(), user.getSalt()));
	    }
	    else
	    {
		user.setSalt(Crypto.generateRandomSalt());
		user.setPassword(Crypto.encrypt(authentication.getPassword(), user.getSalt()));
	    }
	    return okResponse(userClient.update(user).getBody().getResponse(), "Ok", HttpStatus.OK.value());
	}
	catch (UnsupportedEncodingException | DataLengthException | IllegalStateException | InvalidCipherTextException
		| NullPointerException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return okResponse(new User(), "Not found", HttpStatus.NOT_FOUND.value());
    }

    /**
     * Method used to delete user
     * 
     * @param user
     *            user to be deleted
     * @return status
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<BaseResponse<Boolean>> delete(@RequestBody User user)
    {
	try
	{
	    return okResponse(userClient.delete(user).getBody().getResponse(), "Ok", HttpStatus.OK.value());
	}
	catch (Exception ex)
	{
	    // TODO Auto-generated catch block
	    ex.printStackTrace();
	}
	return okResponse(false, "Not found", HttpStatus.NOT_FOUND.value());
    }

    /**
     * Method used to get all users
     * 
     * @param pageSize
     *            limit of the query
     * @param offset
     *            offset of the query
     * @return list of users
     */
    @RequestMapping(value = "getUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<PagedResponse<List<User>>> getUsers(@RequestParam("pageSize") int pageSize,
	    @RequestParam("offset") int offset)
    {
	try
	{
	    PagedResponse<User[]> response = userClient.getAllUsers(pageSize, offset).getBody();
	    return okResponse(Arrays.asList(response.getResponse()), "Ok", HttpStatus.OK.value(), response.getTotal(),
		    response.getPageSize(), response.getOffset());
	}
	catch (Exception ex)
	{
	    // TODO Auto-generated catch block
	    ex.printStackTrace();
	}
	return okResponse(new ArrayList<User>(), "Not found", HttpStatus.NOT_FOUND.value(), 0, 0, 0);
    }

}
