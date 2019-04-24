
package juego;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PanelJuegoVentana extends JFrame{
    
    private BotonJuego[] botones;
    private int dimension ;
    

    public PanelJuegoVentana(String title, int dimension) throws HeadlessException {
        super(title);
        this.dimension = dimension;
        botones = new BotonJuego[(dimension * dimension)];
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        iniciarVentana();
    }
    
    private void iniciarVentana(){
        //DEFINO UN GESTOR DE DISTRIBUCIÓN DE 
        
        Container c = this.getContentPane();
       // c.setLayout(new BoxLayout(c,BoxLayout.X_AXIS));
        c.setLayout(new GridLayout(dimension,dimension,1,1));
        
        
        for(int i= 0; i < this.botones.length; i ++){
            //crear el boton sin barco
            BotonJuego b =new BotonJuego(false);
            //añadir al array
            botones[i] = b;
            //añadir a la ventana
            c.add(b);
        }
        
        ponerBarcos();
        
        //añadir oyente boton
        OyenteBotonesPanel oyente = new OyenteBotonesPanel();
        for(BotonJuego b : botones){
            b.addActionListener(oyente);
        }
        //this.pack();
        this.setSize(300,300);
    }
    
    
    private void ponerBarcos(){
        //poner 10 barcos
        int contador = 0;
        while(contador < 10){
            Random random = new Random();
            int n = random.nextInt(this.botones.length); //devuelve un número de 0 a dimension-1
            System.out.println("... " + n);
            if(! botones[n].isHayBarco()){
                botones[n].setHayBarco(true);
                contador ++;
            }
        }
    }
    
    private class OyenteBotonesPanel implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
             BotonJuego boton = (BotonJuego) e.getSource();
             
             if(boton.isHayBarco()){
                 boton.setText("X");
             }else{
                 boton.setText("O");
             }
             boton.setEnabled(false);
             
           
        
        }
    
}
    
    
}

// for 

//   aleatoriamente pondreis a 10 botones el true de que hay barco
//
//    en el boton 3, 6 ,10  ponerles barco
// 
///7 nuevo oyente de evento ActonEvent añadir a todos lso botones
//
//       is boton tiene barco el boton setText (X) si no tiene barco
//       lo deja igual
//        siempre dehabilita el boton
//


