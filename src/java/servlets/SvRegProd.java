/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Modelo.Productos;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
@WebServlet(name = "SvRegProd", urlPatterns =
{
    "/SvRegProd"
})
public class SvRegProd extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvRegProd</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvRegProd at " + request.getContextPath() + "</h1>");
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
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String fechaVencimientoStr = request.getParameter("fechaVencimiento");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Ajusta el patrón según el formato de tu fecha
        Date fechaVencimiento = null;
        try
        {
            fechaVencimiento = formatter.parse(fechaVencimientoStr);
        } catch (ParseException e)
        {
            e.printStackTrace();
            // Maneja la excepción según sea necesario, por ejemplo, establecer un mensaje de error o un valor por defecto
        }
      int stock = Integer.parseInt(request.getParameter("stock"));
       double precio = Double.parseDouble(request.getParameter("precio"));       
         int categoria= Integer.parseInt(request.getParameter("categoria"));
      String proveedor= request.getParameter("proveedor"); 
      
         Productos RegProd = new Productos();
        
         RegProd.setNombre(nombre);
         RegProd.setDescripcion(descripcion);
         RegProd.setFechaVencimiento(fechaVencimiento);
         RegProd.setID_categoria(categoria);
         RegProd.setPrecio(precio);
         RegProd.setStock(stock);
         RegProd.setRUC_Prov(proveedor);
        System.out.println("nombre: " + nombre);
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
