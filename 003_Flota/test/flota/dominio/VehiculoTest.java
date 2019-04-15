
package flota.dominio;

import flota.dominio.excepciones.CajaException;
import flota.dominio.excepciones.VehiculoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class VehiculoTest {
    
     Vehiculo v;
    
    
    public VehiculoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("despues del bloque de pruebas");
    }
    
    @Before
    public void setUp() {
        System.out.println("antes de cada prueba");
        try {
            System.out.println(" antes del bloque de pruebas");
            short numCajas = 3;
            v= new Vehiculo("222AA",numCajas,300);
        } catch (VehiculoException ex) {
           fail("No se pudo crear el vehiculo");
        }
    }
    
    @After
    public void tearDown() {
        System.out.println("después de cada prueba");
    }
    
    @Test
    public void crearUnVehiculoConMatriculaValida(){
       
        //DATOS INICIALES
        //DATOS ESPERADOS
        //LANZA TAREA
        //SE COMPRUEBA SI EL RESULTADO ES IGUAL A DATOS EXPERADOS
        
        String matricula ="AA2222";
        double cargaMaxima = 3000;
        double cajasMaxima = 10;
        Vehiculo v = new Vehiculo(matricula);
        
        assertEquals(v.getMatricula(), matricula);
        assertEquals(v.getTOTAL_CAJAS_PERMITIDAS(), 10);
        
    }
    
    
    
    @Test
    public void crearUnVEhiculoCon0Cajas(){
        
        //un vehiculo no puede ser creado 
        //indicando que tiene menos de 1 caja
        
        //Dato entrada
        short datoEntradaNumCajas = 0;
        //resultado esperado VehiculoException
        try{
             Vehiculo v = new Vehiculo("AAA", 
                     datoEntradaNumCajas,0);
             fail("Error. No tiene permitir construir un camions para 0 cajas");
        }catch(VehiculoException ve){
            System.out.println(ve.getMessage());
        }   
    }


    @Test
    public void probarCargarCajaVehiculoLLeno(){
        
        //DATOS PREPARACION - Llenar vehiculo
        System.out.println("admite " + v.getTOTAL_CAJAS_PERMITIDAS());
        //tengo un vehiculo que adminte 3 cajas y 3000 kg
        //lo lleno con 3 cajas y 60 kg
        try {
            v.cargar(new Caja(20));
            v.cargar(new Caja(20));
            v.cargar(new Caja(20));
            
        } catch (CajaException | VehiculoException  ex) {
              fail("No pude lenar camion con 3 cajas"); 
        }
        //PRUEBA - AÑADIR UNA CAJA MAS
        try {
            //RESULTADO ESPERADO
            //lo correcto es que ahora cuando meta otra caja
            //ocurra una excepcion  "CAMION LLENO"
            
            v.cargar(new Caja(20));
            //error
            fail("No debo ponder introducir una caja mas");
        } catch (VehiculoException ex) {
            //ok
             
        } catch(CajaException e2){
            //error
            fail("La caja esta bien creada");
        }
        
        
        assertEquals(3, v.getNumCajas());

        
    }
    
    @Test
    public void probarCargarCajaSuperaCargaMaxPermitida(){
        
        
         //DATOS PREPARACION 
        System.out.println("admite " + v.getTOTAL_CAJAS_PERMITIDAS());
        //tengo un vehiculo que adminte 3 cajas y 300 kg
        //lo lleno con 2 cajas y 240 kg
        try {
            v.cargar(new Caja(120));
            v.cargar(new Caja(120));
            
        } catch (CajaException | VehiculoException  ex) {
              fail("No pude lenar camion con  cajas"); 
        }
        //PRUEBA - AÑADIR UNA CAJA MAS
        try {
            //RESULTADO ESPERADO
            //lo correcto es que ahora cuando meta otra caja
            //ocurra una excepcion  "CAMION LLENO"
            
            v.cargar(new Caja(200));
            //error
            fail("No debo ponder introducir una caja tan pesada");
        } catch (VehiculoException ex) {
            //ok
            if(ex.getExcesoPeso() == 0){
                fail("Debo indicar el exceso de peso");
            }
            assertEquals(2, v.getNumCajas());
             
        } catch(CajaException e2){
            //error
            fail("La caja esta bien creada");
        }
        
        
      
        
        
        
    }
    
    @Test
    public void probarCargarEnUnVhcVacio1CajaNoExcedeCargaMaxPermit(){
        
        
         try {
             //VEHICULO NO TIENE CAJAS
             //AÑADIUR UNA Y QUE NO EXCEDE CARGA MAXI

             v.cargar(new Caja(100));
             
             //resultado 1 caja y cargaActual 100
             assertEquals(1, v.getNumCajas());
             assertEquals(100.0, v.getCargaActual(),0);
             
              v.cargar(new Caja(50));
             
             //resultado 2 caja y cargaActual 150
             assertEquals(2, v.getNumCajas());
             assertEquals(150.0, v.getCargaActual(),0);
 
         } catch (VehiculoException | CajaException ex) {
             fail("No he cargado caja");
         }
        
    }
    
}
