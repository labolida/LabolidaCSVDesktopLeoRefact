package layer1front;

import java.awt.Container;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import layer3data.DataManager;


/* guarda estaticamente + publicamente todos os objetos de GUI
 * para facilitar o acesso en ocasioes
 */

public class Context {
	
	/* Menu GUI*/
    public static final String NOVO =   "Novo";
    public static final String ABRIR =  "Abrir";
    public static final String RELATORIO = "Relatorio";
    public static final String FICHA =  "Ficha";
    public static final String NOVA_DATA = "Nova Data";
    public static final String SAIR =   "Sair";

    /* Option input parameter */
    public static String fileName = null;

    /*GUI*/
	public static GUI gui = null;
	public static Frame frame = null;
	
	public static List list = null;
	

    public static GUIForm guiform = null;
	

}
