package com.yang.contact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * main program
 * 
 * @author yang
 *
 */

public class MainProgram {
	public static void main(String[] args) {
		try {
			// 1.show main menu to users
			printMenu();

			// 2.get order from user
			/*
			 * Scanner sc = new Scanner(System.in); String command = sc.next();
			 */
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			ContactOperator operator = new ContactOperatorImpl();
			// user can use it repeatedly
			while (true) {
				String command = br.readLine();

				// 3. execute different operations
				if (command.equals("1")) {
					Contact contact = new Contact();
					// Get id
					System.out.println("please input your ID:");
					String id = br.readLine();
					// Get name
					System.out.println("please input your Name:");
					String name = br.readLine();
					// Get age
					System.out.println("please input your Age:");
					int age = Integer.parseInt(br.readLine());
					// Get gender
					System.out.println("please input your gender:");
					String gender = br.readLine();
					// Get phone
					System.out.println("please input your phone number:");
					String phone = br.readLine();
					// Get email
					System.out.println("please input your email:");
					String email = br.readLine();
					// Get qq
					System.out.println("please input your QQ number:");
					String qq = br.readLine();

					// set contact
					contact.setId(id);
					contact.setName(name);
					contact.setAge(age);
					contact.setGender(gender);
					contact.setPhone(phone);
					contact.setEmail(email);
					contact.setQq(qq);

					// execute
					operator.addContact(contact);
				} else if (command.equals("2")) {
					Contact contact = new Contact();
					// Get id
					System.out.println("please input your updated ID:");
					String id = br.readLine();
					// Get name
					System.out.println("please input your updated Name:");
					String name = br.readLine();
					// Get age
					System.out.println("please input your updated Age:");
					int age = Integer.parseInt(br.readLine());
					// Get gender
					System.out.println("please input your updated gender:");
					String gender = br.readLine();
					// Get phone
					System.out.println("please input your updated phone number:");
					String phone = br.readLine();
					// Get email
					System.out.println("please input your updated email:");
					String email = br.readLine();
					// Get qq
					System.out.println("please input your updated QQ number:");
					String qq = br.readLine();

					// set contact
					contact.setId(id);
					contact.setName(name);
					contact.setAge(age);
					contact.setGender(gender);
					contact.setPhone(phone);
					contact.setEmail(email);
					contact.setQq(qq);

					// execute
					operator.updateContact(contact);
				} else if (command.equals("3")) {
					System.out.println("Please input the id you want to delete:");
					String id = br.readLine();

					operator.deleteContact(id);
				} else if (command.equals("4")) {
					List<Contact> list = operator.showAll();
					for (Contact con : list) {
						System.out.println(con);
					}
				} else if (command.equals("Q") || command.equals("q")) {
					break;
				} else {
					System.out.println("Input error! Please re-input it again.");
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);

		}
	}

	private static void printMenu() {
		System.out.println("=========================");
		System.out.println("[1]Add new contact");
		System.out.println("[2]Update contact");
		System.out.println("[3]Delete contact");
		System.out.println("[4]Show all contacts");
		System.out.println("[Q]Quit");
		System.out.println("=========================");
	}
}
