
package broker.dao;

import broker.domain.Accionista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ejb.Stateless;

@Stateless
public class AccionistaDAO implements AccionistaDAOLocal {

    @Override
    public Accionista findPorNombreClave(Connection con, 
            String nombre, String clave) throws SQLException {
       
        String sql = "SELECT id, nombre, clave FROM ACCIONISTAS WHERE"
                    + " NOMBRE = ? AND CLAVE = ? ";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, nombre);
        pst.setString(2, clave);
        ResultSet rs = pst.executeQuery();
        if( rs.next()){
            return new Accionista(
                    rs.getInt("id"), 
                    rs.getString("nombre"), 
                    rs.getString("clave"));
        }else{
            return null;
        }
        
    }
    
}
