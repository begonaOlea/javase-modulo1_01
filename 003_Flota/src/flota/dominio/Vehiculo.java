package flota.dominio;

/**
 * Clase que modela un Vehiculo de una flota de transporte tiene la capacidad de
 * cargar cajas
 *
 * @author begonaolea
 * @version 1.0
 */
public class Vehiculo {

    //atributos
    private String matricula = "";
    private double cargaMaxima = 3000.0;
    private Caja[] cajas;
    /**
     * atributo que representa la carga en kg que tiene el vehículo. No puede
     * superar la carga máxima y no puede tener valores negativos
     */
    private double cargaActual = 0;
    private int numCajas = 0;
    private final short TOTAL_CAJAS;

    //const
    public Vehiculo(String matricula) {
        this.matricula = matricula;
        this.TOTAL_CAJAS = 5;
        this.cajas = new Caja[TOTAL_CAJAS];
    }

    public Vehiculo(String matricula,
            short totalCajasPermitidas,
            double cargaMaxPermitida) {
        this.matricula = matricula;
        this.TOTAL_CAJAS = totalCajasPermitidas;
        this.cargaMaxima = cargaMaxPermitida;
        this.cajas = new Caja[TOTAL_CAJAS];
    }

    //metodos
    /**
     * método que recibe el peso de una caja a cargar y añade esta carga al
     * camión, incrementando el numero de cajas cargadas en uno
     *
     * @param Caja - caja a cargar peso en kg de la caja
     */
    public void cargar(Caja caja) {
        //validar que solo entren
        if (numCajas >= 5) {
            System.out.println("..No se cargó la caja.  Ya no caben mas cajas");
            return;
        }
        //validar que no super la carga
        if (caja.getPeso() < 0 || cargaMaxima < (cargaActual + caja.getPeso())) {
            System.out.println("..No se cargó la caja.  Ha superado la carga máxima permitida");
            return;
        }
        cargaActual += caja.getPeso();
        cajas[numCajas] = caja;
        numCajas++;
    }

    /**
     * descarga la última caja cargada
     *
     * @return Caja descarga la caja . Si no hay caja devueve un null
     */
    public Caja descargar() {
        //validar que haya cajas
        if (numCajas == 0) {
            System.out.println(".. no quedan cajas");
            return null;
        }
        //devolvemos al última caja
        Caja cajaDescargar = cajas[--numCajas];
        cargaActual -= cajaDescargar.getPeso();
        return cajaDescargar;
    }

    public double getCargaActual() {
        return cargaActual;
    }

    public int getNumCajas() {
        return numCajas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", cargaMaxima=" + cargaMaxima + ", cargaActual=" + cargaActual + ", numCajas=" + numCajas + '}';
    }

}
