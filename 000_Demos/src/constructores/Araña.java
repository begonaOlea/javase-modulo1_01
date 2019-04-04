
package constructores;

public class Araña  extends Animal {
    
    private boolean venenosa;
    
    public Araña() {
//        super(8);
//        this.venenosa = false;
      this(false);
    }
    
    public Araña(boolean venenosa){
        super(8);
        this.venenosa = venenosa;
    }
    
 
    
}
