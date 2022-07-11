package layer1front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import layer2work.Worker;
import layer3data.FileManager;
/* Evento dos Botoes da barra superior */

public class GUIToolBarEvents implements ActionListener {

	
	public void actionPerformed(ActionEvent evt) {
		try {
			String command = evt.getActionCommand();
			System.out.println( command );
			
			if ( command.equals(Context.NOVO)) {
				Context.gui.setTitle(Context.NOVO);
    	        try {
    	        	String filename = Context.gui.openFileBox();
    	        	Worker.loadDataOnList(filename);
		        } 
    	        catch (Exception e) {
			        throw new Exception("GUICenter.create():" + e.getMessage());
		        }
			}
			if ( command.equals(Context.ABRIR)) {
				Context.gui.setTitle(Context.ABRIR);
			}
			if ( command.equals(Context.RELATORIO)) {
				Context.gui.setTitle(Context.RELATORIO);

			}
			if ( command.equals(Context.FICHA)) {
				Context.gui.setTitle(Context.FICHA);
			}
			if ( command.equals(Context.NOVA_DATA)) {
				Context.gui.setTitle(Context.NOVA_DATA);
			}
			if ( command.equals(Context.SAIR)) {
				Context.gui.setTitle(Context.SAIR);
                System.exit(0);
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error at GUIToolBarEvents.actionPerformed():" + e.getMessage());
		}
		
	} 

} 
 