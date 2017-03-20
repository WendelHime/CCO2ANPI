/**
 * 
 */
package br.com.cco2anpi.systemBuildingControl.controllers;

import java.io.UnsupportedEncodingException;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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

    @RequestMapping("index")
    public ModelAndView index()
    {
	return new ModelAndView("/Users/index", "msg", "hello world");
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ModelAndView insert(@RequestParam("username") String username, @RequestParam("password") String password,
	    @RequestParam("name") String name, @RequestParam("cpf") String cpf, @RequestParam("type") int type)
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
	userClient.insert(user, 1);
	return new ModelAndView("/Users/index", "msg", "hello world");
    }
}
