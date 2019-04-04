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
    //lista = array de  NUM_MAX_VEHICULOS vehiculos
    private static Vehiculo[] vehiculos;
    private static int indiceVehiculo = 0;
    
    //bloque de inicializado static
    static{
        vehiculos = new Vehiculo[NUM_MAX_VEHICULOS];
    }

    //constructores
    public Empresa(){
        this("TRANSPORTES YYY");
    }
    
    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return " ** " + nombre.toUpperCase();
    }
    
    public static Vehiculo[] getFlotaVehiculos(){
        return vehiculos;
    }
    
    public int getNumVehiculosDisponibles(){
        return indiceVehiculo;
    }
    
    public static void addVehiculo(Vehiculo v){
        //validar que no me paso
        if(indiceVehiculo == NUM_MAX_VEHICULOS){
            System.out.println("no puedo cargar el vehiculo");
            return;
        }
        vehiculos[indiceVehiculo] = v;
        indiceVehiculo ++; 
    }

    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", vehiculos=" + vehiculos + ", numeroVehiculos=" + indiceVehiculo + '}';
    }
}
