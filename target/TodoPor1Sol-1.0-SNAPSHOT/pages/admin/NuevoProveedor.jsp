
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.*"%>
<%@page import="com.mysql.jdbc.Driver"%>
<%@page import="java.util.*" %>
<%@page import="DAO.*" %>
<%@page import="Modelo.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Proveedores</title>
        <link href="../../resources/css/NuevoProveedor.css" rel="stylesheet" type="text/css"/>
        <link href="../../resources/css/admin.css" rel="stylesheet" type="text/css"/>
        <link href="../../resources/css/admin-display.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </head>   
    <body class="parent-container">
     
        <!-- Para traer el layout(menu lateral) del admin -->
        <jsp:include page="../../admin_layout.jsp" />  
        
        <div class="box-Content" >
            <div class="Frm-Header">
                <span>Nuevo Proveedor</span>
            </div>
            <div class="Container-RegistroProductos negrita" > 

                <!--INGRESAR DATOS -->
                <div class="form-title">Ingrese los Datos</div>
               <form id="form-validation" novalidate>
                   <!--RUC--> 
                   <div class="form-group" method="post" novalidate>
                        <span> Ruc </span>
                        <input name="ruc"  type="text" style="text-align: center" placeholder="" required class="rucEmp">
                        <small name="ruc-help" id="nombre-help" style="display: none;">Ingresar RUC</small>
                    </div>
                    <!--Nombre Comercial-->
                    <div class="form-group">
                        <span> Nmbre Comercial </span>
                        <input name="nombre"  type="text" style="text-align: center" placeholder="" required class="nombreEmp">
                        <small id="nombreProveedor-help" style="display: none;">Ingresar Nombre de Prooveedor</small>
                    </div>
                    <!--Pais-->
                    <div class="form-group">
                        <span> Pais </span>
                        <input name="pais"  type="text" id="fecha-vencimiento" name="fecha-vencimiento" required>
                        <small id="pais-help" style="display: none;">Ingresar un pais</small>
                    </div>
                    <!--Telefono-->
                    <div class="form-group">
                        <span> Telefono </span>
                        <input name="telefono" type="number" placeholder="" min="0" required>
                        <small id="telefono-help" style="display: none;">Ingresar un numero de telefono</small>
                    </div> 
                    <!--Correo-->
                    <div class="form-group">
                        <span> Correo </span>
                        <input name="correo" type="text" placeholder="" min="0" step="any" required> <!--any para que reciba decimales-->
                        <small id="correo-help" style="display: none;">Ingresar correo</small>
                    </div>
                    <div class="button" style="text-align: center">
                        <input type="submit" name="guardar" value="Guardar">
                    </div>
                </form>
            </div>
            
        </div>
        
      <!--SCRIPT PARA VALIDAR EL INGRESO DE DATOS-->
<script>
document.getElementById("form-validation").addEventListener("submit", function(e) {
    e.preventDefault(); // Evita que el formulario sea enviado sin antes ser revisado
    const form = e.target;
    mostrarMensajesAyuda(form);

    if (form.checkValidity()) {
        //Si el formulario es válido se realiza:
        sendData();// 1. Envio por POST del Proveedor a registrar
        clearInputs(); // 2. Limpia los inputs del formulario
        
    }
});

function mostrarMensajesAyuda(form) { 
    const formGroups = form.querySelectorAll('.form-group'); //Seleccionar todos los grupos form-group que estan dentro del formulario
    formGroups.forEach(formGroup => {
        const input = formGroup.querySelector('input, textarea, select'); //Selecciona a todos los input, textarea y select
        const small = formGroup.querySelector('small');//Selecciona a todos los small
        if (!input.validity.valid) {
            small.style.display = 'block'; //si el campo no es válido, se muestra el mensaje de ayuda
        } else {
            small.style.display = 'none'; //si el campo es válido, no se muestra el mensaje de ayuda 
        }
    });
}

        </script>
        
        <!-- SCRIPT PARA CARGAR IMAGENES-->
        <script src="../../loadImages.js" type="text/javascript"></script>
        
        <!-- SCRIPT PARA REGISTRAR PROVEEDOR-->
        <script src="../../ProcessProveedor.js" type="text/javascript"></script>
        
        
    </body>
</html>
    
