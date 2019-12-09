package com.bridgelabz.addressbook.controller;

import java.io.IOException;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.addressbook.service.ExecutionOfAddressBook;

public class AddressBookManager 
{
	public static void main(String args[])
			throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		
		ExecutionOfAddressBook adbook = new ExecutionOfAddressBook();
		
		adbook.readJson();

		Scanner sc = new Scanner(System.in);

	
		boolean isExitAddressBook = false;
		
		System.out.println("Address book Manager's Page");
		while (!isExitAddressBook) {

			System.out.println("Operataions to Perform");
			System.out.println("1. New Address Book");
			System.out.println("2. Open Address Book");
			System.out.println("3. Save Address Book");
			System.out.println("4. SaveAs Address Book");
			System.out.println("5. Quit");
			System.out.println("Select Your Choice");
			
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				
				adbook.createNewAddressBook();

				break;
			case 2:
				
				adbook.openAddressBook();

				break;
			case 3:
			
				adbook.save();
				break;
			case 4:
				adbook.saveAs();
				break;
			case 5:
				
				System.out.println("Exit Address Book");
				isExitAddressBook = true;
				

				break;
			default:
				System.out.println("Invalid choice");
				break;

			}
		}

		sc.close();
	}

}

