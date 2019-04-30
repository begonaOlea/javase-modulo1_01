package demo.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author begonaolea
 */
public class SaludoServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.

        System.out.println(".... Iniciando el ServletSaludo");

    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.

        System.out.println("... Cerrando el Servlet");

    }

    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        System.out.println("... ATENDIENDO UNA PETICION GET");
         //leer el PARAMETRO DE LA PETICIÓN
        String paramNombre = request.getParameter("nombre");
        if (paramNombre == null) {
            paramNombre = "Amigo";
        }

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Saludo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hola " + paramNombre+ "</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("... ATENDIENDO UNA PETICION POST");

        //leer el PARAMETRO DE LA PETICIÓN
        String paramNombre = request.getParameter("nombre");
        if (paramNombre == null) {
            paramNombre = "Amigo";
        }

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Saludo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hola " + paramNombre+ "</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();

    }

}
