
package usuarios.web;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import javax.inject.Inject;
import usuarios.modelo.Usuario;
import usuarios.servicios.GestionarUsuariosService;
import usuarios.servicios.excepciones.UsuarioException;


@Named(value = "editarUsuario")
@SessionScoped
public class EditarUsuarioManagedBean implements Serializable{

    @Inject
    private GestionarUsuariosService servicio;
    
    private Usuario usuario;
    
    private boolean modoAlta = false;
 
    public EditarUsuarioManagedBean() {
        System.out.println("... instanciando EditarUsaurio");
    }
  
    public void setServicio(GestionarUsuariosService servicio) {
        this.servicio = servicio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isModoAlta() {
        return modoAlta;
    }
    
    
    
    public String crear(){
        
        FacesContext fc = FacesContext.getCurrentInstance();
        String mensaje = "";
       
        try {
            servicio.crearNuevoUsuario(usuario);
            mensaje= "El usuario " + usuario.getNombre() 
                    + "se creó con éxito.";
        } catch (UsuarioException ex) {
           mensaje= "El usuario no se creó " + ex.getMessage();
        }
        fc.addMessage(null, new FacesMessage(mensaje));
        return "lista";
        
    }
    
    
     public String modificar(){
        
        FacesContext fc = FacesContext.getCurrentInstance();
        String mensaje = "";
       
        try {
            servicio.modificarUsuario(this.usuario);
            mensaje= "El usuario " + usuario.getNombre() 
                    + "se modificó con éxito.";
        } catch (UsuarioException ex) {
           mensaje= "El usuario no se pudo modificar " + ex.getMessage();
        }
        fc.addMessage(null, new FacesMessage(mensaje));
        return "lista";
        
    }
    
    public String editarParaCrear(){
        this.usuario = new Usuario();
        this.modoAlta =true;
        return "editar";
        
    }
    
    public String editarParaModificar(int id){
        this.usuario = servicio.getUsuario(id);
        this.modoAlta = false;
        return "editar";
    }
    
    
    //LISTENER PARA AJAX
    public void existeDNIListener(AjaxBehaviorEvent ev){
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            if (servicio.existeDNI(usuario.getDni())){
                String msg = "El DNI ya existe";
                fc.addMessage("formUsuario:dni",
                               new FacesMessage(msg)); //h:message for="dni"
             //fc.addMessage(null, new FacesMessage(msg) ); //h:messages   
            }
        } catch (UsuarioException ex) {
            fc.addMessage("formUsuario:dni",
                               new FacesMessage("error bd"));
            
        }
    }
    
}
