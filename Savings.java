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
 * Description: Savings class. a child of account that provides specific actions for its type
 */
public class Savings extends Account implements Policies{
	
	/**default constructor**/
	public Savings()
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
	public Savings(int accountNumber, Person person, double bal)
	{
		super(accountNumber, person, bal);
	}
	/** 
	 * This method updates the account balance. a savings account is given monthly interest based on yearly interest.
	 **/
	@Override
	public void updateBalance() {
		// calculates interest and adds it to balance
		balance = balance * ( 1 + ((YEARLY_INTEREST/100.0f) * (1.0f/12.0f)));
	}

}
