
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//librerias
import Modelo.*;
import DAO.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {
      String listar="pages/admin/GestionarEmpleados.jsp";
      String add = "pages/admin/NuevoEmpleado.jsp";
      String edit = "pages/admin/EditarEmpleados.jsp";
      Empleado empleado = new Empleado();
      DAOempleado dao = new DAOempleado();
      String dni;
   
      //metodo que lee los datos para el empleado
    public void LeerDatosEmpleado(HttpServletRequest request, HttpServletResponse response) {
    try {
        // Asignar valores a los atributos del empleado
        empleado.setDni(request.getParameter("dni"));
        empleado.setNombre(request.getParameter("nombre"));
        empleado.setApellidos(request.getParameter("apellidos"));
        empleado.setCorreo(request.getParameter("correo"));
        empleado.setTelefono(request.getParameter("telefono"));
        empleado.setSueldo(new BigDecimal(request.getParameter("sueldo")));
        empleado.setIdFarm(Integer.parseInt(request.getParameter("farm")));

        // Convertir los Strings de horario a objetos Time
        String horarioEString = request.getParameter("horarioE");
        System.out.println(horarioEString);
        String horarioSString = request.getParameter("horarioS");
        System.out.println(horarioSString);
        
        // Crear objetos Time directamente desde los Strings
//        Time horarioE = Time.valueOf(horarioEString);
//        Time horarioS = Time.valueOf(horarioSString);

        LocalTime e = LocalTime.parse(horarioEString, DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime s= LocalTime.parse(horarioSString, DateTimeFormatter.ofPattern("HH:mm"));
        
        empleado.setHorarioE(e);
        empleado.setHorarioS(s);
        
    } catch (Exception e) {
        e.printStackTrace();
        // Manejar cualquier excepción que pueda ocurrir, como ParseException
    }
}
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String acceso="";
        String action = request.getParameter("accion");//accion: listar,agregar,editar,eliminar
        String method="";
        switch (action) {
            case "Listar":
                acceso = listar;
                break;
            case "Agregar":
                LeerDatosEmpleado(request, response);
                dao.Insert(empleado);
                response.sendRedirect(listar);
                break;
            case "Editar":
                request.setAttribute("DNI", request.getParameter("DNI"));
//                acceso = edit;
                
                method="edit";
                break;
            case "Actualizar":
                LeerDatosEmpleado(request, response);
                dao.Update(empleado);
                acceso = listar;
                response.sendRedirect(listar);

                break;
            case "eliminar":
                dni = request.getParameter("DNI");
                dao.Delete(dni);
                acceso = listar;
                response.sendRedirect(listar);

                break;
            default:
                break;
        }

        if(method.equalsIgnoreCase("edit")){
            RequestDispatcher vista = request.getRequestDispatcher(edit);
                vista.forward(request, response);
            //usar el dispacher
        }
//        if(action.equalsIgnoreCase("listar")){
//            acceso=listar;
////        }else if(action.equalsIgnoreCase("add")){
////            acceso=add;
//        }else if(action.equalsIgnoreCase("Agregar")){
//            LeerDatosEmpleado(request,response);
//            dao.Insert(empleado);
////            response.sendRedirect("pages/admin/GestionarEmpleados.jsp");
//            acceso=listar;
//        }else if (action.equalsIgnoreCase("Editar")) {
//            request.setAttribute("DNI", request.getParameter("DNI"));
//            acceso=edit;
//        }else if (action.equalsIgnoreCase("Actualizar")) {
//            LeerDatosEmpleado(request,response);
//            dao.Update(empleado);
//            acceso=listar;
//        }else if (action.equalsIgnoreCase("eliminar")) {
//            dni=request.getParameter("DNI");
//            dao.Delete(dni);
//            acceso=listar;
//        }
//        response.sendRedirect(acceso);
////        RequestDispatcher vista= request.getRequestDispatcher(acceso);
////        vista.forward(request, response);
////        
    }//fin del processRequest

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

    
    
}
