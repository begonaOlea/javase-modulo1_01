
package juego.pruebas;

import juego.modelo.Carta;
import juego.modelo.JuegoCartas;


public class ProbarJuego {
    
    public static void main(String[] args) {
        
        Carta c1 = new Carta();
        
        System.out.println("... carta 1 es ");
        System.out.println("palo " + c1.getPalo());
        System.out.println("numero " + c1.getNumero());
        
        
        Carta c2 = new Carta();
        
        System.out.println("... carta 2 es ");
        System.out.println("palo " + c2.getPalo());
        System.out.println("numero " + c2.getNumero());
        
        int res = JuegoCartas.jugar(c1,c2);
        
        System.out.println(" resultado  es " +  res);
        
    }
    
}
