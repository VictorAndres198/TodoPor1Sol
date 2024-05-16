<%-- 
    Document   : entradaysalida
    Created on : 12 may. 2024, 05:15:08
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Entrada y Salida</title>
        <link href="../../Todox1Sol/resources/css/employee-display.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="principal-container">
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
                        <c:forEach var="registro" items="${registros}" varStatus="loop">
                            <tr>
                                <td colspan="5"><hr style="border: none; height: 1px; background-color: rgba(29,36,46,0.3); margin: 0;"></td>
                            </tr>
                            <tr>
                                <td style="text-align: center;">${registro.columna1}</td>
                                <td style="text-align: center;">${registro.columna2}</td>
                                <td style="text-align: center;">${registro.columna3}</td>
                                <td style="text-align: center;">${registro.columna4}</td>
                                <td style="text-align: center;">${registro.columna5}</td> 
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>                
                
            </div>         
        </div>
    </body>
</html>
