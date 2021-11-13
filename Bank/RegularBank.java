/**
 * <h1>Regular Bank</h1>
 * <p>Class for a regular account that can be instantiated, this is 
 * an extension from Bank class
 * 
 * @author    Victor Hugo Montano
 * @version   1.0
 * @since     2021-07-30
 */
public class RegularBank extends Bank{

	public RegularBank(String name, int id) {
		super(name, id);
		type = BankType.REGULAR;
	}
	
}
