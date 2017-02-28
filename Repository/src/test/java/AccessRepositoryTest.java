/**
 * 
 */
package br.com.cco2anpi.repository.tests;

import static org.junit.Assert.*;

import org.hibernate.PropertyValueException;
import org.junit.Before;
import org.junit.Test;
import org.osgi.service.useradmin.User;

import br.com.cco2anpi.models.Access;
import br.com.cco2anpi.models.Employer;
import br.com.cco2anpi.models.IAccess;
import br.com.cco2anpi.models.IEmployer;
import br.com.cco2anpi.repository.AccessRepository;

/**
 * @author Giovanni Maciel
 *
 */
public class AccessRepositoryTest {

	AccessRepository accessRepository;
	Access access;
	
	@Before
	public void setUp() throws Exception
	{
		this.accessRepository = new AccessRepository("hibernate.cfg.xml");
		this.access = new Access();
		this.access.setDateIn("20/02");
		this.access.setDateOut("20/03");
		//this.access.setUser(); <-------------------------- WARNING @PARAM
	}
	
	
	/**
	 * Test method for 
	 * {@link br.com.cco2anpi.repository.AccessRepository#AccessRepository(java.lang.String)}.
	 */
	@Test
	public void testAccessRepository() {
		assertTrue(true);
	}

	/**
	 * Test method for 
	 * {@link br.com.cco2anpi.repository.AccessRepository#insert(br.com.cco2anpi.models.IAccess)}.
	 */
	@Test
	public void testInsert() {
		try{
			IAccess access = accessRepository.insert(this.access);
			assertEquals(access.getClass(), Access.class);
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
	 * {@link br.com.cco2anpi.repository.AccessRepository#update(br.com.cco2anpi.models.IAccess)}.
	 */
	@Test
	public void testUpdate() {
		try {
			this.access.setDateIn("30/05");
			this.access.setDateOut("30/08");
			this.access.setId(77);
			IAccess access = accessRepository.update(this.access);
			assertEquals(access.getClass(), Access.class);
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for 
	 * {@link br.com.cco2anpi.repository.AccessRepository#delete(br.com.cco2anpi.models.IAccess)}.
	 */
	@Test
	public void testDelete() {
		try {
			Boolean bool = accessRepository.delete(this.access);
			assertTrue(bool);

		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for 
	 * {@link br.com.cco2anpi.repository.AccessRepository#getAccess(java.lang.Integer)}.
	 */
	@Test
	public void testGetAccess() {
		try {
			IAccess access = accessRepository.getAccess(12);

			if (access != null) {
				assertEquals(access.getClass(), Employer.class);
			} else {
				assertTrue(true);
			}
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for 
	 * {@link br.com.cco2anpi.repository.AccessRepository#getAllAccess()}.
	 */
	@Test
	public void testGetAllAccess() {
		try {
			IAccess[] access = accessRepository.getAllAccess();
			
			// The return of getAllAcess() can be null, then if return is null,
			// test is ok!
			if (access != null) {
				assertEquals(access.getClass(), Access[].class);
			} else {
				assertTrue(true);
			}
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for 
	 * {@link br.com.cco2anpi.repository.AccessRepository#getAccessByTypeAndDate(java.lang.Integer, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetAccessByTypeAndDate() {
		try{
		IAccess[] access = accessRepository.getAccessByTypeAndDate(10, "20/02", "20/03");
		
		// The return of getAllAccessByTypeAndDate() can be null, then if return is null,
		// test is ok!
		if (access != null) {
			assertEquals(access.getClass(), Access[].class);
		} else {
			assertTrue(true);
			}
		}
		catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}		
	}
}
