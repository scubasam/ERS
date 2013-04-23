/**
 * 
 */
package edu.thangiah.test.user;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import edu.thangiah.user.UserBo;
import edu.thangiah.user.action.AddAction;
import edu.thangiah.user.entity.User;

/**
 * Tests the functionality for adding User entities to the database.
 * @author Kelly Smith
 *
 */
public class UserControllerAddTest {
	
	
	protected AddAction action;
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		action = new AddAction();
		
		// Set's a fake data access class to allow the test to pass certain validation tests.
		action.setUserBo(new UserBo(){

			@Override
			public void add(User user) {
			}

			@Override
			public void update(User user) {
			}

			@Override
			public void delete(User user) {
			}

			@Override
			public List<User> findAll() {
				return null;
			}

			@Override
			public List<User> findById(int id) {
				return null;
			}

			@Override
			public List<User> findByUsername(String username) {
				return new ArrayList<User>();
			}

			@Override
			public List<User> findBySessionId(String sessionId) {
				return null;
			}
			
		});
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testAddUserValidateTrue() {
		User user = new User();
		user.setUsername("Testing");
		user.setPassword("Testing");
		user.setEmail("testing@test.com");
		
		action.setUser(user);
		action.validate();
		
		Assert.assertTrue(!action.hasActionErrors());
		Assert.assertTrue(!action.hasFieldErrors());
	}
	
	@Test
	public void testAddUserValidateBadUsername() {
		User user = new User();
		user.setUsername(null);
		user.setPassword("Testing");
		user.setEmail("testing@test.com");
		
		action.setUser(user);
		action.validate();
		
		Assert.assertTrue(!action.hasActionErrors());
		Assert.assertTrue(action.hasFieldErrors());
		Assert.assertTrue(action.getFieldErrors().containsKey("user.username"));
	}
	
	@Test
	public void testAddUserValidateBadEmail() {
		User user = new User();
		user.setUsername("Testing");
		user.setPassword("Testing");
		user.setEmail("testintest.com");
		
		action.setUser(user);
		action.validate();
		
		Assert.assertTrue(!action.hasActionErrors());
		Assert.assertTrue(action.hasFieldErrors());
		Assert.assertTrue(action.getFieldErrors().containsKey("user.email"));
	}
	
	@Test
	public void testAddUserValidateBadPassword() {
		User user = new User();
		user.setUsername("Testing");
		user.setPassword("Te");
		user.setEmail("testin@test.com");
		
		action.setUser(user);
		action.validate();
		
		Assert.assertTrue(!action.hasActionErrors());
		Assert.assertTrue(action.hasFieldErrors());
		Assert.assertTrue(action.getFieldErrors().containsKey("user.password"));
		
		Assert.assertEquals("Password must be at least " + User.minPasswordLength + " characters in length.", action.getFieldErrors().get("user.password").get(0));
	}
	
	@Test
	public void testAddUserValidateBadPassword2() {
		User user = new User();
		user.setUsername("Testing");
		user.setPassword("");
		user.setEmail("testin@test.com");
		
		action.setUser(user);
		action.validate();
		
		Assert.assertTrue(!action.hasActionErrors());
		Assert.assertTrue(action.hasFieldErrors());
		Assert.assertTrue(action.getFieldErrors().containsKey("user.password"));
		
		Assert.assertEquals("Password must be at least " + User.minPasswordLength + " characters in length.", action.getFieldErrors().get("user.password").get(0));
	}

}
