
package respaso.ejbs;

import javax.ejb.Local;
import repaso.dominio.Producto;

@Local
public interface SeleccionProductosStatefulSessionBeanLocal {
    
    public void seleccionarProducto(Producto p);
    public void imprimirSeleccion();
    public void limpiarSeleccion();
    public void liberar();
}
