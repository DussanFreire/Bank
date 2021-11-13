import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <h1>Bubble algorithm with functional programming</h1>
 * <p>This class implements the bubble sort algorithm, it extends from 
 * Sort class and use functional programming.
 * 
 * @author    Victor Hugo Montano
 * @version   1.0
 * @since     2021-08-22
 */
public class BubbleFunctional extends Sort {
	
	public BubbleFunctional() {
		super();
	}
	
	public ArrayList<ISortable> getSortedList(ArrayList<ISortable> listToSort, OrderBy typeOrder) throws Exception {
	    int n = listToSort.size();
		IntStream.range(0, n - 1)
	    .flatMap(i -> IntStream.range(1, n - i))
	    .forEach(j -> {
	        try {
				if (greaterThan(listToSort, j - 1, typeOrder)) {
					Collections.swap(listToSort, j, j - 1);
				    }
			} catch (Exception e) {
				e.printStackTrace();
			}
	     });
	    return listToSort;
	}

	@Override
	public ArrayList getSorted(ArrayList listToSort, OrderBy typeOrder) throws Exception {
		return getSortedList(listToSort, typeOrder);
	}
}
