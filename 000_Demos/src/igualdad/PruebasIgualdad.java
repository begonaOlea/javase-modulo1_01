
package igualdad;

import java.util.HashSet;


public class PruebasIgualdad {
    
    public static void main(String[] args) {
        
        Empleado e1 = new Empleado(1,"Luis Ramos",true);
        Empleado e2 = new Empleado(1,"Luis De la Fuente",true);
        Empleado e3 = new Empleado(2,"Begoña Olea",true);
        
        System.out.println(e1);
        
        System.out.println(" e1 es igual a e2? == " + (e1 == e2));
        System.out.println(" e1 es igual a e2? equals " + (e1.equals(e2)));
        
        
        Punto p1 = new Punto(1,1);
        Punto p2 = new Punto(2,2);
        Punto p3 = new Punto(2,1);
        Punto p4 = p1;              
        Punto p5 = new Punto(1,1);
        
        //Coleccion que no permite duplicados
        //Set
        
        HashSet<Punto> cuadrado = new HashSet();
        
        cuadrado.add(p1);
        cuadrado.add(p2);
        cuadrado.add(p3);
        cuadrado.add(p4);
        cuadrado.add(p5);
       // cuadrado.add(e1); //no admite empleado
       // cuadrado.add(new String("hhh"));

        for(Punto p : cuadrado){
            System.out.println(p);
        }
        
        
        
        
    }
    
}
