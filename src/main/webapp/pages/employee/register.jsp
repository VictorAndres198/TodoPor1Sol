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
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link href="../../TodoPor1Sol/resources/css/employee-display.css" rel="stylesheet" type="text/css"/> 
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </head>
    <body>
        <div class="container pt-4 space-bt">
            <div class="row">
                <div class="col">
                    <h2 class="mb-2">Registro de Entrada y Salida</h2>
                    <p class="lead mb-2">Registro de entrada y salida de los empleados</p>

                    <form action="${pageContext.request.contextPath}/SvMostrarEmpleado" method="post">
                        <input type="hidden" name="dniEmpleado" value="${usuario.dniEmpleado}" />
                    </form>

                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Apellidos</th>
                                    <th scope="col">Hora de Entrada</th>
                                    <th scope="col">Hora de Salida</th>
                                    <th scope="col">Fecha</th>
                                </tr>
                            </thead>                    
                            <tbody>   
                                <tr>
                                    <td id="empleado-nombre" class="text-center bold"></td>
                                    <td id="empleado-apellidos" class="text-center"></td>
                                    <td id="empleado-entrada" class="text-center"></td>
                                    <td id="empleado-salida" class="text-center"></td>
                                    <td id="empleado-fecha" class="text-center"></td> 
                                </tr>
                            </tbody>
                        </table>  
                    </div>
                </div>
            </div>
                   
                    
            <div style="display: flex; justify-content: center; width: 100%;">       
                <div style=" display: flex; flex-direction: row; gap: 70px; padding: 20px 0px 20px 0px">
                    <div class="btn btn-success" id="registrar-entrada">
                        Registrar Entrada
                    </div>
                    <div class="btn btn-info" id="registrar-salida">
                        Registrar Salida
                    </div>
                </div>
            </div>
            <!-- Mensaje de error para la salida -->
            <div id="error-message" style="color: red; text-align: center; display: none;">
                Debe registrar la entrada primero.
            </div>
            
            <div id="error-message2" style="color: red; text-align: center; display: none;">
                Solo puede registrar una vez la entrada.
            </div>
            
        </div>
                    

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body> 
</html>
