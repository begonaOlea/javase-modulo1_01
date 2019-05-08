
package alquiler.web.beans;

import alquiler.dominio.DVDItem;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "alquiler")
@SessionScoped
public class AlquilerManagedBean implements Serializable {

    @Inject 
    private AppManagedBean appManagedBean;
    
    private DVDItem itemActual = null;
    private boolean modoNuevo = false;
    
    public AlquilerManagedBean() {
       }

    public void setAppManagedBean(AppManagedBean appManagedBean) {
        this.appManagedBean = appManagedBean;
    }

    public Collection<DVDItem> getDvds() {
       // return dvds;
       return appManagedBean.getDvds().values();
    }

    public boolean isModoNuevo() {
        return modoNuevo;
    }

    public DVDItem getItemActual() {
        return itemActual;
    }

    
    public String alquilar(int id){
        System.out.println("... alquilo id " + id);
        DVDItem item =  appManagedBean.getDvds().get(id);
        item.setAlquilado(true);
        return null;
    }
      
    public String devolverAlquiler(int id){
        System.out.println("... devolver  id " + id);
        DVDItem item =  appManagedBean.getDvds().get(id);
        item.setAlquilado(false);
        return null;
    }
    
    public String  altaDvd(){ 
        this.modoNuevo = true;
        this.itemActual = new DVDItem();
        return "edita";
    }
    
    public String modificarDvd(int id){
        this.modoNuevo = false;
        this.itemActual = appManagedBean.getDvds().get(id);
        return "edita";
    }
    
    public String guardar(){
        
        FacesContext fc = FacesContext.getCurrentInstance();
    
        if(modoNuevo){
             //validar que el id no existe ya
            if(existe(itemActual.getId())){
                fc.addMessage(null,
                        new FacesMessage("No se pudo guardar el nuevo DVD. El id ya existe."));
                return "edita";
            }else{//añadir el item a map
                appManagedBean.getDvds().put(itemActual.getId() , itemActual);
                fc.addMessage(null, new FacesMessage("Se ha añadido el nuevo DVD."));
            }
        }else{
            //modificar
            appManagedBean.getDvds().put(itemActual.getId() , itemActual);
            fc.addMessage(null, 
                    new FacesMessage("Se ha modificado el DVD con éxito."));
        }
        
        return "alquila";
    }
    
    private boolean existe(int id){
        boolean existe = false;
        existe = appManagedBean.getDvds().containsKey(id);
        return existe;
    }
}
