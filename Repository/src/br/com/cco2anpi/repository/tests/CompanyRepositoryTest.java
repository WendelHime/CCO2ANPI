package br.com.cco2anpi.repository.tests;
/**
 * 
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.cco2anpi.models.Company;
import br.com.cco2anpi.models.ICompany;
import br.com.cco2anpi.models.IEmployer;
import br.com.cco2anpi.repository.CompanyRepository;

/**
 * @author Giovanni Maciel
 *
 */
public class CompanyRepositoryTest {

	private CompanyRepository companyRepository;
	private Company company;

	@Before
	public void setUp() throws Exception {
		this.companyRepository = new CompanyRepository("hibernate.cfg.xml");
		this.company = new Company();
		company.setSocialReason("Counter Strike S/A");
		company.setCnpj("0");
		company.setBusinessHours("0");
		company.setMaximumTemperature(10.0);
		company.setAirConditionerHours("Samsung");
		company.setSet("teste");

		company.setEmployers(new HashSet<IEmployer>(0));

	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.CompanyRepository#CompanyRepository(java.lang.String)}.
	 */
	@Test
	public void testCompanyRepository() {
		assertTrue(true);
	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.CompanyRepository#insert(br.com.cco2anpi.models.ICompany)}.
	 */
	@Test
	public void testInsert() {
		try {
			ICompany company = companyRepository.insert(this.company);
			assertEquals(company.getClass(), Company.class);
		}

		/*
		 * catch(PropertyValueException pvex){
		 * fail("Property required not defined :" + pvex.getMessage()); }
		 */

		catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.CompanyRepository#update(br.com.cco2anpi.models.ICompany)}.
	 */
	@Test
	public void testUpdate() {
		try {
			companyRepository.getAllCompanies(1, 0).get("companies");
			this.company
					.setId(((List<ICompany>) companyRepository.getAllCompanies(1, 0).get("companies")).get(0).getId());
			this.company.setSocialReason("Kraken");
			this.company.setCnpj("2");
			this.company.setMaximumTemperature(15.0);
			ICompany company = companyRepository.update(this.company);
			assertEquals(company.getClass(), Company.class);
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.CompanyRepository#delete(br.com.cco2anpi.models.ICompany)}.
	 */
	@Test
	public void testDelete() {
		try {
			Boolean bool = companyRepository.delete(this.company);
			assertTrue(bool);

		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.CompanyRepository#getCompany(java.lang.Integer)}.
	 */
	@Test
	public void testGetCompany() {
		try {
			ICompany company = companyRepository.getCompany(
					((List<ICompany>) companyRepository.getAllCompanies(1, 0).get("companies")).get(0).getId());

			if (company != null) {
				assertEquals(company.getClass(), Company.class);
			} else {
				assertTrue(true);
			}
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.CompanyRepository#getAllCompanies()}.
	 */
	@Test
	public void testGetAllCompanies() {
		try {
			List<ICompany> companies = ((List<ICompany>) companyRepository.getAllCompanies(1, 0).get("companies"));
			// The return of getAllCompanies() can be null, then if return is
			// null,
			// test is ok!
			if (companies != null) {
				assertEquals(companies.getClass(), new ArrayList<ICompany>().getClass());
			} else {
				assertTrue(true);
			}
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

}
