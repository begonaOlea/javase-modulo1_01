
package juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class OyenteBotonIniciarJuego 
implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        System.out.println("... " + e.getActionCommand());
    
        System.out.println("has hecho clic en el boton");
        
        switch(e.getActionCommand()){
            case "salir":
                    System.exit(0);
                    break;
            case "iniciar":
                 //dehabilitar el boton inicar
                JButton boton = (JButton) e.getSource();
              //  boton.setEnabled(false);
        }
        
        
    
    }
  
}
