package servlets;

import DAO.DAOempleado;
import java.sql.Time;
import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Modelo.Empleado;

/**
 *
 * @author Victor
 */
@WebServlet(name = "SvRegistrarHorario", urlPatterns = {"/SvRegistrarHorario"})
public class SvRegistrarHorario extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String dniEmpleado = (String) session.getAttribute("dniEmpleado");

        DAOempleado daoEmpleado = new DAOempleado();
        Empleado empleado = daoEmpleado.obtenerEmpleadoPorDNI(dniEmpleado);

        // Verificar si el empleado ya tiene un registro para hoy
        // Aquí necesitarías agregar lógica para verificar esto en tu DAO

        // Si no tiene registro, crea uno nuevo
        // Aquí necesitarías agregar lógica para insertar un nuevo registro en tu DAO

        // Si tiene registro, actualiza la hora de salida
        // Aquí necesitarías agregar lógica para actualizar el registro existente en tu DAO

        // Redirige de vuelta a la página de registro
        response.sendRedirect("SvHySEmpleados");
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
        return "Servlet que registra la entrada y salida de empleados";
    }

}
