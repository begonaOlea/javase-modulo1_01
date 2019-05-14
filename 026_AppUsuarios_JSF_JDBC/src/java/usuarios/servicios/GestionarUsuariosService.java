
package usuarios.servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import usuarios.modelo.Usuario;
import usuarios.persistencia.UsuarioDAO;


public class GestionarUsuariosService {
    
    private UsuarioDAO dao;
    private Connection conn;
    
    static{
         try {
            //1. CARGAR DRIVER DE JAVA DB

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("... cargo el driver ok");
       
        } catch (ClassNotFoundException ex) {
            System.out.println("... no pudo cargar el Driver");
        }
    }

    public GestionarUsuariosService() {
        
        try {
            //crear conexión
            String url = "jdbc:derby://localhost:1527/UsuariosDB";
            String usr = "app";
            String pwd = "app";
            
            this.conn = DriverManager.getConnection(url,usr,pwd);
            conn.setAutoCommit(false);
            this.dao = new UsuarioDAO(conn);
            
        } catch (SQLException ex) {
            System.out.println("... No se pudo conectar");
        }  
        
    }
    
    
    public List<Usuario> getListaUsuarios(){
        
        try {
            return dao.obtenerTodos();
        } catch (SQLException ex) {
            Logger.getLogger(GestionarUsuariosService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public void crearNuevoUsuario(Usuario u){
        
        try {
            //valida si dni existe  - PENDIENTE

            dao.alta(u);
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(GestionarUsuariosService.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(GestionarUsuariosService.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

         
        
    }
    
    
}
