package layer1front;

public class Launcher {
	
    public static void main( String args[] ) { 
    	try {
			GUI gui = new GUI();
			Context.gui=gui;
		}
    	catch (Exception e) {
			e.printStackTrace();
			System.out.println("Launcher.main(): " + e.getMessage());
		}
    	
    } 
    
}
