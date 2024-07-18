package servlets;

import DAO.DAOempleado;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvInicioSesion", urlPatterns = {"/SvInicioSesion"})
public class SvInicioSesion extends HttpServlet {

 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {    
    String dni = request.getParameter("dni");    
    String nombre = request.getParameter("usuario"); 
    String clave = request.getParameter("contrasena");
    
    DAOempleado daoUsuario = new DAOempleado();
    Usuario usuario = daoUsuario.validarUsuario(dni, nombre, clave);

    if (usuario != null) {        
        // Añadir el usuario a la sesión
        HttpSession session = request.getSession();
        session.setAttribute("usuario", usuario);
        System.out.println(" ESTO DEVUELVE MI METODO GETDNI() " +
                 usuario.getDniEmpleado() + "/n Esto devuelve mi GETNOMBRE() "+ usuario.getNombre());
        response.sendRedirect("employee.jsp");
    } else {
        System.out.println("DNI, Usuario o contraseña incorrectas");
        request.setAttribute("error", "DNI, Usuario o contraseña incorrectas");
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
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
        return "Servlet para manejar el inicio de sesión";
    }
}