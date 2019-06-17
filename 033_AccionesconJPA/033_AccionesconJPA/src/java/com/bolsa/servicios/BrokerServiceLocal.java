
package com.bolsa.servicios;

import com.bolsa.dominio.Accion;
import com.bolsa.dominio.Accionista;
import com.bolsa.excepciones.BrokerException;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BrokerServiceLocal {
    
    public List<Accionista> getAllAccionistas();
    public Accionista  addAccionista(Accionista accionista);
    public void deleteAccionista(int id);
    public Accionista updateAccionista(Accionista accionista) throws BrokerException;
  
    public List<Accion> getAllAcciones();
    public Accion getAccion(int id);
    public Accion updateAccion(Accion accion)  throws BrokerException;
    
    
}
