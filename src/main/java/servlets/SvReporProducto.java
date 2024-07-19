package servlets;

import Modelo.Empleado;
import Modelo.Producto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class SvReporProducto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvReporProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvReporProducto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        List<Producto> ListProducto = new ArrayList<>();
         List<Producto> tmpList = gson.fromJson(jsonData, new TypeToken<ArrayList<Producto>>() {}.getType());
        ListProducto.add(new Producto());
         ListProducto.addAll(tmpList);
                // Ejemplo: imprimir la lista en la consola
        System.out.println("\nSIZE: "+ListProducto.size());
        for (Producto e : ListProducto) {
            System.out.println(e);
        }
        
        // Aquí puedes manejar la lista de proveedores como desees
        // Por ejemplo, pasarla a JasperReports
        try {
            
            ServletContext srvContext = this.getServletConfig().getServletContext();
            //Obtenemos ruta del Logo de la empresa
            InputStream logoEmpresa = srvContext.getResourceAsStream("resources/img/home/Logo_1_Reporte.png");
            
            //Obtenemos ruta de la plantilla del reporte Jasper
            InputStream reporteProductos = srvContext.getResourceAsStream("resources/jasperReports/ReporteProductos.jasper");
            
            JasperReport report = (JasperReport) JRLoader.loadObject(reporteProductos);
            JRDataSource ds = new JRBeanCollectionDataSource(ListProducto);
            
            Map<String,Object> parameters = new HashMap<>();
            parameters.put("ds", ds);
            parameters.put("LogoEmpresa", logoEmpresa);
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "inline; filename=ReporteProductos.pdf");
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
