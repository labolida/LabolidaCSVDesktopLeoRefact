package layer1front;

import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;



public class GUIForm  {
	
	
	private List<TextField> listOfTextField = new ArrayList<TextField>();
	private List<Label> listOfLabel = new ArrayList<Label>();
	
	
	public Box left = Box.createVerticalBox();
	public Box right = Box.createVerticalBox();
	public Box top = Box.createHorizontalBox();

	
	public Container create() throws Exception {
        try {
        	Container container = new Container();
        	Context.guiform=this;

            container.setLayout( new BoxLayout(container, BoxLayout.Y_AXIS));
            container.add(new Label(" "));

            top.add(left);
            top.add(right);
        	container.add( top ) ;
        	
            Label fillersup = new Label(" ");// filler superior
            fillersup.setEnabled(false);
        	container.add( fillersup  ) ;

            Container buttons = new Container();
            buttons.setLayout( new FlowLayout(FlowLayout.CENTER, 9, 9));

            Button novo = new Button("Novo");
            novo.addActionListener( new GUIFormEvents() );
            novo.setFont( GUI.font );
            buttons.add(novo);

            Button grava = new Button("Grava");
            grava.addActionListener( new GUIFormEvents() );
            grava.setFont( GUI.font );
            buttons.add(grava);

            Button altera = new Button("Altera");
            altera.addActionListener( new GUIFormEvents() );
            altera.setFont( GUI.font );
            buttons.add(altera);

            Button exclui = new Button("Exclui");
            exclui.addActionListener( new GUIFormEvents() );
            exclui.setFont( GUI.font );
            buttons.add(exclui);

        	container.add(buttons);

            Label filler = new Label();// filler inferior
            filler.setPreferredSize(new Dimension(200,400));
            filler.setEnabled(false);
        	container.add( filler  ) ;

        	return container;
		}
        catch (Exception e) {
			throw new Exception("Error at GUIForm.constructior(): brincando con itemFactory " + e.getMessage()); // throws Exception
		}
	}
	

    public String getField( int index ) throws Exception { 
    	try {
   			return listOfTextField.get(index).getText();
		} 
    	catch (Exception e) {
			throw new Exception("Error at GUIToolBar.getField():" + e.getMessage());
		}
    }


    public void addFields( String fieldLabel , String fieldValue ) throws Exception { 
    	try {
    		Label label = new Label( fieldLabel );
    		TextField txt = new TextField( fieldValue );
    		listOfLabel.add(label);
    		listOfTextField.add( txt );
    		right.add(label);
    		right.add(txt);
    		this.right.doLayout();
    		
    		Context.gui.setSize( Context.gui.getWidth()+1, Context.gui.getHeight()+1 );
    		
    		Context.gui.repaint();
		} 
    	catch (Exception e) {
			throw new Exception("Error at GUIToolBar.create():" + e.getMessage());
		}
    } 
    

    public void deleteAllFields(  ) throws Exception { 
    	try {
    		
    		for (int x=0; x<listOfLabel.size(); x++) {
    			listOfLabel.remove(x);
    			listOfTextField.remove(x);
    		}
    		right.removeAll();
    		
		} 
    	catch (Exception e) {
			throw new Exception("Error at GUIToolBar.create():" + e.getMessage());
		}
    } 
    
    
} 




 