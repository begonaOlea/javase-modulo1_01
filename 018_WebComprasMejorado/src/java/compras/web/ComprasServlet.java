package compras.web;

import compras.domain.Producto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ComprasServlet",
        urlPatterns = {"/compras"},
        loadOnStartup = 0)
public class ComprasServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

        //CREO UN ATRIBUTO DE ÁMBITO DE APLICACION CON
        //LA LISTA DE PRODUCTOS
        List<Producto> productos = new ArrayList();

        productos.add(new Producto(1, "Zapatos", 30, 56.9));
        productos.add(new Producto(2, "Libro", 0, 16.0));
        productos.add(new Producto(3, "Bolígrafo", 10, 1.2));
        productos.add(new Producto(4, "Televisión", 10, 456.5));

        this.getServletContext().setAttribute("productos", productos);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.  LEER PARAMETRO DE PETICION
        boolean hayProducto = true;
        boolean hayStock = false;
        String mensaje = "";
        Producto p = null;

        String paramId = request.getParameter("id");
        if (paramId == null) {
            hayProducto = false;
        }

        //2. VER SI HAY STOCK PARA EL PRODUCTO
        if (hayProducto) {
            int id = Integer.parseInt(paramId);

            List<Producto> productos = (ArrayList<Producto>) this.getServletContext().getAttribute("productos");

            p = productos.get(--id);

            //validar que el producto tiene stock
            int stock = p.getStock();
            if (p.getStock() > 0) {
                hayStock = true;
                stock--;
                p.setStock(stock);
            }else{
                mensaje ="No hay stock para el producto "
                        + p.getDescripcion();
            }
        }

        //obtener sesion. Si no existe la crea
        HttpSession sesion = request.getSession();
        // 3. OBTENER LA SESION HTML
        if (hayStock) {


            // 4. OBTENER ATRIBUTO DE SESION CARRO
            //mirar si esta sesion tiene el atribut carro
            //LEER ATRIBUTO DE SESION
            Map<Producto, Integer> carro;
            if (sesion.getAttribute("carro") == null) {
                //es la primera vez que solicitas l session 
                //y todavía no le he añadido el carro
                carro = new LinkedHashMap();
                sesion.setAttribute("carro", carro);

            } else {
                //OBTENE EL ATRIBUTO CARRO
                carro = (LinkedHashMap) sesion.getAttribute("carro");
            }

            //5. AÑADIR EL PRODUCTO AL MAP que ya esta 
            if (carro.containsKey(p)) {
                //ya esta el producto en el carro
                //incrementa valor
                Integer cantidad = carro.get(p);
                carro.put(p, ++cantidad);
            } else {
                //no esta todavía
                //añadir 
                carro.put(p, 1);
            }
            sesion.setAttribute("mensaje", "");
            response.sendRedirect("carro.jsp");
        }else{
            sesion.setAttribute("mensaje", mensaje);
            //no hay stock
            response.sendRedirect("compras.jsp");
        }

        

    }//fin doGet

}
