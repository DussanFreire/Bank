import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * <h1>Export List</h1>
 * <p>This class export every list in txt format
 * 
 * @author    Victor Hugo Montano
 * @version   1.2
 * @since     2021-08-03
 */
public class ExportList {
	
	public void exportList(ArrayList listToExport, String file, ExportBy type) throws Exception {
		exportListGeneral(listToExport, file, type);
	}
	
	public void exportListGeneral(ArrayList<IExportList> listToExport, String file, ExportBy type) throws Exception {
		FileWriter writer = new FileWriter(file + "." + type.name().toLowerCase());
        listToExport.stream()
        .forEach(j -> {
        	try {
				writer.write(exportList(j) + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			} 
        });
        writer.close();
	}
	
	public String exportList(IExportList list) {
		return list.getElementString();
	} 
}
