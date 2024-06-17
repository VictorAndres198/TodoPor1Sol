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
        <title>Registro Empleado</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet"> <!-- Font Awesome -->
        <link href="../../resources/css/GestionarProveedor.css" rel="stylesheet" type="text/css"/>
        <link href="../../resources/css/admin.css" rel="stylesheet" type="text/css"/>
        <link href="../../resources/css/admin-display.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </head>
    <body class="parent-container">
        <!-- Para traer el layout(menu lateral) del admin -->
        <jsp:include page="../../admin_layout.jsp" />  
        <div class="box-Content">
            <div class="Frm-Header">
                <span class="Frm-Title">Gestionar Empleado</span>
                <div class="search-box">
                    <input type="input" class="search-bar">
                    <button type="submit" class="search-btn">
                        <img class="search-icon" src="../../resources/img/icons/search-symbol.png" alt=""/>
                    </button> 
                </div>
            </div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">DNI</th>
                        <th class="text-center">NOMBRE</th>                     
                        <th class="text-center">APELLIDOS</th>
                        <th class="text-center">CORREO</th>
                        <th class="text-center">TELEFONO</th>
                        <th class="text-center">SUELDO</th>
                        <th class="text-center">FARMACIA</th>
                        <th class="text-center">H. ENTRADA</th>
                        <th class="text-center">H. SALIDA</th>
                        <th class="text-center">BOTONES</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        DAOempleado dao = new DAOempleado();
                        ArrayList<Empleado> Lista = dao.ListarEmpleado();
                        Empleado e = null;
                        for (int i = 0; i < Lista.size(); i++) {
                            e = Lista.get(i);

                    %>
                    <tr>
                        <td class="text-center"><%= e.getDni() %></td>
                        <td><%= e.getNombre() %></td>
                        <td><%= e.getApellidos() %></td>
                        <td class="text-center"><%= e.getCorreo() %></td>
                        <td class="text-center"><%= e.getTelefono() %></td>
                        <td class="text-center"><%= e.getSueldo() %></td>
                        <td class="text-center"><%= e.getIdFarm() %></td>
                        <td class="text-center"><%= e.getHorarioE() %></td>
                        <td class="text-center"><%= e.getHorarioS() %></td>
                        <td class="text-center">
                            <a href="/TodoPor1Sol/SvEmpleado?accion=editar&DNI=<%= e.getDni() %>" class="btn btn-success"> <i class="fas fa-edit"></i> </a>
                            <a href="/TodoPor1Sol/SvEmpleado?accion=eliminar&DNI=<%= e.getDni() %>" class="btn btn-danger">
                                <i class="fas fa-trash-alt"></i>
                            </a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
        <!-- SCRIPT PARA CARGAR IMAGENES-->
        <script src="../../loadImages.js" type="text/javascript"></script>
        <!-- SCRIPT PARA MANEJAR LOS DATOS ENVIADOS PARA GENERAR REPORTE -->
        <script src="../../generateReport.js" type="text/javascript"></script>
        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
    </body>
</html>
