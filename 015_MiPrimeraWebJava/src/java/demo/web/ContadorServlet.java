package demo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ContadorServlet",
        urlPatterns = {"/contador"},
        loadOnStartup = 0)
public class ContadorServlet extends HttpServlet {

    private AtomicInteger contador = new AtomicInteger(0);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Leer una cabecera 
        String navegador =  request.getHeader("User-Agent");
        if(navegador == null ){
            navegador="desconocido";
        }
        
        //Leer modo peticion POST/GET/DELETE/...
        String method  = request.getMethod();
         
        //Leer IP 
       
 
        //leer parametro usuario
        String usuario = request.getParameter("usuario");
        if (usuario == null || usuario.trim().length() == 0) {
            usuario = "guest";
        }

        //ASEGURA QUE EN UN ENTORNO MULTIHILO 
        // EL VALOR SE INCREMENTA Y ME LO DEVUELVE 
        // SIN PRODUCIR QUE EL DATO QUEDE INCONSISTENTE
        // POR SER TRATADO POR varios hiloa a la vez
        int valor = this.contador.incrementAndGet();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>contarod</title>");
            out.println("</head>");
            out.println("<body>");
             out.println("<h1>Navegador " + navegador + "!!!</h1>");
            out.println("<h1>Ha habido " + valor + " peticiones </h1>");
            out.println("</body>");
            out.println("</html>");
        }

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
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
