/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota.dominio;

import flota.dominio.Vehiculo;

/**
 *
 * @author begonaolea
 */
public class Empresa {
    
    //atributo de clase
    public static final int NUM_MAX_VEHICULOS = 3;
    
    private String nombre;
    //lista = array de 10 vehiculos
    private Vehiculo[] vehiculos;
    private int indiceVehiculo = 0;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new Vehiculo[NUM_MAX_VEHICULOS];
        this.vehiculos[indiceVehiculo] = new Vehiculo("0000A"); 
        indiceVehiculo ++;
    }
    public String getNombre() {
        return " ** " + nombre.toUpperCase();
    }
    
    public Vehiculo[] getFlotaVehiculos(){
        return vehiculos;
    }
    
    public int getNumVehiculosDisponibles(){
        return indiceVehiculo;
    }
    
    public void addVehiculo(Vehiculo v){
        //validar que no me paso
        if(indiceVehiculo == NUM_MAX_VEHICULOS){
            System.out.println("no puedo cargar el vehiculo");
            return;
        }
        this.vehiculos[indiceVehiculo] = v;
        indiceVehiculo ++; 
    }
    
}
