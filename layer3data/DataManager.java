package layer3data;

import java.util.ArrayList;
import java.util.List;

/**
 * Servico de gestao de dados. 
 * Nao pode ser static!
 * O records deve ser private!
 */


public class DataManager {

	
	private ArrayList<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
	
	private ArrayList<String> header = new ArrayList<String>();
	
	
	/**
	 * CONSTRUCTOR 
	 */
	public DataManager(String filename ) throws Exception {
		try {
			String content = new String(   FileManager.read(filename)   );
			
			String lines[] = content.split("\n");
			for (int x=0; x<lines.length; x++) {
				
				String fields[] = lines[x].split(":");
				ArrayList<String> record = new ArrayList<String>();
				
				for (int f=0; f<fields.length; f++) {
					record.add( fields[f] );
				}
				records.add(record);
			}
			/*header*/
			header = records.get(0) ;
			records.remove(0);
		}
		catch (Exception e) {
			throw new Exception("Error at DataManager.constructor():" + e.getMessage());
		}
	}

	/**
	 * contador de total de registros 
	 */
	public int countRecords( )  throws Exception  {
		try {
			return records.size();
		} 
		catch (Exception e) {
			throw new Exception("Error at DataManager.countRecords():" + e.getMessage()); 
		}
	}
	
	
	/**
	 * Get 1 registro 
	 */
	public ArrayList<String> getRecord( int index )  throws Exception  {
		try {
			return records.get(index);
		} 
		catch (Exception e) {
			throw new Exception("Error at DataManager.getRecord():" + e.getMessage()); 
		}
	}

	
	/**
	 * DELETE registro 
	 */
	public void deleteRecord( int index )  throws Exception  {
		try {
			records.remove(index);
		} 
		catch (Exception e) {
			throw new Exception("Error at DataManager.deleteRecord():" + e.getMessage()); 
		}
	}
	
	
	/**
	 * INSERT registro 
	 */
	public void insertRecord( ArrayList<String> record )  throws Exception  {
		try {
			records.add(record);
		} 
		catch (Exception e) {
			throw new Exception("Error at DataManager.deleteRecord():" + e.getMessage()); 
		}
	}
	
	
	/**
	 * INSERT registro 
	 */
	public void save( String filename )  throws Exception  {
		try {
			StringBuffer buff = new StringBuffer();
			for (String headerFields : header ) {
				buff.append(headerFields);
				buff.append(":");				
			}
			buff.append("\n");
			
			for (List<String> record : records ) {
				for(String field : record) {
					buff.append(field);
					buff.append(":");
				}
				buff.append("\n");
			}
			FileManager.write(filename, new String(buff), false);
		} 
		catch (Exception e) {
			throw new Exception("Error at DataManager.deleteRecord():" + e.getMessage()); 
		}
	}
	
	
	
	
	/*HEADER*/
	public int getHeaderCountFields( )  throws Exception  {
		try {
			return header.size();
		} 
		catch (Exception e) {
			throw new Exception("Error at DataManager.getHeaderCountFields():" + e.getMessage()); 
		}
	}
	
	public String getHeaderName( int index )  throws Exception  {
		try {
			return header.get(index) ;
		} 
		catch (Exception e) {
			throw new Exception("Error at DataManager.getHeaderName():" + e.getMessage()); 
		}
	}
	
	
	
}

