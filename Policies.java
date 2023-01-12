/*
 * Student Name: Nick Ghezzi
 * Professor Name: Howard Rosenblum
 * Due Date: April 3 2022
 * Description: Policies interface. The purpose of this interface is to provide rules for account subclasses
 */

/**
 * The purpose of this interface is to define two constant values that will be used throughout the program 
 *  @author  Nick Ghezzi
 *  @version 1.0
 *  @since	 1.6
**/

interface Policies
{
	/** The monthly Chequing account fee. **/
	public static final double CHEQUING_FEE = 13.50f;
	/** The yearly interest for savings accounts. **/
	public static final double YEARLY_INTEREST = 3.99f;
}