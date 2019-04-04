package constructores;

public class Animal {
    //atributos
    private int numeroPatas;

    //constuctor
   /*
    public Animal(){
        super();
    }
    */
    
    
    public Animal(int patas){
       // super(); pone esto lo escriba yo o no
        this.numeroPatas = patas;
    }
    
    //métodos
    public int getNumeroPatas() {
        return numeroPatas;
    }
    
    
}
