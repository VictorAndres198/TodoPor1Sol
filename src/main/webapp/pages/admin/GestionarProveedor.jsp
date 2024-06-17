<%-- 
    Document   : GestionarProveedor
    Created on : 19 may 2024, 23:37:34
    Author     : Alejo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Proveedores</title>
        <link href="../../resources/css/GestionarProveedor.css" rel="stylesheet" type="text/css"/>
        <link href="../../resources/css/admin.css" rel="stylesheet" type="text/css"/>
        <link href="../../resources/css/admin-display.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </head>  
    <body class="parent-container">
        <!-- Para traer el layout(menu lateral) del admin -->
        <jsp:include page="../../admin_layout.jsp" />  
        <div class="box-Content">
            <div class="Frm-Header">
                <span class="Frm-Title">Gestionar Proveedor</span>
                <div class="search-box">
                    <input type="input" class="search-bar"></<input>
                    <button type="submit" class="search-btn">
                        <img class="search-icon" src="../../resources/img/icons/search-symbol.png" alt=""/>
                    </button> 
                </div>
            </div>
            <div class="Frm-Table">
                <table id="Table-Proveedores" class="table">
                    <thead class="table-header">
                        <tr>
                            <th>RUC</th>
                            <th>Nombre</th>
                            <th>País</th>
                            <th>Teléfono</th>
                            <th>Correo</th>
                        </tr>
                    </thead>
                    <tbody>
                        
        
                    </tbody>
                </table>
            </div>
            <div class="Frm-Btns-Report">
                <button class="Btn_PDF" onclick="sendReportData()">Generar Reporte</button>
            </div>
            <div class="Frm-Btns">
                <button class="box-Content_Btn">Modificar</button>       
                <button class="box-Content_Btn btn_delete">Eliminar</button>       
            </div>
        </div>
            
        <!-- SCRIPT PARA CARGAR IMAGENES-->
        <script src="../../loadImages.js" type="text/javascript"></script>
        
        <!-- SCRIPT PARA CARGAR TODOS LOS PROVEEDORES -->
        <script src="../../SearchProveedor.js" type="text/javascript"></script>
        
        <!-- SCRIPT PARA MANEJAR LOS DATOS ENVIADOS PARA GENERAR REPORTE -->
        <script src="../../generateReport.js" type="text/javascript"></script>
        
    </body>
</html>
