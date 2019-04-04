
package herencia;


public class NominasService {
    
    public static void generarNomina(Empleado e){
        
        System.out.println("..............");
        System.out.println(".. NOMINA  ..");
        System.out.println("..............");
        
        double importe = e.calcularSalario();
        
        System.out.println(" salario base: " + e.salario);
        System.out.println(" salario: " + importe);
        System.out.println("..............");
        
    }
    
}
