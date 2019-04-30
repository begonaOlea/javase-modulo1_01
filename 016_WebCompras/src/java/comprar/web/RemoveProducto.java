package comprar.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author begonaolea
 */
@WebServlet(name = "RemoveProducto", urlPatterns = {"/removeProducto"})
public class RemoveProducto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //0. LEER EL PARAMETRO producto A BORRAR
        String paramProducto = request.getParameter("producto");
        boolean hayParam = true;
        if (paramProducto == null || paramProducto.trim().length() == 0) {
            hayParam = false;
        }
        if (hayParam) {
            //1. OBTENER SESION
            HttpSession s = request.getSession();
            //2. OBTENER EL ATRIBUTO carro
            if(s.getAttribute("carro") != null){
                //3. REMOVE PRODUCTO DEL Map carro    
                Map<String,Integer> carro = (LinkedHashMap) s.getAttribute("carro");
                carro.remove(paramProducto);   
            } //fin hay carro
        }//fin hay parametro
        //4. REDIRECCIONAR A "listaCarro"
        response.sendRedirect("listaCarro");
        
    }

}
