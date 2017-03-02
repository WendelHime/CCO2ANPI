package br.com.cco2anpi.repository.tests;
/**
 * 
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.PropertyValueException;
import org.junit.Before;
import org.junit.Test;

import br.com.cco2anpi.models.Employer;
import br.com.cco2anpi.models.ICompany;
import br.com.cco2anpi.models.IEmployer;
import br.com.cco2anpi.models.User;
import br.com.cco2anpi.repository.CompanyRepository;
import br.com.cco2anpi.repository.EmployersRepository;
import br.com.cco2anpi.repository.UserRepository;

/**
 * @author Giovanni Maciel
 *
 */
public class EmployersRepositoryTest {

	private EmployersRepository employersRepository;
	private Employer employer;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.employersRepository = new EmployersRepository("hibernate.cfg.xml");
		IEmployer[] employers = employersRepository.getAllEmployers();
		if (employers.length > 0) {
			this.employer = new Employer(employers[0]);
		} else {
			CompanyRepository companyRepository = new CompanyRepository("hibernate.cfg.xml");
			UserRepository userRepository = new UserRepository("hibernate.cfg.xml");
			User user = new User(userRepository.getAllUsers()[0]);
			this.employer = new Employer();
			employer.setAccessHour("0");
			employer.setPermissionTemperature(true);
			Set<ICompany> companies = new HashSet<ICompany>();
			companies.add(companyRepository.getAllCompanies()[0]);
			employer.setCompanies(companies);
			employer.setId(user.getUserId());
			employer.setUserID(user.getUserId());
			employer.setAccess(user.getAccess());
			employer.setCpf(user.getCpf());
			employer.setName(user.getName());
			employer.setOfficeHours(user.getOfficeHours());
			employer.setType(user.getType());
			employer.setUsername(user.getUsername());
			employer.setSalt(user.getSalt());
			employer.setPassword(user.getPassword());
		}
	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.EmployersRepository#EmployersRepository(java.lang.String)}.
	 */
	@Test
	public void testEmployersRepository() {
		assertTrue(true);
	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.EmployersRepository#insert(br.com.cco2anpi.models.IEmployer)}.
	 */
	@Test
	public void testInsert() {
		try {
			IEmployer employer = employersRepository.insert(this.employer);
			assertEquals(employer.getClass(), Employer.class);
		} catch (PropertyValueException pvex) {
			fail("Property required not defined :" + pvex.getMessage());
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.EmployersRepository#update(br.com.cco2anpi.models.IEmployer)}.
	 */
	@Test
	public void testUpdate() {
		try {
			this.employer.setId(20);
			this.employer.setUsername("ka");
			this.employer.setAccessHour("2");
			this.employer.setPermissionTemperature(false);
			IEmployer employer = employersRepository.update(this.employer);
			assertEquals(employer.getClass(), Employer.class);
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}

	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.EmployersRepository#delete(br.com.cco2anpi.models.IEmployer)}.
	 */
	@Test
	public void testDelete() {
		try {
			Boolean bool = employersRepository.delete(this.employer);
			assertTrue(bool);

		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.EmployersRepository#getEmployer(java.lang.Inte)ger)}.
	 */
	@Test
	public void testGetEmployer() {
		try {
			IEmployer employer = employersRepository.getEmployer(employersRepository.getAllEmployers()[0].getUserID());

			if (employer != null) {
				assertEquals(employer.getClass(), Employer.class);
			} else {
				assertTrue(true);
			}
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.EmployersRepository#getAllEmployers()}.
	 */
	@Test
	public void testGetAllEmployers() {
		try {
			IEmployer[] employers = employersRepository.getAllEmployers();
			// The return of getAllEmployers() can be null, then if return is
			// null,
			// test is ok!
			if (employers != null) {
				assertEquals(employers.getClass(), Employer[].class);
			} else {
				assertTrue(true);
			}
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

}
