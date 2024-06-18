
package servlets;

import Modelo.Empleado;
import Modelo.Proveedor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
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


@WebServlet(name = "SvReporteProveedor", urlPatterns = {"/SvReporteProveedor"})
public class SvReporteProveedor extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        
        // Convertir JSON a objeto Java(Lista de Proveedores)
        String jsonData = sb.toString();
        Gson gson = new Gson();
        
        List<Proveedor> ListProveedores = new ArrayList<>();
        List<Proveedor> tmpList = gson.fromJson(jsonData, new TypeToken<List<Proveedor>>() {}.getType());
        ListProveedores.add(new Proveedor());
        ListProveedores.addAll(tmpList);
        
        
                // Ejemplo: imprimir la lista en la consola
        System.out.println("\nSIZE: "+ListProveedores.size());
        for (Proveedor proveedor : ListProveedores) {
            System.out.println(proveedor);
        }
        
        // Aquí puedes manejar la lista de proveedores como desees
        // Por ejemplo, pasarla a JasperReports
        try {
            
            ServletContext srvContext = this.getServletConfig().getServletContext();
            //Obtenemos ruta del Logo de la empresa
            InputStream logoEmpresa = srvContext.getResourceAsStream("resources/img/home/Logo_1_Reporte.png");
            
            //Obtenemos ruta de la plantilla del reporte Jasper
            InputStream reporteProveedores = srvContext.getResourceAsStream("resources/jasperReports/ReporteProveedores.jasper");
            
            JasperReport report = (JasperReport) JRLoader.loadObject(reporteProveedores);
            JRDataSource ds = new JRBeanCollectionDataSource(ListProveedores,false);
            
            Map<String,Object> parameters = new HashMap<>();
            parameters.put("ds", ds);
            parameters.put("LogoEmpresa", logoEmpresa);
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "inline; filename=ReporteProveedores.pdf");
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
    }

}
