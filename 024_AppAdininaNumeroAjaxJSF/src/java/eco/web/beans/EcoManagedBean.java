package eco.web.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "eco")
@ViewScoped
public class EcoManagedBean implements Serializable {

    private String nombre; 
    
    public EcoManagedBean() {
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
    public String getSaludar(){
        return "Hola " + nombre;
    }
    
}
