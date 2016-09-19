/**
 * 
 */
package br.com.cco2anpi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import br.com.cco2anpi.models.Employer;

/**
 * @author wotan
 *
 */

@Controller
public class UserController {

	@RequestMapping("/User/user")
	public ModelAndView getUsers() {
		Employer employer = new Employer();
		Gson gson = new Gson();
		return new ModelAndView("/User/user", "user", gson.toJson(employer));
		// return new ModelAndView();
	}
}
