package com.ticontrack.registro.persistencia;

import com.ticontrack.registro.dominio.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO 
        implements GenericDAO<Empleado>{
    
    private Connection conn;

    public EmpleadoDAO() {
    }

    public void setConnection(Connection conn) {
        this.conn = conn;
    }
    
    
    
    @Override
    public void alta(Empleado entidad) throws SQLException {
        
//        String consulta = "INSERT INTO EMPLEADOS "
//                + "(CLAVE, NOMBRE, APELLIDOS, DNI) " 
//                + "VALUES (?,  ?, ?, ?)";
//        
//        PreparedStatement pst = conn.prepareStatement(consulta);
//        pst.setString(1, entidad.getNombre());
//        pst.setString(2, entidad.getDni());
//        pst.executeUpdate();
    }

    @Override
    public void baja(int id) throws SQLException {
        
//        String consulta  = "DELETE FROM USUARIOS "
//                + "WHERE id = ? ";
//        PreparedStatement pst = conn.prepareStatement(consulta);
//        pst.setInt(1, id);
//        pst.executeUpdate();
        
    }

    @Override
    public void modifica(Empleado entidad) throws SQLException {
        
//         String consulta  = "UPDATE  USUARIOS "
//                + "SET NOMBRE = ? , DNI = ? "
//                 + "WHERE id = ? ";
//        PreparedStatement pst = conn.prepareStatement(consulta);
//        pst.setString(1, entidad.getNombre());
//        pst.setString(2, entidad.getDni());
//        pst.setInt(3, entidad.getId());
//        pst.executeUpdate();   
    }

    @Override
    public Empleado buscarPorId(int id) throws SQLException {
        String consulta = "SELECT ID, CLAVE, NOMBRE, APELLIDOS, DNI "
                + "FROM EMPLEADOS "
                + "WHERE ID = ? ";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            Empleado e = new Empleado();
            e.setId(rs.getInt("ID"));
            e.setClave(rs.getString("CLAVE"));
            e.setNombre(rs.getString("NOMBRE"));
            e.setApellidos(rs.getString("APELLIDOS"));
            e.setDni(rs.getString("DNI"));
            return e;
        }else{
            return null;
        }
    
    }

    @Override
    public List<Empleado> obtenerTodos() throws SQLException {
        
        String consulta = "SELECT * "
                + " FROM EMPLEADOS";
        Statement pst = conn.createStatement();
        ResultSet rs = pst.executeQuery(consulta);
        
        List<Empleado> empleados = new ArrayList();
        
        while(rs.next()){
             Empleado e = new Empleado();
            e.setId(rs.getInt("ID"));
            e.setClave(rs.getString("CLAVE"));
            e.setNombre(rs.getString("NOMBRE"));
            e.setApellidos(rs.getString("APELLIDOS"));
            e.setDni(rs.getString("DNI"));
            empleados.add(e);
        }
        return empleados;
        
    }
    
    
    
    
}
