/**
 * <h1>Commission account</h1>
 * <p>This class is an abstract class that in turn is an
 * extension of the account class, it is the parent class
 * of all accounts that have commission.
 * 
 * @author    Victor Hugo Montano
 * @version   1.2
 * @since     2021-07-27
 */
public abstract class CommissionAccount extends Account{

	public CommissionAccount(int accountNumber, int customerNumber) {
		super(accountNumber, customerNumber);
	}

	public double getMonthlyReport(){
		balance = balance + (balance * accountInterest) - Constants.COMMISSION;
		return balance;
	}
	
	public String withdrawEnough(double amount) {
		balance -= amount;
		return Messages.WITHDREW + Double.toString(amount);
	}
}
