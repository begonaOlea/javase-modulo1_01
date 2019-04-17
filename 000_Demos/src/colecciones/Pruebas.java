package colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Vector;

public class Pruebas {

    public static void main(String[] args) {

        int[] numeros = new int[4];

        for (int i : numeros) {
            System.out.println(i);
        }
        
        System.out.println("numero de lemenos " + numeros.length);

        ArrayList objetos = new ArrayList();

        objetos.add(new String("hola"));  //STring
        objetos.add(new Integer(2));  //Integer
        objetos.add(3);  //Integer
        objetos.add(new Alumno("Luis", 2));

        System.out.println("... recorrer colección");

        Object o2 = new Alumno("Rosa", 3);

        for (Object o : objetos) {
            System.out.println(o);  //toString
            if (o instanceof Alumno) {
                Alumno a = (Alumno) o;
                System.out.println("nombre " + a.getNombre());
            }
        }

        ArrayList<Alumno> alumnos = new ArrayList();

        alumnos.add(new Alumno("Mario", 1));
        alumnos.add(new Alumno("Ainara", 1));
        alumnos.add(new Alumno("Maria", 1));
        alumnos.add(new Alumno("Luis", 1));

        for (Alumno a : alumnos) {
            System.out.println("nombre " + a.getNombre());
        }

        Alumno a3 = alumnos.get(3);
        System.out.println("en 3 esta " + a3.getNombre());

        //  alumnos 
        System.out.println("añado a begoña....");
        
        alumnos.add(0, new Alumno("Begoña", 1));
        alumnos.add(new Alumno("lll",2));
        
        
        for (Alumno a : alumnos) {
            System.out.println("nombre " + a.getNombre());
        }
       
     
        
     
        

    }

}
