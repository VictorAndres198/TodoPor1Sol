<%@page import="Conexion.ConectarBD"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : EditarEmpleados
    Created on : 16 jun. 2024, 16:13:04
    Author     : Omar
--%>

<%@page import="Modelo.*"%>
<%@page import="DAO.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Empleados</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="../../resources/css/admin.css" rel="stylesheet" type="text/css"/>
        <link href="../../resources/css/admin-display.css" rel="stylesheet" type="text/css"/>
        <style>
            body {
                background-color: #f0f8ff; /* Cambiar el color de fondo a un azul claro */
                font-family: 'Arial', sans-serif;
            }
            .pattern-bg {
                background: url('https://www.toptal.com/designers/subtlepatterns/patterns/memphis-mini.png');
                padding: 50px 0;
            }
            .card {
                border-radius: 15px;
                box-shadow: 0 4px 12px rgba(0, 0, 0, 0.3);
                overflow: hidden;
            }
            .card-header {
                background: linear-gradient(135deg, #72c2d9, #35a29f); /* Cambiar gradiente a azul y verde verdoso */
                color: white;
                padding: 20px;
                text-align: center;
                font-size: 1.5rem;
            }
            .card-body {
                background: #ffffff;
                padding: 30px;
            }
            .form-label {
                color: #333333;
                font-weight: bold;
            }
            .form-control {
                border-radius: 10px;
                transition: all 0.3s ease;
            }
            .form-control:focus {
                border-color: #72c2d9; /* Cambiar color de borde en enfoque a azul */
                box-shadow: 0 0 10px rgba(114, 194, 217, 0.2); /* Sombra azul claro */
            }
            .btn-primary {
                background-color: #35a29f; /* Cambiar color de fondo del botón a verde verdoso */
                border: none;
                border-radius: 10px;
                padding: 10px 20px;
                transition: background-color 0.3s ease;
            }
            .btn-primary:hover {
                background-color: #2c8b8f; /* Cambiar color del botón al pasar el ratón a un tono más oscuro de verde verdoso */
            }
            .form-group i {
                color: #35a29f; /* Cambiar color de los iconos a verde verdoso */
                margin-right: 10px;
            }
        </style>
        <!-- Enlace a la biblioteca de iconos de Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    </head>
    <body>
        <div class="pattern-bg">
            <div class="container mt-5">
                <div class="col-lg-8 offset-lg-2">
                    <div class="card">
                        <div class="card-header">
                            <i class="fas fa-user-edit"></i> Editar Empleado <!-- Icono de usuario editando -->
                        </div>
                        <div class="card-body">
                            <%
                                DAOempleado dao = new DAOempleado();
                                String dni = (String)request.getAttribute("DNI");
                                Empleado e = dao.ObtenerEmpleado(dni);
                            %>
                            <form action="/TodoPor1Sol/SvEmpleado">
                                <!-- Campo DNI -->
                                <div class="mb-3 form-group">
                                    <label for="dni" class="form-label"><i class="fas fa-id-card"></i> DNI</label>
                                    <input class="form-control" type="text" id="dni" name="dni" readonly value="<%=e.getDni()%>">
                                </div>
                                <!-- Campo Nombre -->
                                <div class="mb-3 form-group">
                                    <label for="nombre" class="form-label"><i class="fas fa-user"></i> Nombre</label>
                                    <input class="form-control" type="text" id="nombre" name="nombre" value="<%=e.getNombre()%>">
                                </div>
                                <!-- Campo Apellidos -->
                                <div class="mb-3 form-group">
                                    <label for="apellidos" class="form-label"><i class="fas fa-user"></i> Apellidos</label>
                                    <input class="form-control" type="text" id="apellidos" name="apellidos" value="<%=e.getApellidos()%>">
                                </div>
                                <!-- Campo Correo -->
                                <div class="mb-3 form-group">
                                    <label for="correo" class="form-label"><i class="fas fa-envelope"></i> Correo</label>
                                    <input class="form-control" type="email" id="correo" name="correo" value="<%=e.getCorreo()%>">
                                </div>
                                <!-- Campo Teléfono -->
                                <div class="mb-3 form-group">
                                    <label for="telefono" class="form-label"><i class="fas fa-phone"></i> Teléfono</label>
                                    <input class="form-control" type="text" id="telefono" name="telefono" value="<%=e.getTelefono()%>">
                                </div>
                                <!-- Campo Sueldo -->
                                <div class="mb-3 form-group">
                                    <label for="sueldo" class="form-label"><i class="fas fa-dollar-sign"></i> Sueldo</label>
                                    <input class="form-control" type="number" id="sueldo" name="sueldo" value="<%=e.getSueldo()%>">
                                </div>
                                <!-- Campo Horario de Entrada -->
                                <div class="mb-3 form-group">
                                    <label for="horarioE" class="form-label"><i class="fas fa-clock"></i> Horario de Entrada</label>
                                    <input class="form-control" type="time" id="horarioE" name="horarioE" value="<%=e.getHorarioE()%>">
                                </div>
                                <!-- Campo Horario de Salida -->
                                <div class="mb-3 form-group">
                                    <label for="horarioS" class="form-label"><i class="fas fa-clock"></i> Horario de Salida</label>
                                    <input class="form-control" type="time" id="horarioS" name="horarioS" value="<%=e.getHorarioS()%>">
                                </div>
                                <!-- Campo Farmacia -->
                                <div class="mb-3 form-group">
                                    <label for="farm" class="form-label"><i class="fas fa-clinic-medical"></i> Farmacia</label>
                                    <select id="farm" name="farm" required class="form-control">
                                        <%
                                            ConectarBD cn = new ConectarBD();
                                            try {
                                                cn.ConectarBD();
                                                String sql = "SELECT * FROM farmacias;";
                                                cn.smt = cn.con.createStatement();
                                                cn.rs = cn.smt.executeQuery(sql);
                                                while (cn.rs.next()) {
                                        %>
                                            <option value="<%=cn.rs.getString(1)%>"><%=cn.rs.getString(2)%></option>
                                        <%
                                                }
                                            } catch (Exception ex) {
                                                out.print(ex.toString());
                                            }
                                        %>
                                    </select>
                                </div>
                                <!-- Botón de actualizar -->
                                <div class="d-grid gap-2">
                                    <button class="btn btn-primary" type="submit" name="accion" value="actualizar">Actualizar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz4fnFO9gybBogGz5KpF1R7mx5ddOzwLPlrFltQFf36rap9Z7koG/F2El" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-p9f8q9L4NCjmprljSOdOycA+Xle13AXgZ0V1o1cTsP9sBjmc5GLIcK7uoNf6IjUM" crossorigin="anonymous"></script>
    </body>
</html>
