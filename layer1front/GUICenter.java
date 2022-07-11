package layer1front;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.List;

/* List da GUI */

public class GUICenter  {

    public Container create() throws Exception { 
    	try {
            Container container = new Container();
            BorderLayout layout = new BorderLayout();
            container.setLayout(layout);

            /* LIST */
            List list = new List();
            Context.list = list;
            list.setFont(GUI.font);
            container.add(list, BorderLayout.CENTER);

            list.addActionListener( new GUICenterEvents() ); // Double click event
            list.addMouseListener( new GUICenterEvents() );  // Mouse click event
            list.addKeyListener(new GUICenterEvents());      // Cursor evento

            return container;
		} 
    	catch (Exception e) {
			throw new Exception("Error at GUICenter.create():" + e.getMessage());
		}
    } 
} 
 