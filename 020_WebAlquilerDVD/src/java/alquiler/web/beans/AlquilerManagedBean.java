
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
    AppManagedBean appManagedBean;
    
    public AlquilerManagedBean() {
       }

    public void setAppManagedBean(AppManagedBean appManagedBean) {
        this.appManagedBean = appManagedBean;
    }

    public Collection<DVDItem> getDvds() {
       // return dvds;
       return appManagedBean.getDvds().values();
    }
    
    public String alquilar(int id){
        System.out.println("... alquilo id " + id);
       // dvds.get(--id).setAlquilado(true);
        DVDItem item =  appManagedBean.getDvds().get(id);
        item.setAlquilado(true);
       
        return null;
    }
      
    public String devolverAlquiler(int id){
        System.out.println("... devolver  id " + id);
        
        DVDItem item =  appManagedBean.getDvds().get(id);
        System.out.println(".. dvd alquilado " + item.getTitulo());
        item.setAlquilado(false);
        return null;
    }
}
