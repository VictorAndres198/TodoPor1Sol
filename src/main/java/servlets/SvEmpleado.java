
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
import java.net.URL;
import java.sql.Time;
import java.time.LocalDateTime;
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
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
                
            case "exportarExcel":
                exportToExcel(response);
                return; // Salir del método después de exportar

            default:
                response.sendRedirect(listar);
                break;
        }

        if(method.equalsIgnoreCase("edit")){
            RequestDispatcher vista = request.getRequestDispatcher(edit);
                vista.forward(request, response);
            
        }
   
    }//fin del processRequest
    
    
    protected void exportToExcel(HttpServletResponse response) throws IOException {
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setHeader("Content-Disposition", "attachment; filename=ReporteEmpleados.xlsx");

    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("Empleados");

    // Cargar la imagen del logo
    String logoURL = "https://www.sysfarmasoluciones.com/simbolo_sysfarma.png";
    InputStream is = new URL(logoURL).openStream();
    byte[] bytes = IOUtils.toByteArray(is);
    is.close();

    int logoHeight = 80; // Altura de la imagen
    int logoWidth = 63; // Ancho de la imagen
    int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
    CreationHelper helper = workbook.getCreationHelper();
    Drawing<?> drawing = sheet.createDrawingPatriarch();
    ClientAnchor anchor = helper.createClientAnchor();
    anchor.setCol1(0);
    anchor.setRow1(0);
    anchor.setCol2(1);
    anchor.setRow2(4);

    // Crear la imagen y ajustar tamaño
    Picture pict = drawing.createPicture(anchor, pictureIdx);
    pict.resize(1.0, 1.0); // Redimensionar al tamaño original de la imagen
    pict.resize(logoWidth / pict.getImageDimension().getWidth(), logoHeight / pict.getImageDimension().getHeight());

    // Estilos
    CellStyle headerStyle = workbook.createCellStyle();
    headerStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(207, 226, 255), null));
    headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    headerStyle.setBorderBottom(BorderStyle.THIN);
    headerStyle.setBorderTop(BorderStyle.THIN);
    headerStyle.setBorderRight(BorderStyle.THIN);
    headerStyle.setBorderLeft(BorderStyle.THIN);
    headerStyle.setAlignment(HorizontalAlignment.CENTER);
    Font headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerFont.setColor(IndexedColors.BLACK.getIndex());
    headerStyle.setFont(headerFont);
    
    // Estilo del titulo
    CellStyle titleStyle = workbook.createCellStyle();
    titleStyle.setAlignment(HorizontalAlignment.CENTER);
    titleStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
    titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

    Font titleFont = workbook.createFont();
    titleFont.setBold(true);
    titleFont.setColor(IndexedColors.BLACK.getIndex());
    titleFont.setFontHeightInPoints((short) 16);
    titleStyle.setFont(titleFont);

    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setBorderBottom(BorderStyle.THIN);
    cellStyle.setBorderTop(BorderStyle.THIN);
    cellStyle.setBorderRight(BorderStyle.THIN);
    cellStyle.setBorderLeft(BorderStyle.THIN);
    cellStyle.setAlignment(HorizontalAlignment.CENTER);

    // Estilo para la información de la empresa
    CellStyle infoStyle = workbook.createCellStyle();
    infoStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(207, 226, 255), null));
    infoStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    infoStyle.setBorderBottom(BorderStyle.THIN);
    infoStyle.setBorderTop(BorderStyle.THIN);
    infoStyle.setBorderRight(BorderStyle.THIN);
    infoStyle.setBorderLeft(BorderStyle.THIN);
    infoStyle.setAlignment(HorizontalAlignment.LEFT);

    // Información de la empresa
    String[][] empresaInfo = {
        {"Empresa :", "Todo Por 1 Sol"},
        {"RUC :", "20603841108"},
        {"Dirección :", "Jr. Jose Carlos Mariategui Nro. 299a"},
        {"Correo :", "TodoPor1Sol@gmail.com"},
        {"Fecha y Hora de impresión :", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm"))},
        {"Teléfono :", "981770647"}
    };

    // Agregar información de la empresa
    int rowIndex = 0;
    for (String[] info : empresaInfo) {
        Row row = sheet.createRow(rowIndex++);
        Cell cell1 = row.createCell(1);
        Cell cell2 = row.createCell(2);
        cell1.setCellValue(info[0]);
        cell2.setCellValue(info[1]);
        cell1.setCellStyle(infoStyle);
        cell2.setCellStyle(infoStyle);
    }

    // Crear fila de título
    Row titleRow = sheet.createRow(rowIndex++);
    Cell titleCell = titleRow.createCell(0);
    titleCell.setCellValue("REPORTE DE EMPLEADOS - TODO POR 1 SOL");
    titleCell.setCellStyle(titleStyle);
    sheet.addMergedRegion(new CellRangeAddress(titleRow.getRowNum(), titleRow.getRowNum(), 0, 8));

    // Crear encabezados
    Row headerRow = sheet.createRow(rowIndex++);
    String[] headers = {"DNI", "Nombre", "Apellidos", "Correo", "Teléfono", "Sueldo", "ID Farmacia", "Horario Entrada", "Horario Salida"};
    for (int i = 0; i < headers.length; i++) {
        Cell cell = headerRow.createCell(i);
        cell.setCellValue(headers[i]);
        cell.setCellStyle(headerStyle);
    }

    // Agregar datos
    DAOempleado dao = new DAOempleado();
    ArrayList<Empleado> listaEmpleados = dao.ListarEmpleado();
    for (Empleado e : listaEmpleados) {
        Row row = sheet.createRow(rowIndex++);
        row.createCell(0).setCellValue(e.getDni());
        row.createCell(1).setCellValue(e.getNombre());
        row.createCell(2).setCellValue(e.getApellidos());
        row.createCell(3).setCellValue(e.getCorreo());
        row.createCell(4).setCellValue(e.getTelefono());
        row.createCell(5).setCellValue(e.getSueldo().doubleValue());
        row.createCell(6).setCellValue(e.getIdFarm());
        row.createCell(7).setCellValue(e.getHorarioE().toString());
        row.createCell(8).setCellValue(e.getHorarioS().toString());

        // Aplicar estilo a las celdas
        for (int j = 0; j < headers.length; j++) {
            row.getCell(j).setCellStyle(cellStyle);
        }
    }

    // Ajustar el ancho de las columnas
    sheet.setColumnWidth(0, 30 * 256); // DNI
    sheet.setColumnWidth(1, 30 * 256); // Nombre
    sheet.setColumnWidth(2, 30 * 256); // Apellidos
    sheet.setColumnWidth(3, 40 * 256); // Correo
    sheet.setColumnWidth(4, 20 * 256); // Teléfono
    sheet.setColumnWidth(5, 15 * 256); // Sueldo
    sheet.setColumnWidth(6, 15 * 256); // ID Farmacia
    sheet.setColumnWidth(7, 20 * 256); // Horario Entrada
    sheet.setColumnWidth(8, 20 * 256); // Horario Salida

    // Escribir el archivo
    try (ServletOutputStream out = response.getOutputStream()) {
        workbook.write(out);
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
