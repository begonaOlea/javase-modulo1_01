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

@WebServlet(name = "ListaCarroServlet", urlPatterns = {"/listaCarro"})
public class ListaCarroServlet extends HttpServlet {

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

        //1. OBTENER LA SESSION
        HttpSession sesion = request.getSession();

        //2. OBTENER EL ATRIBUTO CARRO
        boolean hayProductos = true;
        Map<String, Integer> carro = null;

        if (sesion.getAttribute("carro") == null) {
            hayProductos = false;
        } else {
            //obtener carro 
            carro = (LinkedHashMap) sesion.getAttribute("carro");
            if (carro.size() == 0) {
                hayProductos = false;
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!doctype html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("    <meta charset='utf-8'>");
            out.println("    <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>");
            out.println("    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>");
            out.println("    <title>Carro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Tienda Online</h1>");
            out.println("<ul class='nav nav-pills'>");
            out.println("   <li class='nav-item'>");
            out.println("        <a class='nav-link ' href='compras.html'>Ir a Compras</a>");
            out.println("    </li>");
            out.println("    <li class='nav-item'>");

            out.println("       <a class='nav-link active' href='listaCarro'>Ir a Carro</a>");
            out.println("   </li>");
            out.println("</ul>");

            out.println("       <h2>Lista Productos en el Carro:</h2>");

            if (!hayProductos) {
                out.println(" <div class='alert alert-warning' role='alert'>");
                out.println("   EL carro está vacio ");
                out.println(" </div>");
            } else {
                out.println(" <ul class='list-group'>");

                Set<String> claves = carro.keySet();
                for (String producto : claves) {
                    out.println("<li class='list-group-item d-flex justify-content-between align-items-center'>");
                    out.println(producto);
                    out.println(" <span class='badge badge-primary badge-pill'>"
                            + carro.get(producto)+"</span>");
                    out.println("</li>");
                }
                

                out.println(" </ul>");
            }

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
