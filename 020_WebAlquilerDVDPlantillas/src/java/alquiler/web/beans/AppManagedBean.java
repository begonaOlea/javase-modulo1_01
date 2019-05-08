
package alquiler.web.beans;

import alquiler.dominio.DVDItem;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

@Named(value = "appManagedBean")
@ApplicationScoped
public class AppManagedBean  {
    
    private Map<Integer, DVDItem> dvds;
    /**
     * Creates a new instance of AppManagedBean
     */
    public AppManagedBean() {
        System.out.println("... inicializando AppManagedBean");
        
        dvds = new HashMap();
        dvds.put(1,new DVDItem(1, "Superluna", "pop", false));
        dvds.put(2,new DVDItem(2, "Mozart", "clásica", false));
        dvds.put(3,new DVDItem(3, "Lo Mejor de los 60", "otros", true));
    }

    public Map<Integer, DVDItem> getDvds() {
        return dvds;
    }

    
}
