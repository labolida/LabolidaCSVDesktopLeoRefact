package layer1front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Evento dos Botoes da barra superior */

public class GUIFormEvents implements ActionListener {

	public void actionPerformed(ActionEvent evt) {
		try {
			String command = evt.getActionCommand();
			System.out.println( command );
			
			if ( command.toUpperCase().equals("NOVO")) {
				Context.gui.setTitle("GUIFormEvents Novo");
                //Context.crudFile.formNew();
			}

			if ( command.toUpperCase().equals("GRAVA")) {
				Context.gui.setTitle("GUIFormEvents Grava");
                //Context.crudFile.formCreate();
			}

			if ( command.toUpperCase().equals("ALTERA")) {
				Context.gui.setTitle("GUIFormEvents Altera");
                //Context.crudFile.formUpdate();
			}

			if ( command.toUpperCase().equals("EXCLUI")) {
				Context.gui.setTitle("GUIFormEvents Exclui");
                //Context.crudFile.formDelete();
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error at GUIToolBarEvents.actionPerformed():" + e.getMessage());
		}
		
	} 

} 
 