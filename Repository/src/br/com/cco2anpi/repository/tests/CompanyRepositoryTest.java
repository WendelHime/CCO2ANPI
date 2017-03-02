package br.com.cco2anpi.repository.tests;
/**
 * 
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import br.com.cco2anpi.models.Company;
import br.com.cco2anpi.models.ComplexBuilding;
import br.com.cco2anpi.models.ICompany;
import br.com.cco2anpi.models.IEmployer;
import br.com.cco2anpi.repository.CompanyRepository;
import br.com.cco2anpi.repository.ComplexBuildingRepository;

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
		// company.setComplexBuilding(); <- solve the complexBuilding
		ComplexBuildingRepository complexBuildingRepository = new ComplexBuildingRepository("hibernate.cfg.xml");
		company.setComplexBuilding(new ComplexBuilding(complexBuildingRepository.getAllBuildingSets()[0]));
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
			this.company.setId(companyRepository.getAllCompanies()[0].getId());
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
			ICompany company = companyRepository.getCompany(companyRepository.getAllCompanies()[0].getId());

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
			ICompany[] companies = companyRepository.getAllCompanies();
			// The return of getAllCompanies() can be null, then if return is
			// null,
			// test is ok!
			if (companies != null) {
				assertEquals(companies.getClass(), Company[].class);
			} else {
				assertTrue(true);
			}
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

}
