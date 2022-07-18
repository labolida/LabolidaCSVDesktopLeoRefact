package layer2work;

import java.util.List;
import layer1front.Context;
import layer3data.DataManager;

/**
 * 
 * Servico de trabalho de negocio
 * entre Layer1 e Layer3
 *
 */


public class Worker {

	private static DataManager data = null;
	
	
	
	/**
	 *  Carrega a lista de registross 
	 */
	public static void loadDataOnList( String filename ) throws Exception {
		try {
			Context.list.removeAll();
			data = new DataManager(filename);
			
			// SELECT * FROM TABLE
			int numOfRecords = data.countRecords();
			for (int i=0; i<numOfRecords; i++) {
				List<String> record = data.getRecord(i) ;
				StringBuffer buff = new StringBuffer();
				for ( String field: record ) {
					buff.append( " \t " + field );
				}
				Context.list.add( new String(buff) );
			}
		} 
		catch (Exception e) {
			throw new Exception("Error at DataWorker.loadData():" + e.getMessage()); 
		}
	}
	
	
	
	
	/**
	 *  Carrega a lista de registross 
	 */
	public static void loadDataOnForm( int index ) throws Exception {
		try {
			Context.guiform.deleteAllFields();
			
			List<String> record = data.getRecord(index);
			
			int headerIndex=0;
			for ( String field: record ) {
				Context.guiform.addFields(data.getHeaderName(headerIndex), field);
				headerIndex++;
			}
			
		} 
		catch (Exception e) {
			throw new Exception("Error at DataWorker.loadData():" + e.getMessage()); 
		}
	}

	
	
	
}



