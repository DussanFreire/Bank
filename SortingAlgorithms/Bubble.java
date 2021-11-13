import java.util.ArrayList;
import java.util.Collections;

/**
 * <h1>Bubble algorithm</h1>
 * <p>This class implements the bubble sort algorithm, it extends from 
 * Sort class.
 * 
 * @author    Victor Hugo Montano
 * @version   1.3
 * @since     2021-08-02
 */
public class Bubble extends Sort{
	
	public Bubble() {
		super();
	}

	@Override
	public ArrayList getSorted(ArrayList listToSort, OrderBy typeOrder) throws Exception {
		int sizeList = listToSort.size();
        for (int i = 0; i < sizeList - 1; i++) {
        	for (int j = 0; j < sizeList - i - 1; j++) {
	            if (greaterThan(listToSort, j, typeOrder)) {
	            	Collections.swap(listToSort, j + 1, j);
	            }
        	}
        }
        return listToSort;
	}
}
