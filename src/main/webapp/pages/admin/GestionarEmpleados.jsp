<%@page import="Conexion.ConectarBD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Empleado"%>
<%@page import="DAO.DAOempleado"%>
<%@page import="DAO.DAOempleado"%>
<%@page import="java.text.ParseException"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionar Empleado</title>
        <link href="../../resources/css/GestionarEmpleado.css" rel="stylesheet" type="text/css"/>
        <script src="../../resources/js/BuscadorEmpleados.js" type="text/javascript"></script>
        <link href="../../resources/css/admin.css" rel="stylesheet" type="text/css"/>
        <link href="../../resources/css/admin-display.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet"> <!-- Font Awesome -->
    </head>
    <style>
            /* Estilo para centrar el texto en las celdas de la tabla */
            .table td, .table th {
                text-align: center;
                vertical-align: middle;
            }
    </style>
    <body class="parent-container">
        <!-- Para traer el layout(menu lateral) del admin -->
        <jsp:include page="../../admin_layout.jsp" />  
        <div class="box-Content">
            <div class="Frm-Header">
                <span class="Frm-Title">Gestionar Empleados</span>
                <div class="search-box">
                    <input id="searchTerm" type="text" class="search-bar" onkeyup="doSearch()" placeholder="Buscar empleados...">
                    <button type="submit" class="search-btn">
                        <img class="search-icon" src="../../resources/img/icons/search-symbol.png" alt=""/>
                    </button> 
                </div>
            </div>
            <div class="Frm-Table table-responsive">
            <table class="table table-striped table-sm align-middle"  id="Table-Empleados">
                <thead class="align-middle table-header">
                    <tr class="table-primary">
                        <th>DNI</th>
                        <th>NOMBRE</th>                     
                        <th>APELLIDOS</th>
                        <th>CORREO</th>
                        <th>TELEFONO</th>
                        <th>SUELDO</th>
                        <th>FARMACIA</th>
                        <th>H. ENTRADA</th>
                        <th>H. SALIDA</th>
                        <th>BOTONES</th>
                    </tr>
                </thead>
                <tbody class="table-group-divider">
                    <%
                        DAOempleado dao = new DAOempleado();
                        ArrayList<Empleado> Lista = dao.ListarEmpleado();
                        Empleado e = null;
                        for (int i = 0; i < Lista.size(); i++) {
                            e = Lista.get(i);

                    %>
                    <tr>
                        <td><%= e.getDni() %></td>
                        <td><%= e.getNombre() %></td>
                        <td><%= e.getApellidos() %></td>
                        <td><%= e.getCorreo() %></td>
                        <td><%= e.getTelefono() %></td>
                        <td><%= e.getSueldo() %></td>
                        <td><%= e.getIdFarm() %></td>
                        <td><%= e.getHorarioE() %></td>
                        <td><%= e.getHorarioS() %></td>
                        <td>
                            <a href="/TodoPor1Sol/SvEmpleado?accion=editar&DNI=<%= e.getDni() %>" class="btn btn-success"> 
                                <i class="fas fa-edit"></i>
                            </a>
                            <a href="/TodoPor1Sol/SvEmpleado?accion=eliminar&DNI=<%= e.getDni() %>" class="btn btn-danger">
                                <i class="fas fa-trash-alt"></i>
                            </a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            </div>
            <div class="Frm-Btns-Report">
                <button class="Btn_PDF" onclick="sendReportData()">Generar Reporte</button>
            </div>
            <div class="Frm-Btns-Report">
            <a href="/TodoPor1Sol/SvEmpleado?accion=exportarExcel" class="btn btn-primary">Exportar a Excel</a>
        </div>
        </div>
        <!-- SCRIPT PARA CARGAR IMAGENES-->
        <script src="../../loadImages.js" type="text/javascript"></script>
        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
        
       <!-- SCRIPT PARA MANEJAR LOS DATOS ENVIADOS PARA GENERAR REPORTE -->
       <script src="../../resources/generateReports/reportEmpleado.js" type="text/javascript"></script>

 
    </body>
</html>
