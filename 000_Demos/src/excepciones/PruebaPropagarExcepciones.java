
package excepciones;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author begonaolea
 */
public class PruebaPropagarExcepciones {
    public static void main(String[] args) {
        
        try {
            InformeFlota f = new InformeFlota();
            //crear un objeto InformeFlota
            // atriuto  totalFuel y vale 2000

            f.crearInforme(0);
            
        } catch (Exception ex) {
            System.out.println("No creo informe" + ex.getMessage());
        }
        
        Calculadora cal = new Calculadora();
        try {
            int a = cal.sumar(null,null);
        } catch (CalculadoraException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
}

class Calculadora{
    
    public double dividir(int n1, int n2) throws Exception {
        
        if(n2 == 0){
            System.out.println(".... es cero");
            throw new Exception("n2 es cero. No se puede dividir por cero ");
        }
        
        return n1 / n2;
        
    } 

    public int sumar(Integer n1, Integer n2) throws CalculadoraException{
        if(n1 == null || n2 == null) {
            throw new CalculadoraException("No puedo sumar algun "
                    + "número es null");
        }
        return n1 + n1;  
    }

}

class InformeFlota{
    
    int totalFuel = 2000;
    
    public void crearInforme(int totalCamiones) throws Exception{

        System.out.println("... media fuel consumido");
        Calculadora cal = new Calculadora();
        
        
        
        double media = cal.dividir(this.totalFuel, totalCamiones);
        
       
        System.out.println("media es " + media);
        
//        try {
//            double media = cal.dividir(this.totalFuel, totalCamiones);
//        } catch (Exception ex) {
//            System.out.println(".... ERROR " + ex.getMessage());
//        }
        
        
    }
    
    
    
}   






