
package colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PruebasMetodosAuxiliaresColecciones {
    
    
    public static void main(String[] args) {
        
        List<Alumno> lista = new ArrayList();
        lista.add(new Alumno(2,"Luis",2));
        lista.add(new Alumno(1,"Maria",3));
        lista.add(new Alumno(10,"Maria",3));
        lista.add(new Alumno(7,"Carlos",3)); 
        
        System.out.println("Lista: ");
        for(Alumno a1 : lista) System.out.println(a1);
        
        Collections.sort(lista);
        
        System.out.println("Lista orden curso nombre:");
        for(Alumno a1 : lista) System.out.println(a1);
        
        Collections.sort(lista, new OrdenarAlumnoPorId());
         
        System.out.println("lista por id");
        for(Alumno a1 : lista) System.out.println(a1);
        
        //busqueda binaria  POR ID
        
        Alumno alumnoABuscar = new Alumno(10,"",2);
        
        Collections.sort(lista, new OrdenarAlumnoPorId()); //POR ID

        int posicion = Collections.binarySearch(
                lista,   //Lista donde se busca ordenada por Id
                alumnoABuscar, //objeto buscado
                new OrdenarAlumnoPorId());  // Comparator
        
        System.out.println("Luis con id 2 esta en la pos " + posicion);
   
    }
    

    
}
