package servlets;

import DAO.DAOempleado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvProbarConexionBD", urlPatterns = {"/SvProbarConexionBD"})
public class SvProbarConexionBD extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOempleado daoEmpleado = new DAOempleado();
        boolean conexionExitosa = daoEmpleado.probarConexionBD();

        // Enviar respuesta al cliente
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(conexionExitosa ? "Conexión exitosa" : "Error al conectar a la base de datos");
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
        return "Servlet para probar la conexión a la base de datos";
    }

}
