
package respaso.web.beans;

import java.io.Serializable;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import repaso.dominio.Producto;
import respaso.ejbs.AppSinlgetonSessionBeanLocal;
import respaso.ejbs.DetalleProductosStatelessSessionBeanLocal;

@Named(value = "productosMB")
@ViewScoped
public class ProductosManagedBean implements Serializable{

    //atributos
    private Set<Producto> listaProductos;
    
    //servicios
    @EJB 
    private AppSinlgetonSessionBeanLocal servicio;
    @EJB 
    private DetalleProductosStatelessSessionBeanLocal detalleService;

    public ProductosManagedBean() {
        // sevicio es null
    }
    
    @PostConstruct
    private void iniciar(){
        this.listaProductos = servicio.productos();
    }

    public Set<Producto> getListaProductos() {
        return listaProductos;
    }
    
    //ACTION
    public String imprimir(Producto p){
        detalleService.imprimirProducto(p);
        return null;
    }
    
    
    
}
