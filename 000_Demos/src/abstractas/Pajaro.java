
package abstractas;

public class Pajaro extends Animal{

    @Override
    public void desplazarse() {
        System.out.println("... vuelo por los aires");
    }

    @Override
    public void comer() {
        System.out.println(".. soy un pajaro y como gusanos");
    }
     
}
