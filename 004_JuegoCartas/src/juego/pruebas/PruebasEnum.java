package juego.pruebas;

import java.security.NoSuchAlgorithmException;
import juego.modelo.PalosBaraja;

import static juego.modelo.PalosBaraja.*;
import static java.lang.Math.*;


public class PruebasEnum {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        
        double area = 2 * PI;  //Math
        PalosBaraja p = BASTOS;
        
        //probar enum
        PalosBaraja palo = PalosBaraja.BASTOS;
        PalosBaraja palo2 = PalosBaraja.BASTOS;

        if (palo == palo2) {
            System.out.println("son iguales");
        }

        System.out.println(PalosBaraja.COPAS);

        System.out.println("enumeracion " + PalosBaraja.values());

        for (PalosBaraja v : PalosBaraja.values()) {
            System.out.println("" + v);
        }

        switch (palo) {
            case OROS:
                System.out.println("vale 10");
                break;
            case COPAS:
                System.out.println("vale 20");
                break;
            case ESPADAS:
                System.out.println("vale 30");
                break;
            case BASTOS:
                System.out.println("vale 40");
                break;
        }

        



          

    }



}
