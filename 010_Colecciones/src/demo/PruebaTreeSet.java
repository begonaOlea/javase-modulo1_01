/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.TreeSet;

/**
 *
 * @author begonaolea
 */
public class PruebaTreeSet {
    
    public static void main(String[] args) {
        
        TreeSet<Punto> l = new TreeSet();
        
        l.add(new Punto(1,2,Colores.AZUL));
         l.add(new Punto(1,2,Colores.AZUL));
         
         for(Punto p : l)
             System.out.println(p);
    }
    
}
