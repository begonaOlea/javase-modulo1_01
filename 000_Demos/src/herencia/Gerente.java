
package herencia;


public final class Gerente extends Empleado{
    
    protected String departamento;
    
    public Gerente(String nombre, 
            double salario,
            String departamento){
        this.nombre = nombre;
        this.salario = salario;
        this.departamento = departamento;
    }

    @Override
    public String getDetalles() {
        return super.getDetalles()
                + ", departamento " + this.departamento; 
    }

    public void mandar(){
        System.out.println("mando mucho");
    }

    @Override
    public double calcularSalario() {
         System.out.println(" gerente ");
        return salario * 2;
    }
    
}
