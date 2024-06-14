
package servlets;

import java.io.IOException;
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
    
      Producto pro = new Producto();
      DAOproductos dao = new DAOproductos();
      String id;
      
       public void LeerDatosProducto(HttpServletRequest request, HttpServletResponse response){
       pro.setNombre(request.getParameter("nombre"));
       pro.setDescripcion(request.getParameter("descripcion"));
       pro.setFechaVencimiento(java.sql.Date.valueOf(request.getParameter("fechaVencimiento")));
       pro.setStock(Integer.parseInt(request.getParameter("stock")));
       pro.setPrecio(Double.parseDouble(request.getParameter("precio")));
       pro.setRuc(request.getParameter("proveedor"));
       pro.setID_categoria(Integer.parseInt(request.getParameter("categoria")));
   

       
   }  
        


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String acceso="";
        String action = request.getParameter("accion");//accion: listar,agregar,editar,eliminar
        /*
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
        }*/
        RequestDispatcher vista= request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private Date Date(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
