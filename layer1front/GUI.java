package layer1front;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends Frame {

	public static Font font = new Font("Monospaced", Font.PLAIN, 16);

    public GUI() throws Exception { 
    	try {
            this.setTitle("Framework gui14");
            this.setFont(font); 
            this.setLayout( new BorderLayout()); 

            this.add( new Label(""), BorderLayout.EAST  ); //filler
            this.add( new Label(""), BorderLayout.WEST  ); //filler
            this.add( new Label(""), BorderLayout.SOUTH ); //filler

            Panel panel = new Panel( new BorderLayout() );
            this.add(panel);
            
            panel.add( new GUIToolBar().create(), BorderLayout.NORTH ); // Toolbar - botoes new load save exit

            panel.add( new GUICenter().create(), BorderLayout.CENTER);  // Lista de registros

            panel.add( new GUIForm().create(), BorderLayout.EAST);      // Formulario de edicao de 1 registro.
            
            this.add(panel, BorderLayout.CENTER);
            
            this.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent){
                    System.exit(0);
                }        
            });

            this.setSize(900,600);
            this.setLocation(100, 80);
            this.setVisible(true); 
		} 
    	catch (Exception e) {
			throw new Exception("Error at GUI.constructor():" + e.getMessage() );
		}
    } 

    
    
    
    
    
    public String openFileBox() {
        String filename = "";
        String curdir = System.getProperty("user.dir");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Planilha tratamento", "csv");
        JFileChooser jfc = new JFileChooser(curdir);
        jfc.addChoosableFileFilter(filter);
        jfc.setAcceptAllFileFilterUsed(false);
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            filename = selectedFile.getName();
        }
        return(filename);
    }
    
    
    
} 
 