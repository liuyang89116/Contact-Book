package com.yang.contact;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * XML operation class
 * 
 * @author yang
 *
 */
public class XMLUtil {

	/**
	 * read in xml file
	 */
	public static Document getDocument() {
		try {
			Document doc = new SAXReader().read(new File("/home/yang/Desktop/contact.xml"));
			return doc;
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * write in xml file
	 */
	public static void writeToXml(Document doc) {
		try {
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
}
