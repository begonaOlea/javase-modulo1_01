
package broker.dao;

import broker.domain.Accionista;
import java.sql.Connection;
import java.sql.SQLException;
import javax.ejb.Local;

@Local
public interface AccionistaDAOLocal extends GenericDAO<Accionista>{
    
    public Accionista findPorNombreClave(Connection con,
            String nombre, 
            String clave) throws SQLException;
    
}
