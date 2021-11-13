/**
 * <h1>No commission account</h1>
 * <p>This class is an abstract class that in turn is an
 * extension of the account class, it is the parent class
 * of all accounts that not have commission.
 * 
 * @author    Victor Hugo Montano
 * @version   1.2
 * @since     2021-07-27
 */
public abstract class NoCommissionAccount extends Account{

	public NoCommissionAccount(int accountNumber, int customerNumber) {
		super(accountNumber, customerNumber);
	}
	
	public double getMonthlyReport(){
		balance = balance + (balance * accountInterest);
		return balance;
	}
}
