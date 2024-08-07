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
        <!--Enlaces JS disponibles--->
        <script src="resources/js/employee-display.js"></script>
        <script src="resources/js/scriptsEmpleado/functionsBoleta.js" type="text/javascript"></script>
        <!-- Agregar Chart.js para los gráficos -->
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>    
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
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
                            <label style="color: white; font-weight: 600; margin: 5px 0px;" id="idEmpleado">
                                ID: ${idUsuario}                            
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
            //Parte del codigo que se encarga de eliminar los datos del local storage cada vez que pasa un día:
            // Función para formatear la fecha como YYYY-MM-DD
            function getFormattedDate(date) {
                var year = date.getFullYear();
                var month = ('0' + (date.getMonth() + 1)).slice(-2);
                var day = ('0' + date.getDate()).slice(-2);
                return year + '-' + month + '-' + day;
            }

            // Obtener la fecha actual formateada
            var today = new Date();
            var formattedToday = getFormattedDate(today);

            // Obtener la última fecha guardada en el localStorage
            var lastSavedDate = localStorage.getItem('lastSavedDate');

            // Si la última fecha guardada es diferente de la fecha actual, resetear los datos
            if (lastSavedDate !== formattedToday) {
                // Obtener todos los DNI de empleados guardados
                for (var key in localStorage) {
                    if (key.startsWith('horaE_') || key.startsWith('horaS_') || key.startsWith('guardadoSalida_')) {
                        localStorage.removeItem(key);
                    }
                }
                localStorage.setItem('lastSavedDate', formattedToday);
            }

            var entradaRegistrada = false;

            // Función para obtener la hora actual y mostrarla en la tabla
            function registrarEntrada() {                
                var dniUsuario = localStorage.getItem('Usuario');

                if (entradaRegistrada || !dniUsuario) {
                    $('#error-message2').fadeIn().delay(2000).fadeOut();
                } else {
                    // Obtener la hora actual
                    var nowE = new Date();
                    var formattedTime = ('0' + nowE.getHours()).slice(-2) + ':' + ('0' + nowE.getMinutes()).slice(-2) + ':' + ('0' + nowE.getSeconds()).slice(-2);
                    // Mostrar la hora actual en el campo correspondiente de la tabla
                    $('#empleado-entrada').text(formattedTime);
                    entradaRegistrada = true; 
                    // Guardar hora de entrada en localStorage específicamente para este usuario
                    localStorage.setItem('horaE_' + dniUsuario, formattedTime);
                }
            }

            function registrarSalida() {
                var dniUsuario = localStorage.getItem('Usuario');

                // Obtener la hora actual
                var nowS = new Date();
                var formattedTimeS = ('0' + nowS.getHours()).slice(-2) + ':' + ('0' + nowS.getMinutes()).slice(-2) + ':' + ('0' + nowS.getSeconds()).slice(-2);
                // Mostrar la hora actual en el campo correspondiente de la tabla
                // Guardar en la base de datos solo si no se ha guardado antes
                if (entradaRegistrada && dniUsuario && !localStorage.getItem('guardadoSalida_'+dniUsuario)) {
                    $('#empleado-salida').text(formattedTimeS);
                    // Guardar hora de salida en localStorage específicamente para este usuario
                    localStorage.setItem('horaS_' + dniUsuario, formattedTimeS);

                    // Obtener otros datos necesarios para enviar al servidor
                    var fecha = $('#empleado-fecha').text(); // Obtener la fecha actual de la tabla
                    var hEntrada = $('#empleado-entrada').text(); // Obtener la hora de entrada registrada
                    var dniEmpleado = localStorage.getItem('Usuario'); // Obtener el DNI del empleado de localStorage

                    // Hacer la solicitud AJAX para enviar los datos al servidor
                    $.ajax({
                        url: `${pageContext.request.contextPath}/SvGuardarHoraEmpleado`,
                        type: 'POST',
                        data: {
                            fecha: fecha,
                            hEntrada: hEntrada,
                            hSalida: formattedTimeS,
                            dniEmpleado: dniEmpleado
                        },
                        dataType: 'json',
                        success: function(response) {
                            if (response.success) {
                                console.log("Datos enviados exitosamente.");
                                localStorage.setItem('guardadoSalida_'+dniUsuario, 'true');
                                $('#registrar-salida').prop('disabled', true); // Deshabilitar el botón después de guardar
                            } else {
                                console.error("Hubo un error al enviar los datos.");
                                // Aquí puedes manejar errores específicos si es necesario
                            }
                        },
                        error: function(xhr, status, error) {
                            console.error("Error en la solicitud AJAX:", status, error);
                            // Manejo de errores (mostrar mensaje al usuario, etc.)
                        }
                    });
                } else {
                    if (!localStorage.getItem('guardadoSalida_'+dniUsuario)){                        
                        // Mostrar mensaje de error
                        $('#error-message').fadeIn().delay(2000).fadeOut();
                    } else {
                        $('#error-message3').fadeIn().delay(2000).fadeOut();
                    }
                }
            }

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

                            // Obtener la fecha actual
                            var now = new Date();
                            var formattedDate = now.getFullYear() + '-' + ('0' + (now.getMonth() + 1)).slice(-2) + '-' + ('0' + now.getDate()).slice(-2);
                            // Mostrar la fecha actual en el campo correspondiente
                            $('#employee-display #empleado-fecha').text(formattedDate);

                            localStorage.setItem('Usuario',(data.dni))

                            var horaEntrada = localStorage.getItem('horaE_' + data.dni);
                            if (horaEntrada) {
                                $('#empleado-entrada').text(horaEntrada);
                                entradaRegistrada = true; // Actualizar estado de entradaRegistrada
                            }
                            var horaSalida = localStorage.getItem('horaS_' + data.dni);
                            if (horaSalida) {
                                $('#empleado-salida').text(horaSalida);
                            }
                        },
                        error: function(xhr, status, error) {
                            console.error("Error loading employee data:", status, error);
                            $('#employee-display').html(`<p>Error loading employee data: ${xhr.status} ${xhr.statusText}</p>`);
                        }
                    });
                }
            }

            // Función para obtener el lunes de la semana actual
            function getMonday(date) {
                var day = date.getDay(),
                    diff = date.getDate() - day + (day == 0 ? -6 : 1); // ajuste cuando el día es domingo
                return new Date(date.setDate(diff));
            }

            // Función para obtener los días de la semana a partir del lunes dado
            function getWeekDays(monday) {
                var daysOfWeek = [];
                for (var i = 0; i < 5; i++) { // Iterar de lunes a viernes (5 días laborales)
                    var day = new Date(monday);
                    day.setDate(monday.getDate() + i);
                    daysOfWeek.push(day);
                }
                return daysOfWeek;
            }

            // Función para cargar y mostrar la semana actual en el HTML
            function loadSemanaActual() {
                // Calcular la semana actual y mostrarla en el HTML
                var today = new Date(); // Fecha actual
                var monday = getMonday(today); // Lunes de esta semana

                var daysOfWeek = getWeekDays(monday);

                // Formatear las fechas para mostrarlas como DD/MM/YYYY
                var formattedDays = daysOfWeek.map(function(day) {
                    var dd = String(day.getDate()).padStart(2, '0');
                    var mm = String(day.getMonth() + 1).padStart(2, '0'); // Enero es 0
                    var yyyy = day.getFullYear();
                    return yyyy + '/' + mm + '/' + dd;
                });

                var lunes = formattedDays[0];
                var viernes = formattedDays[4];
                console.log(lunes, viernes);

                // Actualizar el contenido del elemento <h3> con id 'semana-actual'
                var semanaActualText = "Semana del "+lunes+" hasta "+viernes;
                console.log(semanaActualText);
                // Asegúrate de que el DOM esté completamente cargado antes de actualizar el contenido
                $(document).ready(function() {
                    $('#semana-actual').text(semanaActualText);
                });
            }

            function toHome() {
                window.location.href = '${pageContext.request.contextPath}/home.jsp';
            }

        </script>
    </body>
</html>
