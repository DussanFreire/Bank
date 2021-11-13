import java.util.ArrayList;

/**
 * <h1>Central Bank</h1>
 * <p>This class manages everything related to the list of banks,
 * it is the main class of the project since nothing can be accessed 
 * without this class.
 * 
 * @author    Victor Hugo Montano
 * @version   1.0
 * @since     2021-08-02
 */
public class CentralBank {
	
	//Attributes
	private ArrayList<Bank> banks;
	
	public CentralBank() {
		banks = new ArrayList<Bank>();
	}
	
	public void createBank(String name, int id) {
		Bank newBank = new RegularBank(name,id);
		banks.add(newBank);
	}
	
	public ArrayList<Bank> getBankList() {
		return banks;
	}
}
