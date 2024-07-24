<%-- 
    Document   : historialdeventas
    Created on : 7 jul. 2024, 16:53:37
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historial de Ventas</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    </head>
    <body>
        <div class="container">
            <h2 class="pt-4">Historial de Ventas</h2>
            <p class="lead mb-2">Historial de todas las ventas hechas por mes</p>
            <div id="graficos">
                <canvas id="ventasChart" width="400" height="200"></canvas>
            </div>
        </div>
    </body>
</html>
