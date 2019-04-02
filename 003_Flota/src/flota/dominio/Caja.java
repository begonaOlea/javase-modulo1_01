
package flota.dominio;

public class Caja {
    
    private double peso;

    public Caja() {
        peso = 100;
    }
    public Caja(double peso){
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
  
}
