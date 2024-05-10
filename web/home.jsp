<%-- 
    Document   : home
    Created on : 9 may. 2024, 11:59:48
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todo Por 1 Sol</title>
        <link href="resources/css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="contenedor-login">
            
            <div class="header-login">
                <div class="header-login2">
                    <div class="header-logo">                        
                        <img style="object-fit: contain; width: 100%; height: 100%;" src="resources/img/home/Logo.png" alt=""/>
                    </div>
                    <div class="header-text">
                        SISTEMA DE VENTAS                  
                    </div>
                </div>
                
                <button class="button">
                    ADMINISTRADOR
                </button>                
            </div>
            <div class="login">
                <div class="imagen">
                    <img style="height: 400px; width: 400px;" src="resources/img/home/TodoPor1Sol.png" alt=""/>
                </div>
                
                <div class="separador"></div>
                
                <div class="form-container">
                    <div style="color:#1d242e;font-size: 2rem; font-weight: 500;">
                        Ingrese sus Datos
                    </div>
                    <form action="" method="post" class="form-login">
                        <div style="display: flex; flex-direction: row; align-items: center;">
                            <div style="margin: 20px 8px 0px 8px;">
                                <img style="height: 48px; width:48px;" src="resources/img/home/Usuarioicono.png" alt=""/>
                            </div>
                            <div>
                                <label style="color:#787e85;font-size: 1.25rem;">Usuario</label><br>
                                <input type="text" name="usuario" value="${usuario}"/>
                            </div>                            
                        </div>
                        <div style="display: flex; flex-direction: row; align-items: center;">
                            <div style="margin: 20px 8px 0px 8px;">
                                <img style="height: 48px; width:48px;" src="resources/img/home/Contraicono.png" alt=""/>
                            </div>
                            <div>
                                <label style="color:#787e85;font-size: 1.25rem;">Contraseña</label><br>
                                <input type="password" name="contraseña" value="${contraseña}"/>
                            </div> 
                            <div>
                                <img style="height: 36px; width:36px;margin: 28px 8px 0px 8px; cursor: pointer;" src="resources/img/home/ContraOjo.png" alt=""/>
                            </div>
                        </div>
                        <div style="display: flex; justify-content: center; margin: 30px 0px 0px 0px;">
                            <button class="button">
                                Iniciar Sesión
                            </button>
                        </div>
                    </form>
                </div>
            </div>
                            
            <div class="footer-home">
            </div>
                            
        </div>
    </body>
</html>
