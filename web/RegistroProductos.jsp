<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Productos</title>

        <script src="node_modules/bootstrap/dist/ js/bootstrap.min.js"></script>
        <link href="resources/css/RegistroProducto/EstiloRegProd.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/RegistroProducto/EstiloRegProd.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body class="body-RegiProd">
        <div class="employee">
            <div class="logo">
                <img style="height:60px; width:60px; margin: 10px 8px" src="resources/img/home/Logo.png" alt=""/>
                Todo Por 1 Sol
            </div>

            <div class="titulo">
                <h>Nuevo Producto</h>                

            </div>

            <div class="nav-RegiProd">
                <div style="overflow: hidden; overflow-y: auto">                    
                    <div style="display:flex; flex-direction:row; height: fit-content; width:100%; justify-content: center; align-items: center; padding: 30px 0px;">
                        <img src="resources/img/employee/employee.png" alt=""/>
                        <div style="display: flex; flex-direction: column; padding: 0px 10px;">
                            <label style="color: white; font-weight: 600; margin: 5px 0px;">
                                Andrés
                            </label>
                            <label style="color: #FED600; font-weight: 600;">
                                Administrador
                            </label>
                        </div>
                    </div>
                    <div class="button-nav-empl">
                        <div style="display: flex; justify-content: end;"></div>
                        <div>Panel de informacion</div>
                    </div>
                    <div class="button-nav-empl">
                        <div style="display: flex; justify-content: end;"></div>
                        <div>Empleados</div>
                    </div>
                    <div class="button-nav-empl" onclick="rotateChevron()">
                        <div style="display: flex; justify-content: end;"></div>
                        <div style="display: flex; align-items: center;">Productos</div>
                        <div style="display: flex; align-items: center; height: 100%; width: 100%;">

                            <img id="chevron" style="max-height: 16px; max-width: 16px;" src="resources/img/employee/cheuron-abajo.png" alt=""/>

                        </div>
                    </div>
                    <div class="button-nav-empl">
                        <div style="display: flex; justify-content: end;"></div>
                        <div>Nuevo Producto</div>
                    </div>
                    <div class="button-nav-empl">
                        <div style="display: flex; justify-content: end;"></div>
                        <div>Gestionar Producto</div>
                    </div>

                    <div class="button-nav-empl" onclick="rotateChevron()">
                        <div style="display: flex; justify-content: end;"></div>
                        <div style="display: flex; align-items: center;">Proveedor</div>
                        <div style="display: flex; align-items: center; height: 100%; width: 100%;">

                            <img id="chevron" style="max-height: 16px; max-width: 16px;" src="resources/img/employee/cheuron-abajo.png" alt=""/>

                        </div>
                    </div>


                    <div class="button-nav-empl expanded hide">
                        <div style="display: flex; justify-content: end;"></div>
                        <div>Boleta</div>
                    </div>
                    <div class="button-nav-empl expanded hide">
                        <div style="display: flex; justify-content: end;"></div>
                        <div>Factura</div>
                    </div>
                    <div class="button-nav-empl">
                        <div style="display: flex; justify-content: end;"></div>
                        <div>Historial de Ventas</div>
                    </div>  
                </div>

                <div class="button-nav-empl">
                    <div style="display: flex; justify-content: end;"></div>
                    <div>Cerrar Sesión</div>
                </div>
            </div>

          
<!-- CONTENEDOR REGISTRO DE NUEVOS PRODUCTOS -->
<div class="Container-RegistroProductos negrita"> 
    <div class="IngreseDatos"> Ingrese los Datos</div>

    <form id="form-validation" action="guardar.jsp" method="post" novalidate>
        <div class="form-group">
            <span> Nombre </span>
            <input type="text" style="text-align: center" placeholder="" required>
            <small id="nombre-help" style="display: none;">Ingresar nombre</small>
        </div>
        <div class="form-group">
            <span> Descripción </span>
            <textarea rows="4" cols="20" placeholder="" required></textarea>
            <small id="descripcion-help" style="display: none;">Ingresar descripción</small>
        </div>
        <div class="form-group">
            <span> Fecha de Vencimiento </span>
            <input type="date" id="fecha-vencimiento" name="fecha-vencimiento" required>
            <small id="fecha-help" style="display: none;">Ingresar fecha de vencimiento</small>
        </div>
        <div class="form-group">
            <span> Stock </span>
            <input type="number" placeholder="" min="0" required>
            <small id="stock-help" style="display: none;">Ingresar stock</small>
        </div>
        <div class="form-group">
            <span> Precio </span>
            <input type="number" placeholder="" min="0" required>
            <small id="precio-help" style="display: none;">Ingresar precio</small>
        </div>
        <div class="form-group">
            <span> Proveedor </span>
            <select id="proveedores" name="proveedores" required>
                <option value="" selected="selected"></option>
                <option value="Lab">Lab</option>
                <option value="Dove">Dove</option>
            </select>
            <small id="proveedor-help" style="display: none;">Ingresar proveedor</small>
        </div>
        <div class="button" style="text-align: center">
            <input type="submit" value="Guardar">
        </div>
    </form>
</div>


<script>
document.getElementById("form-validation").addEventListener("submit", function(e) {
    e.preventDefault(); // Prevenir el envío del formulario
    const form = e.target;
    mostrarMensajesAyuda(form);

    if (form.checkValidity()) {
        form.submit(); // Si el formulario es válido, proceder a enviarlo
    }
});

function mostrarMensajesAyuda(form) {
    const formGroups = form.querySelectorAll('.form-group');
    formGroups.forEach(formGroup => {
        const input = formGroup.querySelector('input, textarea, select');
        const small = formGroup.querySelector('small');
        if (!input.validity.valid) {
            small.style.display = 'block';
        } else {
            small.style.display = 'none';
        }
    });
}

</script>

</body>
</html>

