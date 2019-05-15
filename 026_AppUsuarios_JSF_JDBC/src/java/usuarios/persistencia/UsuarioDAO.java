package usuarios.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import usuarios.modelo.Usuario;

public class UsuarioDAO 
        implements GenericDAO<Usuario>{
    
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void alta(Usuario entidad) throws SQLException {
        
        String consulta = "INSERT INTO USUARIOS "
                + "(NOMBRE, DNI) " 
                + "VALUES (?, ?)";
        
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setString(1, entidad.getNombre());
        pst.setString(2, entidad.getDni());
        pst.executeUpdate();
    }

    @Override
    public void baja(int id) throws SQLException {
        
        String consulta  = "DELETE FROM USUARIOS "
                + "WHERE id = ? ";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, id);
        pst.executeUpdate();
        
    }

    @Override
    public void modifica(Usuario entidad) throws SQLException {
        
         String consulta  = "UPDATE  USUARIOS "
                + "SET NOMBRE = ? , DNI = ? "
                 + "WHERE id = ? ";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setString(1, entidad.getNombre());
        pst.setString(2, entidad.getDni());
        pst.setInt(3, entidad.getId());
        pst.executeUpdate();   
    }
/**
 * 
 * @param id
 * @return  devuelve el usaurio encontrado o null si no existe
 * @throws SQLException 
 */
    
    
    @Override
    public Usuario buscarPorId(int id) throws SQLException {
        String consulta = "SELECT * "
                + "FROM USUARIOS "
                + "WHERE ID = ? ";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            Usuario usr = new Usuario();
            usr.setId(rs.getInt("ID"));
            usr.setNombre(rs.getString("NOMBRE"));
            usr.setDni(rs.getString("DNI"));
            return usr;
        }else{
            return null;
        }
    
    }

    @Override
    public List<Usuario> obtenerTodos() throws SQLException {
        
        String consulta = "SELECT * FROM USUARIOS";
        Statement pst = conn.createStatement();
        ResultSet rs = pst.executeQuery(consulta);
        
        List<Usuario> usuarios = new ArrayList();
        
        while(rs.next()){
            Usuario usr = new Usuario();
            usr.setId(rs.getInt("ID"));
            usr.setNombre(rs.getString("NOMBRE"));
            usr.setDni(rs.getString("DNI"));
            
            usuarios.add(usr);
        }
        return usuarios;
        
    }
    
    public Usuario getUsuarioPorDNI(String dni) throws SQLException{
        String consulta = "SELECT * "
                + "FROM USUARIOS "
                + "WHERE DNI = ? ";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setString(1, dni);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            Usuario usr = new Usuario();
            usr.setId(rs.getInt("ID"));
            usr.setNombre(rs.getString("NOMBRE"));
            usr.setDni(rs.getString("DNI"));
            return usr;
        }else{
            return null;
        }
    }
    
    
}
