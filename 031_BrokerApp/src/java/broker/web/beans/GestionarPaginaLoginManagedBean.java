
package broker.web.beans;

import broker.domain.Accionista;
import broker.services.LoginServiceLocal;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;


@Named(value = "loginManagedBean")
@ViewScoped
public class GestionarPaginaLoginManagedBean
                implements Serializable{

    @Inject
    private UsuarioBean usuarioBean;
    @EJB
    private LoginServiceLocal loginService;
    
    /**
     * Creates a new instance of GestionarPaginaLoginManagedBean
     */
    public GestionarPaginaLoginManagedBean() {
    }

//    public UsuarioBean getUsuarioBean() {
//        return usuarioBean;
//    }
//
//    public void setUsuarioBean(UsuarioBean usuarioBean) {
//        this.usuarioBean = usuarioBean;
//    }

    public String btnLogin(){
        String msgResultado = "";

        try {
            Accionista a=
            loginService.login(
                    usuarioBean.getUsuario().getNombre(),
                    usuarioBean.getUsuario().getClave()
            );
            if(a == null ) //no existe
            {
                usuarioBean.setUsuario(new Accionista());
                msgResultado = "El usuario o clave no son válidos.";
            }else{
                usuarioBean.setUsuario(a);
                msgResultado = "Login ok !!!"+ a.getId();
            }
                
            
        } catch (Exception ex) {
            ex.printStackTrace();
            msgResultado = "Error inesperado. Consulte con su administrador";
        }
        
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage(msgResultado));
                
        return null; //pagina a la que vamos        
        
    }
    
    
}
