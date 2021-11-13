/**
 * <h1>Housing Account</h1>
 * <p>Class for a housing account that can be instantiated, this 
 * account does not have a commission so it is a no commission account extension.
 * 
 * @author    Victor Hugo Montano
 * @version   1.3
 * @since     2021-07-23
 */
public class HousingAccount extends NoCommissionAccount{
	
	public HousingAccount(int account_number, int customer_number) {
		super(account_number, customer_number);{
			accountInterest = Constants.ACCOUNT_INTEREST_HOUSING;
			type = AccountType.HOUSING;
		};	
	}
	
}
