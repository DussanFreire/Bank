import java.util.ArrayList;

/**
 * <h1>Linear search algorithm</h1>
 * <p>This class implements the linear search algorithm, it extends from 
 * Search class.
 * 
 * @author    Victor Hugo Montano
 * @version   1.2
 * @since     2021-08-02
 */
public class Linear extends Search{
	
	public Boolean findInAList(ArrayList<ISortable> listToSearch,  String nameToSearch, int idToSearch,
								SearchBy searchType, int index) throws Exception {
		return isEqual(listToSearch, searchType, index, nameToSearch, idToSearch);
	}

	@Override
	public int findGeneral(ArrayList listToSearch, String nameToSearch, int idToSearch,
							SearchBy searchType) throws Exception {
		for (int index = 0; index < listToSearch.size(); index++) {
	        if (findInAList(listToSearch, nameToSearch, idToSearch, searchType, index))
	            return index;
	    }
		throw new Exception(Messages.DOES_NOT_EXIST);
	}
}
