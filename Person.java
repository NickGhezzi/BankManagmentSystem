/*
 * Student Name: Nick Ghezzi
 * Professor Name: Howard Rosenblum
 * Due Date: April 3 2022
 * Description: Person class, stores data related to a person
 */

/**
 * The purpose of this class is to read user input, store, and print information related to a person. is the parent class to student
 *  @author  Nick Ghezzi
 *  @version 1.4
 *  @since	 1.6
 **/
public class Person {
	//member variables
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNumber;
	/** 
	 * Default constructor
	 **/
	public Person()
	{
	}
	
	/** 
	 * This constructor initializes the all attributes of a person.
	 *@param fname
	 *		 a string that is the persons first name
	 *@param lname
	 *		 a string that is the persons last name
	 *@param emailAddress
	 *		 a string that is the persons email address
	 *@param phone
	 *		 a string that is the persons phone number
	 **/
	public Person(String fname, String lname, String emailAddress, long phone)
	{
		firstName = fname;
		lastName = lname;
		email = emailAddress;
		phoneNumber = phone;
	}
	
	/** 
	 * This method asks user to input information. asks for full name, email, and phone number
	 *@param keyboard
	 *		 scanner class used to read inputs
	 * 
	 **/
	protected void readInfo(java.util.Scanner keyboard)
	{
		System.out.print("Enter first name: ");
		firstName = keyboard.nextLine();
		
		System.out.print("Enter last name: ");
		lastName = keyboard.nextLine();
		
		System.out.print("Enter email Id: ");
		email = keyboard.nextLine();

		System.out.print("Enter phone number: ");
		phoneNumber = keyboard.nextLong();
		keyboard.nextLine();
	}
	
	/** 
	 * This method prints formatted information that a person has. full name, email, and phone number
	 **/
	protected void printInfo()
	{
		//print full name, email, and phone
		//will be second thing to print out
		System.out.printf(" %20s  | %20s  | %20d  |", firstName + " " + lastName, email, phoneNumber);
	}

	/**
	 * gives the current, formatted, first name and last name of the person object.
	 * @return formatted string of first name and last name
	 */
	public String getFullName()
	{
		return firstName + " " + lastName;
	}
	
	/**
	 * gives the current email of the person object.
	 * @return string email
	 */
	public String getEmail()
	{
		return email;
	}
	
	/**
	 * gives the current phone number of the person object.
	 * @return long phone number
	 */
	public long getPhoneNumber()
	{
		return phoneNumber;
	}
	
}
