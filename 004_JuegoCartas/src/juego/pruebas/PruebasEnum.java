package juego.pruebas;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import juego.modelo.Carta;
import juego.modelo.PalosBaraja;

public class PruebasEnum {

    public static void main(String[] args) throws NoSuchAlgorithmException {

//        //probar enum
//        PalosBaraja palo = PalosBaraja.BASTOS;
//        PalosBaraja palo2 = PalosBaraja.BASTOS;
//
//        if (palo == palo2) {
//            System.out.println("son iguales");
//        }
//
//        System.out.println(PalosBaraja.COPAS);
//
//        System.out.println("enumeracion " + PalosBaraja.values());
//
//        for (PalosBaraja v : PalosBaraja.values()) {
//            System.out.println("" + v);
//        }
//
//        switch (palo) {
//            case OROS:
//                System.out.println("vale 10");
//                break;
//            case COPAS:
//                System.out.println("vale 20");
//                break;
//            case ESPADAS:
//                System.out.println("vale 30");
//                break;
//            case BASTOS:
//                System.out.println("vale 40");
//                break;
//        }
//
//        //crear aleatoriamente 10 palos
//        for(int i = 0; i < 10;i++){
//            
//            System.out.println("palo " + Carta.getPaloAleatorio());
//            
//        }
//        
//        
        
for(int i = 0; i < 10;i++)
        System.out.println(
                
                (int) (Math.random()*10) + 1 
        
        );

    }

}
