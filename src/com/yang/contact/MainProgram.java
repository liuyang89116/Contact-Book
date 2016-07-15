package com.yang.contact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 主程序
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
			//user can use it repeatedly
			while (true) {
				String command = br.readLine();

				// 3. execute different operations
				if (command.equals("1")) {
					
					operator.addContact(contact);
				} else if (command.equals("2")) {
					operator.updateContact(contact);
				} else if (command.equals("3")) {
					operator.deleteContact(id);
				} else if (command.equals("4")) {
					operator.showAll();
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
