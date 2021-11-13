import java.io.IOException;

/**
 * <h1>Main Account class</h1>
 * <p>This account class implements all the main methods and attributes
 * of any type of account, since it is the parent class of all the
 * types of account that can be created in the bank.
 * 
 * @author    Victor Hugo Montano
 * @version   1.4
 * @since     2021-07-23
 */
public abstract class Account implements ISortable, IExportList {
	
	//Attributes
	protected int accountNumber;
	protected int customerNumber;
	protected double accountInterest;
	protected double balance;
	protected int accountPoints;
	protected AccountType type;
	protected BankManager manager;
	
	//Constructor
	public Account(int accountNumber, int customerNumber) {
		this.accountNumber = accountNumber;
		this.customerNumber = customerNumber;
		balance = 0;
		accountPoints = 0;
		manager = new BankManager();
	}
	
	//Methods
	public void enterMoney(double money){
		balance += money;
		updatePoints(money);
	}
	
	public void updatePoints(double money) {
		double div = money / 10;
		accountPoints = accountPoints + (int)div;
	}
	
	public double checkBalance(){
		return balance;
	}
	
	public boolean changeClient(int newNumberClient){
		customerNumber = newNumberClient;
		return true;
	}
	
	public int getPoints(){
		return accountPoints;
	}
	
	//return number of account
	public int getId(){
		return accountNumber;
	}
	
	public int getCustomerNumber(){
		return customerNumber;
	}
	
	public AccountType getType() {
		return type;
	}
	
	public void setManager(BankManager manager) {
		this.manager = manager;
	}
	
	public String getName() throws Exception {
		return manager.getCustomerAccountName(customerNumber);
	}
	
	public String getElementString() {
		return String.valueOf(accountNumber) + " " + String.valueOf(customerNumber) + " "
				+ String.valueOf(accountInterest) + " " + String.valueOf(balance) + " "
				+ String.valueOf(accountPoints) + " " + type.name();
	}
	
	//Abstract method
	public abstract double getMonthlyReport();
	
	public String getMonthlyReportString() {
		return String.valueOf(accountNumber) + " " + String.valueOf(getMonthlyReport());
	}
	
}
