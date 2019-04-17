
package colecciones;


import java.util.Set;
import java.util.TreeSet;

public class PruebaTreeSet {
    
    public static void main(String[] args) {   
        Set<Alumno> lista = new TreeSet();

        Alumno a1 = new Alumno("Luis", 1);
        Alumno a2 = new Alumno("Luis", 1);
        lista.add(a1);
        lista.add(a2);
        lista.add(new Alumno("Maria", 1));
        lista.add(new Alumno("Maria", 3));
        lista.add(new Alumno("Aitor", 3));

        for(Alumno a: lista)
            System.out.println(a);
        
        
        //lista orden solo por el nombre 
        
        Set<Alumno> listaOrdenadaPorId = new TreeSet(new OrdenarAlumnoPorId());
        
        listaOrdenadaPorId.add(new Alumno(2,"Luis",2));
        listaOrdenadaPorId.add(new Alumno(1,"Maria",3));
        listaOrdenadaPorId.add(new Alumno(10,"Maria",3));
        listaOrdenadaPorId.add(new Alumno(7,"Carlos",3)); 
        
        System.out.println(".... Lista por id");
        for(Alumno aux: listaOrdenadaPorId){
            System.out.println(aux);   
        }
        
        
    }
    
}
            
            
