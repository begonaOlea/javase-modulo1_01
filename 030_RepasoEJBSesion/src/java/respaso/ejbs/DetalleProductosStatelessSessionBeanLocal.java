
package respaso.ejbs;

import javax.ejb.Local;
import repaso.dominio.Producto;

@Local
public interface DetalleProductosStatelessSessionBeanLocal {

    public void imprimirProducto(Producto p);
    
}
