
package juego;

import javax.swing.JButton;

public class BotonJuego  extends JButton {
    
    private boolean hayBarco;

    public BotonJuego(boolean hayBarco) {
        this.hayBarco = hayBarco;
    }

    public boolean isHayBarco() {
        return hayBarco;
    }

    public void setHayBarco(boolean hayBarco) {
        this.hayBarco = hayBarco;
    }
    
    
    
    
}
