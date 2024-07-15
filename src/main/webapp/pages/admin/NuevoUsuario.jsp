<%@page import="Modelo.Usuario"%>
<%@page import="DAO.DAOusuario"%>
<%@page import="Modelo.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DAOempleado"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    <title>Gestionar Usuario</title>
    <link href="../../resources/css/GestionarUsuario.css" rel="stylesheet" type="text/css"/>
    <link href="../../resources/css/admin.css" rel="stylesheet" type="text/css"/>
    <link href="../../resources/css/admin-display.css" rel="stylesheet" type="text/css"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body class="parent-container">
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
        <Style>
            .card {
                margin-top: 20px;
            }
            .card-header {
                background-color: #cfe2ff; /* Color de fondo del encabezado */
                color: #000;
            }
        </Style>

        <!-- Formulario para agregar/editar usuarios -->
        <div class="card mb-4">
            <div class="card-header">
                <h5 class="card-title">Formulario de Usuario</h5>
            </div>
            <div class="card-body">
                <form id="userForm" action="/TodoPor1Sol/SvUsuario" method="POST" class="row g-3">
                    <input type="hidden" name="accion" id="formAction" value="agregar">
                    <div class="col-md-4">
                        <select name="dniEmpleado" id="dniEmpleado" class="form-control" required>
                            <option value="">Seleccionar DNI</option>
                            <% 
                                DAOempleado daoEmp = new DAOempleado();
                                ArrayList<Empleado> listaEmpleados = daoEmp.ListarEmpleado();
                                for (Empleado emp : listaEmpleados) {
                            %>
                            <option value="<%= emp.getDni() %>"><%= emp.getDni() %></option>
                            <% } %>
                        </select>
                    </div>
                    <div class="col-md-4">
                        <input type="text" name="nombre" id="nombre" class="form-control" placeholder="Nombre" required>
                    </div>
                    <div class="col-md-4">
                        <input type="password" name="clave" id="clave" class="form-control" placeholder="Clave" required>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" id="addButton" class="btn btn-success">Agregar Usuario</button>
                        <button type="button" id="editButton" class="btn btn-warning" style="display: none;">Editar Usuario</button>
                    </div>
                </form>
            </div>
        </div>
        <!-- Tabla de Usuarios --> 
            <div class="Frm-Table table-responsive">
                <table class="table table-striped table-sm align-middle" id="Table-Usuario">
                    <thead class="align-middle table-header">
                        <tr class="table-primary">
                            <th>DNI</th>
                            <th>NOMBRE</th>
                            <th>CLAVE</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody class="table-group-divider">
                        <%
                            DAOusuario dao = new DAOusuario();
                            ArrayList<Usuario> listaUsuarios = dao.ListarUsuario();
                            Usuario u = null;
                            for (int i = 0; i < listaUsuarios.size(); i++) {
                                u = listaUsuarios.get(i);
                        %>
                        <tr>
                            <td><%= u.getDniEmpleado() %></td>
                            <td><%= u.getNombre() %></td>
                            <td><%= u.getClave() %></td>
                            <td>
                                <a href="javascript:void(0);" class="btn btn-success editButton" data-dni="<%= u.getDniEmpleado() %>" data-nombre="<%= u.getNombre() %>" data-clave="<%= u.getClave() %>"> 
                                    <i class="fas fa-edit"></i>
                                </a>
                                <a href="/TodoPor1Sol/SvUsuario?accion=eliminar&dniEmpleado=<%= u.getDniEmpleado() %>" class="btn btn-danger">
                                    <i class="fas fa-trash-alt"></i>
                                </a>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
    </div>

    <script src="../../loadImages.js" type="text/javascript"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
    
    <script>
        $(document).ready(function(){
            $('.editButton').on('click', function(){
                var dniEmpleado = $(this).data('dni');
                var nombre = $(this).data('nombre');
                var clave = $(this).data('clave');
                
                $('#dniEmpleado').val(dniEmpleado).prop('readonly', true);
                $('#nombre').val(nombre);
                $('#clave').val(clave);
                $('#formAction').val('actualizar');
                $('#addButton').hide();
                $('#editButton').show();
            });

            $('#editButton').on('click', function(){
                $('#userForm').submit();
            });
        });
    </script>
</body>
</html>
