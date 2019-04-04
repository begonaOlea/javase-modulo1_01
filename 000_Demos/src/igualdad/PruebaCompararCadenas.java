package igualdad;


public class PruebaCompararCadenas {
    
    public static void main(String[] args) {
        
        String  s1 = "hola";
        String  s2 = "hola";
        String  s3  = new String("hola");
        
        //comparo s1  con s2
        System.out.println("s1 == s2 " + (s1 == s2));
        System.out.println("s1 equals s2 " + (s1.equals(s2)));
        
        
          //comparo s1  con s3
        System.out.println("s1 == s3 " + (s1 == s3));
        System.out.println("s1 equals s3 " + (s1.equals(s3)));
      
        
    }
    
}
