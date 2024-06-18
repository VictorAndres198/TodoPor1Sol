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
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
   
             <%
             
             DAOempleado dao = new DAOempleado();
             String dni= (String)request.getAttribute("DNI");
             Empleado e=dao.ObtenerEmpleado(dni);
             
             %>
            <h1>Editar Empleado</h1>
            <form action="/TodoPor1Sol/SvEmpleado">
                DNI:<br>
                    <input class="form-control" type="text" name="dni" readonly value="<%=e.getDni()%>" enab><br>
                    Nombre: <br>
                    <input class="form-control" type="text" name="nombre" value="<%=e.getNombre()%>"><br>
                    Apellidos: <br>
                    <input class="form-control" type="text" name="apellidos" value="<%=e.getApellidos()%>"><br>
                    Correo: <br>
                    <input class="form-control" type="text" name="correo" value="<%=e.getCorreo()%>"><br>
                    Telefono: <br>
                    <input class="form-control" type="text" name="telefono" value="<%=e.getTelefono()%>"><br>
                    Sueldo: <br>
                    <input class="form-control" type="number" name="sueldo" value="<%=e.getSueldo()%>"><br>
                    Horario de Entrada: <br>
                    <input class="form-control" type="time" name="horarioE" value="<%=e.getHorarioE()%>"><br> 
                    Horario de Salida: <br>
                    <input class="form-control" type="time" name="horarioS" value="<%=e.getHorarioS()%>"><br> 
                    
                    <!-- Aquí agregamos el bloque de Farmacias -->
                <div class="form-group">
                    <span>Farmacia</span>
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
                    <small id="farm-help" style="display: none;">Ingresar la Farmacia</small>
                </div>

                    <input class="btn btn-primary" type="submit" name="accion" value="actualizar"> 
                
            </form>
          </div>
          
        </div>

    </body>
</html>
