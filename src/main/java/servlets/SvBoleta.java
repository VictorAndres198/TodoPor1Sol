
package servlets;

import Modelo.ClientePersona;
import Services.ServiceBoleta;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvBoleta", urlPatterns = {"/SvBoleta"})
public class SvBoleta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");      
        
        String id = request.getParameter("id");
        String idEmpl = request.getParameter("idEmpl");
        ServiceBoleta serviceBoleta = new ServiceBoleta();
        ClientePersona cli = serviceBoleta.FindCliPersonaById(id);
        System.out.println("valor: "+id);
        System.out.println(cli);
        System.out.println("Consultado por el usuario: "+idEmpl);
        
        Gson gson = new Gson();
        String jsonData = gson.toJson(cli);
        
        PrintWriter out = response.getWriter();
        out.print(jsonData);
        out.flush();
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
