/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Conexion.ConectarBD;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
public class SvObtenerPrecioProducto extends HttpServlet {

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
       response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        // Obtener el ID del producto desde la solicitud
        String idProducto = request.getParameter("id");
        if (idProducto != null && !idProducto.isEmpty()) {
            try {
                // Conectar a la base de datos y obtener el precio del producto
                ConectarBD cn = new ConectarBD();                
            Connection con = cn.getConnection();
                String sql = "SELECT Precio FROM Productos WHERE ID_Prod = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, idProducto);
                ResultSet rs = pstmt.executeQuery();
                
                // Procesar resultado y enviar respuesta JSON
                if (rs.next()) {
                    double precio = rs.getDouble("Precio");
                    out.println("{\"precio\": " + precio + "}");
                } else {
                    out.println("{\"error\": \"Producto no encontrado\"}");
                }
                pstmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("{\"error\": \"Error de base de datos\"}");
            }
        } else {
            out.println("{\"error\": \"ID de producto no proporcionado\"}");
        }
        out.close();
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
