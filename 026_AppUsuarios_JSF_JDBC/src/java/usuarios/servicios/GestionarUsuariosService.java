
package usuarios.servicios;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import usuarios.modelo.Usuario;
import usuarios.persistencia.UsuarioDAO;
import usuarios.servicios.excepciones.UsuarioException;

@Named(value = "gestionarUsuariosService")
@SessionScoped
public class GestionarUsuariosService implements Serializable {
    
    private static Logger log = Logger.getLogger("GestionarUsuariosService");
    
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
    
    public void crearNuevoUsuario(Usuario u) 
           throws UsuarioException{
        log.info("grabando nuevo usuario");
        try {
            //valida si dni existe  - PENDIENTE

            Usuario usr = dao.getUsuarioPorDNI(u.getDni());
            
            if(usr != null){
                throw new UsuarioException("Ya existe "
                        + "un usuario con el DNI" + u.getDni());
            }
            
            dao.alta(u);
            conn.commit();
            
        } catch (SQLException ex) {
            log.severe("Al crearNuevo Usuario. error bd :" + ex.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                log.severe("Al crearNuevo Usuario. error rollback :" + ex1.getMessage());
            }
            
        }    
        
    }
    
    
    public void modificarUsuario(Usuario u) 
           throws UsuarioException{
        log.info("modificar el usuario "  + u.getId());
        try {
            //valida si el DNI YA LO TIENE OTRO 

            Usuario usr = dao.getUsuarioPorDNI(u.getDni());
            
            if(usr != null && usr.getId() != u.getId()){
                throw new UsuarioException("Ya existe "
                        + "un usuario con el DNI" + u.getDni());
            }
            
            dao.modifica(u);
            conn.commit();
            
        } catch (SQLException ex) {
            log.severe("Al crearNuevo Usuario. error bd :" + ex.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                log.severe("Al crearNuevo Usuario. error rollback :" + ex1.getMessage());
            }
            
        }    
        
    }
    
    public Usuario getUsuario(int id){
        
        Usuario usr = null;
        try {
            usr = dao.buscarPorId(id);
            
        } catch (SQLException ex) {
            log.severe("Error buscarUsuario por Id " +
                    ex.getMessage());

        }
        return usr;
    }
    
    
   
   
}
