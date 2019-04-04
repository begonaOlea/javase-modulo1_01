
package juego.modelo;


public enum PalosBaraja {
    OROS(10), COPAS(20), BASTOS(30), ESPADAS (40); 
     
    //atributo
    private int valorPalo;
    
    //constructor
    private PalosBaraja(int valor){
        this.valorPalo = valor;
    }
    
    public int getValorPalo() {
        return valorPalo;
    }
    
    
    
}
