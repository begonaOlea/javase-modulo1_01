package flota.dominio.pruebas;

import flota.dominio.Caja;
import flota.dominio.Vehiculo;
import flota.dominio.excepciones.VehiculoException;
import flota.dominio.excepciones.CajaException;


public class PruebaVehiculo {

    public static void main(String[] args) {
        try {
            short numCajas = 5;
            Vehiculo v = new Vehiculo("2345T", numCajas, 300);

            System.out.println("carga actual " + v.getCargaActual());
            System.out.println("cajas  " + v.getNumCajas());
            System.out.println("cargo 400 kg");

            Caja caja1 = new Caja(300);
            v.cargar(caja1);

            System.out.println("carga actual " + v.getCargaActual());
            System.out.println("cajas  " + v.getNumCajas());

            Caja caja2 = new Caja(500);
            v.cargar(caja2);

            System.out.println("carga actual " + v.getCargaActual());
            System.out.println("cajas  " + v.getNumCajas());

            Caja cajaDescargada = v.descargar();
            System.out.println("descargo caja con peso: " + cajaDescargada.getPeso());

            System.out.println("carga actual " + v.getCargaActual());
            System.out.println("cajas  " + v.getNumCajas());

            System.out.println(".... cargando muchas cajas");

            v.cargar(caja2);

            Caja caja3 = new Caja(100);
            v.cargar(caja3);
            Caja caja4 = new Caja(100);
            v.cargar(caja4);
            Caja caja5 = new Caja(34);
            v.cargar(caja5);
            Caja caja6 = new Caja(56);
            v.cargar(caja6);
            Caja caja7 = new Caja(40);
            v.cargar(caja7);

            System.out.println("carga actual " + v.getCargaActual());
            System.out.println("cajas  " + v.getNumCajas());

        } catch (VehiculoException e)  {
              System.out.println(e.getMessage());
              if(e.getExcesoPeso() >0 ){
                  System.out.println("Te has excedido en " + 
                          e.getExcesoPeso() + " kg");
              }  
        } catch(CajaException e){
             System.out.println(e.getMessage());
        }

//        System.out.println("carga actual " + v.getCargaActual());
//        System.out.println("cargo - 400 kg" );
//        v.cargar(-400);
//        System.out.println("carga actual " + v.getCargaActual());   
    }

}
