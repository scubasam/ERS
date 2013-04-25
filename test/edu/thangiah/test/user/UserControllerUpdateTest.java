/**
 * 
 */
package edu.thangiah.test.user;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import edu.thangiah.user.action.UpdateAction;
import edu.thangiah.user.entity.User;

/**
 * Tests the functionality for updating User entities within the database.
 * @author Kelly Smith
 *
 */
public class UserControllerUpdateTest {
	
	
	private UpdateAction action;
	
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
		action = new UpdateAction();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testUpdateUserValidateTrue() {
		User user = new User();
		user.setUsername("Testing");
		user.setEmail("testing@test.com");
		
		action.setUser(user);
		action.validate();
		
		Assert.assertTrue(!action.hasActionErrors());
		Assert.assertTrue(!action.hasFieldErrors());
	}
	
	@Test
	public void testUpdateUserValidateBadUsername() {
		User user = new User();
		user.setUsername(null);
		user.setEmail("testing@test.com");
		
		action.setUser(user);
		action.validate();
		
		Assert.assertTrue(!action.hasActionErrors());
		Assert.assertTrue(action.hasFieldErrors());
		Assert.assertTrue(action.getFieldErrors().containsKey("user.username"));
	}
	
	@Test
	public void testUpdateUserValidateBadEmail() {
		User user = new User();
		user.setUsername("Testing");
		user.setEmail("testintest.com");
		
		action.setUser(user);
		action.validate();
		
		Assert.assertTrue(!action.hasActionErrors());
		Assert.assertTrue(action.hasFieldErrors());
		Assert.assertTrue(action.getFieldErrors().containsKey("user.email"));
	}
	
	@Test
	public void testMergeUser(){
		User fromDb = new User();
		fromDb.setId(new Long(1));
		
		User fromForm = new User();
		fromForm.setUsername("username");
		fromForm.setEmail("email@email.com");
		fromForm.setAdmin(true);
		
		// Use Java reflection to access the private method.
		Method method;
		try {
			
			@SuppressWarnings("unchecked")
			Class<User>[] parameterTypes = (Class<User>[]) new Class[2];
			parameterTypes[0] = User.class;
			parameterTypes[1] = User.class;
			
			method = UpdateAction.class.getDeclaredMethod("mergeUser", parameterTypes);
			
			method.setAccessible(true);
			
			Object[] parameters = new Object[2];
			parameters[0] = fromDb;
			parameters[1] = fromForm;
			
			try {
				method.invoke(action, parameters);
				
				Assert.assertEquals(new Long(1), fromDb.getId());
				Assert.assertEquals(fromForm.getUsername(), fromDb.getUsername());
				Assert.assertEquals(fromForm.getEmail(), fromDb.getEmail());
				Assert.assertEquals(fromForm.isAdmin(), fromDb.isAdmin());
				
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		}
	}

}
