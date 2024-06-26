<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>employee</title>
        <link href="resources/css/employee.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        
        <script>
            function rotateCheuron() {
                const cheuron = document.getElementById("cheuron");
                cheuron.classList.toggle("rotated");
                cheuron.classList.toggle("transition");
                
                const expandedElements = document.querySelectorAll('.expanded');
                // Agregamos o eliminamos la clase fade según el estado actual del elemento
                expandedElements.forEach(function(element) {
                    element.classList.toggle('hide');
                });

                // Eliminamos la clase de transición después de la duración de la transición
                setTimeout(function() {
                    cheuron.classList.remove("transition");
                }, 400);
               
            };
            
            $('#employee-display').load('pages/employee/register.jsp');
            /*$(document).ready(function() {
            function loadPage(page) {
                console.log("Loading page:", page); // Agregar este console.log
                $('#employee-display').load(`/TodoPor1Sol/pages/employee/${page}.jsp`, function(response, status, xhr) {
                    if (status == "error") {
                        $('#employee-display').html(`<p>Error loading page: ${xhr.status} ${xhr.statusText}</p>`);
                    }
                });
            }

            // Página por defecto
            loadPage('register');

            // Asignar eventos de clic para los ítems del menú
            $('#nav-register').click(function() {
                loadPage('register');
            });

            $('#nav-inventory').click(function() {
                loadPage('inventory');
            });

            $('#nav-sale').click(function() {
                loadPage('sale');
            });

            $('#nav-sale-receipt').click(function() {
                loadPage('sale-receipt');
            });

            $('#nav-sale-invoice').click(function() {
                loadPage('sale-invoice');
            });

            $('#nav-sale-history').click(function() {
                loadPage('sale-history');
            });
        });*/
        
        </script>
        
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
                        <label style="color: white;font-weight: 600; margin: 5px 0px;">
                            Andrés
                        </label>
                        <label  style="color: #00FEC1;font-weight: 600;">
                            Empleado
                        </label>
                    </div>
                </div>
                <div class="button-nav-empl" id="nav-register">
                    <div style="display: flex; justify-content: end;"></div>
                    <div>Registro de Entr. y Sal.</div>
                </div>
                <div class="button-nav-empl">
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
                <div class="button-nav-empl expanded hide">
                    <div style="display: flex; justify-content: end;">
                        
                    </div>
                    <div>
                        Boleta
                    </div>
                </div>
                <div class="button-nav-empl expanded hide">
                    <div style="display: flex; justify-content: end;">
                        
                    </div>
                    <div>
                        Factura
                    </div>
                </div>
                <div class="button-nav-empl">
                    <div style="display: flex; justify-content: end;">
                        
                    </div>
                    <div>
                        Historial de Ventas
                    </div>
                </div>  
          </div>

            <div class="button-nav-empl">
                <div style="display: flex; justify-content: end;">
                </div>
                <div>
                    <a class="SeccionName" href="/TodoPor1Sol/home.jsp">Cerrar Sesión</a>
                </div>
            </div>
                
            </div>
            
            <div id="employee-display">
                
            </div>
        </div>
        
    </body>
</html>
