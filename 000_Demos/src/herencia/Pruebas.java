package herencia;

public class Pruebas {
    
    
    public static void main(String[] args) {
        
        Empleado e = new Empleado("Luis Ramos", 3000);
        Gerente g = new Gerente("Mario Ross", 5000, "desarrollo" );
        
        
        
        System.out.println("e " + e.getDetalles());
        System.out.println("g " + g.getDetalles());
        
        
        Empleado[] lista = new Empleado[5];
        
        lista[0] = e;
        lista[1] = g;
        lista[2] = new Empleado("Maria " , 2400);
        lista[3] = new Jefe();
        lista[4] = new Gerente("Carmen", 4600,"Sistemas");
         
        for(Empleado em: lista){
            System.out.println(em.getDetalles());
            if(em instanceof Gerente){
                Gerente gr = (Gerente) em;
                gr.mandar();
            }  
        }
        
        
        Empleado e3 = new Gerente("Carmen", 4600,"Sistemas");
        Gerente g3 = (Gerente) e3;
        
        
        System.out.println("Nóminas ......");
        
        for(Empleado eNominas : lista){
            NominasService.generarNomina(eNominas);
        }
        
        CEO j = new CEO();
        NominasService.generarNomina(j);
        
        
        
    }
    
}
