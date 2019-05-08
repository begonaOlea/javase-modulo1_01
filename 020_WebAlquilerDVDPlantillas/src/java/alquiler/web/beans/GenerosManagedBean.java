
package alquiler.web.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


@Named(value = "generosMB")
@RequestScoped
public class GenerosManagedBean {

    private String nuevoGenero;
    
    @Inject 
    private AppManagedBean appManagedBean;
    
    /**
     * Creates a new instance of GenerosManagedBean
     */
    public GenerosManagedBean() {
    }

    public AppManagedBean getAppManagedBean() {
        return appManagedBean;
    }
    
    

    public void setNuevoGenero(String nuevoGenero) {
        this.nuevoGenero = nuevoGenero;
    }

    public String getNuevoGenero() {
        return nuevoGenero;
    }
    
    public String guardarNuevoGenero(){
        appManagedBean.getGeneros().add(nuevoGenero);
        return null;
    }
    
}
