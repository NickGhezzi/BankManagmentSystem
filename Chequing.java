/**
 * The purpose of this class is to be a child of account and provide specific actions for its type
 *  @author  Nick Ghezzi
 *  @version 1.0
 *  @since	 1.6
**/

/*
 * Student Name: Nick Ghezzi
 * Professor Name: Howard Rosenblum
 * Due Date: April 3 2022
 * Description: Chequing class. a child of account that provides specific actions for its type
 */

public class Chequing extends Account implements Policies {
	/**default constructor**/
	public Chequing()
	{
		super();
	}
	
	/**initialized constructor
	 * @param accountNumber 
	 * 		account code related to this specific account
	 * @param person
	 *		 person object that will be associated with account
	 * @param bal 
	 * 		balance of account
	 **/
	public Chequing(int accountNumber, Person person, double bal)
	{
		super(accountNumber, person, bal);
	}
	/** 
	 * This method updates the account balance. a chequing account is charged a fee
	 **/
	@Override
	public void updateBalance() {
		// applies chequing fee to account balance
		balance -= CHEQUING_FEE;
	}

}
