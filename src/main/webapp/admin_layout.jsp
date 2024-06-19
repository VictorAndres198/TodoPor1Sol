<!-- ESTE ES EL MENU DE NAVEGACION DEL ADMIN, PUEDE SER REUTILIZADO EN LOS demas Forms-->
    
        <script>
            function rotateCheuron() {
                const cheuron = document.getElementById("cheuron");
                cheuron.classList.toggle("rotated");
                cheuron.classList.toggle("transition");
                
                const expandedElements = document.querySelectorAll('.productosExpandidos');
                // Agregamos o eliminamos la clase fade según el estado actual del elemento
                expandedElements.forEach(function(element) {
                    element.classList.toggle('hide');
                });

                // Eliminamos la clase de transición después de la duración de la transición
                setTimeout(function() {
                    cheuron.classList.remove("transition");
                }, 400);
            };
            
            function rotateCheuron0() {
                const cheuron0 = document.getElementById("cheuron0");
                cheuron0.classList.toggle("rotated");
                cheuron0.classList.toggle("transition");
                
                const expandedElements0 = document.querySelectorAll('.empleadosExpandidos');
                // Agregamos o eliminamos la clase fade según el estado actual del elemento
                expandedElements0.forEach(function(element) {
                    element.classList.toggle('hide');
                });

                // Eliminamos la clase de transición después de la duración de la transición
                setTimeout(function() {
                    cheuron0.classList.remove("transition");
                }, 400);
            };
            
            function rotateCheuron2() {
                const cheuron2 = document.getElementById("cheuron2");
                cheuron2.classList.toggle("rotated");
                cheuron2.classList.toggle("transition");
                
                const expandedElements2 = document.querySelectorAll('.proveedoresExpandidos');
                // Agregamos o eliminamos la clase fade según el estado actual del elemento
                expandedElements2.forEach(function(element) {
                    element.classList.toggle('hide');
                });

                // Eliminamos la clase de transición después de la duración de la transición
                setTimeout(function() {
                    cheuron2.classList.remove("transition");
                }, 400);
            };
            
        </script>
        
        <div class="admin">
            <div class="logo">
                <img id="logoBotica" style="height:60px; width:60px; margin: 10px 8px" alt=""/>
                Todo Por 1 Sol
            </div>
            
            <div class="nav-admin">
              <div style="overflow: hidden; overflow-y: auto">                    
                <div style="display:flex;flex-direction:row; height: fit-content; width:100%; justify-content: center; align-items: center; padding: 30px 0px;">
                    <img id="adminImg" alt=""/>
                    <div style="display: flex; flex-direction: column; padding: 0px 10px;">
                        <label style="color: white;font-weight: 600; margin: 5px 0px;">
                            Mario
                        </label>
                        <label  style="color: #00FEC1;font-weight: 600;">
                            Administrador
                        </label>
                    </div>
                </div>
                <a class="button-nav-admin" href="/TodoPor1Sol/pages/admin/AdminPanel.jsp" style="text-decoration: none">
                    <div style="display: flex; justify-content: end;"></div>
                    <div>
                         <div class="SeccionName">Panel de Información</div>
                    </div>
                </a>
                <div class="button-nav-admin"  onclick="rotateCheuron0()">
                    <div style="display: flex; justify-content: end;"></div>
                    <div style="display: flex; align-items: center;">
                        Empleado
                    </div>
                    <div style="display: flex; align-items: center;height: 100%;width: 100%;">
                        <img id="cheuron0" name="cheuron0" style="max-height: 16px; max-width: 16px;" alt="" src="resources/img/admin/cheuron-abajo0.png"/>
                    </div>
                </div>
                <a class="button-nav-admin expanded empleadosExpandidos hide" href="/TodoPor1Sol/pages/admin/NuevoEmpleado.jsp" style="text-decoration: none;">
                    <div style="display: flex; justify-content: end;"></div>
                    <div>
                        <div class="SeccionName">Nuevo Empleado</div>
                    </div>
                </a>
                <a class="button-nav-admin expanded empleadosExpandidos hide" href="/TodoPor1Sol/pages/admin/GestionarEmpleados.jsp" style="text-decoration: none">
                    <div style="display: flex; justify-content: end;">
                        
                    </div>
                    <div>
                        <div class="SeccionName" >Gestionar Empleados</div>
                    </div>
                </a>
                <div class="button-nav-admin"  onclick="rotateCheuron()">
                    <div style="display: flex; justify-content: end;"></div>
                    <div style="display: flex; align-items: center;">
                        Productos
                    </div>
                    <div style="display: flex; align-items: center;height: 100%;width: 100%;">
                        <img id="cheuron" name="cheuron" style="max-height: 16px; max-width: 16px;" alt=""/>
                    </div>
                </div>
                <a class="button-nav-admin expanded productosExpandidos hide" href="/TodoPor1Sol/pages/admin/RegistroProductos.jsp" style="text-decoration: none">
                    <div style="display: flex; justify-content: end;"></div>
                    <div>                        
                        <div class="SeccionName">Nuevo Producto</div> 
                    </div>
                </a>
                <a class="button-nav-admin expanded productosExpandidos hide" href="/TodoPor1Sol/pages/admin/GestionarProductos.jsp" style="text-decoration: none">
                    <div style="display: flex; justify-content: end;"></div>
                    <div>
                      <div class="SeccionName">Gestionar Productos</div>   
                    </div>
                </a>
                <div class="button-nav-admin"  onclick="rotateCheuron2()" >
                    <div style="display: flex; justify-content: end;"></div>
                    <div style="display: flex; align-items: center;">
                        Proveedor
                    </div>
                    <div style="display: flex; align-items: center;height: 100%;width: 100%;">
                        <img id="cheuron2" name="cheuron2" style="max-height: 16px; max-width: 16px;" src="resources/img/admin/cheuron-abajo2.png" alt=""/>
                    </div>
                </div>
                  
                <a class="button-nav-admin expanded proveedoresExpandidos hide" href="/TodoPor1Sol/pages/admin/NuevoProveedor.jsp" style="text-decoration: none">
                    <div style="display: flex; justify-content: end;"></div>
                    <div>
                        <div class="SeccionName" >Nuevo Proveedor</div>
                    </div>
                </a>
                
                <a class="button-nav-admin expanded proveedoresExpandidos hide" href="/TodoPor1Sol/pages/admin/GestionarProveedor.jsp" style="text-decoration: none">
                    <div style="display: flex; justify-content: end;"></div>
                    <div>
                        <div class="SeccionName">Gestionar Proveedor</div>
                    </div>
                </a>
                <a class="button-nav-admin" style="text-decoration: none;">
                    <div style="display: flex; justify-content: end;"></div>
                    <div>
                        Historial de Ventas
                    </div>
                </a>  
               
                
        </div>
                <a class="button-nav-admin" style="text-decoration: none;"  href="/TodoPor1Sol/home.jsp">
                    <div style="display: flex; justify-content: end;"></div>
                    <div>
                        <div class="SeccionName">Cerrar Sesión</div>
                    </div>
                </a>
     </div>
</div>
                
