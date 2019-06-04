
package com.bolsa.web.beans;

import com.bolsa.dominio.Accionista;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "accionistasMB")
@ViewScoped
public class AccionistasManagedBean implements Serializable{

    //ejb  BrokerService
    private List<Accionista> listaAccionistas;
    
    private Accionista nuevoAccionista;
     
    public AccionistasManagedBean() {
        System.out.println("..... instanciando AccionistasManagedBean");
    }

    public List<Accionista> getListaAccionistas() {
      //  this.listaAccionistas = brokerSevice.getListaAccionistas();
      if ( this.listaAccionistas == null){
          this.listaAccionistas = new ArrayList();
      } 
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
        
       // brokerService.addAccionista(nuevoAccionista);
        
        this.listaAccionistas.add(nuevoAccionista);
        
        return null;
        
    }
    
    
    
    
}
