
package usuarios.web;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import usuarios.modelo.Usuario;
import usuarios.servicios.GestionarUsuariosService;

/**
 *
 * @author begonaolea
 */
@Named(value = "gestionarUsuariosManagedBean")
@RequestScoped
public class GestionarUsuariosManagedBean {
     
    @Inject
    private GestionarUsuariosService servicio;
 
    public GestionarUsuariosManagedBean() {
        
      //  this.servicio = new GestionarUsuariosService();
    }

    public void setServicio(GestionarUsuariosService servicio) {
        this.servicio = servicio;
    }
 
    public List<Usuario> getLista(){
        return servicio.getListaUsuarios();
    }
    
    
    
}
