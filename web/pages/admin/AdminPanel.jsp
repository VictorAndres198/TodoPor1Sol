
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../../resources/css/adminPanel.css" rel="stylesheet" type="text/css"/>
        <!-- Recursos del layout Admin -->
        <link href="../../resources/css/admin.css" rel="stylesheet" type="text/css"/>
        <link href="../../resources/css/admin-display.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body class="parent-container">
        <!-- Para traer el layout(menu lateral) del admin -->
        <jsp:include page="../../admin_layout.jsp" /> 
        <!-- script de carga de imagenes-->
        <script src="../../loadImages.js" type="text/javascript"></script>
        
        <div class="box-Content">
            <div class="Frm-Header">    
                <span class="Frm-name">Panel de Informacion</span>
                <span class="Frm-description">Una descripción general rápida de los datos en el inventario.</span>
            </div>

            <div class="card-container">
                <div class ="card">
                    <div>
                        <span class="card-title">Inventario</span>
                        <a class="card-config" src="">Ir a la Configuracion >></a>
                    </div>
                    <div class="card-info">
                        <div class="card-info card-element">
                            <span class="card-info number">289</span>
                            <span class="card-info detail">Nro. Total de medicamentos</span>                

                        </div>
                        <div class="card-info card-element">
                            <span class="card-info number">289</span>
                            <span class="card-info detail">Nro. Total de medicamentos</span>                             
                        </div>
                    </div>
                </div>
                <div class ="card">
                    <div>
                        <span class="card-title">Inventario</span>
                        <a class="card-config" src="">Ir a la Configuracion >></a>
                    </div>
                    <div class="card-info">
                        <div class="card-info card-element">
                            <span class="card-info number">289</span>
                            <span class="card-info detail">Nro. Total de medicamentos</span>                

                        </div>
                        <div class="card-info card-element">
                            <span class="card-info number">289</span>
                            <span class="card-info detail">Nro. Total de medicamentos</span>                             
                        </div>
                    </div>
                </div>
                <div class ="card">
                    <div>
                        <span class="card-title">Inventario</span>
                        <a class="card-config" src="">Ir a la Configuracion >></a>
                    </div>
                    <div class="card-info">
                        <div class="card-info card-element">
                            <span class="card-info number">289</span>
                            <span class="card-info detail">Nro. Total de medicamentos</span>                

                        </div>
                        <div class="card-info card-element">
                            <span class="card-info number">289</span>
                            <span class="card-info detail">Nro. Total de medicamentos</span>                             
                        </div>
                    </div>
                </div>
                <div class ="card">
                    <div>
                        <span class="card-title">Inventario</span>
                        <a class="card-config" src="">Ir a la Configuracion >></a>
                    </div>
                    <div class="card-info">
                        <div class="card-info card-element">
                            <span class="card-info number">289</span>
                            <span class="card-info detail">Nro. Total de medicamentos</span>                

                        </div>
                        <div class="card-info card-element">
                            <span class="card-info number">289</span>
                            <span class="card-info detail">Nro. Total de medicamentos</span>                             
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        
    </body>
</html>
