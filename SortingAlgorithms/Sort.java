import java.util.ArrayList;
import java.util.Collections;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.reflect.Method;

/**
 * <h1>Sorting class</h1>
 * <p>This sort class implements all the main methods and attributes
 * of any type of sort algorithms, since it is the parent class of all the
 * types of sort that can be created in any part of the project.
 * 
 * @author    Victor Hugo Montano
 * @version   1.1
 * @param <T>
 * @since     2021-08-02
 */
public abstract class Sort<T> implements IPerformance {

	public Sort() {}
	
	public abstract ArrayList<ISortable> getSorted(ArrayList<ISortable> listToSort, OrderBy typeOrder) throws Exception;
	
	public ArrayList<ISortable> getSortedDescending(ArrayList<ISortable> listToSort, OrderBy typeOrder) throws Exception{
		Collections.reverse(getSorted(listToSort, typeOrder));
		return listToSort;
	}
	/*
	 * This method return true if the order type is by id and return false
	 * if the type is by name, because by the moment we only have 2 types of order.
	 */
	public Boolean getTypeOrder(OrderBy typeOrder) throws Exception{
		Boolean resp = false;
		switch (typeOrder) {
			case ID:
				resp = true; break;
			case NAME:
				resp = false; break;
			default:
				throw new Exception(Messages.WRONG_ORDER);
		}
		return resp;
	}
	
	public long getTime(ArrayList<ISortable> list) throws Exception {
		long start, end;
		start = System.currentTimeMillis();
		list = getSorted(list, OrderBy.ID);
		end = System.currentTimeMillis();
		return end - start; 
	}
	
	public long getMemory(ArrayList<ISortable> list) throws Exception {
		MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
		MemoryUsage beforeHeapMemoryUsage = mbean.getHeapMemoryUsage();
		list = getSorted(list, OrderBy.ID);
		MemoryUsage afterHeapMemoryUsage = mbean.getHeapMemoryUsage();
		long consumed =  afterHeapMemoryUsage.getUsed() - beforeHeapMemoryUsage.getUsed();
		return consumed; 
	}
	
	public Boolean greaterThan(ArrayList<ISortable> listToSort, int j, OrderBy typeOrder) throws Exception {
		return getTypeOrder(typeOrder) ? listToSort.get(j).getId() > listToSort.get(j + 1).getId()
				: listToSort.get(j).getName().toLowerCase().compareTo(listToSort.get(j + 1).getName().toLowerCase()) > 0;
	}
}
