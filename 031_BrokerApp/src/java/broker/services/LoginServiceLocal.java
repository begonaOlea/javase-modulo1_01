
package broker.services;

import broker.domain.Accionista;
import javax.ejb.Local;

@Local
public interface LoginServiceLocal {
    
    public Accionista login(String nombre, String clave) throws Exception;
    
    public void logout();
}
