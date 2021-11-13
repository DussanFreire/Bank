import java.util.ArrayList;
import java.util.Collections;

/**
 * <h1>QuickSort algorithm</h1>
 * <p>This class implements the quick sort algorithm, it extends from 
 * Sort class.
 * 
 * @author    Victor Hugo Montano
 * @version   1.3
 * @since     2021-08-02
 */
public class Quicksort extends Sort{
	
	public Quicksort() {
		super();
	}
	
	public Boolean getSortedList(ArrayList<ISortable> listToSort, int j, int end, OrderBy typeOrder) throws Exception {
		return getTypeOrder(typeOrder) ? listToSort.get(j).getId() <= listToSort.get(end).getId()
				: listToSort.get(j).getName().toLowerCase().compareTo(listToSort.get(end).getName().toLowerCase()) <= 0;
	}
	
	public int partition(ArrayList<ISortable> listToSort, int begin, int end, OrderBy typeOrder) throws Exception {
		int i = begin - 1;
		for(int j = begin; j < end; j++) {
			if(getSortedList(listToSort, begin, end, typeOrder)) {
				i++;
				Collections.swap(listToSort, i, j);
			}
		}
		Collections.swap(listToSort, i + 1, end);
		return i + 1;
	}
	
	public void quickSort(ArrayList<ISortable> listToSort, int begin, int end, OrderBy typeOrder) throws Exception {
		if (begin < end) {
			int partitionIndex = partition(listToSort, begin, end, typeOrder);
			quickSort(listToSort, begin, partitionIndex - 1, typeOrder);
			quickSort(listToSort, partitionIndex + 1, end, typeOrder);
		}
	}

	@Override
	public ArrayList getSorted(ArrayList listToSort, OrderBy typeOrder) throws Exception {
		int begin = listToSort.size() - 1, end = 0;
		quickSort(listToSort, begin, end, typeOrder);
		return listToSort;
	}
}
