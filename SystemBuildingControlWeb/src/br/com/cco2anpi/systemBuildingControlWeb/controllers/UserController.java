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
//@EnableWebMvc
//@RequestMapping("User/*")
public class UserController extends BaseController {
	
//	@RequestMapping("index")
//	public ModelAndView index(){
//		return new ModelAndView("/User/user");
//	}
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
}
