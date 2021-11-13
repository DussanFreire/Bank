import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * <h1>Bank Manager</h1>
 * <p>This class manages the lists of clients and accounts, processes all 
 * requests from the bank class and delegates functions to the account 
 * and client classes.
 * 
 * @author    Victor Hugo Montano
 * @version   1.3
 * @since     2021-07-28
 */
public class BankManager {
	
	//Attributes
	ManagerType type;
	private ArrayList<ISortable> customers;
	private ArrayList<ISortable> accounts;
	private Search searcher; 
	
	public BankManager() {
		this.type = ManagerType.REGULAR;
		customers = new ArrayList<ISortable>();
		accounts = new ArrayList<ISortable>();
		searcher = new Linear();
	}
	
	//create a new customer 
	public void createCustomer(int number, String name, String lastName, String addressAndPhone, int cellPhone) {
		customers.add(new Customer(number, name, lastName, addressAndPhone, cellPhone));
	}
	
	public void createAccount(Account newAccount) throws Exception {
		newAccount.setManager(this);
		accounts.add(newAccount);
		((Customer) customers.get(searcher.findPosition(customers, newAccount.getCustomerNumber())))
									.addAccount(newAccount.getId());
	}
	
	public Account getAccount(int accountNumber) throws Exception {
		return (Account) searcher.find(accounts, accountNumber);
	}
	
	public void updateAccount(Account account) throws Exception {
		accounts.set(searcher.findPosition(accounts, account.getId()), account);
	}
	
	public Customer getCustomer(int customerNumber) throws Exception {
		return (Customer) searcher.find(customers, customerNumber);
	}
	
	public void updateCustomer(Customer customer) throws Exception {
		customers.set(searcher.findPosition(customers, customer.getId()), customer);
	}
	
	//Delete account to the old client
	public void deleteAccountCustomer(int accountNumber, int newCustomerNumber) throws Exception {
		Account accountToChange = getAccount(accountNumber);
		Customer customerToChange = getCustomer(accountToChange.getCustomerNumber());
		customerToChange.changeAccount(accountNumber);
		updateCustomer(customerToChange);
	}
	
	//Add account to the new client
	public void addAccountCustomer(int accountNumber, int newCustomerNumber) throws Exception {
		Customer customerToAdd = getCustomer(newCustomerNumber);
		customerToAdd.addAccount(accountNumber);
		updateCustomer(customerToAdd);
	}
	
	public void changeClientAccount(int accountNumber, int newCustomerNumber) throws Exception {
		Account accountToChange = getAccount(accountNumber);
		deleteAccountCustomer(accountNumber, newCustomerNumber);
		addAccountCustomer(accountNumber, newCustomerNumber);
		accountToChange.changeClient(newCustomerNumber);
		updateAccount(accountToChange);
	}
	
	public String getCustomerAccountName(int customerNumber) throws Exception {
		return searcher.find(customers, customerNumber).getName();
	}
	
	public ArrayList<ISortable> getCustomerList(){
		return customers;
	}
	
	public ArrayList<ISortable> getAccountList(){
		return accounts;
	}
	
	public ArrayList<String> getMonthlyReportList(){
		ArrayList<String> listReport = new ArrayList<String>();
		accounts.stream()
			.forEach(i -> listReport.add(((Account) i).getMonthlyReportString()));
		return listReport;
	}
}
