package demo;

import java.util.HashMap;

public class PruebaMap {
    
    public static void main(String[] args) {
        
        HashMap<Punto, Colores> figura = new HashMap();
        
        Punto p1 = new Punto(1,1,Colores.AZUL);
        Punto p2 = new Punto(1,1,Colores.ROJO);
        Punto p3 = new Punto(2,1,Colores.VERDE);
        Punto p4 = new Punto(1,1,Colores.ROJO);
        Punto p5 = new Punto(1,7,Colores.ROJO);
         
        figura.put(p1, Colores.AZUL);
        figura.put(p2, Colores.ROJO);
        figura.put(p3, Colores.ROJO);
        
        for(Punto p : figura.keySet()){
            System.out.println(p + "->" + figura.get(p));
        }
        
    }
    
}
