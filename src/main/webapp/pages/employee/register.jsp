<%-- 
    Document   : entradaysalida
    Created on : 12 may. 2024, 05:15:08
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="usuario" class="Modelo.Usuario" scope="session" />
<jsp:useBean id="empleado" class="Modelo.Empleado" scope="request" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Entrada y Salida</title>
        <link href="../../TodoPor1Sol/resources/css/employee-display.css" rel="stylesheet" type="text/css"/> 
    </head>
    <body>
        <div class="principal-container">
            <form action="${pageContext.request.contextPath}/SvMostrarEmpleado" method="post">
                <input type="hidden" name="dniEmpleado" value="${usuario.dniEmpleado}" />
                <button type="submit">Cargar Empleado</button>
            </form>
            <div style="padding: 30px 40px;">
                <p class="header-e-d">
                    Registro de Entrada y Salida
                </p>
                <p class="paragraph-e-d">
                    Registro de entrada y salida de los empleados
                </p>
                
                <table class="tabla">
                    <thead>
                        <tr>
                            <th style="padding: 0px 10px; color: #1D242E">Nombre</th>
                            <th style="padding: 0px 10px; color: #1D242E">Apellidos</th>
                            <th style="padding: 0px 10px; color: #1D242E">Hora de Entrada</th>
                            <th style="padding: 0px 10px; color: #1D242E">Hora de Salida</th>
                            <th style="padding: 0px 10px; color: #1D242E">Fecha</th>
                        </tr>
                    </thead>                    
                    <tbody>   
                            <tr>
                                <td colspan="5"><hr style="border: none; height: 1px; background-color: rgba(29,36,46,0.3); margin: 0;"></td>
                            </tr>
                            <tr>
                                <td style="text-align: center;">${empleado.nombre}</td>
                                <td style="text-align: center;">|${empleado.apellidos}</td>
                                <td style="text-align: center;"></td>
                                <td style="text-align: center;"></td>
                                <td style="text-align: center;"></td> 
                            </tr>
                    </tbody>
                </table>                
                
            </div>         
        </div>
                              
    </body>
</html>
