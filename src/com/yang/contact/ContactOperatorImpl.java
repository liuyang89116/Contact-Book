package com.yang.contact;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

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
				doc = XMLUtil.getDocument();
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
			XMLUtil.writeToXml(doc);
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
			// 1.read in xml file
			Document doc = XMLUtil.getDocument();
			Element contactElem = (Element) doc.selectSingleNode("//contact[@id='" + contact.getId() + "']");

			// 2.update tag content
			contactElem.element("name").setText(contact.getName());
			contactElem.element("gender").setText(contact.getGender());
			contactElem.element("age").setText(contact.getAge() + "");
			contactElem.element("phone").setText(contact.getPhone());
			contactElem.element("email").setText(contact.getEmail());
			contactElem.element("qq").setText(contact.getQq());

			// 3. write in xml file
			XMLUtil.writeToXml(doc);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteContact(String id) {
		/**
		 * delete contact
		 */
		try {
			// 1.read in xml file
			Document doc = XMLUtil.getDocument();
			// 2.search contact
			Element contactElem = (Element) doc.selectSingleNode("//contact[@id='" + id + "']");
			// delete contact
			contactElem.detach();

			// 3. write in xml file
			XMLUtil.writeToXml(doc);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Contact> showAll() {
		// 1.read in xml file
		Document doc = XMLUtil.getDocument();

		// 2.create list object
		List<Contact> list = new ArrayList<Contact>();
		// 3. read in contact tag
		List<Element> conList = (List<Element>) doc.selectNodes("//contact");
		for (Element e : conList) {
			// create contact object
			Contact c = new Contact();
			c.setId(e.attributeValue("id"));
			c.setName(e.elementText("name"));
			c.setGender(e.elementText("gender"));
			c.setAge(Integer.parseInt(e.elementText("age")));
			c.setPhone(e.elementText("phone"));
			c.setEmail(e.elementText("email"));
			c.setQq(e.elementText("qq"));
			// put contact into list
			list.add(c);
		}

		return list;
	}

}
