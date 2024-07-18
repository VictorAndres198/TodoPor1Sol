<%-- 
    Document   : realizarventa
    Created on : 7 jul. 2024, 16:53:27
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Realizar Venta</title>
        <style>
            body {
                font-family: Arial, sans-serif;
            }
            .container {
                width: 80%;
                margin: 20px auto;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 10px;
            }
            .header {
                text-align: center;
                margin-bottom: 20px;
            }
            .details {
                margin-bottom: 20px;
            }
            .details label {
                display: inline-block;
                width: 100px;
            }
            .details input {
                width: 300px;
                margin-bottom: 10px;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }
            table, th, td {
                border: 1px solid black;
            }
            th, td {
                padding: 10px;
                text-align: left;
            }
            .total {
                text-align: right;
                margin-top: 20px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <h1>Todo Por 1 Sol</h1>
                <p>La botica más cerca de ti</p>
                <p>R.U.C. 10097777666</p>
                <p>BOLETA DE VENTA</p>
                <p>003-0000001</p>
            </div>
            <div class="details">
                <label for="nombre">Señor:</label>
                <input type="text" id="nombre" name="nombre"><br>
                <label for="direccion">Dirección:</label>
                <input type="text" id="direccion" name="direccion"><br>
                <label for="dni">D.I.:</label>
                <input type="text" id="dni" name="dni"><br>
                <label for="fecha">Fecha:</label>
                <input type="text" id="fecha" name="fecha"><br>
            </div>
            <table>
                <tr>
                    <th>CANT.</th>
                    <th>DESCRIPCIÓN</th>
                    <th>P.U.</th>
                    <th>TOTAL</th>
                </tr>
                <%-- Aquí puedes agregar filas dinámicamente con JSP o JavaScript --%>
                <tr>
                    <td>1</td>
                    <td>Ejemplo Producto</td>
                    <td>10.00</td>
                    <td>10.00</td>
                </tr>
            </table>
            <div class="total">
                <label for="total">TOTAL S/.:</label>
                <input type="text" id="total" name="total" value="10.00">
            </div>
        </div>
    </body>
</html>
