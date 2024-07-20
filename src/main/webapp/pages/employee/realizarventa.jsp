<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Conexion.ConectarBD"%>
<jsp:useBean id="usuario" class="Modelo.Usuario" scope="session" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet"> <!-- Font Awesome -->
    <title>Realizar Venta</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .header {
            text-align: center;
            margin-bottom: 20px;
        }
        .header h1 {
            color: #333;
        }
        .details {
            margin-bottom: 20px;
        }
        .details label {
            display: inline-block;
            width: 70px;
        }
        .details input {
            width: 300px;
            margin-bottom: 10px;
        }
        #tablaVenta {
            width: 100%;
            margin-bottom: 20px;
            border-collapse: collapse;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }
        #tablaVenta th, #tablaVenta td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            text-align: center;
        }
        #tablaVenta th {
            background-color: #f0f0f0;
            color: #333;
        }
        .input-cant {
            width: 60px;
            text-align: center;
        }
        .search-bar {
            width: calc(100% - 10px);
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .add-btn,.mail-btn,.report-btn {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        
        .mail-btn{
            background-color: #4B4B4B;
        }

        .report-btn{
            background-color: #CC2121;
        }
        
        .add-btn:hover {
            background-color: #aed0f5;
        }
        
        .mail-btn:hover {
            background-color: #989898;
        }

        .report-btn:hover {
            background-color: #F98D8D;
        }

        .total {
            text-align: right;
        }
        .total label {
            font-weight: bold;
        }
        .total input[type="text"] {
            width: 100px;
            text-align: right;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        
        .searchBtn{
            padding: 0.15em 0.6em;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Todo Por 1 Sol</h1>
            <p>La botica m�s cerca de ti</p>
            <p>R.U.C. 10097777666</p>
            <p>BOLETA DE VENTA</p>
            <p>003-0000001</p>
        </div>
        <div class="details">
            <!--BUSCAR CLIENTE-->
            <input type="text" placeholder="DNI del cliente..." id="dniCliente">
            <button type="button" class="searchBtn" onclick="searchClient()"><i class="fa-solid fa-magnifying-glass"></i></button>
            <br>
            <label for="nombres">Nombres</label>
            <input type="text" id="nombres" name="nombres" readonly="true"><br>
            
            <label for="apellidos">Apellidos</label>
            <input type="text" id="apellidos" name="apellidos" readonly="true"><br>
            
            <label for="telefono">Telefono</label>
            <input type="text" id="telefono" name="telefono" readonly="true"><br>
            
            <label for="correo">Correo</label>
            <input type="text" id="correo" name="correo" readonly="true"><br>
        </div>
        <table id="tablaVenta">
            <thead>
                <tr>
                    <th>CANT.</th>
                    <th>CATEGORIA</th>
                    <th>PRODUCTO</th>
                    <th>DESCRIPCI�N</th>
                    <th>P.U.</th>
                    <th>SUBTOTAL</th>
                </tr>
            </thead>
            <tbody id="bodyTablaVenta">
                <!-- Fila inicial por defecto -->
                <tr>
                    <td><input type="number" class="input-cant" id="cantidad1" value="1" min="0" oninput="calcularTotal(1)"></td>
                    <td>
                        <select class="search-bar form-control" onchange="seleccionarProducto(this.value, 1)">
                            <option value="">Seleccionar producto...</option>
                            <!-- Llenado din�mico del combobox con nombres de productos -->
                            <% 
                                try {
                                    ConectarBD cn = new ConectarBD();
                                    String sql = "SELECT prod.ID_Prod AS ID, prod.Nombre AS producto FROM Productos prod WHERE Stock >= 0";
                                    cn.smt = cn.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                                    cn.rs = cn.smt.executeQuery(sql);

                                    while (cn.rs.next()) {
                            %>
                            <option value="<%= cn.rs.getString("producto") %>"><%= cn.rs.getString("producto") %></option>
                            <% 
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            %>
                        </select>
                    </td>
                    <td><input type="text" id="precio1" name="precio" value="0.00" class="input-precio" oninput="calcularTotal(1)"></td>
                    <td><span id="total1">0.00</span></td>
                    <td><label id="infoProducto1"></label></td> <!-- Label para mostrar ID y Precio -->
                </tr>
            </tbody>
        </table>
        <button type="button" class="add-btn" onclick="agregarFila()">Agregar Producto</button>
        <button type="button" class="mail-btn">Enviar Correo</button>
        <button type="button" class="report-btn"><i class="fa-solid fa-file-pdf"></i></button>
        <div class="total">
            
            <label for="opGravada">OP GRAVADA S/.:</label>
            <input type="text" id="opGravada" name="opGravada" value="0.00" readonly="true"><br>
            
            <label for="igv">IGV S/.:</label>
            <input type="text" id="igv" name="igv" value="0.00" readonly="true"><br>
            
            <label for="total">IMPORTE TOTAL S/.:</label>
            <input type="text" id="total" name="total" value="0.00" readonly="true">
        </div>
    </div>

    <script>
        var numFilas = 1;



function calcularTotal(numFila) {
    try {
        var cantidad = parseFloat(document.getElementById('cantidad' + numFila).value.trim());
        var precioUnitario = parseFloat(document.getElementById('precio' + numFila).value.trim());
        var total = cantidad * precioUnitario;
        document.getElementById('total' + numFila).textContent = total.toFixed(2);

        // Actualizar el total general
        actualizarTotalGeneral();
    } catch (e) {
        console.error(e);
    }
}


function seleccionarProducto(productoId, numFila) {
    try {
        var table = document.getElementById('tablaVenta');
        var rows = table.getElementsByTagName('tr');
        for (var i = 1; i < rows.length; i++) {
            var cells = rows[i].getElementsByTagName('td');
            if (cells[1].getElementsByTagName('select')[0].value.trim() === productoId) {
                var precio = parseFloat(cells[2].getElementsByTagName('input')[0].value.trim());
                document.getElementById('precio' + numFila).value = precio.toFixed(2);
                calcularTotal(numFila);

                // Obtener el ID y el Precio del producto seleccionado
                obtenerPrecioProducto(productoId, numFila);
                break;
            }
        }
    } catch (e) {
        console.error(e);
    }
}


function obtenerPrecioProducto(idProducto, numFila) {
    var xhr = new XMLHttpRequest();
    var url = '/TuAplicacion/SvObtenerPrecioProducto?id=' + encodeURIComponent(idProducto);

    xhr.open('GET', url, true);
    xhr.setRequestHeader('Content-type', 'application/json');

    xhr.onreadystatechange = function() {
        if (xhr.readyState == XMLHttpRequest.DONE) {
            if (xhr.status == 200) {
                var response = JSON.parse(xhr.responseText);
                var precioProducto = response.precio;
                var labelInfoProducto = document.getElementById('infoProducto' + numFila);
                if (precioProducto !== undefined) {
                    labelInfoProducto.textContent = 'ID: ' + idProducto + ' - Precio: ' + precioProducto.toFixed(2);
                    document.getElementById('precio' + numFila).value = precioProducto.toFixed(2);
                    calcularTotal(numFila);
                } else {
                    labelInfoProducto.textContent = 'ID: ' + idProducto + ' - Precio: No encontrado';
                }
            } else {
                console.error('Error al obtener el precio del producto');
            }
        }
    };

    xhr.send();
}




        function agregarFila() {
            numFilas++;
            try {
                var table = document.getElementById('tablaVenta').getElementsByTagName('tbody')[0];
                var newRow = table.insertRow();
                var cantidadCell = newRow.insertCell(0);
                var descripcionCell = newRow.insertCell(1);
                var precioCell = newRow.insertCell(2);
                var totalCell = newRow.insertCell(3);
                var infoProductoCell = newRow.insertCell(4); // Nueva celda para mostrar ID y Precio

                cantidadCell.innerHTML = '<input type="number" class="input-cant" id="cantidad' + numFilas + '" value="1" oninput="calcularTotal(' + numFilas + ')">';
                descripcionCell.innerHTML = `
                    <select class="search-bar form-control" onchange="seleccionarProducto(this.value, ${numFilas})">
                        <option value="">Seleccionar producto...</option>
                        <% 
                            try {
                                ConectarBD cn = new ConectarBD();
                                String sql = "SELECT prod.ID_Prod AS ID, prod.Nombre AS producto FROM Productos prod WHERE Stock >= 0";
                                cn.smt = cn.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                                cn.rs = cn.smt.executeQuery(sql);

                                while (cn.rs.next()) {
                        %>
                        <option value="<%= cn.rs.getString("producto") %>"><%= cn.rs.getString("producto") %></option>
                        <% 
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        %>
                    </select>
                `;
                precioCell.innerHTML = '<input type="text" id="precio' + numFilas + '" name="precio" value="0.00" class="input-precio" oninput="calcularTotal(' + numFilas + ')">';
                totalCell.innerHTML = '<span id="total' + numFilas + '">0.00</span>';
                infoProductoCell.innerHTML = '<label id="infoProducto' + numFilas + '"></label>'; // Label para mostrar ID y Precio

            } catch (e) {
                console.error(e);
            }
        }

        function calcularTotal(numFila) {
            try {
                var cantidad = parseFloat(document.getElementById('cantidad' + numFila).value.trim());
                var precioUnitario = parseFloat(document.getElementById('precio' + numFila).value.trim());
                var total = cantidad * precioUnitario;
                document.getElementById('total' + numFila).textContent = total.toFixed(2);

                // Actualizar el total general
                actualizarTotalGeneral();
            } catch (e) {
                console.error(e);
            }
        }

        function actualizarTotalGeneral() {
            try {
                var table = document.getElementById('tablaVenta');
                var rows = table.getElementsByTagName('tr');
                var totalGeneral = 0;
                for (var i = 1; i < rows.length; i++) {
                    var cells = rows[i].getElementsByTagName('td');
                    var totalFila = parseFloat(cells[3].getElementsByTagName('span')[0].textContent.trim());
                    totalGeneral += totalFila;
                }
                document.getElementById('opGravada').value = totalGeneral.toFixed(2);
            } catch (e) {
                console.error(e);
            }
        }
    </script>
    <script src="../../resources/js/scriptsEmpleado/functionsBoleta.js" type="text/javascript"></script>
    
</body>
</html>
