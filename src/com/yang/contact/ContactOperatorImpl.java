package com.yang.contact;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * implement all operations
 * 
 * @author yang
 *
 */
public class ContactOperatorImpl implements ContactOperator {
	/**
	 * add new contact
	 */
	@Override
	public void addContact(Contact contact) {
		try {
			File file = new File("/home/yang/Desktop/contact.xml");
			Document doc = null;
			Element rootElem = null;
			if (!file.exists()) {
				/**
				 * Store contacts to xml files
				 */
				// create xml file
				doc = DocumentHelper.createDocument();
				// create root tag
				rootElem = doc.addElement("contactList");
			} else {
				// if exist, read in the file
				doc = new SAXReader().read(file);
				// if exist, read in root element
				rootElem = doc.getRootElement();
			}

			// create contact tag
			/**
			 * <contact id="1"> <name>eric</name> <gender>male</gender>
			 * <age>20</age> <phone>40232434</phone>
			 * <email>wang@gmail.com</email> <qq>123456</qq> </contact>
			 */
			Element contactElem = rootElem.addElement("contact");
			contactElem.addAttribute("id", contact.getId());
			contactElem.addElement("name").setText(contact.getName());
			contactElem.addElement("gender").setText(contact.getGender());
			contactElem.addElement("age").setText(contact.getAge() + "");
			contactElem.addElement("phone").setText(contact.getPhone());
			contactElem.addElement("email").setText(contact.getEmail());
			contactElem.addElement("qq").setText(contact.getQq());

			// write document to xml file
			FileOutputStream out = new FileOutputStream("/home/yang/Desktop/contact.xml");
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter writer = new XMLWriter(out, format);
			writer.write(doc);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * update contact
	 */
	@Override
	public void updateContact(Contact contact) {
		/**
		 * update contact by tracing id value
		 */
		try {
			// read in xml file
			Document doc = new SAXReader().read(new File("/home/yang/Desktop/contact.xml"));
			Element contactElem = (Element) doc.selectSingleNode("//contact[@id='" + contact.getId() + "']");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteContact(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Contact> showAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
