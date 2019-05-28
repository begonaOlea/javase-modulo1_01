
package broker.services;

import broker.dao.AccionistaDAOLocal;
import broker.domain.Accionista;
import java.sql.Connection;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
public class LoginService  implements LoginServiceLocal{
    
    
    @Resource(name = "java:app/jdbc/brokerdb")
    private DataSource ds;
    @EJB
    private AccionistaDAOLocal accionistasDao;

    @Override
    public Accionista login(String nombre, String clave) throws Exception {
      
            Connection con = ds.getConnection();
            //con.setAutocommit(false);
            Accionista a =
            accionistasDao.findPorNombreClave(con, nombre, clave);
            //con.commit
            con.close();
            return a;
    }

    @Override
    public void logout() {
          }
    
    
    
}
