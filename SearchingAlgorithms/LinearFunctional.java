import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * <h1>Linear algorithm with functional programming</h1>
 * <p>This class implements the linear search algorithm, it extends from 
 * Search class and use functional programming.
 * 
 * @author    Victor Hugo Montano
 * @version   1.0
 * @since     2021-08-22
 */
public class LinearFunctional extends Search {

	public ISortable findFunctional(ArrayList<ISortable> listToSearch, String nameToSearch, int idToSearch, SearchBy searchType) {
		ISortable resp;
		resp = listToSearch.stream()
	    		.filter(i -> {
					try {
						return nameToSearch.equals(i.getName());
					} catch (Exception e) {
						e.printStackTrace();
					}
					return false;
				})
	    		.findAny()
	    		.orElse(null);
	    return resp;
	}
	
	@Override
	public int findGeneral(ArrayList listToSearch, String nameToSearch, int idToSearch, SearchBy searchType)
			throws Exception {
		return findFunctional(listToSearch, nameToSearch, idToSearch, searchType).getId();
	}

}
