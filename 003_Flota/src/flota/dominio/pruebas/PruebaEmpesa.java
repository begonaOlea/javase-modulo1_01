
package flota.dominio.pruebas;

import flota.dominio.Empresa;
import flota.dominio.Vehiculo;

public class PruebaEmpesa {
    
    
    public static void main(String[] args) {
        
        
        
        
        
        // Pruebas
       // 1. Crear una empresa nueva con el nombre "TRANSPORTES RAMOS"
        
        Empresa e = new Empresa("TRANSPORTES RAMOS");
        
        String nombre =  e.getNombre();
        
        System.out.println(" nombre es " + nombre);
        
        
//        2. Mostrar una lista de los vehículos de la empresa
//          que tiene inicamente : minimo 1 maximo 10
           System.out.println("2. pruebo mostrar los camiones inicales");
            Vehiculo[] vehiculos = e.getFlotaVehiculos();
            
           for(Vehiculo v : vehiculos){
               if(v != null){
                    System.out.println(v);
               }
           }
           
           //2.b. mostra el numero de vehiculso actualment
           
           System.out.println(" total camiones empesa " 
                   + e.getNumVehiculosDisponibles());
           

//        3. Añadir un vehículo
          Vehiculo vnuevo1 = new Vehiculo();
          Vehiculo vnuevo2 = new Vehiculo();
          //3.1  y hay sitio
          e.addVehiculo(vnuevo1);
          e.addVehiculo(vnuevo2);
           for(Vehiculo v : vehiculos){
               if(v != null){
                    System.out.println(v);
               }
           }
          
          //3.2. y no hay sitio
          
          Vehiculo vnuevo3 = new Vehiculo();
     
          e.addVehiculo(vnuevo3);
       
           for(Vehiculo v : vehiculos){
               if(v != null){
                    System.out.println(v);
               }
           }

//       
                
                
                
        
        
    }
    
}
