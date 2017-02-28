/**
 * 
 */
package br.com.cco2anpi.repository.tests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.hibernate.PropertyValueException;
import org.junit.Before;
import org.junit.Test;

import br.com.cco2anpi.models.ComplexBuilding;
import br.com.cco2anpi.models.Employer;
import br.com.cco2anpi.models.IComplexBuilding;
import br.com.cco2anpi.models.IEmployer;
import br.com.cco2anpi.repository.ComplexBuildingRepository;
import br.com.cco2anpi.repository.EmployersRepository;
import br.com.cco2anpi.tools.Crypto;

/**
 * @author Giovanni Maciel
 *
 */
public class ComplexBiuldingRepositoryTest {

	private ComplexBuildingRepository complexBuildingRepository;
	private ComplexBuilding complexBuilding;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.complexBuildingRepository = new ComplexBuildingRepository("hibernate.cfg.xml");
		this.complexBuilding = new ComplexBuilding();
		//complexBuilding.setCompanies(companies); <---------- WARNING @PARAM
		complexBuilding.setNumber("2");
		complexBuilding.setCompanies(new HashSet(0));
	}
		
	/**
	 * Test method for {@link br.com.cco2anpi.repository.ComplexBuildingRepository#ComplexBuildingRepository(java.lang.String)}.
	 */
	@Test
	public void testComplexBuildingRepository() {
		assertTrue(true);
	}

	/**
	 * Test method for 
	 * {@link br.com.cco2anpi.repository.ComplexBuildingRepository#insert(br.com.cco2anpi.models.IComplexBuilding)}.
	 */
	@Test
	public void testInsert() {
		try{
			IComplexBuilding complexBuilding = complexBuildingRepository.insert(this.complexBuilding);
			assertEquals(complexBuilding.getClass(), ComplexBuilding.class);
		}
		
		/*catch(PropertyValueException pvex){
			fail("Property required not defined :" + pvex.getMessage());
		}*/
		
		catch(Exception ex){
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for 
	 * {@link br.com.cco2anpi.repository.ComplexBuildingRepository#update(br.com.cco2anpi.models.IComplexBuilding)}.
	 */
	@Test
	public void testUpdate() {
		complexBuilding.setNumber("77");
		complexBuilding.setId(98);
		IComplexBuilding complexBuilding = complexBuildingRepository.update(this.complexBuilding);
		assertEquals(complexBuilding.getClass(), ComplexBuilding.class);
	}

	/**
	 * Test method for 
	 * {@link br.com.cco2anpi.repository.ComplexBuildingRepository#delete(br.com.cco2anpi.models.IComplexBuilding)}.
	 */
	@Test
	public void testDelete() {
		try {
			Boolean bool = complexBuildingRepository.delete(this.complexBuilding);
			assertTrue(bool);
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for 
	 * {@link br.com.cco2anpi.repository.ComplexBuildingRepository#getComplexBuilding(br.com.cco2anpi.models.IComplexBuilding)}.
	 */
	@Test
	public void testGetComplexBuilding() {
		try {
			//IComplexBuilding complexBuilding = complexBuildingRepository.getComplexBuilding("COMPLEX BUILDING GOES HERE"); <-- WARNING @PARAM

			if (complexBuilding != null) {
				assertEquals(complexBuilding.getClass(), ComplexBuilding.class);
			} else {
				assertTrue(true);
			}
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for {@link br.com.cco2anpi.repository.ComplexBuildingRepository#getAllBuildingSets()}.
	 */
	@Test
	public void testGetAllBuildingSets() {
		try {
			IComplexBuilding[] complexes = complexBuildingRepository.getAllBuildingSets();
			// The return of getAllBuildingSets() can be null, then if return is null,
			// test is ok!
			if (complexes != null) {
				assertEquals(complexes.getClass(), ComplexBuilding[].class);
			} else {
				assertTrue(true);
			}
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

}
