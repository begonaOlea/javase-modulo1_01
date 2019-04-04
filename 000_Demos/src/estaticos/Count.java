
package estaticos;

import sun.security.x509.SerialNumber;


public class Count {
    //atributo de clase
    private static  int counter = 0;
    
    //atributo de instancia (objeto)
    private int serialNumber = 0;
    
    //constructor
    public Count(){
        counter ++;
        this.serialNumber = counter;
    }
    
    
    //get static
    public static int getContador(){
      
        return counter;
    }

    @Override
    public String toString() {
        return "Count{" + "serialNumber=" + serialNumber + '}';
    }
    
    
    
}
