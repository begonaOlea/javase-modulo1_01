package flota.dominio;


public class Vehiculo {
   
    private String matricula = "";
    private double cargaMaxima = 3000.0;
    private double cargaActual = 0;
    private int numCajas = 0;
    
    public void cargar(double peso){
        if (peso > 0 && cargaMaxima >= (cargaActual + peso)){
            cargaActual += peso;
            numCajas ++;
        }
    }

    public double getCargaActual() {
        return cargaActual;
    }
    
    
    
}
