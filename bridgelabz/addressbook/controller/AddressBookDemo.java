package com.bridgelabz.addressbook.controller;

import java.io.IOException;
import java.util.ArrayList;


import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.addressbook.model.Address;
import com.bridgelabz.addressbook.model.AddressBookModel;
import com.bridgelabz.addressbook.model.Person;
import com.bridgelabz.addressbook.repository.JsonUtil;
import com.bridgelabz.addressbook.util.Utility2;


public class AddressBookDemo 
{
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		AddressBookModel model = new AddressBookModel();

		String path = "/home/admin94/Desktop/ObjectOrientedPrograms/AddressBook/AddressBook.json";

		ArrayList<Person> personList = new ArrayList<Person>();

		// adding person

		Person p1 = new Person();
		
		p1.setFirstName("Pramila");
		p1.setLastName("Tawari");
		
		Address address = new Address();
		address.setCity("Chembur");
		address.setState("maharashtra");
		address.setZip(400094);
		
		p1.setAddressObj(address);
		
		long mobile = 865525052;
		p1.setMobileNumber(mobile);

		Person p2 = new Person();

		
		p2.setFirstName("Sayli");
		p2.setLastName("Patil");
		
		Address address2 = new Address();
		address2.setCity("Kalyan");
		address2.setState("Maharshtra");
		address2.setZip(421306);
		
		p2.setAddressObj(address2);
		p2.setMobileNumber((long) 775533355);

		personList.add(p1);
		personList.add(p2);

		model.setPerson(personList);
		
		//Code to esit the data of person using Moile Number or
		//identified by Mobile Number
		
		System.out.println("Enter Persons mobile number you want to edit:");
		
		Long mobileNumberToSearch = (long) Utility2.longInput();
		
		
		int indexOfPerson = 0;
		boolean isPersonFound = false;
		for (int i = 0; i < personList.size(); i++)
		{
			if (mobileNumberToSearch.equals(personList.get(i).getMobile()) )
			{
				isPersonFound = true;
				indexOfPerson = i;
				System.out.println("Person Found with the " +mobileNumberToSearch+ " Number");
				break;
			}
		}

		if (isPersonFound) {
			personList.get(indexOfPerson).getAddressObj().setCity("Satara");
			personList.get(indexOfPerson).getAddressObj().setZip(400096);
			personList.get(indexOfPerson).setMobileNumber((long) 963251469);
			
			System.out.println("Editing of data is completed");
		} else if(!isPersonFound)
		{
			System.out.println("Person with " +mobileNumberToSearch+ " Number Doesn't exists");

		}
		//code to sort by last name

		for (int i = 0; i < personList.size() - 1; i++) {
			for (int j = 0; j < personList.size() - i - 1; j++) {

				if (personList.get(j).getLastName().compareTo(personList.get(j + 1).getLastName()) > 0) {
					Object temp = personList.get(j);
					personList.set(j, personList.get(j + 1));
					personList.set(j + 1, (Person) temp);

				}
			}
		}
		model.setPerson(personList);

		//code to sort by zip number

		for (int i = 0; i < personList.size() - 1; i++) {
			for (int j = 0; j < personList.size() - i - 1; j++) {

				if (personList.get(j).getAddressObj().getZip() > personList.get(j + 1).getAddressObj().getZip()) {
					Object temp = personList.get(j);
					personList.set(j, personList.get(j + 1));
					personList.set(j + 1, (Person) temp);

				}
			}
		}
		model.setPerson(personList);

		JsonUtil.writeMapper(path, model);

	}

}

/*public static void main(String args[]) throws JsonGenerationException, JsonMappingException, IOException 
{
	AddressBookModel model=new AddressBookModel();
	
	String path="/home/admin94/Desktop/ObjectOrientedPrograms/AddressBook/AddressBook2.json";
	
	ArrayList<Person> personList=new ArrayList<Person>();
	
	//For Person 1 Data
	Person p1=new Person();
	
	p1.setFirstName("Shweta");
	p1.setLastname("Shinde");
	
	Address ad1=new Address();
	
	ad1.setCity("Mumbai");
	ad1.setState("Maharashtra");
	ad1.setZip(400009);
	
	p1.setAddressObj(ad1);
	
	long mobileNumber=863266321;
	p1.setMobileNumber(mobileNumber);
	
	//For person 2 Data
	
	Person p2=new Person();
	
	p2.setFirstName("Pranali");
	p2.setLastname("Patil");
	
	Address ad2=new Address();
	
	ad2.setCity("Mumbai");
	ad2.setState("Maharashtra");
	ad2.setZip(400036);
	
	p1.setAddressObj(ad1);
	
	mobileNumber=963256143;
	p1.setMobileNumber(mobileNumber);
	
	personList.add(p1);
	personList.add(p2);
	
	model.setPerson(personList);
	
	System.out.println("Enter the Mobile Number whose data you want to edit:-");
	long mn=Utility2.longInput();
	
	boolean isPersonFound=false;
	
	int index=0;
	
	for(int i=0;i<personList.size();i++)
	{
		if(mn==personList.get(i).getMobile());
		{
			isPersonFound=true;
			index=1;
			System.out.println("Person Found with the" +mn+ "Number");
			
		}
	}
	
	if(isPersonFound)
	{
		personList.get(index).getAddressObj().setCity("Kalyan");
		personList.get(index).getAddressObj().setZip(426315);
		personList.get(index).setMobileNumber((long) 963216251);
		System.out.println("Editing of data is completed");
		}
	else
	{
		System.out.println("Person with" +mn+ "number Doesn't exists");
	}
	
	
	//cod eto sort by last name
	for(int i=0;i<personList.size()-1;i++)
	{
		for(int j=0;i<personList.size()-i-1;i++)
		{
			if(personList.get(j).getLastName().compareTo(personList.get(j+1).getLastName())>0)
			{
				Object temp=personList.get(j);
				
				personList.set(j,personList.get(j+1));
				personList.set(j+1,(Person) temp);
			}
		}
	}
	model.setPerson(personList);
	
	for(int i=0;i<personList.size()-1;i++)
	{
		for(int j=0;i<personList.size()-i-1;i++)
		{
		if(personList.get(j).getAddressObj().getZip()>personList.get(j+1).getAddressObj().getZip())
		{
			Object temp1=personList.get(j);
			personList.set(j, personList.get(j+1));
			personList.set(j+1, (Person) temp1);
		}
		}
		
}
	model.setPerson(personList);

	JsonUtil.writeMapper(path, model);
}
}*/