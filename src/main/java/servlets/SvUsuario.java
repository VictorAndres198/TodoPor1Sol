package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Usuario;
import DAO.DAOusuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletOutputStream;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.ClientAnchor.AnchorType;
import org.apache.poi.xssf.usermodel.XSSFColor;


@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {
    String listar="pages/admin/NuevoUsuario.jsp";
    Usuario usuario = new Usuario();
    DAOusuario dao = new DAOusuario();

    public void LeerDatosUsuario(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            request.setCharacterEncoding("UTF-8");
            usuario.setDniEmpleado(request.getParameter("dniEmpleado"));
            usuario.setNombre(request.getParameter("nombre"));
            usuario.setClave(request.getParameter("clave"));
            
            // Logging para depurar
            System.out.println("LeerDatosUsuario - dniEmpleado: " + usuario.getDniEmpleado());
            System.out.println("LeerDatosUsuario - nombre: " + usuario.getNombre());
            System.out.println("LeerDatosUsuario - clave: " + usuario.getClave());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("accion");
        
        // Logging para depurar
        System.out.println("processRequest - action: " + action);

        switch (action) {
            case "agregar":
                LeerDatosUsuario(request, response);
                dao.Insert(usuario);
                response.sendRedirect(listar);
                break;

            case "actualizar":
                LeerDatosUsuario(request, response);
                dao.Update(usuario);
                response.sendRedirect(listar);
                break;

            case "eliminar":
                String dni = request.getParameter("dniEmpleado");
                
                // Logging para depurar
                System.out.println("processRequest - eliminar - dni: " + dni);

                dao.Delete(dni);
                response.sendRedirect(listar);
                break;
                
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
        return "Short description";
    }
}


