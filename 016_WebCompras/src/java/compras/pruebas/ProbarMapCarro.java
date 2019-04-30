
package compras.pruebas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class ProbarMapCarro {
    
    public static void main(String[] args) {
        
        // clave es un string nombre del producot
        // valor es el numero de vez que lo compras
        Map<String, Integer> carro = new LinkedHashMap();
        
        //prueba 1 - clic una vez en comprar Zapato
        
        //prueba 2 - ya hay un zapato y clic otra vez en comprar Zapato
       
        carro.put("zapato", 4);
        String prod = "zapato";

        if( carro.containsKey(prod) ){
            //ya esta el producto en el carro
            //incrementa valor
            Integer cantidad = carro.get(prod);
            carro.put(prod, ++cantidad);
            
        }else{
            //no esta todavía
            //añadir 
            carro.put(prod, 1);
        }
        
        //lista 
        Set<String> claves = carro.keySet();
        for(String clave: claves){
            System.out.println(". " + clave +" "+ carro.get(clave));
        }
        
        
        
    }
    
}
