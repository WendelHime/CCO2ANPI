/**
 * 
 */
package br.com.cco2anpi.repository.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.cco2anpi.models.Access;
import br.com.cco2anpi.models.IAccess;
import br.com.cco2anpi.repository.AccessRepository;

/**
 * @author Giovanni Maciel
 *
 */
public class AccessRepositoryTest {

	AccessRepository accessRepository;
	Access access;

	@Before
	public void setUp() throws Exception {
		this.accessRepository = new AccessRepository("hibernate.cfg.xml");
		// UserRepository userRepository = new
		// UserRepository("hibernate.cfg.xml");
		this.access = new Access();
		this.access.setDateIn("20/02");
		this.access.setDateOut("20/03");
		this.access.setId(1);
		// this.access.setUser(); <-------------------------- WARNING @PARAM
		// User user = new User(((List<IUser>) userRepository.getAllUsers(1,
		// 0)).get(0));
		// this.access.setUser(user);
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
		try {
			IAccess access = accessRepository.insert(this.access);
			assertEquals(access.getClass(), Access.class);
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
	 * {@link br.com.cco2anpi.repository.AccessRepository#update(br.com.cco2anpi.models.IAccess)}.
	 */
	@Test
	public void testUpdate() {
		try {
			this.access.setDateIn("30/05");
			this.access.setDateOut("30/08");
			this.access.setId(((List<IAccess>) accessRepository.getAllAccess(1, 0).get("access")).get(0).getId());
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
			IAccess access = accessRepository
					.getAccess(((List<IAccess>) accessRepository.getAllAccess(1, 0).get("access")).get(0).getId());

			if (access != null) {
				assertEquals(access.getClass(), Access.class);
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
			List<IAccess> access = ((List<IAccess>) accessRepository.getAllAccess(1, 0).get("access"));

			// The return of getAllAcess() can be null, then if return is null,
			// test is ok!
			if (access != null) {
				assertEquals(access.getClass(), new ArrayList<IAccess>().getClass());
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
		try {
			List<IAccess> access = (List<IAccess>) accessRepository.getAccessByTypeAndDate(10, "20/02", "20/03", 1, 0)
					.get("access");

			// The return of getAllAccessByTypeAndDate() can be null, then if
			// return is null,
			// test is ok!
			if (access != null) {
				assertEquals(access.getClass(), new ArrayList<IAccess>().getClass());
			} else {
				assertTrue(true);
			}
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}
}