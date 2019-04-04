/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author begonaolea
 */
public class Secretario extends Empleado{

    private String[] idiomas;

    @Override
    public String getDetalles() {
        return super.getDetalles(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

    public String getNombre() {
        return "Secre " + nombre;
    }
        
        
 
    
}
