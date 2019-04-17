
package colecciones;

import java.util.*;


public class PruebaSetAlumnos {
    
    public static void main(String[] args) {
        
        
        Set<Alumno> lista = new HashSet();
        
        Alumno a = new Alumno("Pedro", 3);
        Alumno b = new Alumno("Pedro", 3);
        Alumno c = a;
        
        
        System.out.println("a==b" + (a==b)); //false
        System.out.println("a==c" + (a==c));  //true
        System.out.println("a.equals(b)" + (a.equals(b))); //true
        System.out.println("a.equals(c)" + (a.equals(c))); //true        
        
        lista.add(a);
        lista.add(a);
        lista.add(new Alumno("Luis", 1));
        lista.add(new Alumno("Luis", 1));
        lista.add(new Alumno("Maria", 1));
        lista.add(new Alumno("Maria", 3));
        
        
        
       
        
        
        for(Alumno a2: lista)
            System.out.println(a2);
            
    }
    
}
