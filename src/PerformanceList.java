import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * <h1>Auxiliar performance class</h1>
 * <p>Class to help the performance measurement of the different algorithms 
 * 
 * @author    Victor Hugo Montano
 * @version   1.0
 * @since     2021-08-27
 */
public class PerformanceList {
	
	public ArrayList<Bank> createBigListBank(long size){
		CentralBank central = new CentralBank();
		IntStream.range(0, (int) size)
			.forEach(j -> central.createBank("a" + String.valueOf(j), j));
		return central.getBankList();
	}
	
}
