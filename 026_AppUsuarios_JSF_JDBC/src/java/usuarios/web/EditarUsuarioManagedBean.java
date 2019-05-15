
package usuarios.web;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import usuarios.modelo.Usuario;
import usuarios.servicios.GestionarUsuariosService;
import usuarios.servicios.excepciones.UsuarioException;


@Named(value = "editarUsuario")
@ViewScoped
public class EditarUsuarioManagedBean implements Serializable{

    @Inject
    private GestionarUsuariosService servicio;
    
    private Usuario usuario;
 
    public EditarUsuarioManagedBean() {
        this.usuario = new Usuario();
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
    
}
