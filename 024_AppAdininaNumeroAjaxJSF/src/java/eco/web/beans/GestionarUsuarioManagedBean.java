package eco.web.beans;

import java.io.Serializable;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "gestionarUsuario")
@ViewScoped
public class GestionarUsuarioManagedBean 
  implements Serializable{

    private String nombre;
    private String dni;
    private String apellidos;
    
    private boolean dniExiste = false;
        
    /**
     * Creates a new instance of GestionarUsuarioManagedBean
     */
    public GestionarUsuarioManagedBean() {
    }

    public boolean isDniExiste() {
        return dniExiste;
    }  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {        
        //valido si existe o no
        if(dni.equals("1234")){
            this.dniExiste = true;
        }else{
            this.dniExiste = false;
        }
        this.dni = dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    //action
    public String grabar(){
        System.out.println("... grabando "
                + this.dni);
        return null;
    }
    
    //lister
    public void hacerAlgo(AjaxBehaviorEvent event){
        
        System.out.println("event " + event.getComponent());
        System.out.println("... dni " + dni);
    }
            
            
            
            
            
            
            
            
            
            
    
    
    
    
}
