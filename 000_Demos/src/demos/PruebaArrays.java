package demos;

public class PruebaArrays {
    

    
    public static void main(String[] args) {
        
        
        //array de 10 enteros
        
        int[] numeros = new int[10]; //10 elementos de 0 a 9
        
        numeros[8] = 333;
        
        for(int n : numeros){
            System.out.println(n);
        }
        
        Punto[] puntos = new Punto[3];
        System.out.println("..... recorro array de puntos");
        
        puntos[0] = new Punto(1,2);
        puntos[1] = new Punto(4,2);
        puntos[2] = new Punto(3,2);
        
        for(Punto p : puntos){
            System.out.println(p);
        }
        
        int contador = 0;
        while ( contador < 3){
            System.out.println("y " + puntos[contador].getY());
            if(puntos[contador].getX()>2){
                System.out.println("SUPER PUNTO");
                contador ++;
                continue;
            }
            System.out.println("x " + puntos[contador].getX());
            contador ++;
        }
        
        
    }
    
    
     
        
    
}
