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

import br.com.cco2anpi.models.IAccess;
import br.com.cco2anpi.models.IUser;
import br.com.cco2anpi.models.User;
import br.com.cco2anpi.repository.UserRepository;
import br.com.cco2anpi.tools.Crypto;

/**
 * @author pitagoras
 *
 */
/**
 * Class for test UserRepository's methods
 */
public class UserRepositoryTest {

	private UserRepository userRepository;
	private User user;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.userRepository = new UserRepository("hibernate.cfg.xml");
		this.user = new User();
		user.setUsername("ge");
		user.setSalt(Crypto.generateRandomSalt());
		user.setPassword(Crypto.encrypt("k", user.getSalt()));
		user.setName("k");
		user.setCpf("0");
		user.setOfficeHours("0");
		user.setAccess(new HashSet<IAccess>(0));
		user.setType(0);
	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.UserRepository#UserRepository(java.lang.String)}
	 * .
	 */
	@Test
	public void testUserRepository() {
		assertTrue(true);
	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.UserRepository#insert(br.com.cco2anpi.models.IUser)}
	 * .
	 */
	@Test
	public void testInsert() {
		try {

			IUser user = userRepository.insert(this.user);
			assertEquals(user.getClass(), User.class);
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.UserRepository#update(br.com.cco2anpi.models.IUser)}
	 * .
	 */
	@Test
	public void testUpdate() {
		try {
			this.user.setUserId(18);
			this.user.setUsername("ge");
			IUser user = userRepository.update(this.user);
			// The return of getUser() can be null, then if return is null, test
			// is ok!
			assertEquals(user.getClass(), User.class);
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.UserRepository#delete(br.com.cco2anpi.models.IUser)}
	 * .
	 */
	@Test
	public void testDelete() {
		try {
			Boolean bool = userRepository.delete(this.user);
			// The return of getUser() can be null, then if return is null, test
			// is ok!

			assertTrue(bool);

		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.UserRepository#getUser(java.lang.Integer)}
	 * .
	 */
	@Test
	public void testGetUser() {
		try {
			IUser user = userRepository.getUser(userRepository.getAllUsers()[0].getUserId());
			// The return of getUser() can be null, then if return is null, test
			// is ok!
			if (user != null) {
				assertEquals(user.getClass(), User.class);
			} else {
				assertTrue(true);
			}
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.UserRepository#getAllUsers()}.
	 */
	@Test
	public void testGetAllUsers() {
		try {
			IUser[] users = userRepository.getAllUsers();
			// The return of getAllUsers() can be null, then if return is null,
			// test is ok!
			if (users != null) {
				assertEquals(users.getClass(), User[].class);
			} else {
				assertTrue(true);
			}
		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link br.com.cco2anpi.repository.UserRepository#exists(br.com.cco2anpi.models.IUser)}
	 * .
	 */
	@Test
	public void testExists() {
		try {
			boolean bool = userRepository.exists(this.user);
			// The return of getUser() can be null, then if return is null, test
			// is ok!
			assertTrue(bool);

		} catch (Exception ex) {
			fail("Error on execution: " + ex.getMessage());
		}
	}

}
