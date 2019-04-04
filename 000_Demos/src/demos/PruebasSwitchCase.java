package demos;

public class PruebasSwitchCase {

 

    public static void main(String[] args) {
        
        int diaSemana = 2;
        switch(diaSemana){
            default:
                System.out.println("otro día");
                break;
            case 1:
                System.out.println("Lunes");
                break;
            case 2: 
                System.out.println("Martes");
                break;
            case 3: 
                System.out.println("Miércoles");
                break;
        } 
        
       final String g1="BAJA";
        String g2="ALTA";
        
        String gama ="ALTA";
        switch(gama){
            case g1:
                System.out.println("uno");
            case "ALTA":
                System.out.println("dos");
        }
        
        
        int i = 0;
        for(; i<10; i++){
            
        }
       
        System.out.println(".. i " + i);
    }
     
    
}
