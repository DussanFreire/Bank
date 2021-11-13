import java.util.ArrayList;

/**
 * <h1>Binary search algorithm</h1>
 * <p>This class implements the binary search algorithm, it extends from 
 * Search class.
 * 
 * @author    Victor Hugo Montano
 * @version   1.1
 * @since     2021-08-02
 */
public class Binary extends Search {
	
	public Boolean getSearchList(ArrayList<ISortable> listToSearch, String nameToSearch, int idToSearch, 
			SearchBy searchType, int mid, Comparator typeComparator) throws Exception {
		if(getTypeComparator(typeComparator)) {
			return isEqual(listToSearch, searchType, mid, nameToSearch, idToSearch);
		} else {
			return isGreaterThan(listToSearch, searchType, mid, nameToSearch, idToSearch);
		}
	}
	
	public int binary(ArrayList<ISortable> listToSearch, String nameToSearch,  int idToSearch,
						SearchBy searchType, int low, int high) throws Exception {
		if (high >= low) {
            int mid = low + (high - low) / 2;
            if (getSearchList(listToSearch, nameToSearch, idToSearch, 
					searchType, mid, Comparator.EQUAL_TO)) {
            	return mid;
            }
            if (getSearchList(listToSearch, nameToSearch, idToSearch, 
					searchType, mid, Comparator.GREATER_THAN)) {
            	return binary(listToSearch, nameToSearch, idToSearch, searchType, 1, mid - 1);
            }
            return binary(listToSearch, nameToSearch, idToSearch, searchType, mid + 1, high);
        }
		throw new Exception(Messages.DOES_NOT_EXIST);
	}
	
	@Override
	public int findGeneral(ArrayList listToSearch, String nameToSearch, int idToSearch,
			SearchBy searchType) throws Exception {
		return binary(listToSearch, nameToSearch, idToSearch, searchType, 0, listToSearch.size() - 1);
	}
}
