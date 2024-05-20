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
        <title>Registro de Productos</title>
      
        <script src="node_modules/bootstrap/dist/ js/bootstrap.min.js"></script>
        <link href="resources/css/RegistroProducto/EstiloRegProd.css" rel="stylesheet" type="text/css"/>
    </head>
    
        
<!-- CONTENEDOR REGISTRO DE NUEVOS PRODUCTOS -->

<div class="Container-RegistroProductos negrita"> 
    
    <!--INGRESAR DATOS -->
    <div class="IngreseDatos">NUEVO PRODUCTO</div>
   <form id="form-validation" action="SvProductos" method="post" novalidate>
        <div class="form-group">
            <span> Nombre </span>
            <input name="nombre"  type="text" style="text-align: center" placeholder="" required>
            <small name="nombre" id="nombre-help" style="display: none;">Ingresar nombre</small>
        </div>
        <!--DESCRIPCIÓN-->
        <div class="form-group">
            <span> Descripción </span>
            <textarea name="descripcion"  rows="4" cols="20" placeholder="" ></textarea>
            <small id="descripcion-help" style="display: none;"></small>
        </div>
        <!--FECHA DE VENCIMIENTO-->
        <div class="form-group">
            <span> Fecha de Vencimiento </span>
            <input name="fechaVencimiento"  type="date" id="fecha-vencimiento" name="fecha-vencimiento" required>
            <small id="fecha-help" style="display: none;">Ingresar fecha de vencimiento</small>
        </div>
        <!--STOCK-->
        <div class="form-group">
            <span> Stock </span>
            <input name="stock" type="number" placeholder="" min="0" required>
            <small id="stock-help" style="display: none;">Ingresar stock</small>
        </div> 
        <!--PRECIO-->
        <div class="form-group">
            <span> Precio </span>
            <input name="precio" type="number" placeholder="" min="0" step="any" required> <!--any para que reciba decimales-->
            <small id="precio-help" style="display: none;">Ingresar precio</small>
        </div>
        <!--PROVEEDORES-->
        <div class="form-group">
            <span> Proveedor </span>
            <select id="proveedores" name="proveedor" required>
                <option value="1" selected="selected"></option>
                <option value="2">Lab</option>
                <option value="3">Dove</option>
            </select>
            <small id="proveedor-help" style="display: none;">Ingresar proveedor</small>
        </div>
        <!--CATEGORIA-->
        <div class="form-group"  >
            <span class="categoria"> Categoria </span>
            <select id="categoria" name="categoria" required>
                <option value="1" selected="selected"></option>
                <option value="2">Generico</option>
                <option value="3">Original</option>
            </select>
            <small id="categoria-help" style="display: none;">Ingresar categoria</small>
        </div>
        <div class="button" style="text-align: center">
            <input type="submit" name="guardar" value="Guardar">
        </div>
    </form>
</div>


 <!--SCRIPT PARA VALIDAR EL INGRESO DE DATOS-->
<script>
document.getElementById("form-validation").addEventListener("submit", function(e) {
    e.preventDefault(); // Evita que el formulario sea enviado sin antes ser revisado
    const form = e.target;
    mostrarMensajesAyuda(form);

    if (form.checkValidity()) {
        form.submit(); // Si el formulario es válido, proceder a enviarlo
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

    

</html>

