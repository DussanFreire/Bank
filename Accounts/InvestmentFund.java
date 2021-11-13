/**
 * <h1>Investment Fund Account</h1>
 * <p>Class for a investment fund account that can be instantiated, this 
 * account does have a commission so it is a commission account extension.
 * In addition to the fact that this type of account has the peculiarity 
 * that it has credit, so it can be blocked by consuming all the credit.
 * 
 * @author    Victor Hugo Montano
 * @version   1.3
 * @since     2021-07-23
 */
public class InvestmentFund extends CommissionAccount implements IWithdrawMoney{
	
	private boolean isBlocked;
	
	public InvestmentFund(int accountNumber, int customerNumber) {
		super(accountNumber, customerNumber);{
			accountInterest = Constants.ACCOUNT_INTEREST_INVEST;
			isBlocked = false;
			type = AccountType.INVEST;
		};	
	}
	
	@Override
	public String withdraw(double amount) {
		String resp = Messages.NOT_ENOUHG;
		resp = !getIsBlocked()
				? balance + Constants.CREDIT >= amount ? withdrawWithCredit(amount) : resp
				: Messages.BLOCKED;
		return resp;
	}
	
	public boolean getIsBlocked() {
		return isBlocked;
	}
	
	public String equalCredit(double amount) {
			isBlocked = true;
			return withdrawEnough(amount) + Messages.EXCEED_CREDIT;
	}
	
	public String withdrawWithCredit(double amount) {
		String resp = Messages.NOT_ENOUHG;
		resp = balance + Constants.CREDIT > amount ? withdrawEnough(amount) : equalCredit(amount);
		return resp;
	}
	
}
