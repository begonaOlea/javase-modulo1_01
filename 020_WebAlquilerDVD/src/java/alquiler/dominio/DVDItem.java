
package alquiler.dominio;

import java.io.Serializable;


public class DVDItem implements Serializable{
    
    private int id;
    private String titulo;
    private String genero;
    private boolean alquilado;

    public DVDItem() {
    }

    public DVDItem(int id, String titulo, String genero, boolean alquilado) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.alquilado = alquilado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
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
        final DVDItem other = (DVDItem) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
