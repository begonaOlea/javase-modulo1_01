
package flota.dominio;

import flota.dominio.excepciones.CajaException;

public class Caja {
    
    private double peso;

    public Caja() {
        peso = 100;
    }
    public Caja(double peso) throws CajaException{
        if(peso < 0 ){
          //  throw new IllegalArgumentException("La caja no puede tener un peso negativo.");
          throw new CajaException("No puedes "
                  + "crear una caja con un peso negativo.");
        }
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) throws CajaException {
        if(peso < 0 ){
          throw new CajaException("No se puede "
                  + "asignar un peso negativo.");
        }
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Caja{" + "peso=" + peso + '}';
    }

    
    
    
    
  
}
