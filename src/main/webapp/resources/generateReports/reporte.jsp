<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.*"%>
<%@page import="Conexion.ConectarBD"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ConectarBD cn = new ConectarBD();
            Connection con = cn.getConnection();

            File jasperFile = new File(application.getRealPath("/resources/jasperReports/ReporteProductos.jasper"));
            Map parametro = new HashMap();
            byte[] bytes = JasperRunManager.runReportToPdf(jasperFile.getPath(), null, con);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            response.setHeader("Content-Disposition", "attachment; filename=\"ReporteProductos.pdf\"");
            ServletOutputStream output = response.getOutputStream();
            response.getOutputStream();
            output.write(bytes, 0, bytes.length);
            output.flush();
            output.close();

        %>





    </body>
</html>
