package layer3data;

import java.util.ArrayList;
import java.util.List;

public class Test_Data {

	public static void main(String[] args) {
		try {
			System.out.println( "Testando a capa 3 de accesso a datos:" );
			
			DataManager data = new DataManager("database.csv");
			
			// DELETE REGISTRO
			data.deleteRecord( 6 );
			
			
			// INSERT NEW REGISTRO
			ArrayList<String> newrecord = new ArrayList<String>(); 
			newrecord.add("Leonardo");
			newrecord.add("Martin");
			newrecord.add("Labolida");
			newrecord.add("45");
			newrecord.add("29/01/1977");
			data.insertRecord(newrecord);
			
			
			// SELECT * FROM TABLE
			int numOfRecords = data.countRecords();
			for (int i=0; i<numOfRecords; i++) {
				System.out.print("\n-LendoRegistro:"+i);
				List<String> record = data.getRecord(i) ;
				for ( String field: record ) {
					System.out.print( "  " + field );
				}
			}
			
			System.out.print("\n\n");
			
			// PERSIST
			data.save("database.test.csv");
			
			
			
			
			/*HEADER*/
			int countHeader = data.getHeaderCountFields();
			for (int h=0; h<countHeader; h++) {
				String headerName = data.getHeaderName(h);
				System.out.println( "HEADER-->" + headerName );
			}
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error at Test_Data.main():" + e.getMessage());
		}

	}

}
