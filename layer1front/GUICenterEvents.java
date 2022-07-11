package layer1front;


import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import layer2work.Worker;

/* Evento do awt list */

public class GUICenterEvents implements ActionListener, MouseListener, KeyListener{

	public void actionPerformed(ActionEvent evt) {
		try { //double click
			String command = evt.getActionCommand();
			System.out.println( "DoubleClick on " + command );
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error at GUIToolBarEvents.actionPerformed():" + e.getMessage());
		}
	}

	
	//@Override MouseListener
	public void mouseClicked(MouseEvent e) {
		try {
			//System.out.println( e.getID() +""+ e.getSource() );
			whenClickOnListLoadForm();
		} 
		catch (Exception ex) {
			System.out.println("Error at GUICenterEvents.mouseClicked():" + ex.getMessage());
		}
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}


	//@Override KeyListener
	public void keyTyped(KeyEvent e) {
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		whenClickOnListLoadForm();
	} 

	
	// Cuando clicka no Lista entao carrega os campos do registro no formulario
	public void whenClickOnListLoadForm() {
		try {
			System.out.println("event whenClickOnListLoadForm ");
			List list = Context.list;
			for ( int x=0; x<list.getItemCount(); x++ ) {
				if ( list.isIndexSelected(x) ) {
					System.out.println("index seleccionado do list="+x);
					Worker.loadDataOnForm(x);
				}
			}
		} 
		catch (Exception ex) {
			System.out.println("Error at GUICenterEvents.whenClickOnListLoadForm():" + ex.getMessage());
		}
	}
	
} 
 