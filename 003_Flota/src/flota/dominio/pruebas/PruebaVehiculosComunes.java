
package flota.dominio.pruebas;

import flota.dominio.Empresa;
import flota.dominio.Vehiculo;

public class PruebaVehiculosComunes {
    
    
    public static void main(String[] args) {
        
        
        Empresa e1= new Empresa("ABC");
        
        Empresa e2= new Empresa("XXX");
        
        //pruebo que se ha creado un array 
        //con un solo vehículo
        Vehiculo[] flota = Empresa.getFlotaVehiculos();
       
        System.out.println("... flota es " + flota);
        for(Vehiculo v : flota){
            System.out.println(v);
        }
        
        //añadir vehiculos 
        
       
        Empresa.addVehiculo(new Vehiculo ("3333A"));
        Empresa.addVehiculo(new Vehiculo ("777A"));
        
        e2.addVehiculo(new Vehiculo ("44A"));
        
        System.out.println(".... despues de añadir 3 vehiculos");
        for(Vehiculo v : flota){
            System.out.println(v);
        }
    }
    
}
