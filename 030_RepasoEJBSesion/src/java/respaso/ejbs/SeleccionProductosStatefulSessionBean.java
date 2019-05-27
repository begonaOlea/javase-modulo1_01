
package respaso.ejbs;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import repaso.dominio.Producto;

@Stateful
public class SeleccionProductosStatefulSessionBean implements SeleccionProductosStatefulSessionBeanLocal {

    private Set<Producto> productosSeleccionados ;
  
    @EJB
    private DetalleProductosStatelessSessionBeanLocal detalleService;

    
    @PostConstruct
    private void iniciar(){
        System.out.println("..... instanciando SeleccionProductosStatefulSessionBean");
    }
    
    @PreDestroy
    private void destruir(){
        System.out.println("..... destruyento SeleccionProductosStatefulSessionBean");
    }
 
    
    public SeleccionProductosStatefulSessionBean() {
        this.productosSeleccionados = new HashSet(); 
    } 
    
    
    @Override
    public void seleccionarProducto(Producto p) {
        System.out.println("... selecionando con el ejb " + this);
         this.productosSeleccionados.add(p);
    }
    @Override
    public void imprimirSeleccion() {
        System.out.println("... imprimiendo seleccion con el ejb " + this);
        System.out.println("... LISTA PRODUCTOS ... ");
        for(Producto p : productosSeleccionados){
            detalleService.imprimirProducto(p);
        }
    }

    @Override
    public void limpiarSeleccion() {
        System.out.println("... limpiando seleccion con el ejb " + this);
       this.productosSeleccionados.clear();
    }

    @Override
    @Remove
    public void liberar() {
      limpiarSeleccion();
      System.out.println(".... liberando EJB SeleccionProductosStatefulSessionBean ");
    }
    
    @PrePassivate
    public void pasiva(){
        System.out.println(".... pasivando EJB SeleccionProductosStatefulSessionBean");
    }
 
    @PostActivate
    public void activa(){
        System.out.println(".... activando EJB SeleccionProductosStatefulSessionBean");
    }
    
    
}
