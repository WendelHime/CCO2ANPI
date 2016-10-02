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
    protected IAccessRepository accessRepository = new AccessRepository("hibernate.cfg.xml");
    protected IUserRepository userRepository = new UserRepository("hibernate.cfg.xml");
    protected IComplexBuildingRepository complexBuildingRepository = new ComplexBuildingRepository("hibernate.cfg.xml");
    protected ICompanyRepository companyRepository = new CompanyRepository("hibernate.cfg.xml");
    protected IEmployerRepository employerRepository = new EmployersRepository("hibernate.cfg.xml");
    // private StopWatch stopWatch;

    /**
     * Constructor of the class base controller
     */
    // public BaseController() {
    //// stopWatch = new StopWatch();
    // userRepository = new UserRepository("hibernate.cfg.xml");
    // }
}
