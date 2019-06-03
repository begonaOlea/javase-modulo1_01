package demo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ManagedBean
@RequestScoped
public class UsuarioBean {

    @Size(min = 3, max = 12)
    private String nombre = null;
    
    @Pattern(regexp = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[a-zA-Z] {2,4}$", message = "Email incorrecto")
    private String email = null;
    
    @Min(value = 18)
    @Max(value = 99)
    private Integer edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

}
