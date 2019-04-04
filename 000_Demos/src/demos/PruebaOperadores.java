
package demos;

/**
 *
 * @author begonaolea
 */
public class PruebaOperadores {
    
    public static void main(String[] args) {
        
//        int  a = 2;
//        int   b = 4;
//
//        a ++;
//        b --;
//        System.out.println("a " + a);  //3
//        System.out.println("b " + b);  //3
//        
        
        int  a = 2;
        int   b = 4;

        ++ a ;
        -- b;
        System.out.println("a " + a);  //3
        System.out.println("b " + b);  //3
        
        
        int c;
        a = 3;
       // c = a ++;  //  c = 3 y a = 4
        
        c = ++ a;  //  c = 4 y a = 
        
        System.out.println("a " + a);  //4
        
        System.out.println("c " + c);  //4
        
        
        
 
    }
    
}
