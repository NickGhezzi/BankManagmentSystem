/*
 * Student Name: Nick Ghezzi
 * Professor Name: Howard Rosenblum
 * Due Date: April 3 2022
 * Description: Account class. abstract class to declare and or define methods that will be used or implemented in future child classes
 */

import java.util.InputMismatchException;

/**
 * The purpose of this abstract class is to declare and or define methods that will be used or implemented in future child classes
 *  @author  Nick Ghezzi
 *  @version 1.0
 *  @since	 1.6
**/
public abstract class Account {
	private Person accHolder;
	private int accNum;
	/** The accounts balance **/
	protected double balance;
	
	/** 
	 * Default constructor. initializes default values
	 **/
	public Account() 
	{
		balance = 0;
		accHolder = new Person();
	}
	
	/** 
	 * This constructor initializes the balance based on given amount.
	 * @param accountNumber 
	 * 		account code related to this specific account
	 * @param person
	 *		 person object that will be associated with account
	 * @param bal 
	 * 		balance of account
	 **/
	public Account(int accountNumber, Person person, double bal) 
	{
		balance = bal;
		accNum = accountNumber;
		accHolder = person;
	}
	
	/** 
	 * This method asks user to input information. asks for account number and balance
	 *@param keyboard
	 *		 scanner class used to read inputs
	 * 
	 **/
	protected void readInfo(java.util.Scanner keyboard)
	{
		//ask for account number
		System.out.print("Enter Account Number: ");
		accNum = keyboard.nextInt();
		keyboard.nextLine();
		
		//reads person info
		accHolder.readInfo(keyboard);

		//ask for account balance
		boolean validAccountnum = false;
		do {
			System.out.print("Enter balance: ");
			try
			{
				balance = keyboard.nextDouble();
				keyboard.nextLine();
			}
			catch(InputMismatchException ime)
			{
				balance = -1;
				keyboard.nextLine();
			}
		
			validAccountnum = balance >= 0 ? true : false;
			
			if(validAccountnum == false)
				System.out.println("Invalid amount... Please try again");
		}while(validAccountnum == false);
		
	}
	
	/** 
	 * This method prints formatted information that a account has. account number, balance 
	 **/
	protected void printInfo()
	{
		System.out.printf(" %10d  |", accNum);
		accHolder.printInfo();
		System.out.printf(" %10.2f  %n", balance);
	}
	
	/**
	 * Overwrites toString method to return a formated string that contains all account and person information
	 * @return returns a formated string that contains all account and person information
	 */
	@Override
	public String toString()
	{
		return String.format("%d %s %s %d %.2f%n", accNum, accHolder.getFullName(), accHolder.getEmail(), accHolder.getPhoneNumber(), balance);
	}
	
	/** 
	 * This abstract method ensures the implementation in child classes
	 **/
	protected abstract void updateBalance();
}


