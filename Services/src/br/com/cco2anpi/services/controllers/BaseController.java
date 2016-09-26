/**
 * 
 */
package br.com.cco2anpi.services.controllers;

import br.com.cco2anpi.repository.IUserRepository;
import br.com.cco2anpi.repository.UserRepository;

/**
 * @author wotan Class used to be de base of all controllers
 */
public class BaseController {

	public final int defaultPageSize = 50;
	protected IUserRepository userRepository = new UserRepository("hibernate.cfg.xml");
//	private StopWatch stopWatch;

	/**
	 * Constructor of the class base controller
	 */
//	public BaseController() {
////		stopWatch = new StopWatch();
//		userRepository = new UserRepository("hibernate.cfg.xml");
//	}
}
