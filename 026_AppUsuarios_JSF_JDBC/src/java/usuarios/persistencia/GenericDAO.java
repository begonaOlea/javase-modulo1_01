
package usuarios.persistencia;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<E> {
    
    public void alta(E entidad) throws SQLException;
    public void baja(int id) throws SQLException;
    public void modifica(E entidad) throws SQLException;
    public E buscarPorId(int id) throws SQLException;
    public List<E> obtenerTodos() throws SQLException;
    
    
}
