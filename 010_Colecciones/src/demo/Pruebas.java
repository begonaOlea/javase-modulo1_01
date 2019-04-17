
package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pruebas {
    
    public static void main(String[] args) {
        
        Punto p1 = new Punto(1,1,Colores.AZUL);
        Punto p2 = new Punto(1,1,Colores.ROJO);
        Punto p3 = new Punto(2,1,Colores.VERDE);
        Punto p4 = new Punto(1,1,Colores.ROJO);
        Punto p5 = new Punto(1,7,Colores.ROJO);
         
        Set<Punto> puntos = new HashSet();
        
        puntos.add(p1);
        puntos.add(p2);
        puntos.add(p3);
        puntos.add(p4);
        puntos.add(p5);
        
  
        Figura.dibujarFigura(puntos);
        
        
        //---------------------------------
        //Creamos una lista de puntos 
        List<Punto> lista = new ArrayList();
        
        for(Punto p : puntos){
            lista.add(p);
        }
        //mostra lista de puntos ordenada por xy
        
        Figura.listarPuntosOrdenadoPorXeY(lista);
        
        
        //---------------------------------
        //buscar un punto con coordenadas 1 y 7
        Punto p17 = new Punto(1,7,Colores.ROJO);
        
        boolean encontrado = Figura.estaPunto(lista, p17);
        
        System.out.println("encontrado ? " + encontrado);
        
        
    
        
        
    }
    
}
