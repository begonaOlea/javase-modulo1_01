
package broker.web.beans;

import broker.domain.Accionista;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    private Accionista usuario;
    private String idioma;
    
    public UsuarioBean() {
        this.usuario = new Accionista();
        this.idioma = "es";
    }

    public Accionista getUsuario() {
        return usuario;
    }

    public void setUsuario(Accionista usuario) {
        this.usuario = usuario;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    
    
}
