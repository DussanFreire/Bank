import java.util.ArrayList;

/**
 * <h1>Main Bank class</h1>
 * <p>The bank class is the main class of the banks that implements all the main
 * methods and attributes of any type of bank, since it is the parent class of all the
 * bank types that can be created in the program, it interacts directly
 * with the user and delegates functions to the BankManager class, through
 * this class the accounts and customers are managed.
 * 
 * @author    Victor Hugo Montano
 * @version   1.5
 * @since     2021-07-23
 */
public abstract class Bank implements ISortable, IExportList {
	
	//Attributes
	protected String name;
	protected BankManager manager;
	protected int id;
	protected BankType type;
	
	public Bank(String name, int id) {
		this.name = name;
		manager = new BankManager();
		this.id = id;
	}
	
	//add to the customers
	public void addCustomer(int number, String name, String lastName, String addressAndPhone, int cellPhone) {
		manager.createCustomer(number, name, lastName, addressAndPhone, cellPhone);
	}
	
	public void addCustomer(Customer newCustomer) {
		manager.createCustomer(newCustomer.getId(), newCustomer.getName(), newCustomer.getLastName(), 
								newCustomer.getAddressAndPhone(), newCustomer.getCellPhone());
	}
	
	//add to the accounts
	public void addAccount(AccountType typeOfAccount, int accountNumber, int customerNumber) throws Exception {
		switch (typeOfAccount) {
			case CURRENT:
				manager.createAccount(new CurrentAccount(accountNumber,customerNumber));
				break;
			case HOUSING:
				manager.createAccount(new HousingAccount(accountNumber,customerNumber));
				break;
			case INVEST:
				manager.createAccount(new InvestmentFund(accountNumber,customerNumber));
				break;
			default:
				throw new Exception(Messages.WRONG_ACCOUNT);
		}
	}
	
	public Account getAccount(int accountNumber) throws Exception {
		return manager.getAccount(accountNumber);
	}
	
	public void updateAccount(Account account) throws Exception {
		manager.updateAccount(account);
	}
	
	public Customer getCustomer(int customerNumber) throws Exception {
		return manager.getCustomer(customerNumber);
	}
	
	public void updateCustomer(Customer customer) throws Exception {
		manager.updateCustomer(customer);
	}
	
	public void changeClientAccount(int accountNumber, int newCustomerNumber) throws Exception {
		manager.changeClientAccount(accountNumber, newCustomerNumber);
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public BankType getType() {
		return type;
	}
	
	public String getElementString() {
		return String.valueOf(id) + " " + name + " " + type.name();
	}
	
	public ArrayList<ISortable> getCustomerList(){
		return manager.getCustomerList();
	}
	
	public ArrayList<ISortable> getAccountList(){
		return manager.getAccountList();
	}
}
