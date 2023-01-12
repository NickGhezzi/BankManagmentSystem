/*
 * Student Name: Nick Ghezzi
 * Professor Name: Howard Rosenblum
 * Due Date: April 3 2022
 * Description: bank test class. entry point for program. creates bank and manages options entered by user. responsible for exiting program
 */

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The purpose of this class is to be the entry point for program. creates a bank object and manages options entered by user. responsible for exiting program
 *  @author  Nick Ghezzi
 *  @version 1.2
 *  @since	 1.6
 **/
public class BankTest {
	//entry point for program
		/** 
		 * This method is the entry point for program
		 * @param args
		 * 		  input
		 **/
		public static void main(String[] args) {
			//local variables
			Scanner keyboard =  new Scanner(System.in);
			String name;
			int numAccounts;
			int option = 0;
			Bank bank;
			
			//asks for bank name
			System.out.print("Enter the name of the bank: ");
			name = keyboard.nextLine();
			//asks for amount of accounts
			boolean validAccountnum = false;
			do {
				System.out.print("Enter num of account holders: ");
				try
				{
					numAccounts = keyboard.nextInt();
					keyboard.nextLine();
				}
				catch(InputMismatchException ime)
				{
					numAccounts = 0;
					keyboard.nextLine();
				}
			
				validAccountnum = numAccounts >= 1 ? true : false;
				
				if(validAccountnum == false)
					System.out.println("Invalid option... Please try again");
			}while(validAccountnum == false);
			//creates bank based on inputs
			bank = new Bank(name, numAccounts);
			
			//main loop of program
			//will ask for option every loop and process them accordingly.
			//will exit if user enters 4
			do {
				boolean isValidOption = false;
				//checks for user option input. will repeat every time the user enters invalid option
				do {
					System.out.println("1. Read Account\n2. Run monthly process\n3. Print all Accounts\n4. Read data from file\n5. Write data to file\n6. Exit");
					System.out.print("Enter your option: ");
					
					try
					{
						option = keyboard.nextInt();
						keyboard.nextLine();
					}
					catch(InputMismatchException ime)
					{
						option = 0;
						keyboard.nextLine();
					}
				
					isValidOption = option >= 1 && option <= 6 ? true : false;
				
					if(isValidOption == false)
						System.out.println("Invalid option... Please try again");
				
				}while(isValidOption == false);
				
				//performs action on bank based on user input
				if(option == 1)
				{
					bank.readAccounts(keyboard);
				}
				else if(option == 2)
				{
					bank.processAccounts();
				}
				else if(option == 3)
				{
					bank.printAccounts();
				}
				else if(option == 4)
				{
					Bank.readFileData(bank.getAccounts());
				}
				else if(option == 5)
				{
					Bank.writeFileData(bank.getAccounts());
				}
				
			}while(option != 6);
			
			//exit message for program
			keyboard.close();
			System.out.println("Goodbye... Have a nice day\nProgram by Nick Ghezzi");
		}
}
