<%-- 
    Document   : GestionarProveedor
    Created on : 19 may 2024, 23:37:34
    Author     : Alejo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion de Pedidos</title>
        <link href="../../resources/css/GestionarPedidos.css" rel="stylesheet" type="text/css"/>
        <script src="../../resources/js/BuscadorProveedores.js" type="text/javascript"></script>
        <link href="../../resources/css/admin.css" rel="stylesheet" type="text/css"/>
        <link href="../../resources/css/admin-display.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet"> <!-- Font Awesome -->

    </head>  
    <body class="parent-container">
        <!-- Para traer el layout(menu lateral) del admin -->
        <jsp:include page="../../admin_layout.jsp" />  
        <div class="box-Content">
            <div class="Frm-Header">
                <span class="Frm-Title">Gestion de Pedidos</span>
                <div class="search-box">
                    <input id="searchTerm" type="text" class="search-bar" onkeyup="doSearch()" placeholder="Buscar proveedores..."></<input>
                    <button type="submit" class="search-btn">
                        <img class="search-icon" src="../../resources/img/icons/search-symbol.png" alt=""/>
                    </button> 
                </div>
            </div>
            
            <div><h2>PEDIDO</h2></div>
            <div class="Frm-Table table-responsive">
                <table class="table table-striped table-sm align-middle" id="Table-Pedidos">
                    <thead class="align-middle table-header">
                        <tr class="table-primary">
                            <th>ID</th>
                            <th>Fecha-Hora</th>
                            <th>Precio Total</th>
                            <th>IGV</th>
                            <th>Precio Final</th>
                            <th>Botones</th>
                        </tr>
                    </thead>
                    <tbody class="table-group-divider">
                        
        
                    </tbody >
                </table>
            </div>
            
            <div><h2>DETALLE PEDIDO</h2></div>
            
            <div class="Frm-Table table-responsive">
                <table class="table table-striped table-sm align-middle">
                    <thead class="align-middle table-header">
                        <tr class="table-primary">
                            <th>ID Pedido</th>
                            <th>ID Producto</th>
                            <th>Nombre </th>
                            <th>Cantidad</th>
                            <th>Subtotal</th>
                        </tr>
                    </thead>
                    <tbody class="table-group-divider">
                        <tr>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                        </tr>
                        <tr>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                        </tr>
                        <tr>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                        </tr>
                        <tr>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                        </tr>
                        <tr>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                        </tr>
                        <tr>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                        </tr>
                        <tr>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                        </tr>
                        <tr>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                        </tr>
                        <tr>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                        </tr>
                        <tr>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                            <th>data</th>
                        </tr>
                    <br>
                    </tbody >
                </table>
            </div>
       
        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
        
                
        <!-- SCRIPT PARA CARGAR IMAGENES-->
        <script src="../../loadImages.js" type="text/javascript"></script>
        
        <!-- SCRIPT PARA CARGAR TODOS LOS PEDIDOS-->
        <script src="../../resources/js/scriptsPedidos/searchPedidos.js" type="text/javascript"></script>
        
        
    </body>
</html>
