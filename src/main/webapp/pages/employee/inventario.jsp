<%-- 
    Document   : inventario
    Created on : 7 jul. 2024, 16:53:17
    Author     : Victor
--%>
<%@page import="Conexion.ConectarBD"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Inventario de Productos</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Estilos personalizados -->
    <style>
        .search-box {
            display: flex;
            align-items: center;
            margin-bottom: 20px;
        }
        .search-bar {
            width: 300px;
            margin-right: 10px;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .search-btn {
            padding: 6px 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            background-color: #f8f9fa;
            cursor: pointer;
        }
        .search-icon {
            width: 20px;
            height: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="pt-4">Inventario</h2>
        <p class="lead mb-2">Inventario completo de todos los productos disponibles para la venta</p>
        <!-- Barra de búsqueda -->
        <div class="search-box">
            <input id="searchTerm" type="text" class="search-bar form-control" onkeyup="doSearch()" placeholder="Buscar...">
            <button type="button" class="search-btn btn btn-outline-secondary">
                <img class="search-icon" src="resources/img/icons/search-symbol.png" alt="Buscar">
            </button>
        </div>

        <!-- Tabla de productos -->
        <div class="table-responsive">
            <table id="Table-Productos" class="table table-striped table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Vencimiento</th>
                        <th>Precio</th>
                        <th>Stock</th>
                        <th>Categoría</th>
                        <th>Proveedor</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        ConectarBD cn = new ConectarBD();
                        String sql = "SELECT prod.ID_Prod AS ID, prod.Nombre AS producto, prod.descripcion, "
                                + "prod.FechaVencimiento, prod.Precio, prod.Stock, "
                                + "cat.Nombre AS categoria, "
                                + "prov.RUC AS RUC_Prov, prov.nombre AS proveedor "
                                + "FROM Productos prod "
                                + "JOIN Proveedores prov ON prod.RUC_Prov = prov.RUC "
                                + "JOIN Categorias cat ON prod.ID_categoria = cat.ID_categoria where Stock >= 0";
                        cn.smt = cn.con.createStatement();
                        cn.rs = cn.smt.executeQuery(sql);

                        while (cn.rs.next()) {
                    %>
                    <tr>
                        <td><%= cn.rs.getString("producto") %></td>
                        <td><%= cn.rs.getString("descripcion") %></td>
                        <td><%= cn.rs.getDate("FechaVencimiento") %></td>
                        <td><%= cn.rs.getDouble("Precio") %></td>
                        <td><%= cn.rs.getInt("Stock") %></td>
                        <td><%= cn.rs.getString("categoria") %></td>
                        <td><%= cn.rs.getString("proveedor") %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>

    <!-- jQuery y Script para la búsqueda en la tabla -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        function doSearch() {
            var tableReg = document.getElementById('Table-Productos');
            var searchText = document.getElementById('searchTerm').value.toLowerCase();
            var cellsOfRow = "";
            var found = false;
            var compareWith = "";

            // Recorremos todas las filas del contenido de la tabla productos
            for (var i = 1; i < tableReg.rows.length; i++) {
                cellsOfRow = tableReg.rows[i].getElementsByTagName('td');
                found = false;

                // Recorremos todas las celdas
                for (var j = 0; j < cellsOfRow.length && !found; j++) {
                    compareWith = cellsOfRow[j].innerHTML.toLowerCase();

                    // Buscar texto en el contenido de la celda 
                    if (searchText.length == 0 || (compareWith.indexOf(searchText) > -1)) {
                        found = true; 
                    }
                }

                if (found) {
                    tableReg.rows[i].style.display = '';
                } else {
                    // Si no encuentra ninguna coincidencia en la fila, esconde la fila de la tabla
                    tableReg.rows[i].style.display = 'none';
                }
            }
        }
    </script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>