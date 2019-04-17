package demo;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Figura {

    public static void dibujarFigura(Set<Punto> puntos) {

        if (puntos == null || puntos.size() == 0) {
            System.out.println("No hay una figura");
        } else {
            for (Punto p : puntos) {
                System.out.println(p);
            }
        }

    }

    public static void listarPuntosOrdenadoPorXeY(List<Punto> puntos) {

        Collections.sort(puntos);
        for (Punto p : puntos) {
            System.out.println(p);
        }

    }

    public static boolean estaPunto(List<Punto> lista, Punto pBuscar) {

        Collections.sort(lista);
        int posicion = Collections.binarySearch(lista, pBuscar);
        if (posicion < 0) {  //no encontrado
            return false;
        } else {   //encontrado
            return true;
        }

    }
}