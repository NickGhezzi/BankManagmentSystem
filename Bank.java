/*
 * Student Name: Nick Ghezzi
 * Professor Name: Howard Rosenblum
 * Due Date: April 3 2022
 * Description: Bank class. class to create, store, read and print account objects.
 */


import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * The purpose of this class is to create, store, read and print account objects.
 *  @author  Nick Ghezzi
 *  @version 1.0
 *  @since	 1.6
 **/
public class Bank {
	private String name;
	private ArrayList<Account> accounts;
	private static Scanner input;
	private static Formatter output;

	/** 
	 * Default constructor. initializes default values
	 **/
	public Bank()
	{
		name = "";
		accounts = new ArrayList<Account>();
	}
	/** 
	 * This constructor initializes the bank name and arraylist of accounts.
	 *@param bankName
	 *		 a string that is the banks name
	 * 
	 * @param numAccounts
	 * 	      the amount of accounts in the bank. will create account array list based on this amount.
	 **/
	public Bank(String bankName, int numAccounts)
	{
		name = bankName;
		accounts = new ArrayList<Account>(numAccounts);
	}
	
	private static void printTitle(String name)
	{
		System.out.printf("                                    %20s BANK %n", name.toUpperCase());
	}
	
	private static void printStars()
	{
		System.out.print("*************************************************************************************************\n");
	}
	
	private static void printHeader()
	{
		System.out.printf(" %10s  | %20s  | %20s  | %20s  | %10s%n", "Acc Number", "Name", "Email", "Phone Number", "Balance");
	}
	

	/** 
	 * This method will create an appropriate account based on inputed choice from user. will then read info for that account
	 *@param keyboard
	 *		 scanner class used to read inputs
	 **/
	protected void readAccounts(java.util.Scanner keyboard)
	{
			//local variables for checking input
			boolean isValidInput = false;
			int accountType;

			//loop will keep asking for account type until a valid input is entered
			do {
				System.out.println("1. Chequing\n2. Savings");
				System.out.print("Enter the type of account you want to create: ");
		
				try
				{
					accountType = keyboard.nextInt();
					keyboard.nextLine();
				}
				catch(InputMismatchException ime)
				{
					accountType = 0;
					keyboard.nextLine();
				}
				
				isValidInput = accountType == 1 || accountType == 2 ? true : false;
			
				if(isValidInput == false)
					System.out.println("Invalid accound type... please re-enter");
			
			}
			while(isValidInput == false);
			
			//after valid input is made. determine what account type to add to arraylist
			if(accountType == 1)
			{
				accounts.add(new Chequing());
			}
			else if (accountType == 2)
			{
				accounts.add(new Savings());
			}
			
			//reads info for instantiated account
			accounts.get(accounts.size() - 1).readInfo(keyboard);
	}
	
	/**
	 * will run account process and updates balances 
	 */
	protected void processAccounts()
	{
		//checks if there are accounts to process
				if(accounts.isEmpty())
				{
					System.out.println("No accounts to process");
				}
				else
				{
					for (int i = 0; i < accounts.size(); i++)
					{
						accounts.get(i).updateBalance();
					}
				}
	}
	
	/** 
	 * This method will loop through all created accounts and print their info
	 **/
	protected void printAccounts()
	{
		//checks if there are accounts to print
		if(accounts.isEmpty())
		{
			System.out.println("No accounts to display");
		}
		else
		{
			//prints headers and account info
			printStars();
			printTitle(name);
			printStars();
			printHeader();
			printStars();
			for (int i = 0; i < accounts.size(); i++)
			{
				accounts.get(i).printInfo();
			}
		}
	}
	
	/**
	 * gets banks accounts
	 * @return
	 * 		banks accounts
	 */
	public ArrayList<Account> getAccounts()
	{
		return accounts;
	}
	
	/**
	 * reads data from a file and processes it into account objects
	 * @param acc
	 * 	account list to add new accounts too
	 */
	protected static void readFileData(ArrayList<Account> acc)
	{
		try {
			openInputFile();
			//loops through text file
			while(input.hasNext()){
				String type = input.next();
				//will make a chequeing account
				if(type.equals("C")) {
					int accNum = input.nextInt();
					Person person = new Person(input.next(), input.next(), input.next(), input.nextLong());
					acc.add(new Chequing(accNum, person, input.nextDouble()));
				}//will make a savings account
				else if(type.equals("S")) {
					int accNum = input.nextInt();
					Person person = new Person(input.next(), input.next(), input.next(), input.nextLong());
					acc.add(new Savings(accNum, person, input.nextDouble()));
				}
			}
		System.out.println("\n***acounts read from file***\n");
		}
		catch(FileNotFoundException fe) {
			System.out.println("File not found");
		}
		closeFile();
	}
	
	/**
	 * writes banks account data to a file
	 * @param acc
	 * 	account list to read into file from
	 */
	protected static void writeFileData(ArrayList<Account> acc)
	{
		if(acc.isEmpty() == false)
		{
			try
			{
				openOutputFile();
				for(Account account : acc)
				{			
					String info = account.toString();
					if(account instanceof Chequing){
						info = "C " + info;
					}
					else if(account instanceof Savings){
						info = "S " + info;
					}
			
					output.format("%s", info);
				}
				System.out.println("\n***all acounts written to file***\n");
			}
			catch(FileNotFoundException fe) {
				System.out.println("File not found");
			}
		}
		else
		{
			System.out.println("\nNo accounts to save\n");
		}
		closeFile();
	}
	
	private static void openInputFile() throws FileNotFoundException
	{
		try {
			input = new Scanner(Paths.get("AccountsSource.txt"));
		}
		catch(FileNotFoundException fe) {
			throw new FileNotFoundException();
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void openOutputFile() throws FileNotFoundException
	{
		try {
			output = new Formatter("AccountsOutput.txt");
		}
		catch(FileNotFoundException fe) {
			throw new FileNotFoundException();
		} 
		catch (SecurityException se) {
			System.out.println(se.getMessage());
		}
	}
	
	private static void closeFile()
	{
		if(input != null) {
			input.close();
		}
		if(output != null) {
			output.close();
		}	
	}
	
}
