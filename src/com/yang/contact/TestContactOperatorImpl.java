package com.yang.contact;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a test class for contact operation
 * 
 * @author yang
 *
 */
public class TestContactOperatorImpl {
	ContactOperator operator = null;

	/**
	 * initialize the object
	 */
	@Before
	public void init() {
		operator = new ContactOperatorImpl();
	}

	@Test
	public void testAddContact() {
		Contact contact = new Contact();
		contact.setId("1");
		contact.setName("Ronaldo");
		contact.setAge(25);
		contact.setGender("male");
		contact.setPhone("4022155686");
		contact.setEmail("liu@gmail.com");
		contact.setQq("121654645");
		operator.addContact(contact);
	}

	@Test
	public void testUpdateContact() {
		Contact contact = new Contact();
		contact.setId("3"); // update the contact with id = 3
		contact.setName("Liu");
		contact.setAge(18);
		contact.setGender("male");
		contact.setPhone("4022155686");
		contact.setEmail("liu@gmail.com");
		contact.setQq("121654645");
		operator.updateContact(contact);
	}

	@Test
	public void testDeleteContact() {
		operator.deleteContact("4");
	}

	@Test
	public void testShowAll() {
		List<Contact> list = operator.showAll();
		for (Contact contact : list) {
			System.out.println(contact);
		}
	}
}
