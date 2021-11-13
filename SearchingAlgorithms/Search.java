import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;

/**
 * <h1>Searching class</h1>
 * <p>This search class implements all the main methods and attributes
 * of any type of search algorithms, since it is the parent class of all the
 * types of search that can be created in any part of the project.
 * 
 * @author    Victor Hugo Montano
 * @version   1.3
 * @since     2021-08-02
 */
public abstract class Search<T> implements IPerformance {
	
	public Search() {
	}
	
	public int findPosition(ArrayList<ISortable> listToSearch, int idToSearch) throws Exception {
		return findGeneral(listToSearch, Messages.NOTHING, idToSearch, SearchBy.ID);
	}
	
	public ISortable find(ArrayList<ISortable> listToSearch, int idToSearch) throws Exception {
		return listToSearch.get(findGeneral(listToSearch, Messages.NOTHING, idToSearch, SearchBy.ID));
	}
	
	public ISortable find(ArrayList<ISortable> listToSearch, String nameToSearch) throws Exception {
		return listToSearch.get(findGeneral(listToSearch, nameToSearch, Constants.NO_NUMBER, SearchBy.NAME));
	}
	
	public abstract int findGeneral(ArrayList<ISortable> listToSearch, String nameToSearch, 
			int idToSearch, SearchBy searchType) throws Exception;
	
	/*
	 * This method return true if the search type is by id and return false
	 * if the type is by name, because by the moment we only have 2 types of search.
	 */
	public Boolean getTypeSearch(SearchBy searchType) throws Exception{
		Boolean resp = false;
		switch (searchType) {
			case ID:
				resp = true; break;
			case NAME:
				resp = false; break;
			default:
				throw new Exception(Messages.WRONG_SEARCH);
		}
		return resp;
	}
	
	/*
	 * This method return true if the comparator type is equal to and return false
	 * if the type is by greater than, because by the moment we only have 2 types of comparator.
	 */
	public Boolean getTypeComparator(Comparator comparatorType) throws Exception {
		Boolean resp = false;
		switch (comparatorType) {
			case EQUAL_TO:
				resp = true; break;
			case GREATER_THAN:
				resp = false; break;
			default:
				throw new Exception(Messages.WRONG_COMPARATOR);
		}
		return resp;
	}
	
	/*
	 * This method return true or false if the element of a list
	 * is equal to the search element
	 */
	public Boolean isEqual(ArrayList<ISortable> listToSearch, SearchBy searchType, int index,
			String nameToSearch, int idToSearch) throws Exception {
		return getTypeSearch(searchType) ? listToSearch.get(index).getId() == idToSearch
				: listToSearch.get(index).getName().toLowerCase().equals(nameToSearch.toLowerCase());
	}
	
	/*
	 * This method return true or false if the element of a list
	 * is greater than the search element
	 */
	public Boolean isGreaterThan(ArrayList<ISortable> listToSearch, SearchBy searchType, int mid,
			String nameToSearch, int idToSearch) throws Exception {
		return getTypeSearch(searchType) ? listToSearch.get(mid).getId() > idToSearch
				: listToSearch.get(mid).getName().compareTo(nameToSearch) > 0;
	}
	
	public long getTime(ArrayList<ISortable> list) throws Exception {
		long start, end;
		int element = (int)(Math.random() % list.size());
		start = System.currentTimeMillis();
		int aux = findGeneral(list, list.get(element).getName(), list.get(element).getId(), SearchBy.NAME);
		end = System.currentTimeMillis();
		return end - start; 
	}
	
	public long getMemory(ArrayList<ISortable> list) throws Exception {
		MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
		MemoryUsage beforeHeapMemoryUsage = mbean.getHeapMemoryUsage();
		int element = (int)(Math.random() % list.size());
		int aux = findGeneral(list, list.get(element).getName(), list.get(element).getId(), SearchBy.NAME);
		MemoryMXBean mbean2 = ManagementFactory.getMemoryMXBean();
		MemoryUsage afterHeapMemoryUsage = mbean2.getHeapMemoryUsage();
		long consumed =  afterHeapMemoryUsage.getUsed() - beforeHeapMemoryUsage.getUsed();
		return consumed;
	}
}
