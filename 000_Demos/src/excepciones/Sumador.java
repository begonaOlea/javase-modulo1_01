package excepciones;

public class Sumador {

    public static void main(String[] args) {

        int total = 0;
        for (String s : args) {
            System.out.println(".. trato " + s);
            try {
                int n = Integer.parseInt(s); 
                
                total = (total + n) / n;
            } catch (NumberFormatException e1) {
                System.out.println("el argumento " +
                        s + " no es entero. No lo sumo.");
            } catch (ArithmeticException e2) {
                System.out.println("No puedo continuar. No se puede dividir por cero");
                return;
            }
        }//fin for
        
        System.out.println("... total " + total);

    }

}
