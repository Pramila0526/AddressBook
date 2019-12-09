package com.bridgelabz.addressbook.service;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.bridgelabz.addressbook.model.Address;
import com.bridgelabz.addressbook.model.AddressBookModel;
import com.bridgelabz.addressbook.model.Person;
import com.bridgelabz.addressbook.repository.JsonUtil;


import java.util.Scanner;

public class ExecutionOfAddressBook implements UtilAddressBook 
{

	Scanner sc=new Scanner(System.in);
	int indexOfPerson=0;
	String path="/home/admin94/Desktop/ObjectOrientedPrograms/AddressBook/AddressBook2.json"; 
	AddressBookModel model=new AddressBookModel();
	ArrayList<Person> personList=new ArrayList<Person>();
	int counter=0;
	String stateName;
	
	public static void printPersonDetails(ArrayList<Person> persons, String stateName) {
			String str = "";
			str += "Person detail\n";

			System.out.println(str);
			persons.forEach(i -> {
				if (!stateName.isEmpty() && stateName.equals(i.getAddressObj().getState())) {
					System.out.println(i.getFirstName() + " " + i.getLastName() + " " + i.getAddressObj().getAddress()
							+ " " + i.getAddressObj().getCity() + " " + i.getAddressObj().getState() + " "
							+ i.getAddressObj().getZip() + " " + i.getMobile());
				}

			});

			
		}

	
	public void readJson() 
	{
		File file=new File(path);
		if(file.exists()&&file.length()!=0)
		{
			try
			{
				model=(AddressBookModel) JsonUtil.readMapper(path, model);// TODO Auto-generated method stub
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			personList.addAll(model.getPerson());
			counter=personList.size();
		}
		
	}

	@Override
	public void createNewAddressBook() 
	{
		
			System.out.println("====New Address Book====");
			
			System.out.println("Enter the state name: ");

			stateName = sc.next();

			boolean isFoundState = false;
			for (int i = 0; i < personList.size(); i++) {
				if (personList.get(i).getAddressObj().getState().equals(stateName)) {
					isFoundState = true;
					break;
				}
			}
			if (!isFoundState) {

				System.out.println("==state is added==");
				boolean close = false;

				while (!close) {
					System.out.println("Options to select:-");
					System.out.println("1. Add a Person");
					System.out.println("2. Delete the Person");
					System.out.println("3. Edit Person");
					System.out.println("4. Sort by last name");
					System.out.println("5. Sortby Zip Code");
					System.out.println("6. Print");
					System.out.println("7. Close or Exit");
					int ch = sc.nextInt();
					switch (ch) {
					case 1:
						// add person
						addPerson();

						break;
					case 2:
						// edit person
						deletePerson();
						
						break;
					case 3:
						// delete person
						editPerson();
						break;
					case 4:
						// sort by last name

						sortByLastName();

						break;
					case 5:
						// sort by zip

						sortByZip();

						break;
					case 6:
						// print

						if (counter > 0) {
							System.out.println("Printing all records...");

							ExecutionOfAddressBook.printPersonDetails(personList, stateName);

						} else
							System.out.println("Less data to print");

						break;
					case 7:
						// close
						close = true;
						System.out.println("Closing the book");
						break;
					default:
						System.out.println("Invalid choice");
					}
				}
			} else
				System.out.println("Mobile Number exist please try again");

			System.out.println("===New Address Book===");

		}
		// TODO Auto-generated method stub
	public void openAddressBook() {
	
			System.out.println("=====Open Address Book=====");
			HashMap<String, String> map = new HashMap<>();
			for (int i = 0; i < personList.size(); i++) {
				map.put(personList.get(i).getAddressObj().getState(), personList.get(i).getAddressObj().getState());
			}
			System.out.println("states available " + map.keySet());
			System.out.println("Enter state");
			stateName = sc.next();
			boolean isFoundState = false;
			for (int i = 0; i < personList.size(); i++) {
				if (personList.get(i).getAddressObj().getState().equals(stateName)) {
					isFoundState = true;
					break;
				}
			}
			if (isFoundState) {
				System.out.println("->State is found<-");
				boolean close2 = false;

				while (!close2) {
					System.out.println(
							"Select option: \n1.add\n2.edit\n3.delete\n4.sort by last name\n5.sort by zip\n6.print\n7.quit");
					switch (sc.nextInt()) {
					case 1:
						
						addPerson(); // function to add the  person
						break;
					case 2:
						
						editPerson(); // function to edit person
						break;
					case 3:
						
						deletePerson(); // function to delete person
						break;
					case 4:
						
						sortByLastName(); // function to sort by last name

						break;
					case 5:
					

						sortByZip(); 	//function to sort by zip

						break;
					case 6:
						// printing the details
						if (counter > 0) {
							System.out.println("Printing all records...");

							ExecutionOfAddressBook.printPersonDetails(personList, stateName);

						} else
							System.out.println("There is no record to print...");

						break;
					case 7:
						// close
						close2 = true;
						System.out.println("Closing the details");
						break;
					default:
						System.out.println("Invalid option");
					}
				}

			} else
				System.out.println("Please create new state ");

			System.out.println("======Open Address Book======");

		}

		
		
	
	
	@Override
	public void addPerson() {
		System.out.println("Add Details of The Person");
		Person p=new Person();
		System.out.println("Enter the Mobile number ");
		Long mobileNumber=sc.nextLong();
		
		boolean isMobileTaken=false;
		
		for(int i=0;i<personList.size();i++)
		{
			if(personList.get(i).getMobile()==mobileNumber)
			{
				isMobileTaken=true;
				break;
			}
		}
		if(isMobileTaken)
		{
			System.out.println("This Mobile Number is already Taken");
		}
		else
		{
			p.setMobileNumber(mobileNumber);
			System.out.println("Enter the First Name");
			p.setFirstName(sc.next().toLowerCase());
			
			System.out.println("Enter the Last Name");
			p.setLastName(sc.next().toLowerCase());
			
			System.out.println("Enter the Adress Details");
			
			Address ad=new Address();
			
			System.out.println("Enter address: ");
			ad.setAddress(sc.next());
			
			System.out.println("Enter city: ");
			ad.setCity(sc.next());
			
			System.out.println("Enter State: ");
			ad.setState(sc.next());
			
			System.out.println("Enter zip: ");
			ad.setZip(sc.nextInt());
			
			p.setAddressObj(ad);

			personList.add(p);

			System.out.println();
			System.out.println("New Person is added to the details");
			counter++;
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editPerson() {
		
			if (counter > 0) 
			{
				System.out.println("Enter Persons mobile number you want to edit:");
				Long searchMobile = sc.nextLong();
				indexOfPerson = 0;
				boolean isFoundPerson = false;
				for (int i = 0; i < personList.size(); i++) {
					if (searchMobile == personList.get(i).getMobile()) {
						isFoundPerson = true;
						indexOfPerson = i;
						break;
					}
				}
				if (isFoundPerson) {

					System.out.println("Enter the new address");
					personList.get(indexOfPerson).getAddressObj().setAddress(sc.next());
					System.out.println("enter new city name");
					personList.get(indexOfPerson).getAddressObj().setCity(sc.next());
					System.out.println("enter new zip");
					personList.get(indexOfPerson).getAddressObj().setZip(sc.nextInt());

					personList.get(indexOfPerson).setMobileNumber(searchMobile);

					System.out.println();
					System.out.println("Editing the person's details completed");

				} else
					System.out.println("Person with " +searchMobile+ " number Doesn't exists in the address book");
			} else
				System.out.println("There is no record to edit the details");

		}
		// TODO Auto-generated method stub
		
	

	@Override
	public void deletePerson() {
		if (counter > 0) {
			System.out.println("Enter Persons mobile number you want to delete:");
			Long mobileNumberToSearch= sc.nextLong();
			indexOfPerson = 0;
			boolean isFoundPerson = false;
			
			for (int i = 0; i < personList.size(); i++) 
			{
				if (mobileNumberToSearch.equals(personList.get(i).getMobile())) {
					isFoundPerson = true;
					indexOfPerson = i;
					break;
				}
			}
			if (isFoundPerson) {
				personList.remove(indexOfPerson);
				counter--;
				System.out.println();
				System.out.println("Delete completed");
			} else
				System.out.println("No person found with this number");
		} else
			System.out.println("No records to delete");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortByLastName() {
		if (counter > 1) {
            System.out.println("Sorting the address book Details by last name");
            for(int i=0;i<personList.size();i++) {
            	for(int j=0;j<personList.size();i++)
            	{
            		if(personList.get(j).getLastName().compareTo(personList.get(j+1).getLastName())>0)
            		{
            			Object temp=personList.get(j);
            			personList.set(j,personList.get(j));
            			personList.set(j+1, (Person) temp);
            		}
            	}
            }
            System.out.println("Sorting of address book data by the laste name is done");
		}
		else
		{
			System.out.println("Please Enter more data to sort by the last name");
		}
	}// TODO Auto-generated method stub
		
	
	@Override
	public void sortByZip() {
		if (counter > 1) {
			System.out.println("Sorting the Address Book Details by zip");

			for (int i = 0; i < personList.size() - 1; i++) {
				for (int j = 0; j < personList.size() - i - 1; j++) {

					if (personList.get(j).getAddressObj().getZip() > personList.get(j + 1).getAddressObj().getZip()) {
					Object temp1=personList.get(j);
					personList.set(j,personList.get(j+1));
					personList.set(j+1, (Person) temp1);

				}
			}
		}// TODO Auto-generated method stub
		System.out.println("Sorting of address book data by zip code is completed");
	}
		else
		{
			System.out.println("Please Enter More data to sort by zip code");
		}
	}
	
	public void save() {
		System.out.println("-----------------------Save Address Book-----------------------");

		System.out.println("->Saving address book into json<-");
		model.setPerson(personList);
		try {
			JsonUtil.writeMapper(path, model);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("SuccessFully writing into file");

		
// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAs() throws FileNotFoundException 
	{
		System.out.println("Saving the Address Book as");
		System.out.println("Press y to continue");
		if(sc.next().charAt(0)=='y')
		{
			String pathForSaving="/home/admin94/Desktop/ObjectOrientedPrograms"
					+ "/AddressBook/AddressBookForSaving.json";
			if(new File(pathForSaving).exists())
			{
				throw new FileNotFoundException("Cannot rewrite");
			}
			else
			{
				System.out.println("Saving address book into the file");
				model.setPerson(personList);
				try {
					JsonUtil.writeMapper(pathForSaving, model);
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			
			System.out.println();
			System.out.println("SuccesFully writing into file");
		}
		// TODO Auto-generated method stub
		}	
	}

	

}
