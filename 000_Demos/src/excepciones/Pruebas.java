package excepciones;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pruebas {

    public static void main(String[] args) {
//       
//        String sNumero =  "200";
//        int numero = 0;
//        try{
//         numero =  Integer.parseInt(sNumero);
//         System.out.println("el numero es " + numero);
//         
//        }catch(NumberFormatException e){
//            System.out.println("No pude convertir el numero a entero");
//            System.out.println("Error " + e.getMessage()); 
//            numero = 10;
//        }
//        
//        System.out.println("aqui despues de todo");
//    
//        
//        
//        System.out.println("... division por cero");
//        
//        try {
//            double media = 20.0  / 0; // funciona ;
//           // int media = 20 / 0;  // si lanza excepcion
//            System.out.println("... todo ok");
//           // return;
//          // System.exit(0);
//        } catch (Exception e) {
//            System.out.println("... error dividiendo");
//            return;
//        } finally {
//            System.out.println("... entro aqui siempres ocurra"
//                    + "o no la excepcion");
//        }
//        
//        System.out.println("... fin main");

        Integer.parseInt("hola");  // NumberFormatException 
        //no es Checked  - no oblica el compilador
        //a tratarlo

        File fichero = new File("T:/carta.txt");
        try {
            boolean creado = fichero.createNewFile();
            System.out.println("... creado?" + creado);
        } catch (IOException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
