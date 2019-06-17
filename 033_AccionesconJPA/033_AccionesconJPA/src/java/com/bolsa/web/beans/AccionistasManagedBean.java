
package com.bolsa.web.beans;

import com.bolsa.dominio.Accionista;
import com.bolsa.excepciones.BrokerException;
import com.bolsa.servicios.BrokerServiceLocal;
import com.sun.faces.util.MessageFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "accionistasMB")
@ViewScoped
public class AccionistasManagedBean implements Serializable{

    //ejb  BrokerService
    @EJB private BrokerServiceLocal brokerService;
    
    private List<Accionista> listaAccionistas;
    
    private Accionista nuevoAccionista;
     
    public AccionistasManagedBean() {
        System.out.println("..... instanciando AccionistasManagedBean");
    }

    public List<Accionista> getListaAccionistas() {
        this.listaAccionistas = brokerService.getAllAccionistas();
////      if ( this.listaAccionistas == null){
////          this.listaAccionistas = new ArrayList();
////      } 
      return listaAccionistas;
    }

    public Accionista getNuevoAccionista() {
        if( nuevoAccionista == null )
            nuevoAccionista= new Accionista();
        return nuevoAccionista;
    }

    public void setNuevoAccionista(Accionista nuevoAccionista) {
        this.nuevoAccionista = nuevoAccionista;
    }
    
    
    //accion
    public String btnInsertarAccionista(){
        System.out.println(".... insertando");
        
        brokerService.addAccionista(nuevoAccionista);
        
       // this.listaAccionistas.add(nuevoAccionista);
        nuevoAccionista = new Accionista();
        return null;
        
    }
    
    public String btnBorrarAccionista(int id){
        
        brokerService.deleteAccionista(id);
        
        return null;
    }
    
    
    public String btnModificarNombreAccionista(Accionista a){
        
        try {
            a.setNombre("Maria " + a.getNombre());
            brokerService.updateAccionista(a);   
        } catch (BrokerException ex) {
            Logger.getLogger(AccionistasManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//    public String btnEditar(int id){
//        this.modificarAccionista = brokeService.buscarAccionistaPorid(id);
//        this.modoEdicion = true;
//    }
//    
    public String btnGrabarCambios(){

        FacesContext fc = FacesContext.getCurrentInstance();
        try {
           // modifAccionista.setId(33333);
            brokerService.updateAccionista(nuevoAccionista);
            //modoEdicion = false
            return null;
        } catch (BrokerException ex) {
            //ex.getMessage()  "acccionista.noexiste"
            FacesMessage msg = MessageFactory.getMessage(ex.getMessage());
            fc.addMessage(null,msg);
            
            Logger.getLogger(AccionistasManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception e){
            fc.addMessage(null, MessageFactory.getMessage("error.inesperado"));
            e.printStackTrace();
        }
        return null;
    }
    
    
    
}
