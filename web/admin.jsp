

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>admin</title>
        <link href="resources/css/admin.css" rel="stylesheet" type="text/css"/>
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
            
            $(document).ready(function() {
                // Cargar el contenido del archivo JSP en el div
                $('#admin-display').load('pages/admin/RegistroProductos.jsp');
            });
        </script>
        
    </head>
    <body class="body-admin">
        <div class="admin">
            <div class="logo">
                <img style="height:60px; width:60px; margin: 10px 8px"src="resources/img/home/Logo.png" alt=""/>
                Todo Por 1 Sol
            </div>
            <div style="background: #F7FAFD;"></div>
            
            <div class="nav-admin">
              <div style="overflow: hidden; overflow-y: auto">                    
                <div style="display:flex;flex-direction:row; height: fit-content; width:100%; justify-content: center; align-items: center; padding: 30px 0px;">
                    <img src="resources/img/admin/admin.png" alt=""/>
                    <div style="display: flex; flex-direction: column; padding: 0px 10px;">
                        <label style="color: white;font-weight: 600; margin: 5px 0px;">
                            Mario
                        </label>
                        <label  style="color: #00FEC1;font-weight: 600;">
                            Administrador
                        </label>
                    </div>
                </div>
                <div class="button-nav-admin">
                    <div style="display: flex; justify-content: end;">
                        
                    </div>
                    <div>
                        Panel de Información
                    </div>
                </div>
                <div class="button-nav-admin">
                    <div style="display: flex; justify-content: end;">
                        
                    </div>
                    <div>
                        Empleados
                    </div>
                </div>
                  <div class="button-nav-admin"  onclick="rotateCheuron()">
                    <div style="display: flex; justify-content: end;">                        
                    </div>
                    <div style="display: flex; align-items: center;">
                        Productos
                    </div>
                    <div style="display: flex; align-items: center;height: 100%;width: 100%;">
                        <img id="cheuron" style="max-height: 16px; max-width: 16px;" src="resources/img/admin/cheuron-abajo.png" alt=""/>
                    </div>
                </div>
                <div class="button-nav-admin expanded hide">
                    <div style="display: flex; justify-content: end;">
                        
                    </div>
                    <div>
                        Nuevo Productos
                    </div>
                </div>
                <div class="button-nav-admin expanded hide">
                    <div style="display: flex; justify-content: end;">
                        
                    </div>
                    <div>
                        Gestionar Productos
                    </div>
                </div>
                <div class="button-nav-admin"  onclick="rotateCheuron()" >
                    <div style="display: flex; justify-content: end;">                        
                    </div>
                    <div style="display: flex; align-items: center;">
                        Proveedor
                    </div>
                    <div style="display: flex; align-items: center;height: 100%;width: 100%;">
                        <img id="cheuron" style="max-height: 16px; max-width: 16px;" src="resources/img/admin/cheuron-abajo.png" alt=""/>
                    </div>
                </div>
                <div class="button-nav-admin expanded hide">
                    <div style="display: flex; justify-content: end;">
                        
                    </div>
                    <div>
                        Nuevo Proveedor
                    </div>
                </div>
                <div class="button-nav-admin expanded hide">
                    <div style="display: flex; justify-content: end;">
                        
                    </div>
                    <div>
                        Gestionar Proveedor
                    </div>
                </div>
                <div class="button-nav-admin">
                    <div style="display: flex; justify-content: end;">
                        
                    </div>
                    <div>
                        Historial de Ventas
                    </div>
                </div>  
          </div>

            <div class="button-nav-admin">
                <div style="display: flex; justify-content: end;">
                </div>
                <div>
                    Cerrar Sesión
                </div>
            </div>
                
            </div>
            
            <div id="admin-display">
                
            </div>
        </div>
        
    </body>
</html>

