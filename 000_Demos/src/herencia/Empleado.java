package herencia;

import java.util.Date;

public class Empleado {
   
    //ATRIBUTOS
    protected String nombre;
    protected double salario;
    protected Date fechaNac;
    
    //CONSTRUCTOR
    
    public Empleado(){
        this("", 0);
    }
    
    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
        this.fechaNac = new Date();
    }
        
    //METODOS
    public String getDetalles(){
        return "nombre " + this.nombre 
               + ", salario " + this.salario  
               +", fechaNac " + this.fechaNac;
    }
    
    public double calcularSalario(){
        System.out.println(" empleado ");
        return salario * 1.2;
    }
    
    
    public int suma(int n, int n2){
        return n + n2;
    }

    public final String getNombre() {
        return nombre;
    }
    
    
}
