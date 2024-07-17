/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import DAO.DAOempleado;
import Modelo.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/**
 *
 * @author Victor
 */
public class SvMostrarEmpleado extends HttpServlet {

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
        // Obtener el valor del dniEmpleado desde el request
        String dni = request.getParameter("dniEmpleado");

        // Aquí puedes agregar validaciones si es necesario
        if (dni != null && !dni.isEmpty()) {
            DAOempleado daoEmpleado = new DAOempleado();
            Empleado empleado = daoEmpleado.obtenerEmpleadoPorDNI(dni);

            // Imprimir para debug
            System.out.println("ESTE ES EL DNI OBTENIDO DEL SERVLET MOSTRAR EMPLEADO: " + dni);

            // Establecer el empleado en la request
            request.setAttribute("empleado", empleado);

            // Redirigir al JSP con los datos del empleado
            String path = "/pages/employee/register.jsp"; 
            request.getRequestDispatcher(path).forward(request, response);
        } else {
            // Manejar el caso cuando dniEmpleado no está presente o es inválido
            response.sendRedirect("/pages/employee/error.jsp");
        }
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
