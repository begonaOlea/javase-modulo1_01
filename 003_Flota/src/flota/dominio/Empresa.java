
package flota.dominio;
/**
 * 
 * @author begonaolea
 */

public class Empresa {
    //atributos
    private String nombre = "";
    private Vehiculo[] vehiculos;
    private int indice = 0;
    
    //constructor
    public Empresa(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new Vehiculo[10];
        this.vehiculos[indice] = new Vehiculo();
        indice ++;
    }
    
    //metodos get y set
    public String getNombre() {
        return nombre;
    }
    
    //metodos
    public void addVehiculo(Vehiculo v){
        if(indice == 10){
            System.out.println(".No se añade el nuevo Vehiculo, "
                    + "la empresa solo gestiona  10 vehiculos");
        }
        vehiculos[indice] = v;
        indice ++;
        
    }
    
    public Vehiculo[] getVehiculos(){
        return this.vehiculos;
    }
    
    
}
