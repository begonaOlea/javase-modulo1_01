
package usuarios.persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<E> {
    
    public void alta(Connection con, E entidad) throws SQLException;
    public void baja(Connection con, int id) throws SQLException;
    public void modifica(Connection con, E entidad) throws SQLException;
    public E buscarPorId(Connection con, int id) throws SQLException;
    public List<E> obtenerTodos(Connection con ) throws SQLException;
    
    
}
