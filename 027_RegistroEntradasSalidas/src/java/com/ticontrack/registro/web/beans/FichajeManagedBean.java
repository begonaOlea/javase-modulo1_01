
package com.ticontrack.registro.web.beans;


import com.ticontrack.registro.dominio.Empleado;
import com.ticontrack.registro.persistencia.EmpleadoDAO;
import com.ticontrack.registro.servicios.FichajeException;
import com.ticontrack.registro.servicios.FichajesService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.sql.DataSource;

@Named(value = "fichaje")
@RequestScoped
public class FichajeManagedBean {
    
    
    @Inject
    private FichajesService fichajesService;

    public FichajeManagedBean() {
    }

    public void setFichajesService(FichajesService fichajesService) {
        this.fichajesService = fichajesService;
    }

    
    public List<Empleado> getListaEmpleado(){
        
        List<Empleado> lista = null;
        try {
            
             lista =  fichajesService.obtenerListaEmpleados();
       
        } catch (FichajeException ex) {
            añadirMensaje(ex.getMessage());
        }
        return lista;
    }
    
   
     private void añadirMensaje(String mensaje){
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage(mensaje));
     }
    
}
