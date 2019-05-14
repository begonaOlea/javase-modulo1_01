package juego.web.beans;
import java.io.Serializable;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "numeroAdivinar")
@SessionScoped
public class NumeroAAdivinarManagedBean implements Serializable {

    private int numeroAAdivinar;

    public NumeroAAdivinarManagedBean() { 
        generaNumero();
    }

    public int getNumeroAAdivinar() {
        return numeroAAdivinar;
    }

    public void generaNumero(){
        Random r = new Random();
        numeroAAdivinar = r.nextInt(10) + 1;
    }    
}
