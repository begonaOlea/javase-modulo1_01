
package respaso.web.beans;

import java.io.Serializable;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import repaso.dominio.Producto;
import repaso.jms.EnviarMensajeBean;
import respaso.ejbs.AppSinlgetonSessionBeanLocal;
import respaso.ejbs.DetalleProductosStatelessSessionBeanLocal;
import respaso.ejbs.SeleccionProductosStatefulSessionBeanLocal;

@Named(value = "productosMB")
//@ViewScoped
@SessionScoped
public class ProductosManagedBean implements Serializable{

    //atributos
    private Set<Producto> listaProductos;
    
    //servicios
    @EJB 
    private AppSinlgetonSessionBeanLocal servicio;
    @EJB 
    private DetalleProductosStatelessSessionBeanLocal detalleService;
    @EJB
    private SeleccionProductosStatefulSessionBeanLocal selectService;
    
    @Inject
    private EnviarMensajeBean enviarMensajeBean;
    
    public ProductosManagedBean() {
        System.out.println(".... intanciando MB ProductosManagedBean");
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
    
    public String seleccionar(Producto p){
        selectService.seleccionarProducto(p);
        return null;
    }
    
    public String imprimirSeleccion(){
        selectService.imprimirSeleccion();
        return null;
    }
    
    public String limpiarSeleccion(){
        selectService.limpiarSeleccion();
        return null;
    }  
    
    public String enviarIncidenciaProducto(Producto p){
        enviarMensajeBean.sendMessage("se averío " + p.getDescripcion());
        return null;
    }
    
}
