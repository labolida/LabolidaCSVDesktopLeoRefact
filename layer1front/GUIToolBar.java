package layer1front;

import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;

/*  Botoes da parte superior da interface grafica */

public class GUIToolBar  {
	
    public Container create() throws Exception { 
    	try {
            Container container = new Container();
            container.setLayout( new FlowLayout(0, 9, 9)  );
            
            Button b1 = new Button(Context.NOVO);
            Button b2 = new Button(Context.ABRIR);
            Button b3 = new Button(Context.RELATORIO);
            Button b4 = new Button(Context.FICHA);
            Button b5 = new Button(Context.NOVA_DATA);
            Button b6 = new Button(Context.SAIR);

            b1.setFont( GUI.font );
            b2.setFont( GUI.font );
            b3.setFont( GUI.font );
            b4.setFont( GUI.font );
            b5.setFont( GUI.font );
            b6.setFont( GUI.font );

            b1.addActionListener( new GUIToolBarEvents() );
            b2.addActionListener( new GUIToolBarEvents() );
            b3.addActionListener( new GUIToolBarEvents() );
            b4.addActionListener( new GUIToolBarEvents() );
            b5.addActionListener( new GUIToolBarEvents() );
            b6.addActionListener( new GUIToolBarEvents() );

            container.add(b1);
            container.add(b2);
            container.add(b3);
            container.add(b4);
            container.add(b5);
            container.add(b6);

            return container;
		} 
    	catch (Exception e) {
			throw new Exception("Error at GUIToolBar.create():" + e.getMessage());
		}
    } 

} 
 