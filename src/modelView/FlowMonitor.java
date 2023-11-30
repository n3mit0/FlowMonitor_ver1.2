package modelView;

import java.io.IOException;
import view.Login;

/**
 *
 * @author julie
 */
public class FlowMonitor {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        //inicio();

        Login ventana = new Login();
        //pasar login a estadoplanta
        ventana.setVisible(true);
        
    }

}
