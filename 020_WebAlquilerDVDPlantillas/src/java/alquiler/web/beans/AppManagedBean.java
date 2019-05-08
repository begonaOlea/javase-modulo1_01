
package alquiler.web.beans;

import alquiler.dominio.DVDItem;
import alquiler.dominio.Genero;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

@Named(value = "appManagedBean")
@ApplicationScoped
public class AppManagedBean  {
    
    private Map<Integer, DVDItem> dvds;
    
    private Set<String> generos;
    
    /**
     * Creates a new instance of AppManagedBean
     */
    public AppManagedBean() {
        System.out.println("... inicializando AppManagedBean");
        
        dvds = new HashMap();
        dvds.put(1,new DVDItem(1, "Superluna", "pop", false));
        dvds.put(2,new DVDItem(2, "Mozart", "clásica", false));
        dvds.put(3,new DVDItem(3, "Lo Mejor de los 60", "otros", true));
           
        generos = new HashSet();
        generos.add("pop");
        generos.add("clásica");
        generos.add("otros");
    }

    public Map<Integer, DVDItem> getDvds() {
        return dvds;
    }

    public Set<String> getGeneros() {
        return generos;
    }
    
    public void addNewGenero(String genero){
        if(genero != null){
            generos.add(genero);
        }
    }

    
    
}
