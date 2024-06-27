
package servlets;

import DAO.DAOproductos;
import Modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SvEliminarProductos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //CODIGO PARA QUE TE DEJE INSERTAR (Ñ) EN MYSQL
       response.setContentType("text/html;charset=UTF-8");
       request.setCharacterEncoding("UTF-8");

        //ID POR DEFECTO CON EL NÚMERO 0
        int id= Integer.parseInt(request.getParameter("ID"));  //ID 
       Producto prod = new Producto(id, null, null, null, 0.0, 0, 0, null); // Crear un objeto Producto con solo el ID
       DAOproductos prodao= new DAOproductos();
       
       String resultado = prodao.eliminar(prod);
       
        if ("Producto eliminado con éxito".equals(resultado)) {
            response.sendRedirect("/TodoPor1Sol/pages/admin/GestionarProductos.jsp");
        } else {
          // Manejar el error de inserción
            request.setAttribute("mensajeError", resultado);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        //response.getWriter().print(result);
        
        
        
        
        
        
        
        
        
        
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
