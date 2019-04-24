package juego;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InicioJuegoVentana extends JFrame {

    //atributos
    private JLabel etiqueta1;
    private JTextField cmpDimensionCasillero;
    private JButton btnIniciarJuego;
    private JButton btnSalir;

    public InicioJuegoVentana(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarVentana();
    }

    private void iniciarVentana() {
        // definir un LayoutManager
        //pone los elementos en linea alineados a la izda. y margenes 10
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        //creando componentes
        this.etiqueta1 = new JLabel("Introduce dimensión del casillero");
        this.cmpDimensionCasillero = new JTextField(30);
        this.btnIniciarJuego = new JButton("Iniciar Juego");
        this.btnSalir = new JButton("Salir");

        //añadir a la ventana
        this.getContentPane().add(this.etiqueta1);
        this.getContentPane().add(this.cmpDimensionCasillero);
        this.getContentPane().add(this.btnIniciarJuego);
        this.getContentPane().add(this.btnSalir);

        //eventos 
        OyenteBotonIniciarJuego oyente = new OyenteBotonIniciarJuego();

        this.btnIniciarJuego.setActionCommand("iniciar");
        this.btnSalir.setActionCommand("salir");

        this.btnIniciarJuego.addActionListener(oyente);
        this.btnSalir.addActionListener(oyente);

        OyenteBotones oyente2 = new OyenteBotones();
        this.btnIniciarJuego.addActionListener(oyente2);

        this.pack();
        //this.setSize(200, 200);
    }

    public static void main(String[] args) {
        InicioJuegoVentana ventana = new InicioJuegoVentana("Hundir la Flota");
        ventana.setVisible(true);
    }

    //CLASE INTERNA
    //PUEDE ACCEDER A LOS ATRIBUTOS DE LA CLASE
    //EXTERNA QUE LA CONTIENE
    private class OyenteBotones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //leer el campo dimension del tablero
            String sDimension = cmpDimensionCasillero.getText();
            System.out.println("... dimension es " + sDimension);

            try {
                int dimension = Integer.parseInt(sDimension);

                if (dimension < 4) {
                    JOptionPane
                        .showMessageDialog(null, "Las dimensiones del panel "
                                + "deben ser 4 o más (filas,columnas)");

                } else {

                    PanelJuegoVentana v = new PanelJuegoVentana("Panel Juego", dimension);
                    v.setVisible(true);
                }

            } catch (NumberFormatException ex) {
                JOptionPane
                        .showMessageDialog(null, "Debe introduccir un número entero");
            }

        }

    }

} //fin clase InicioJuegoVentana
