
package com.bolsa.servicios;

import com.bolsa.dominio.Accion;
import com.bolsa.dominio.Accionista;
import com.bolsa.excepciones.BrokerException;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


//EN LOS EJBs transaccional es gestionada por 
//CONTENEDOR por defecto
@Stateless
public class BrokerService implements BrokerServiceLocal {

    @PersistenceContext EntityManager em;

    @Override
    public List<Accionista> getAllAccionistas() {
       
        Query q = em.createNamedQuery("Accionista.findAll"); 
//prepra una consutla con una query predefinida
        List<Accionista> lista = q.getResultList();
         
        return lista;
        
    }

    @Override
    public Accionista addAccionista(Accionista accionista) {
       //por defecto se crea NEW TX
        accionista.setFechaCreacion(new Date());
        accionista.setFechaModificacion(new Date());
        //aqui todavia accionista no forma
        //parte del contexto de peristencia em
        em.persist(accionista);
        //aqui si
        
        return accionista;
        //COMMIT O ROLLCACK
    }

    @Override
    public void deleteAccionista(int id) {
        Accionista aBorrar = em.find(Accionista.class, id);
        em.remove(aBorrar);

    }
/**
 * Metodo que modifica los datos dela ccionista 
 * PEro si no existe lanza la exx ....
 * @param accionista
 * @return 
 */
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Accionista updateAccionista(Accionista accionista) 
            throws BrokerException {
        
        //MODO A
        // find  ,  setter cambian los valores
//        System.out.println("... buscando accionista por id");
//        Accionista aBD = em.find(Accionista.class, accionista.getIdAccionista());
//        if(aBD != null){
//            aBD.setNombre(accionista.getNombre());
//            aBD.setFechaModificacion(new Date());
//        }else{
//            throw new BrokerException("accionista.noexiste");
//        }
//        System.out.println("... cambio datos accionista");
//        return aBD;
        
        //MODO B
        // find  y merge
        
        accionista.setFechaModificacion(new Date());
        Accionista aBD = em.merge(accionista);
        
  
        // acccionisto sigue sin estar sincr con labd
        //aBD forma parte el contexto persistencia de em
        //y por lo tanto esta sicronizado
        
        return aBD;
       // commit automático cuadno termina el metodo sin 
       // excepciones 
    }

    @Override
    public List<Accion> getAllAcciones() {
         Query q = em.createNamedQuery("Accion.findAll"); 
        List<Accion> lista = q.getResultList();
         
        return lista;
    }

    @Override
    public Accion getAccion(int id){
        return em.find(Accion.class, id);
    }

    @Override
    public Accion updateAccion(Accion accion) throws BrokerException {
        try{
          Accion accionBD  =em.merge(accion);
        }catch(OptimisticLockException e){
            throw new BrokerException("accion.modificar.optimistic.error");
        }
        return accion;
    }
    
    
   
    
    
}
