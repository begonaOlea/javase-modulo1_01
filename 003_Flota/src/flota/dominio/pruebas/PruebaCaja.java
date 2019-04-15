package flota.dominio.pruebas;

import flota.dominio.Caja;
import flota.dominio.excepciones.CajaException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PruebaCaja {
    
    public static void main(String[] args) {
        
        try {
            Caja c = new Caja(220);
            
            c.setPeso(-1);
            
        } catch (CajaException ex) {
            
            System.out.println("Error:" + ex.getMessage() );
            
        }
        
        
    }
    
}
