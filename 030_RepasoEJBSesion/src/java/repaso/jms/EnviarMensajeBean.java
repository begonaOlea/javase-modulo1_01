package repaso.jms;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.Queue;

@JMSDestinationDefinition(
        name = "java:comp/jms/indicencias",
        interfaceName = "javax.jms.Queue",
        destinationName = "IncidenciasQueue")
@Named
@SessionScoped
public class EnviarMensajeBean 
             implements Serializable{

    @Inject
    private JMSContext context;
    @Resource(lookup = "java:comp/jms/indicencias")
    private Queue queue;
    private Logger logger = Logger.getLogger("EnviarMensajeBean");

    public void sendMessage(String tipoIncidencia) {
    try {
        String text = "Incidencia: " + tipoIncidencia;
        context.createProducer().send(queue, text);

        FacesMessage facesMessage = 
                new FacesMessage("Enivado el  mensajes: " + text);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    } catch (Exception e) {
        logger.log(Level.SEVERE, "Error enviando msg a cola: "
                +e.getMessage());
                
    }
}
    
    

}
