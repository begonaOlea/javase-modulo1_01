
package alquiler.web.beans;

import alquiler.dominio.DVDItem;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "alquiler")
@SessionScoped
public class AlquilerManagedBean implements Serializable {

    private List<DVDItem> dvds;
    
    public AlquilerManagedBean() {
        dvds = new ArrayList();
        dvds.add(new DVDItem(1, "Superluna", "pop", false));
        dvds.add(new DVDItem(2, "Mozart", "clásica", false));
        dvds.add(new DVDItem(3, "Lo Mejor de los 60", "otros", true));
    }

    public List<DVDItem> getDvds() {
        return dvds;
    }
    
    public String alquilar(int id){
        System.out.println("... alquilo id " + id);
        dvds.get(--id).setAlquilado(true);
        return null;
    }
    
    
    public String devolverAlquiler(int id){
        System.out.println("... devolver  id " + id);
        dvds.get(--id).setAlquilado(false);
        return null;
    }
}
