<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="usuario" class="Modelo.Usuario" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>employee</title>
        <link href="resources/css/employee.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>        
        <script src="resources/js/employee-display.js"></script> <!-- Enlace al archivo JS separado -->

        
    </head>
    <body class="body-employee">
        <div class="employee">
            <div class="logo">
                <img style="height:60px; width:60px; margin: 10px 8px"src="resources/img/home/Logo.png" alt=""/>
                Todo Por 1 Sol
            </div>
            <div style="background: #F7FAFD;"></div>
            
            <div class="nav-employee">
              <div style="overflow: hidden; overflow-y: auto">                    
                <div style="display:flex;flex-direction:row; height: fit-content; width:100%; justify-content: center; align-items: center; padding: 30px 0px;">
                    <img src="resources/img/employee/employee.png" alt=""/>
                    <div style="display: flex; flex-direction: column; padding: 0px 10px;">
                        <%-- Verificar si el usuario está en la sesión --%>
                        <c:if test="${not empty usuario}">
                            <label style="color: white; font-weight: 600; margin: 5px 0px;">
                                Bienvenid@, ${usuario.nombre}
                            </label>
                        </c:if>
                        <label  style="color: #00FEC1;font-weight: 600;">
                            Empleado
                        </label>
                    </div>
                </div>
                <div class="button-nav-empl" id="nav-register">
                    <div style="display: flex; justify-content: end;"></div>
                    <div>Registro de Entr. y Sal.</div>
                </div>
                <div class="button-nav-empl" id="nav-inventory">
                    <div style="display: flex; justify-content: end;">
                        
                    </div>
                    <div>
                        Inventario
                    </div>
                </div>
                  <div class="button-nav-empl"  onclick="rotateCheuron()">
                    <div style="display: flex; justify-content: end;">                        
                    </div>
                    <div style="display: flex; align-items: center;">
                        Realizar Venta
                    </div>
                    <div style="display: flex; align-items: center;height: 100%;width: 100%;">
                        <img id="cheuron" style="max-height: 16px; max-width: 16px;" src="resources/img/employee/cheuron-abajo.png" alt=""/>
                    </div>
                </div>
                  <div class="button-nav-empl expanded hide" id="nav-realizarventa">
                    <div style="display: flex; justify-content: end;">
                        
                    </div>
                    <div>
                        Boleta
                    </div>
                </div>
                <div class="button-nav-empl expanded hide" id="nav-realizarventa">
                    <div style="display: flex; justify-content: end;">
                        
                    </div>
                    <div>
                        Factura
                    </div>
                </div>
                  <div class="button-nav-empl" id="nav-historialventas">
                    <div style="display: flex; justify-content: end;">
                        
                    </div>
                    <div>
                        Historial de Ventas
                    </div>
                </div>  
          </div>
           
            <div class="button-nav-empl"  id="nav-home" onclick="toHome()">
                <div style="display: flex; justify-content: end;">
                </div>
                <div>
                    Cerrar Sesión
                </div>
            </div>

            </div>
            
            <div id="employee-display">
                
            </div>
        </div>
        
        <script>
            function loadEmployeeData() {
                var dniEmpleado = `${usuario.dniEmpleado}`;
                if (dniEmpleado) {
                    $.ajax({
                        url: `${pageContext.request.contextPath}/SvMostrarEmpleado`,
                        type: 'POST',
                        data: { dniEmpleado: dniEmpleado },
                        dataType: 'json',
                        success: function(data) {
                            console.log("Empleado data:", data);
                            $('#employee-display #empleado-nombre').text(data.nombre);
                            $('#employee-display #empleado-apellidos').text(data.apellidos);
                        },
                        error: function(xhr, status, error) {
                            console.error("Error loading employee data:", status, error);
                            $('#employee-display').html(`<p>Error loading employee data: ${xhr.status} ${xhr.statusText}</p>`);
                        }
                    });
                }
            }
            
            function toHome() {
                window.location.href = '${pageContext.request.contextPath}/home.jsp';
            }
        </script>
    </body>
</html>
