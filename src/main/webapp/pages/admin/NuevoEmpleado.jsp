
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Conexion.ConectarBD"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.*"%>
<%@page import="com.mysql.jdbc.Driver"%>
<%@page import="java.util.*" %>
<%@page import="DAO.*" %>
<%@page import="Modelo.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Empleados</title>
        
        <script src="node_modules/bootstrap/dist/ js/bootstrap.min.js"></script>
        <link href="../../resources/css/RegistroEmpleado.css" rel="stylesheet" type="text/css"/>
        <link href="../../resources/css/admin.css" rel="stylesheet" type="text/css"/>
        <link href="../../resources/css/admin-display.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <body class="parent-container">      
        <!-- CONTENEDOR REGISTRO DE NUEVOS Empleados -->
          <!-- Para traer el layout(menu lateral) del admin -->
        <jsp:include page="../../admin_layout.jsp" /> 
        <!-- script de carga de imagenes--> 
        <div class="box-Content" >
            <div class="Frm-Header">
                <span>Nuevo Empleado</span>
            </div>
            <div class="Container-RegistroEmpleados negrita"> 
                <!--INGRESAR DATOS -->
               <div class="IngreseDatos">Ingrese los Datos</div>
               <form  action="/TodoPor1Sol/SvEmpleado" >
                   <!--DNI-->
                    <div class="form-group">
                        <span> DNI </span>
                        <input name="dni"  type="text" style="text-align: center" placeholder="" required>
                        <small name="dni" id="dni-help" style="display: none;">Ingresar DNI</small>
                    </div>
                   <!--NOMBRE-->
                    <div class="form-group">
                        <span> Nombre </span>
                        <input name="nombre"  type="text" style="text-align: center" placeholder="" required>
                        <small name="nombre" id="nombre-help" style="display: none;">Ingresar nombre</small>
                    </div>
                   <!--APELLIDOS-->
                    <div class="form-group">
                        <span> Apellidos </span>
                        <input name="apellidos"  type="text" style="text-align: center" placeholder="" required>
                        <small name="apellidos" id="apellidos-help" style="display: none;">Ingresar Apellidos</small>
                    </div>
                    <!--CORREO-->
                    <div class="form-group">
                        <span> Correo </span>
                        <input name="correo"  type="text" style="text-align: center" placeholder="" required>
                        <small name="correo" id="correo-help" style="display: none;">Ingresar correo</small>
                    </div>
                    <!--TELEFONO-->
                    <div class="form-group form-text-Area">
                        <span> Telefono </span>
                        <input name="telefono"  type="text" style="text-align: center" placeholder="" required>
                        <small name="telefono" id="telefono-help" style="display: none;">Ingresar telefono</small>
                    </div>
                    <!--SUELDO-->
                    <div class="form-group">
                        <span> Sueldo </span>
                        <input name="sueldo" type="number" placeholder="" min="0" step="any" required> <!--any para que reciba decimales-->
                        <small id="sueldo-help" style="display: none;">Ingresar Sueldo</small>
                    </div>
                    <!--HORARIO DE ENTRADA-->
                    <div class="form-group">
                        <span> Horario de entrada </span>
                        <input name="horarioE" type="time" style="text-align: center" placeholder="" required>
                        <small name="horarioE" id="horarioE-help" style="display: none;">Ingresar horario de entrada</small>
                    </div>

                    <!--HORARIO DE SALIDA-->
                    <div class="form-group">
                        <span> Horario de salida </span>
                        <input name="horarioS" type="time" style="text-align: center" placeholder="" required>
                        <small name="horarioS" id="horarioS-help" style="display: none;">Ingresar horario de salida</small>
                    </div>
                    <!--Farmacia-->
                    <div class="form-group">
                        <span> Farmacia </span>
                        <select id="farm" name="farm" required>
                            <% 
                        ConectarBD cn = new ConectarBD();
                       
                        try{
                        cn.ConectarBD();
                        String sql= "select * from farmacias; "; 
                        cn.smt= cn.con.createStatement();
                        cn.rs=cn.smt.executeQuery(sql);
                        while(cn.rs.next()){
                %>
                <option value="<%=cn.rs.getString(1)%>"><%=cn.rs.getString(2)%></option>
                <% 
                                }
                                }catch (Exception e){
                                out.print(e.toString());
                                }
                                
                            
                            %>

                            
                        </select>
                        <small id="farm-help" style="display: none;">Ingresar la Farmacia</small>
                    </div>
                    <div class="button" style="text-align: center">
                       <input type="submit" name="accion" value="Agregar">
                    </div>
                </form>
            </div>
            
        </div>
    </body>


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

<!-- CARGAR LAS IMAGENES  -->
 <script src="../../loadImages.js" type="text/javascript"></script>
    

</html>

