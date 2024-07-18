/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Conexion.ConectarBD;
import Modelo.HoraEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
public class SvGuardarHoraEmpleado extends HttpServlet {

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
        // Obtener los parámetros del request
        String fechaStr = request.getParameter("fecha");
        String hEntrada = request.getParameter("hEntrada");
        String hSalida = request.getParameter("hSalida");
        String dniEmpleado = request.getParameter("dniEmpleado");

        // Convertir la fecha de String a Date
        Date fecha = null;
        try {
            fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Crear un objeto HoraEmpleado con los datos recibidos
        HoraEmpleado horaEmpleado = new HoraEmpleado(fecha, hEntrada, hSalida, dniEmpleado);

        // Guardar en la base de datos utilizando un método en tu capa de servicio o DAO
        boolean exito = guardarHoraEmpleado(horaEmpleado);

        // Enviar una respuesta JSON al cliente
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print("{\"success\": " + exito + "}");
        out.flush();
    }
    
    // Método para guardar los datos en la base de datos
    private boolean guardarHoraEmpleado(HoraEmpleado horaEmpleado) {
        boolean exito = false;
        try {
            // Configurar la conexión a la base de datos (ajusta los parámetros según tu configuración)
            ConectarBD conectarBD = new ConectarBD();
            Connection con = conectarBD.getConnection();

            // Preparar la consulta SQL para insertar los datos
            String query = "INSERT INTO horarios (Fecha, Hentrada, Hsalida, DNI_empleado) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setDate(1, new java.sql.Date(horaEmpleado.getFecha().getTime())); // Convertir fecha a java.sql.Date
            pstmt.setString(2, horaEmpleado.gethEntrada());
            pstmt.setString(3, horaEmpleado.gethSalida());
            pstmt.setString(4, horaEmpleado.getDniEmpleado());

            // Ejecutar la consulta
            int filasInsertadas = pstmt.executeUpdate();
            if (filasInsertadas > 0) {
                exito = true;
            }

            // Cerrar recursos
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejo de excepciones (log, mensajes de error, etc.)
        }
        return exito;
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
