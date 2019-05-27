
package respaso.ejbs;

import java.util.Set;
import javax.ejb.Local;
import repaso.dominio.Producto;


@Local
public interface AppSinlgetonSessionBeanLocal {
    
    public  Set<Producto> productos();
    
}
