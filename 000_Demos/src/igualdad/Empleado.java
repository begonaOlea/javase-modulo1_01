
package igualdad;


public class Empleado {
    
    //atributos
    private int id;
    private String nombre;
    private boolean activo;

    //constructores
    public Empleado(){
        super();
    }
    
    public Empleado(int id, String nombre, boolean activo) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }
    
    //getters y setter

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    // metodo object

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", activo=" + activo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}
