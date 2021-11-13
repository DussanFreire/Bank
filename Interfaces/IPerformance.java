import java.util.ArrayList;

/**
 * <h1>Performance interface</h1>
 * <p>Interface to measure the performance of an algorithm
 * 
 * @author    Victor Hugo Montano
 * @version   1.0
 * @since     2021-08-19
 */
public interface IPerformance {
	
	long getTime(ArrayList<ISortable> listToMeasure) throws Exception;
	
	long getMemory(ArrayList<ISortable> listToMeasure) throws Exception;
}
