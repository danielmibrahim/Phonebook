package phonebook;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Phonebook 
{
	
	
	public static Person person = new Person();
	
	 public static int currentInt = 100;
	 public static Person[] people = new Person[currentInt];
	 
	 
	 
	 public static Person [] addLine(Person e) {
		  people[currentInt]=people[people.length+1];
		  currentInt++;
		 return people;
		 }
	
	public static int currentEntry = 0;
	
	public static Person [] add(Person e) {
		people[currentEntry]=e;
		currentEntry++;
		return people;
	}
	
	public static Person [] remove(Person e) {
		people[currentInt]=people[people.length-1];
		currentInt--;
		return people;
			
		
	}
	
	public static void main(String[] args) throws IOException 
	{
		 
		 
		 
		Scanner in = new Scanner (System.in);
	
		
		  System.out.println();
		  System.out.println("1: Add New Entry");
		  System.out.println("2: Remove An Entry");
		  System.out.println("3: Edit An Entry");
		  System.out.println("4: Search for An Entry");
		  System.out.println("5: Show All");
		  System.out.println("6: Exit");

		  System.out.println();
		  
		  System.out.println("Input a Selection: ");
       try {   
		  int selection = in.nextInt();
        
          switch(selection)
          {
          case 1: 
        	  addUser();
        	  main(args);

        	break;
         
          case 2:
        	  removeEntry();
        	  main(args);
        	break;
          case 3:
        	  editEntry();
        	  main(args);
        	  break;
          case 4:
        	  searchEntry();
        	  main(args);
         break;
          case 5:
        	  showAll(people);
        	  main(args);

        	  break;
        	
        	 
          case 6:
        	  System.out.println("Goodbye");
        	  System.exit(0);

        	  break;  
        	  
          default: System.out.println("\nInvalid entry. Please try again");
    	  main(args);

          }
       }
       catch (InputMismatchException e1) {
    	   System.out.println("\nInvalid entry. Please try again");
    	   main(args);
       }
	} 
	
	public static void addUser () {
		System.out.println("Enter a Contact in this format: Name, Street, City, State, Zip, Phone");
		
	try {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().trim();
		
		String[] contactArray = input.split(", ");
		
		String wholeName = contactArray[0].trim();
		String street = contactArray[1].trim();
		String city = contactArray[2].trim();
		String state = contactArray[3].trim();
		String zip = contactArray[4].trim();
		String phone = contactArray[5].trim();
		
	
		String[] fullName = wholeName.split(" ");
		String firstName = fullName[0].trim();
		String lastName = fullName[fullName.length -1].trim();
		
		Person person = new Person(firstName, lastName, street, city, state, zip, phone);
		
		Person e = person;
		
		people = add(e);
		System.out.println("\nContact Added Successfully");

	}
	catch (ArrayIndexOutOfBoundsException e1)
	{
		
		System.out.println("\nInvalid entry. Please try again");
	
	}

	
	}
	
	public static void removeEntry () {
	
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the phone number of contact you want to delete");
		String remove = s.nextLine();
		try {
		for (Person person: people) {
			 if (person.getPhone().equals(remove)) {
			 for (int i = 0; i < people.length; i++) {
			  if (people[i]==person) {
			  for (int j = i; j < people.length - 1; j++) {
			  people[j]=people[j +1];
			  }
			  }
			  }
			  System.out.println("Deleted " + person.getFirstName() + " " + person.getLastName() + ".");
			 
			  break;
			 }
	    	}
			 
		}
		catch(NullPointerException e) {
			System.out.println("Contact does not exist");
		}
	}
	
	
	
	public static void editEntry() throws IOException{
		
		Scanner s = new Scanner(System.in);
		
	
		System.out.println("Enter phone number of person you want to edit ");
		String searchPhone = s.next();
		
		try {
			
		for (Person person: people){
			 for (int i = 0; i < people.length; i++) {

			if (person.getPhone().equals(searchPhone)){
				System.out.println(person);
				System.out.println("What would you like to edit?");
				System.out.println();
				System.out.println("1: First Name");
				  System.out.println("2: Last Name");
				  System.out.println("3: City");
				  System.out.println("4: State");
				  System.out.println("5: Zip");
				  System.out.println("6: Phone");
				  System.out.println("7: Return to Main Menu");
				
				  Scanner edit = new Scanner(System.in);
					
					int editOption = edit.nextInt();
				  switch(editOption) {
				  
				  case 1: 
					  Scanner editFirst = new Scanner(System.in);
					 System.out.println("Enter new first name");
					 String editFirstName = editFirst.nextLine(); 
					
					 person.setFirstName(editFirstName);
					
					 System.out.println("Contact Updated Successfully");
					 break;
					 
				  case 2: 
					  Scanner editLast = new Scanner(System.in);
					 System.out.println("Enter new last name");
					 String editLastName = editLast.nextLine(); 
					
					 person.setLastName(editLastName);

					 System.out.println("Contact Updated Successfully");
					 break;
				
				  case 3: 
					  Scanner editNewCity = new Scanner(System.in);
					 System.out.println("Enter new city");
					 String editCity = editNewCity.nextLine(); 
					
					 person.setCity(editCity);

					 System.out.println("Contact Updated Successfully");
					 break;
					 
				  case 4: 
					  Scanner editNewState = new Scanner(System.in);
					 System.out.println("Enter new state");
					 String editState = editNewState.nextLine(); 
					
					 person.setState(editState);

					 System.out.println("Contact Updated Successfully");
					 break;
					 
				  case 5: 
					  Scanner editNewZip = new Scanner(System.in);
					 System.out.println("Enter new zip");
					 String editZip = editNewZip.nextLine(); 
					
					 person.setZip(editZip);

					 System.out.println("Contact Updated Successfully");
					 break;
					 
				  case 6: 
					  Scanner editNewPhone = new Scanner(System.in);
					 System.out.println("Enter new phone");
					 String editPhone = editNewPhone.nextLine(); 
					
					 person.setPhone(editPhone);

					 System.out.println("Contact Updated Successfully");
					 break;
					 
					case 7: 
					default: main(null);
				  }
			}
			
			else {
				System.out.println("\nInvalid entry. Please try again");
		
			}
			break;
		}
		}
		}
	
		
	
		catch (NullPointerException e1){
		
			
		}
		
	}
	
	
		

	
	
	public static void showAll (Person[] people)
	{
		for(Person person : people) {
			try {
				if (person!=null) {
					System.out.println(person);
				}
				else {
					break;
				}
			}
			catch (NullPointerException e) {
				
			}
		
		}
		
		

		
	}
	
	public static void searchEntry() throws IOException
	{
		
		  System.out.println();
		  System.out.println("1: Search by First Name");
		  System.out.println("2: Search by Last Name");
		  System.out.println("3: Search by City");
		  System.out.println("4: Search by State");
		  System.out.println("5: Search by Zip");
		  System.out.println("6: Return to Main Menu");

		  System.out.println();
		  
		  System.out.println("Input a Search Option: ");
		
		Scanner search = new Scanner(System.in);
		
		int searchOption = search.nextInt();
		switch(searchOption)
	
		{
		case 1:
			System.out.println("Enter First Name");
			String searchFirst = search.next();
		
			try {
				 for (int i = 0; i < people.length; i++) {
			for (Person person: people){
				

				if (person.getFirstName().equalsIgnoreCase(searchFirst)){
					System.out.println(person);	

				}

			

				 }
			
				
	
			}
		break;	
		}
			
		
			catch (NullPointerException e1){
				
			}
			searchEntry();

			break;
		
		
		case 2:
			System.out.println("Enter Last Name");
			String searchLast = search.next();
		
			try {
				 for (int i = 0; i < people.length; i++) {
			for (Person person: people){
			
				if (person.getLastName().equalsIgnoreCase(searchLast)){
					System.out.println(person);
				}
				
			}
		}
					break;

			}
			
		
			catch (NullPointerException e1){
				
			
			}
			searchEntry();

			break;
	
		case 3:
			System.out.println("Enter City");
			String searchCity = search.next();
		
			try {
				for (int i = 0; i < people.length; i++) {
			for (Person person: people){
				 

				if (person.getCity().equalsIgnoreCase(searchCity)){
					System.out.println(person);

					}
				 }
			}
		
					break;

			}
		
			catch (NullPointerException e1){
							}
			searchEntry();

			break;
		
		case 4:
			System.out.println("Enter State e.g. MO");
			String searchState = search.next();
		
			try {
				 for (int i = 0; i < people.length; i++) {

			for (Person person: people){
			
				if (person.getState().equalsIgnoreCase(searchState)){
					System.out.println(person);

				}
			}
				break;
			}
		}
			
		
			catch (NullPointerException e1){
				
			
			}
			searchEntry();

			break;
			
		case 5:
			System.out.println("Enter Zip");
			String searchZip = search.next();
		
			try {
				 for (int i = 0; i < people.length; i++) {

			for (Person person: people){
			
				if (person.getZip().equalsIgnoreCase(searchZip)){
					System.out.println(person);

				}
			}
			}
					break;

		}
			
		
			catch (NullPointerException e1){
				
				
			}
			searchEntry();

			break;
			
			
		case 6: 
			default: main(null);
			
		
	}
}
	
}


