package juego.modelo;


public class Carta {

    //atributos
    private PalosBaraja palo;
    private int numero;

    //constructor
    public Carta() {
        this.numero = getNumeroAleatorio();
        this.palo = getPaloAleatorio();
    }

    //método
    public PalosBaraja getPalo() {
        return palo;
    }

    public int getNumero() {
        return numero;
    }

    public static PalosBaraja getPaloAleatorio() {

        PalosBaraja pAleatorio;
  // de 0 a 3 
        int indice = (int) ((Math.random() * 100) % 4);

        pAleatorio = PalosBaraja.values()[indice];

        return pAleatorio;
    }

    public static int getNumeroAleatorio() {
        int numero = ((int) (Math.random() * 10)) + 1;
        return numero;
    }

}
