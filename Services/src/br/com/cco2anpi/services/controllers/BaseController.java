/**
 * 
 */
package br.com.cco2anpi.services.controllers;

import br.com.cco2anpi.repository.AccessRepository;
import br.com.cco2anpi.repository.CompanyRepository;
import br.com.cco2anpi.repository.ComplexBuildingRepository;
import br.com.cco2anpi.repository.EmployersRepository;
import br.com.cco2anpi.repository.IAccessRepository;
import br.com.cco2anpi.repository.ICompanyRepository;
import br.com.cco2anpi.repository.IComplexBuildingRepository;
import br.com.cco2anpi.repository.IEmployerRepository;
import br.com.cco2anpi.repository.IUserRepository;
import br.com.cco2anpi.repository.UserRepository;

/**
 * @author wotan Class used to be de base of all controllers
 */
public class BaseController {

	public final int defaultPageSize = 50;
	protected IAccessRepository accessRepository;
	protected IUserRepository userRepository;
	protected IComplexBuildingRepository complexBuildingRepository;
	protected ICompanyRepository companyRepository;
	protected IEmployerRepository employerRepository;
	protected long startTime;

	/**
	 * Constructor of the class base controller
	 */
	public BaseController() {
		accessRepository = new AccessRepository("hibernate.cfg.xml");
		userRepository = new UserRepository("hibernate.cfg.xml");
		complexBuildingRepository = new ComplexBuildingRepository("hibernate.cfg.xml");
		companyRepository = new CompanyRepository("hibernate.cfg.xml");
		employerRepository = new EmployersRepository("hibernate.cfg.xml");
	}

	/**
	 * Method to calculate elapsed time
	 * 
	 * @param start
	 *            when starts to count
	 * @return in ms time used until this call
	 */
	protected long calculateElapsedTime(long start) {
		return System.currentTimeMillis() - start;
	}
}
