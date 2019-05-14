package juego.web.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "partida")
@ViewScoped
public class PartidaManagedBean implements Serializable{

    private int numeroEnvioParaAdivinar;
    private String resultado = "";
    @ManagedProperty(value="#{numeroAdivinar}")
    private NumeroAAdivinarManagedBean numeroAdivinar;
    
    public PartidaManagedBean() {
    }

    public NumeroAAdivinarManagedBean getNumeroAdivinar() {
        return numeroAdivinar;
    }


    //cuando crea en PartidaManagedBean -> new
    //luego llama a este mentod para pasarle el 
    //NumeroAAdivinarManagedBean de ambito sesión
    public void setNumeroAdivinar(NumeroAAdivinarManagedBean numeroAdivinar) {       
       
        this.numeroAdivinar = numeroAdivinar;
    }

    public int getNumeroEnvioParaAdivinar() {
        
        return numeroEnvioParaAdivinar;
    }

    public void setNumeroEnvioParaAdivinar(int numeroEnvioParaAdivinar) {
        System.out.println("... has entrado en setNumeroEnvioParaAdivinar ");
         adivinarNumero(numeroEnvioParaAdivinar);
        this.numeroEnvioParaAdivinar = numeroEnvioParaAdivinar;
    }

    public String getResultado() {
        System.out.println("... has entrado en getResultado");
        return resultado;
    }    
    
    //acciones
    public String iniciarJuego(){
        this.numeroEnvioParaAdivinar = 0;
        this.resultado = "";
        this.numeroAdivinar.generaNumero();
        return null;
    }
    
    public String adivinar(){
        if(this.numeroEnvioParaAdivinar ==
            this.numeroAdivinar.getNumeroAAdivinar()){
            System.out.println(".. lo has adivinado");
            this.resultado = "LO HAS ADIVINADO";
        }else{
            System.out.println(".. No es . Vuelve a intentarlo");
            this.resultado = "NO HAS ACERTADO. VUELVE A INTENTARLO";
        }
        return null;
    }
    
    
    private void adivinarNumero(int num){
         if(num == this.numeroAdivinar.getNumeroAAdivinar()){            
            this.resultado = "LO HAS ADIVINADO";
        }else{
            this.resultado = "NO HAS ACERTADO. VUELVE A INTENTARLO";
        }
    }
    
}
