/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import DAO.DAOproductos;
import Modelo.Producto;
import java.io.IOException;
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
@WebServlet(name = "SvProductoss", urlPatterns =
{
    "/SvProductoss"
})
public class SvProductoss extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre"); //nombre 
        String descripcion = request.getParameter("descripcion"); //descripcion 
        String fechaVencimientoStr = request.getParameter("fechaVencimiento"); //fecha de vencimiento
        int Stock = Integer.parseInt(request.getParameter("stock")); // Stock
        String precioStr = request.getParameter("precio"); //precio
        
        String proveedorRUC = request.getParameter("proveedor"); // Obtener el RUC del proveedor

        
        
        
         int categoria= Integer.parseInt(request.getParameter("categoria")); // Obtener el ID categoria
         // Convertir el parámetro a double
        double precio = 0.0; // Valor por defecto en caso de que no se pueda convertir

        try {
            precio = Double.parseDouble(precioStr);
        } catch (NumberFormatException e) {
            // Manejo de error en caso de que el parámetro no sea un número válido
            e.printStackTrace(); // o puedes manejar el error de otra forma
        }
         
         //conversion de string fecha a date
         SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
        
        Date fechaVencimiento = null;
       
        try {
            fechaVencimiento = d.parse(fechaVencimientoStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
     
        
        
       Producto prod = new Producto(nombre, descripcion, fechaVencimiento, precio, Stock, categoria, proveedorRUC);
       DAOproductos prodao= new DAOproductos();

        String result = prodao.insertarProducto(prod);
        response.getWriter().print(result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        

        
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
