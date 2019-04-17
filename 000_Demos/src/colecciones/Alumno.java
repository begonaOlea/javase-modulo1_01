package colecciones;

import java.util.Objects;

public class Alumno implements Comparable<Alumno> {

    private int id;
    private String nombre;
    private int curso;

    //constructores
    public Alumno(String nombre, int curso) {
        this.nombre = nombre;
        this.curso = curso;
    }
     public Alumno(int id, String nombre, int curso) {
       this(nombre,curso);
       this.id= id;
    }
     
    //get y  set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", curso=" + curso + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + this.curso;

        System.out.println("el hascode es " + hash);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("... estoy comparando con equals");
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (this.curso != other.curso) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Alumno o) {
        //COMPARO POR CURSO Y LUEGO POR NOMBRE
        // retun 0  - si son iguales
        // return >0  si soy mayor
        // return <0  si soy menor

        int r = 0;

        int cursoCompara = this.curso - o.curso;
        int nombreCompara = this.nombre.compareTo(o.nombre);

        if (cursoCompara == 0 && nombreCompara == 0) {
            //iguales
            r = 0;
        } else if (cursoCompara != 0) {
            r = cursoCompara;
        } else {
            //curso es igual . comparo por nombre
            r = nombreCompara;
        }
        return r;
    }

}
