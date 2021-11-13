import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * <h1>Customer class</h1>
 * <p>Customer base class that has all the attributes and the
 * list of account numbers in its name.
 * 
 * @author    Victor Hugo Montano
 * @version   1.2
 * @since     2021-07-23
 */
public class Customer implements ISortable, IExportList {
	
	//Attributes
	protected int id;
	protected String name;
	protected String lastName;
	protected String addressAndPhone;
	protected int cellPhone;
	protected ArrayList<Integer> accountsNumbers;
	
	//Construct
	public Customer(int id, String name, String lastName, String addressAndPhone, int cellPhone) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.addressAndPhone = addressAndPhone;
		this.cellPhone = cellPhone;
		accountsNumbers = new ArrayList<Integer>();
	}
	
	public void addAccount(int accountNumber) {
		accountsNumbers.add(accountNumber);
	}
	
	public int getId() {
		return id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getAddressAndPhone() {
		return addressAndPhone;
	}
	
	public int getCellPhone() {
		return cellPhone;
	}
	
	public void changeAccount(int accountNumberRemove) {
		int size = accountsNumbers.size();
		IntStream.range(0, size)
			.forEach(i -> {
				if(accountsNumbers.get(i) == accountNumberRemove) {
					accountsNumbers.remove(i);
				}
		});
	}
	
	public String getName() {
		return name;
	}
	
	public String getElementString() {
		return String.valueOf(id) + " " + name + " " + lastName + " " 
				+ addressAndPhone + " " + String.valueOf(cellPhone);
	}
}
