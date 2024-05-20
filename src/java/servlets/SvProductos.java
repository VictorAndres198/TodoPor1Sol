
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Librerias
import Modelo.*;
import DAO.*;
import java.util.Date;
import javax.servlet.RequestDispatcher;


@WebServlet(name = "SvProductos", urlPatterns = {"/SvProductos"})
public class SvProductos extends HttpServlet {
    
      Productos pro = new Productos();
      DAOproductos dao = new DAOproductos();
      String id;
      
       public void LeerDatosProducto(HttpServletRequest request, HttpServletResponse response){
       pro.setNombre(request.getParameter("nombre"));
       pro.setDescripcion(request.getParameter("descripcion"));
       pro.setFechaVencimiento(java.sql.Date.valueOf(request.getParameter("fechaVencimiento")));
       pro.setStock(Integer.parseInt(request.getParameter("stock")));
       pro.setPrecio(Double.parseDouble(request.getParameter("precio")));
       pro.setRUC_Prov(request.getParameter("proveedor"));
       pro.setID_categoria(Integer.parseInt(request.getParameter("categoria")));


       
   }  
        


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String acceso="";
        String action = request.getParameter("accion");//accion: listar,agregar,editar,eliminar
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }else if(action.equalsIgnoreCase("Agregar")){
            LeerDatosCargo(request,response);
            dao.AgregarCargo(cargo);
            acceso=listar;
        }else if (action.equalsIgnoreCase("Editar")) {
            request.setAttribute("idcar", request.getParameter("idcar"));
            acceso=edit;
        }else if (action.equalsIgnoreCase("Actualizar")) {
            LeerDatosCargo(request,response);
            dao.EditarCargo(cargo);
            acceso=listar;
        }else if (action.equalsIgnoreCase("eliminar")) {
            id=request.getParameter("idcar");
            dao.EliminarCargo(id);
            acceso=listar;
        }
        RequestDispatcher vista= request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
    }//fin del processRequest

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

    private Date Date(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
