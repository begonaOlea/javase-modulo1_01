
package flota.dominio.excepciones;


public class VehiculoException extends Exception{

    //atributos 
    private double excesoPeso;
    
    public VehiculoException(String msgException) {
        super(msgException);
    }

    public void setExcesoPeso(double excesoPeso) {
        this.excesoPeso = excesoPeso;
    }

    public double getExcesoPeso() {
        return excesoPeso;
    }
    
    
            
    
    
    
}
