package com.bolsa.web.beans;

import com.bolsa.dominio.Accion;
import com.bolsa.excepciones.BrokerException;
import com.bolsa.servicios.BrokerServiceLocal;
import com.sun.faces.util.MessageFactory;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.view.facelets.FaceletContext;


@Named(value = "accionesMB")
@ViewScoped
public class AccionesManagedBean implements Serializable {

    private Accion accionModificar;
    @EJB private BrokerServiceLocal brokerService;
    
    public AccionesManagedBean() {
    }

    public Accion getAccionModificar() {
        return accionModificar;
    }

    public void setAccionModificar(Accion accionModificar) {
        this.accionModificar = accionModificar;
    }

 
    
    public List<Accion> getListaAcciones(){
        return brokerService.getAllAcciones();
    }
    
    public void btnEditarAccion(int idAccion ){
        
        this.accionModificar = brokerService.getAccion(idAccion);
        System.out.println(".... modifico accion con version " 
                + accionModificar.getVersion());
    }
    
    public void btnGrabar(){
         System.out.println(".... grabar accion con version " 
                + accionModificar.getVersion());
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            brokerService.updateAccion(accionModificar);
            accionModificar = null;
            fc.addMessage(null, MessageFactory.getMessage("accion.modificar.ok"));
        } catch (BrokerException ex) {
            Logger.getLogger(AccionesManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            fc.addMessage(null, MessageFactory.getMessage(ex.getMessage()));
        }
    }
}
