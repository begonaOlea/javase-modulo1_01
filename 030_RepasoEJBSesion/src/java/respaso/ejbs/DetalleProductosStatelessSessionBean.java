
package respaso.ejbs;

import javax.ejb.Stateless;
import repaso.dominio.Producto;


@Stateless
public class DetalleProductosStatelessSessionBean implements DetalleProductosStatelessSessionBeanLocal {

    @Override
    public void imprimirProducto(Producto p) {
       
        System.out.println(".... DETALLE PRODUCTO .... ");
        
        System.out.printf(".... %s - %s .... ",
                p.getId(),
                p.getDescripcion());
        System.out.println("................. ");
       
    }

}
