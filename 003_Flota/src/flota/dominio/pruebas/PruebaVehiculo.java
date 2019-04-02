
package flota.dominio.pruebas;

import flota.dominio.Vehiculo;
import java.util.logging.Logger;

public class PruebaVehiculo {
  
    
    public static void main(String[] args) {
        
        Vehiculo v = new Vehiculo();
        
        System.out.println("carga actual " + v.getCargaActual());
        System.out.println("cajas  " + v.getNumCajas());
        System.out.println("cargo 400 kg" );
        v.cargar(400);
       
        
         System.out.println("carga actual " + v.getCargaActual());
        System.out.println("cajas  " + v.getNumCajas());
       
        
//        System.out.println("carga actual " + v.getCargaActual());
//        System.out.println("cargo - 400 kg" );
//        v.cargar(-400);
//        System.out.println("carga actual " + v.getCargaActual());
        
    }
     
}
