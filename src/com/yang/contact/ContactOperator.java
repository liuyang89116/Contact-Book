package com.yang.contact;

import java.util.List;

/**
 * Used for storing different methods related to contacts
 * 
 * @author yang
 *
 */
public interface ContactOperator {
	public void addContact(Contact contact); //add new contact
	public void updateContact(Contact contact); //update contacts
	public void deleteContact(String id); //delete contact
	public List<Contact> showAll(); //show all contacts
}
