<%@ page import="java.sql.*" %>
<%@ page import="Conexion.ConectarBD" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        .add-btn {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .add-btn:hover {
            background-color: #0056b3;
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
        <table id="tablaVenta">
            <thead>
                <tr>
                    <th>CANT.</th>
                    <th>DESCRIPCIÓN / BUSCAR</th>
                    <th>P.U.</th>
                    <th>TOTAL</th>
                </tr>
            </thead>
            <tbody id="bodyTablaVenta">
                <!-- Fila inicial por defecto -->
                <tr>
                    <td><input type="number" class="input-cant" id="cantidad1" value="1" oninput="calcularTotal(1)"></td>
                    <td>
                        <select class="search-bar form-control" onchange="seleccionarProducto(this.value, 1)">
                            <option value="">Seleccionar producto...</option>
                            <!-- Llenado dinámico del combobox con nombres de productos -->
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
                    <td><input type="text" id="precio1" name="precio" value="0.00" disabled></td>
                    <td><span id="total1">0.00</span></td>
                </tr>
            </tbody>
        </table>
        <button type="button" class="add-btn" onclick="agregarFila()">Agregar Producto</button>
        <div class="total">
            <label for="total">TOTAL S/.:</label>
            <input type="text" id="total" name="total" value="0.00">
        </div>
    </div>

    <script>
        var numFilas = 1;

        function seleccionarProducto(producto, numFila) {
            try {
                var table = document.getElementById('tablaVenta');
                var rows = table.getElementsByTagName('tr');
                for (var i = 1; i < rows.length; i++) {
                    var cells = rows[i].getElementsByTagName('td');
                    if (cells[1].getElementsByTagName('select')[0].value.trim() === producto) {
                        var precio = parseFloat(cells[2].getElementsByTagName('input')[0].value.trim());
                        document.getElementById('precio' + numFila).value = precio.toFixed(2);
                        calcularTotal(numFila);
                        break;
                    }
                }
            } catch (e) {
                console.error(e);
            }
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

                cantidadCell.innerHTML = `<input type="number" class="input-cant" id="cantidad${numFilas}" value="1" oninput="calcularTotal(${numFilas})">`;
                descripcionCell.innerHTML = `
                    <select class="search-bar form-control" onchange="seleccionarProducto(this.value, ${numFilas})">
                        <option value="">Seleccionar producto...</option>
                    <% 
                        ConectarBD cn = new ConectarBD();
                        try {
                            String sql = "SELECT prod.ID_Prod AS ID, prod.Nombre AS producto FROM Productos prod WHERE Stock >= 0";
                            cn.smt = cn.con.createStatement();
                            cn.rs = cn.smt.executeQuery(sql);
                    %>
                    <select class="search-bar form-control" onchange="seleccionarProducto(this.value, 1)">
                        <option value="">Seleccionar producto...</option>
                        <% 
                            if (cn.rs != null) {
                                cn.rs.beforeFirst(); // Volver al inicio del conjunto de resultados
                                while (cn.rs.next()) {
                        %>
                        <option value="<%= cn.rs.getString("producto") %>"><%= cn.rs.getString("producto") %></option>
                        <% 
                                }
                            }
                        %>
                    </select>
                    <% 
                            // Cerrar recursos al finalizar
                            if (cn.rs != null) {
                                cn.rs.close();
                            }
                            if (cn.smt != null) {
                                cn.smt.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    %>
                `;
                precioCell.innerHTML = `<input type="text" id="precio${numFilas}" name="precio" value="0.00" disabled>`;
                totalCell.innerHTML = '<span id="total' + numFilas + '">0.00</span>';

                document.getElementById(`cantidad${numFilas}`).focus(); // Enfocar el nuevo campo de cantidad
            } catch (e) {
                console.error(e);
            }
        }

        function calcularTotal(numeroFila) {
            try {
                var cantidad = parseInt(document.getElementById(`cantidad${numeroFila}`).value);
                var precioUnitario = parseFloat(document.getElementById(`precio${numeroFila}`).value);
                var total = cantidad * precioUnitario;
                document.getElementById(`total${numeroFila}`).textContent = total.toFixed(2); // Mostrar total con dos decimales
                actualizarTotalGeneral();
            } catch (e) {
                console.error(e);
            }
        }

        function actualizarTotalGeneral() {
            try {
                var totalGeneral = 0.0;
                for (var i = 1; i <= numFilas; i++) {
                    var totalFila = parseFloat(document.getElementById(`total${i}`).textContent);
                    totalGeneral += totalFila;
                }
                document.getElementById('total').value = totalGeneral.toFixed(2); // Mostrar total general en el input de TOTAL
            } catch (e) {
                console.error(e);
            }
        }
    </script>
</body>
</html>
