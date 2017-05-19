package br.com.cco2anpi.systemBuildingControl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author biondi
 *
 */
@Controller
@EnableWebMvc
@RequestMapping("/*")
public class RootController extends BaseController {
	/**
	 * Method used to standard page User
	 * 
	 * @return view index
	 */
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("/Users/login");
	}
}
