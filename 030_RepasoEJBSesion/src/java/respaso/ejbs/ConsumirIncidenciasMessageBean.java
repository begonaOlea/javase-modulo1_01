package respaso.ejbs;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:comp/jms/indicencias")
    ,
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ConsumirIncidenciasMessageBean implements MessageListener {
    
    public ConsumirIncidenciasMessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        if( message instanceof TextMessage){
            
            try {
                
                String msg = message.getBody(String.class);
                
                System.out.println(".... HEMOS RECIBIDO INCIDENCIA: " + msg);
                
                
            } catch (JMSException ex) {
                Logger.getLogger(ConsumirIncidenciasMessageBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
