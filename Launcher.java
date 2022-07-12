

import layer1front.Context;
import layer1front.GUI;

public class Launcher {
	
    public static void main( String args[] ) { 
    	try {
            if (args.length == 1) {         // nome do arquivo opcional
                Context.fileName = args[0];
            }
			GUI gui = new GUI();
			Context.gui=gui;
		}
    	catch (Exception e) {
			e.printStackTrace();
			System.out.println("Launcher.main(): " + e.getMessage());
		}
    	
    } 
    
}
