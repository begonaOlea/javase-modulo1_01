
/*
  esto es un comentario muy largo
*/
package flota.dominio;

/**
 * Clase que modela un Vehiculo de una flota de transporte
 * tiene la capacidad de cargar cajas
 * 
 * @author begonaolea
 * @version 1.0
 */
public class Vehiculo {
    //atributos
    private String matricula = "";
    private double cargaMaxima = 3000.0;
    
    /**
     * atributo que representa la carga en kg que 
     * tiene el vehículo. No puede superar la carga
     * máxima y no puede tener valores negativos
     */
    private double cargaActual = 0;
    private int numCajas = 0;
    
    //metodos
    
    /**
     * método que recibe el peso de una caja a cargar 
     * y añade esta carga al camión, incrementando el numero
     * de cajas cargadas en uno
     * @param peso - peso en kg de la caja
     */
    public void cargar(double peso){
        if (peso > 0 && cargaMaxima >= (cargaActual + peso)){
            cargaActual += peso;
            numCajas ++;
        }
    }

    public double getCargaActual() {
        return cargaActual;
    }

    public int getNumCajas() {
        return numCajas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", cargaMaxima=" + cargaMaxima + ", cargaActual=" + cargaActual + ", numCajas=" + numCajas + '}';
    }

   
}
