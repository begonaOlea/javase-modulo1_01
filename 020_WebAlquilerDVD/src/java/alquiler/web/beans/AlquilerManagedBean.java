
package alquiler.web.beans;

import alquiler.dominio.DVDItem;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
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
        return "editarDvd";
    }
    
    public String modificarDvd(int id){
        this.modoNuevo = false;
        this.itemActual = appManagedBean.getDvds().get(id);
        return "editarDvd";
    }
    
    public String guardar(){
        if(modoNuevo){
            //añadir el item a map
            appManagedBean.getDvds()
                    .put(itemActual.getId() , itemActual);
        }else{
            //modificar
             appManagedBean.getDvds()
                    .put(itemActual.getId() , itemActual);
        }
        
        System.out.println(appManagedBean.getDvds());
        return "alquiler";
    }
    
    
}
