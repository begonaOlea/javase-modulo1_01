
package abstractas;


public abstract class Animal {
    
    private int patas = 0;
    
    public Animal(){
        super();
    }
    
    public Animal(int patas){
        this.patas = patas;
    }

    public int getPatas() {
        return patas;
    }
    
    public abstract void desplazarse();
    public abstract void comer();
 
}
