/**
 * 
 */
package br.com.cco2anpi.systemBuildingControlWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author pitagoras
 *
 */
//   http://localhost:8080/SystemBuildingControlWeb
@Controller
@EnableWebMvc
@RequestMapping("User/*")
public class UserController extends BaseController {
	
	@RequestMapping("index")
	public ModelAndView index(){
		return new ModelAndView("/User/user");
	}
}
