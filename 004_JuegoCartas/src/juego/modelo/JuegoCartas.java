package juego.modelo;

public class JuegoCartas {

    /**
     * metodo que me dice si las dos cartas son iguales o cual es la que gana Si
     * son iguales retorna 0, Si la primera es mayor retorna 1 si la segunda es
     * mayor retorna 2
     *
     * @param c1 - carta uno
     * @param c2 - carta dos
     * @return int 0, 1 o 2
     */
    public static int jugar(Carta c1, Carta c2) {

        int valorCarta1 = valorCarta(c1);
        int valorCarta2 = valorCarta(c2);

        if (valorCarta1 > valorCarta2) {
            return 1;
        } else if (valorCarta1 < valorCarta2) {
            return 2;
        } else {
            return 0;
        }
    }

    private static int valorCarta(Carta c) {

        int valor = 0;
        valor = c.getPalo().getValorPalo();
        valor = valor * c.getNumero();
        return valor;
    }

}
