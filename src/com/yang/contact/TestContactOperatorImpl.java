package com.yang.contact;


import org.junit.Before;
import org.junit.Test;

/**
 * This is a test class for contact operation
 * @author yang
 *
 */
public class TestContactOperatorImpl {
	ContactOperator operator =  null;
	
	/**
	 * initialize the object
	 */
	@Before
	public void init(){
		operator = new ContactOperatorImpl();
	}
	
	@Test
	public void testAddContact(){
		Contact contact = new Contact();
		contact.setId("3");
		contact.setName("Kobe");
		contact.setAge(23);
		contact.setGender("male");
		contact.setPhone("4022155686");
		contact.setEmail("liu@gmail.com");
		contact.setQq("121654645");
		operator.addContact(contact);
	}
}
