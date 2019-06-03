package demo;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.AssertTrue;


import javax.validation.constraints.Size;


@ManagedBean
@RequestScoped
public class LoginBean {

    @Size(min = 5, max = 15, message = "Tamaño incorrecto password")
    private String password;
    @Size(min = 5, max = 15, message = "Tamaño incorrecto confirmation")
    private String confirm;
    private String status = "";
    
//    @NotNull
//    private String  valor;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public String getValor() {
//        return valor;
//    }
//
//    public void setValor(String valor) {
//        this.valor = valor;
//    } 
    
   @AssertTrue(message = "Ha introducido una clave diferente!")
   public boolean isPasswordsEquals() {
      return password.equals(confirm);
   }
   //action del boton
   public String almacenarNuevaPassword() {
       System.out.println("... estatus " + status);
        FacesContext.getCurrentInstance()
                .addMessage(null, 
                  new FacesMessage("La nueva clave se guardo con éxito"));
        return null;
   }

    

}
