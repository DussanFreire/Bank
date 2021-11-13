import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.List;

/**
 * <h1>Main</h1>
 * <p>Main method that interacts with the person and works as a menu
 * 
 * @author    Victor Hugo Montano
 * @version   1.6
 * @since     2021-07-23
 */
public class Main {
	
	//Attributes to read from console
	static Scanner sn = new Scanner(System.in);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Binary searchBinary = new Binary();
	static Linear searchLinear = new Linear();
	static Bubble sortBubble = new Bubble();
	static Quicksort sortQuick = new Quicksort();
	static BubbleFunctional sortBinaryFunctional = new BubbleFunctional();
	static LinearFunctional searchLinearFunctional = new LinearFunctional();
	static CentralBank centralBank = new CentralBank();
	static ArrayList<Bank> banks = new ArrayList<Bank>();
	static ArrayList<Customer> customers = new ArrayList<Customer>();
	static ArrayList<Account> accounts = new ArrayList<Account>();
	static ExportList export = new ExportList();
	static int idRead, option;
	static Bank bank;
	static Account account;
	static Customer customer;
	static String aux, nameRead;
	static PerformanceList performanceList = new PerformanceList();
	
	//Method to print a list in console
	public static void showList(ArrayList arrayList) {
		int size = arrayList.size();
		IntStream.range(0, size)
			.forEach(i -> System.out.println(((IExportList) arrayList.get(i)).getElementString()));
	}
	
	//Method to request account type
	public static AccountType requestAccountType() throws Exception {
		System.out.println("Choose the type of account");
		int i = 1; AccountType typeSelected;
		for (AccountType type : AccountType.values()) { 
		    System.out.println(i + ". " + type + "\n");i++;
		}
		switch (sn.nextInt()) {
			case 1:
				typeSelected = AccountType.CURRENT; break;
			case 2:
				typeSelected = AccountType.HOUSING; break;
			case 3:
				typeSelected = AccountType.INVEST; break;
			default:
				throw new Exception(Messages.WRONG_ACCOUNT);
		}
		return typeSelected;
	}
	
	//Method to request customer data
	public static Customer requestCustomerData() throws IOException {
		int id, cellPhone;
		String name, lastName, addressAndPhone;
		System.out.println("Enter the id of the new customer:\n");
		id = sn.nextInt();
		System.out.println("Enter the name of the new customer:\n");
		name = br.readLine();
		System.out.println("Enter the last name of the new customer:\n");
		lastName = br.readLine();
		System.out.println("Enter the address and phone of the new customer:\n");
		addressAndPhone = br.readLine();
		System.out.println("Enter the cell phone of the new customer:\n");
		cellPhone = sn.nextInt();
		return new Customer(id, name, lastName, addressAndPhone, cellPhone);
	}
	
	//Method to request bank to update
	public static Bank requestBank() throws Exception {
		int id;
		System.out.println("Enter the id of the bank \n");
		id = sn.nextInt();
        return (Bank) searchLinear.find(centralBank.getBankList(), id);
	}
	
	//Method to choose sort algorithm
	public static void selectSortAlgorithm(OrderBy order, ArrayList list) throws Exception {
		System.out.println("Choose the algorithm to sort");
		int i = 1;
		for (SortAlgorithm type : SortAlgorithm.values()) { 
		    System.out.println(i + ". " + type); i++;
		}
		switch (sn.nextInt()) {
			case 1:
				list = sortBubble.getSorted(list, order);
				break;
			case 2:
				list = sortQuick.getSorted(list, order);
			default:
				throw new Exception(MenuOptions.WRONG_OPTION);
		}
	}

	//Method to choose search algorithm
	public static void selectSearchAlgorithm(SearchBy search, ArrayList list) throws Exception {
		ISortable resp;
		System.out.println("Choose the algorithm to search");
		int i = 1;
		for (SearchAlgorithm type : SearchAlgorithm.values()) { 
		    System.out.println(i + ". " + type); i++;
		}
		switch (sn.nextInt()) {
			case 1:
				if(search == SearchBy.ID) {
					System.out.println("Write the id to be searched: \n");
					option = sn.nextInt();
					resp = searchBinary(list, option);
				} else {
					System.out.println("Write the name to be searched: \n");
					aux = br.readLine();
					resp = searchBinary(list, aux);
				}
				break;
			case 2:
				if(search == SearchBy.ID) {
					System.out.println("Write the id to be searched: \n");
					option = sn.nextInt();
					resp = searchLinear.find(list, option);
				} else {
					System.out.println("Write the name to be searched: \n");
					aux = br.readLine();
					resp = searchLinear.find(list, aux);
				}
				break;
			default:
				throw new Exception(MenuOptions.WRONG_OPTION);
		}
		System.out.println("Item found. \n");
	}
	
	//Search Binary by Id
	public static ISortable searchBinary(ArrayList list, int id) throws Exception {
		list = sortBubble.getSorted(list, OrderBy.ID);
		return searchBinary.find(banks, id);
	}
	
	//Search Binary by name
	public static ISortable searchBinary(ArrayList list, String name) throws Exception {
		list = sortBubble.getSorted(list, OrderBy.NAME);
		return searchBinary.find(banks, name);
	}
	
	//Method to show different lists
	public static void showLists() throws Exception {
		System.out.println("Choose what type list do want to show");
		System.out.println("1. Show bank list");
		System.out.println("2. Show customer list");
		System.out.println("3. Show account list");
		switch (sn.nextInt()) {
			case 1:
				System.out.println("Bank list");
				banks = centralBank.getBankList();
				showList(centralBank.getBankList());
				break;
			case 2:
				bank = requestBank();
	            showList(bank.getCustomerList());
	            break;
			case 3:
				bank = requestBank();
	        	showList(bank.getAccountList());
	        	break;
			default:
				throw new Exception(MenuOptions.WRONG_OPTION);
		}
	}
	
	//Method to export a lists
	public static void exportList() throws Exception {
		ExportBy type = selectTypeExport();
		System.out.println("Choose what type list do want to export");
		System.out.println("1. Export bank list");
		System.out.println("2. Export account list");
		System.out.println("3. Export customer list");
		switch (sn.nextInt()) {
			case 1:
				System.out.println("Exported bank list");
				export.exportList(banks, NamesFiles.EXPORT_BANKS, type);
				break;
			case 2:
				bank = requestBank();
				export.exportList(bank.getAccountList(), NamesFiles.EXPORT_ACCOUNTS, type);
				System.out.println("Exported account list");
	            break;
			case 3:
				bank = requestBank();
				export.exportList(bank.getCustomerList(), NamesFiles.EXPORT_CUSTOMERS, type);
				System.out.println("Exported customer list");
	        	break;
			default:
				throw new Exception(MenuOptions.WRONG_OPTION);
		}
	}
	
	//Method to select type of extencion of file to export
	public static ExportBy selectTypeExport() throws Exception {
		System.out.println("Choose export type");
		int i = 1; ExportBy resp;
		for (ExportBy type : ExportBy.values()) { 
		    System.out.println(i + ". " + type); i++;
		}
		switch (sn.nextInt()) {
			case 1:
				resp = ExportBy.CSV;
				break;
			case 2:
				resp = ExportBy.TXT;
	            break;
			default:
				throw new Exception(MenuOptions.WRONG_OPTION);
		}
		return resp;
	}
	
	//Method to request type to sort
	public static OrderBy getTypeSort() throws Exception {
		System.out.println("Choose sort type");
		int i = 1; OrderBy resp;
		for (OrderBy type : OrderBy.values()) { 
		    System.out.println(i + ". " + type); i++;
		}
		switch (sn.nextInt()) {
			case 1:
				resp = OrderBy.ID; break;
			case 2:
				resp = OrderBy.NAME; break;
			default:
				throw new Exception(MenuOptions.WRONG_OPTION);
		}
		return resp;
	}
	
	//Method to request type to search
	public static SearchBy getTypeSearch() throws Exception {
		System.out.println("Choose search type");
		int i = 1; SearchBy resp;
		for (SearchBy type : SearchBy.values()) { 
		    System.out.println(i + ". " + type); i++;
		}
		switch (sn.nextInt()) {
			case 1:
				resp = SearchBy.ID; 
				System.out.println("Write the id to be searched: \n");
				idRead = sn.nextInt();
				break;
			case 2:
				resp = SearchBy.NAME;
				System.out.println("Write the name to be searched: \n");
				nameRead = br.readLine();
				break;
			default:
				throw new Exception(MenuOptions.WRONG_OPTION);
		}
		return resp;
	}
	
	//Method to sort lists ascending
	public static void sortListAscending() throws Exception {
		System.out.println("Choose what type list do want to sort");
		System.out.println("1. Sort bank list");
		System.out.println("2. Sort customer list");
		System.out.println("3. Sort account list");
		switch (sn.nextInt()) {
			case 1:
				banks = centralBank.getBankList();
				banks = sortBubble.getSorted(banks, getTypeSort());
                showList(banks);
				break;
			case 2:
				bank = requestBank();
				customers = sortBubble.getSorted(bank.getCustomerList(), getTypeSort());
                showList(bank.getCustomerList());
	            break;
			case 3:
				bank = requestBank();
				accounts = sortBubble.getSorted(bank.getAccountList(), getTypeSort());
                showList(bank.getAccountList());
	        	break;
			default:
				throw new Exception(MenuOptions.WRONG_OPTION);
		}
	}
	
	//Method to sort lists Descending
	public static void sortListDescending() throws Exception {
		System.out.println("Choose what type list do want to sort");
		System.out.println("1. Sort bank list");
		System.out.println("2. Sort customer list");
		System.out.println("3. Sort account list");
		switch (sn.nextInt()) {
			case 1:
				banks = centralBank.getBankList();
				banks = sortBubble.getSortedDescending(banks, getTypeSort());
                showList(banks);
				break;
			case 2:
				bank = requestBank();
				customers = sortBubble.getSortedDescending(bank.getCustomerList(), getTypeSort());
                showList(bank.getCustomerList());
	            break;
			case 3:
				bank = requestBank();
				accounts = sortBubble.getSortedDescending(bank.getAccountList(), getTypeSort());
                showList(bank.getAccountList());
	        	break;
			default:
				throw new Exception(MenuOptions.WRONG_OPTION);
		}
	}
	
	//Method to sort lists
	public static void sortList() throws Exception {
		System.out.println("Choose if you want to sort the list in ascending or descending order");
		System.out.println("1. Ascending");
		System.out.println("2. Descending");
		switch (sn.nextInt()) {
			case 1:
				sortListAscending();
				break;
			case 2:
				sortListDescending();
	            break;
			default:
				throw new Exception(MenuOptions.WRONG_OPTION);
		}
	}
	
	//Method to sort lists
	public static void searchList() throws Exception {
		OrderBy order;
		System.out.println("Choose what type list do want to search");
		System.out.println("1. Search bank list");
		System.out.println("2. Search customer list");
		System.out.println("3. Search account list");
		option = sn.nextInt();
		SearchBy search = getTypeSearch();
		switch (option) {
			case 1:
				banks = centralBank.getBankList();
				if(search == SearchBy.ID) {
					bank = (Bank) searchLinear.find(banks, idRead);
				} else {
					bank = (Bank) searchLinear.find(banks, nameRead);
				}
				System.out.println("Item found:");
				System.out.println(bank.getElementString());
				break;
			case 2:
				bank = requestBank();
				if(search == SearchBy.ID) {
					customer = (Customer) searchLinear.find(bank.getCustomerList(), idRead);
				} else {
					customer = (Customer) searchLinear.find(bank.getCustomerList(), nameRead);
				}
				System.out.println("Item found:");
				System.out.println(customer.getElementString());
	            break;
			case 3:
				bank = requestBank();
				if(search == SearchBy.ID) {
					account = (Account) searchLinear.find(bank.getAccountList(), idRead);
				} else {
					account = (Account) searchLinear.find(bank.getAccountList(), nameRead);
				}
				System.out.println("Item found:");
				System.out.println(account.getElementString());
	        	break;
			default:
				throw new Exception(MenuOptions.WRONG_OPTION);
		}
	}
	
	//Method to see performance of algorithms
	public static void showPerformance() throws Exception {
		System.out.println("Performance of the bubble sort method");
		System.out.println("Time to sort (milliseconds): " + sortBubble.getTime(performanceList.createBigListBank(10000)));
		System.out.println("Total consumed Memory: " + sortBubble.getMemory(performanceList.createBigListBank(10000)));
		System.out.println("Performance of the quick sort method \n");
		System.out.println("Time to sort (milliseconds): " + sortQuick.getTime(performanceList.createBigListBank(10000)));
		System.out.println("Total consumed Memory: " + sortQuick.getMemory(performanceList.createBigListBank(10000)));
		System.out.println("Performance of the linear search method \n");
		System.out.println("Time to search (milliseconds): " + searchLinear.getTime(performanceList.createBigListBank(10000)));
		System.out.println("Total consumed Memory: " + searchLinear.getMemory(performanceList.createBigListBank(10000)));
		System.out.println("Performance of the binary search method \n");
		System.out.println("Time to search (milliseconds): " + searchBinary.getTime(performanceList.createBigListBank(10000)));
		System.out.println("Total consumed Memory: " + searchBinary.getMemory(performanceList.createBigListBank(10000)));
	}
	
	//Method to compare performance of algorithms with functional programming and not
	public static void comparePerformance() throws Exception {
		System.out.println("Performance of the bubble sort method");
		System.out.println("Time to sort (milliseconds): " + sortBubble.getTime(performanceList.createBigListBank(10000)));
		System.out.println("Total consumed Memory: " + sortBubble.getMemory(performanceList.createBigListBank(10000)));
		System.out.println("Performance of the bubble sort method with functional programming");
		System.out.println("Time to sort (milliseconds): " + sortBinaryFunctional.getTime(performanceList.createBigListBank(10000)));
		System.out.println("Total consumed Memory: " + sortBinaryFunctional.getMemory(performanceList.createBigListBank(10000)));
		System.out.println("\nPerformance of the linear search method ");
		System.out.println("Time to search (milliseconds): " + searchLinear.getTime(performanceList.createBigListBank(10000)));
		System.out.println("Total consumed Memory: " + searchLinear.getMemory(performanceList.createBigListBank(10000)));
		System.out.println("Performance of the linear search method witn functional programming");
		System.out.println("Time to search (milliseconds): " + searchLinearFunctional.getTime(performanceList.createBigListBank(10000)));
		System.out.println("Total consumed Memory: " + searchLinearFunctional.getMemory(performanceList.createBigListBank(10000)));
	}
	
	public static void main(String[] args) throws Exception {
		
		//Add banks
		centralBank.createBank("BNB", 102);
		centralBank.createBank("Assure", 101);
		centralBank.createBank("Mercantil", 105);
		
		//Add customers and accounts
		banks = centralBank.getBankList();
		bank = (Bank) searchLinear.find(banks, 101);
		bank.addCustomer(new Customer(129, "Victor", "Montano", "Shakeaspeare 1010, 4503455", 79794464));
		bank.addCustomer(new Customer(67, "Sergio", "Villafan", "America 206, 4864735", 67483923));
		bank.addAccount(AccountType.CURRENT, 211, 129);
		bank.addAccount(AccountType.HOUSING, 202, 129);
		
		bank = (Bank) searchLinear.find(banks, 102);
		bank.addCustomer(new Customer(94, "Jhonatan", "Montano", "Heroinas 403, 4584921", 62934202));
		bank.addAccount(AccountType.INVEST, 205, 94);
		
		bank = (Bank) searchLinear.find(banks, 105);
		bank.addCustomer(new Customer(127, "Daniel", "Gumucio", "Circunvalacion 602, 45465434", 732832923));
		bank.addAccount(AccountType.INVEST, 210, 127);
		
		 boolean exit = false;
	     int option, id = 0;
	     String name;
	     while (!exit) {
	    	 System.out.println("Welcome to the central bank of Bolivia");
	         System.out.println("1. " + MenuOptions.CREATE_BANK);
	         System.out.println("2. " + MenuOptions.CREATE_ACCOUNT);
	         System.out.println("3. " + MenuOptions.CREATE_CUSTOMER);
	         System.out.println("4. Show a list");
	         System.out.println("5. Export a list");
	         System.out.println("6. See performance of algorithms");
	         System.out.println("7. Sort a list");
	         System.out.println("8. Search a list");
	         System.out.println("9. Compare algorithms with functional programming and not");
	         System.out.println("10. Exit");
	
	            try {
	                System.out.println("Write one of the options");
	                option = sn.nextInt();
	                switch (option) {
	                    case 1:
	                    	System.out.println("Enter the id of the new bank: \n");
	                    	id = sn.nextInt();
	                    	System.out.println("Enter the name of the new bank: \n");
	                    	name = br.readLine();
	                    	centralBank.createBank(name, id);
	                    	System.out.println("The new bank was created \n");
	                        break;
	                    case 2:
	                        bank = requestBank();
	                        System.out.println("Enter the customer id of the new account:\n");
	                        id = sn.nextInt();
	                        customer = bank.getCustomer(id);
	                        bank.addAccount(requestAccountType(), option, id);
	                        System.out.println("The new customer was added:\n");
	                        break;
	                    case 3:
	                        banks = centralBank.getBankList();
	                        System.out.println("Enter the name of the bank where the customer will be created \n");
	                        bank = requestBank();
	                        bank.addCustomer(requestCustomerData());
	                        System.out.println("The new customer was added\n");
	                        break;
	                    case 4:
	                    	showLists();
	                        break;
	                    case 5:
	                    	exportList();
	                    	break;
	                    case 6:
	                    	showPerformance();
	                        break;
	                    case 7:
	                    	sortList();
	                        break;
	                    case 8:
	                    	searchList();
	                        break;
	                    case 9:
	                    	comparePerformance();
	                        break;
	                    case 10:
	                    	exit = true;
	                        break;
	                    default:
	                        System.out.println("Only numbers between 1 and 10");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("You must insert a number");
	                sn.next();
	            }
	        }
	}
}
