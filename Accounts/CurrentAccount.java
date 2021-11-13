/**
 * <h1>Current account</h1>
 * <p>Class for a current account that can be instantiated, this 
 * account does have a commission so it is a commission account extension.
 * 
 * @author    Victor Hugo Montano
 * @version   1.3
 * @since     2021-07-23
 */
public class CurrentAccount extends CommissionAccount implements IWithdrawMoney{
	
	public CurrentAccount(int accountNumber, int customerNumber) {
		super(accountNumber, customerNumber);{
			accountInterest = Constants.ACCOUNT_INTEREST_CURRENT;
			type = AccountType.CURRENT;
		};	
	}
	
	public String withdraw(double amount) {
		String resp = Messages.NOT_ENOUHG;
		resp = balance >= amount ? withdrawEnough(amount) : resp;
		return resp;
	}

}
