package colecciones;

import java.util.*;

public class PruebaSet {

    public static void main(String[] args) {

        //NO DUPLICADOS
        //NO INDEXADAS
        HashSet s;          // NO ORDENADO      
        LinkedHashSet s2;   // ORDDEN INSERCION
        TreeSet s3;         // ORDEN NATURAL  ¿¿¿???

        Set<String> nombres = new TreeSet();

        nombres.add("LUIS");
        nombres.add("MARIO");
        nombres.add("LAURA");
        nombres.add("CARLOS");
        nombres.add("CARLOS");
       
        
        System.out.println("... lista:");
        for(String nom : nombres){
            System.out.println(nom);
        }

    }

}
