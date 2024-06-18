<%-- 
    Document   : GestionarProductos
    Created on : 17 jun. 2024, 5:48:13 p. m.
    Author     : Andres
--%>

<%@page import="Conexion.ConectarBD"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.*"%>
<%@page import="com.mysql.jdbc.Driver"%>
<%@page import="java.util.*" %>
<%@page import="DAO.*" %>
<%@page import="Modelo.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionar Productos </title>
        <script src="node_modules/bootstrap/dist/ js/bootstrap.min.js"></script>

        <link href="resources/css/admin.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/employee-display.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/RegistroProducto/GestionarProductos.css" rel="stylesheet" type="text/css"/>

        <title>Gestionar Productos</title>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>






    </head>

    <body class="parent-container">      
        <!-- Para traer el layout(menu lateral) del admin -->
        <jsp:include page="admin_layout.jsp"/>
        <div class="box-Content">
            <div class="Frm-Header">
                <span class="Frm-Title">Gestionar Productos</span>
                <div class="search-box">
                    <input type="input" class="search-bar"></<input>
                    <button type="submit" class="search-btn">
                        <img class="search-icon" src="resources/img/icons/search-symbol.png" alt=""/>
                        <button> 
                            </div>
                            </div>
                            <div class="Frm-Table">
                                <table id="Table-Proveedores" class="table">
                                    <thead class="table-header">
                                        <tr>
                                            <th>ID</th>
                                            <th>Nombre</th>
                                            <th>Descripcion</th>
                                            <th>Fecha de vencimiento</th>
                                            <th>Precio</th>
                                            <th>Stock</th>
                                            <th>Categoria</th>
                                            <th>Proveedor</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            //Resulset = rs
                                            //Conection = cn
                                            //Statement = smt
                                            // ConectarBD = clase de conexión a la base de datos
                                            ConectarBD cn = new ConectarBD();
                                            // Consulta SQL CON INNERJOIN
                                            String sql = "SELECT prod.ID_Prod AS ID, prod.Nombre AS producto, prod.descripcion, "
                                                    + "prod.FechaVencimiento, prod.Precio, prod.Stock, "
                                                    + "cat.Nombre AS categoria, "
                                                   + "prov.RUC AS RUC_Prov, prov.nombre AS proveedor "
                                                    + "FROM Productos prod "
                                                    + "JOIN Proveedores prov ON prod.RUC_Prov = prov.RUC "
                                                    + "JOIN Categorias cat ON prod.ID_categoria = cat.ID_categoria";
                                            cn.smt = cn.con.createStatement();
                                            cn.rs = cn.smt.executeQuery(sql);

                                            while (cn.rs.next())
                                            {
                                        %>
                                        <tr>
                                            <td><%= cn.rs.getInt("ID")%></td>
                                            <td><%= cn.rs.getString("producto")%></td>
                                            <td><%= cn.rs.getString("descripcion")%></td>
                                            <td><%= cn.rs.getDate("FechaVencimiento")%></td>
                                            <td><%= cn.rs.getDouble("Precio")%></td>
                                            <td><%= cn.rs.getInt("Stock")%></td>
                                            <td><%= cn.rs.getString("categoria")%></td>
                                            <td><%= cn.rs.getString("proveedor")%></td>
                                        </tr>
                                        <%
                                            }
                                        %>


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
                            </body>




                            <!-- CARGAR LAS IMAGENES  -->
                            <!-- <script src="../../loadImages.js" type="text/javascript"></script>  -->

                            <script src="../../loadImages.js" type="text/javascript"></script>

                            </html>