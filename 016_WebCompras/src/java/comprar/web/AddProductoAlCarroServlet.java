
package comprar.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddProductoAlCarroServlet", 
        urlPatterns = {"/addCarro"})
public class AddProductoAlCarroServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        //1.  LEER PARAMETRO DE PETICION
        String paramProducto = request.getParameter("producto");
        if( paramProducto == null ){
            paramProducto ="No has comprado nada";
        }
        
        // 2. OBTENER LA SESION HTML
        
        //obtener sesion. Si no existe la crea
        HttpSession sesion = request.getSession();
        
        // 3. OBTENER ATRIBUTO DE SESION CARRO
        
        //mirar si esta sesion tiene el atribut carro
        //LEER ATRIBUTO DE SESION
        Map<String, Integer> carro;
        if(sesion.getAttribute("carro") == null){
            //es la primera vez que solicitas l session 
            //y todavía no le he añadido el carro
//            AÑADIR UN  Map<String, Integer> carro  EN SESION
//            Y LE LLAMO AL ATRIBUTO "carro";

             carro = new LinkedHashMap();
             sesion.setAttribute("carro", carro);

        }else{
            //OBTENE EL ATRIBUTO CARRO
            carro = (LinkedHashMap)sesion.getAttribute("carro");
        }
        
        //4. AÑADIR EL PRODUCTO AL MAP que ya esta 
        //como atributo de la sesion con el nombre "carro"
        
        
       if( carro.containsKey(paramProducto) ){
            //ya esta el producto en el carro
            //incrementa valor
            Integer cantidad = carro.get(paramProducto);
            carro.put(paramProducto, ++cantidad);
            
        }else{
            //no esta todavía
            //añadir 
            carro.put(paramProducto, 1);
        }
        
        //lista 
        Set<String> claves = carro.keySet();
        for(String clave: claves){
            System.out.println(". " + clave +" "+ carro.get(clave));
        }
        

        
        response.setContentType("text/html;charset=UTF-8");
       
        response.sendRedirect("compras.html");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        processRequest(request, response);
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
