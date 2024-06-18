
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.BufferedReader;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {
      String listar="pages/admin/GestionarEmpleados.jsp";
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

        // Convertir los Strings de horario a objetos LocalTime
        String horarioEString = request.getParameter("horarioE");
        String horarioSString = request.getParameter("horarioS");

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
            case "agregar":
                LeerDatosEmpleado(request, response);
                dao.Insert(empleado);
                response.sendRedirect(listar);
                break;
                
            case "editar":
                request.setAttribute("DNI", request.getParameter("DNI"));
                method="edit";
                break;
                
            case "actualizar":
                LeerDatosEmpleado(request, response);
                dao.Update(empleado);
                response.sendRedirect(listar);

                break;
                
            case "eliminar":
                dni = request.getParameter("DNI");
                dao.Delete(dni);
                acceso = listar;
                response.sendRedirect(listar);
                break;
        }

        if(method.equalsIgnoreCase("edit")){
            RequestDispatcher vista = request.getRequestDispatcher(edit);
                vista.forward(request, response);
            
        }
   
    }//fin del processRequest


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        ServletOutputStream out = response.getOutputStream();
        
        // Leer el cuerpo de la solicitud(contenido de la tabla proveedores)
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        
        // Convertir JSON a objeto Java(Lista de Empleados)
        String jsonData = sb.toString();
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalTime.class, new TypeAdapter<LocalTime>() {
                private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

                @Override
                public void write(JsonWriter jsonWriter, LocalTime localTime) throws IOException {
                    jsonWriter.value(localTime.format(formatter));
                }

                @Override
                public LocalTime read(JsonReader jsonReader) throws IOException {
                    return LocalTime.parse(jsonReader.nextString(), formatter);
                }
            }).create();
        List<Empleado> ListEmpleados = new ArrayList<>();
        List<Empleado> tmpList = gson.fromJson(jsonData, new TypeToken<ArrayList<Empleado>>() {}.getType());
        
        ListEmpleados.add(new Empleado());
        ListEmpleados.addAll(tmpList);
                // Ejemplo: imprimir la lista en la consola
        System.out.println("\nSIZE: "+ListEmpleados.size());
        for (Empleado e : ListEmpleados) {
            System.out.println(e);
        }
        
        // Aquí puedes manejar la lista de proveedores como desees
        // Por ejemplo, pasarla a JasperReports
        try {
            
            ServletContext srvContext = this.getServletConfig().getServletContext();
            //Obtenemos ruta del Logo de la empresa
            InputStream logoEmpresa = srvContext.getResourceAsStream("resources/img/home/Logo_1_Reporte.png");
            
            //Obtenemos ruta de la plantilla del reporte Jasper
            InputStream reporteEmpleados = srvContext.getResourceAsStream("resources/jasperReports/ReporteEmpleados.jasper");
            
            JasperReport report = (JasperReport) JRLoader.loadObject(reporteEmpleados);
            JRDataSource ds = new JRBeanCollectionDataSource(ListEmpleados);
            
            Map<String,Object> parameters = new HashMap<>();
            parameters.put("ds", ds);
            parameters.put("LogoEmpresa", logoEmpresa);
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "inline; filename=ReporteEmpleados.pdf");
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters,ds);
            JasperExportManager.exportReportToPdfStream(jasperPrint, out);
            out.flush();
            out.close();
            
        } catch (Exception e) {
            
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("status", "ok");
            responseMap.put("msj", "Data received and processed");
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(gson.toJson(responseMap));
            out.flush();
            e.printStackTrace();
            throw new ServletException(e);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    
}
