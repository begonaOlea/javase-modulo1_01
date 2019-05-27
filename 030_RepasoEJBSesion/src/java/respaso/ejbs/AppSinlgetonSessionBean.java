
package respaso.ejbs;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import repaso.dominio.Producto;

@Singleton
public class AppSinlgetonSessionBean 
        implements AppSinlgetonSessionBeanLocal {

    private Set<Producto> productos;
    
  

    public AppSinlgetonSessionBean() {
        this.productos = new HashSet();
    }
    
    @PostConstruct
    public void iniciar(){
        this.productos.add(new Producto(1,"Libro"));
        this.productos.add(new Producto(2,"Zapato"));
        this.productos.add(new Producto(3,"Teléfono")); 
    }
 
    
    @Override
    public Set<Producto> productos() {
        return productos;
    }
    
    
    @PreDestroy
    public void terminar(){
        System.out.println(".... destruyento AppSingletonSessionBean");
    }
    
    
}
