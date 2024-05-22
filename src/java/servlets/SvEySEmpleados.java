package servlets;


import DAO.DAOempleado;
import Conexion.ConectarBD;
import java.sql.Connection;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Modelo.Empleado;
import Modelo.Horario;

/**
 *
 * @author Victor
 */
@WebServlet(name = "SvEySEmpleados", urlPatterns = {"/SvEySEmpleados"})
public class SvEySEmpleados extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String dniEmpleado = (String) session.getAttribute("dniEmpleado"); // Supongo que el DNI se almacena en la sesión

        DAOempleado daoEmpleado = new DAOempleado();
        Empleado empleado = daoEmpleado.obtenerEmpleadoPorDNI(dniEmpleado);
        List<Horario> horarios = daoEmpleado.obtenerHorariosPorEmpleado(dniEmpleado);

        request.setAttribute("empleado", empleado);
        request.setAttribute("horarios", horarios);
        request.getRequestDispatcher("/pages/employee/register.jsp").forward(request, response);
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
        return "Servlet que maneja los horarios y datos del empleado";
    }
}
