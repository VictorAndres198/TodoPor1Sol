package DAO;

import Conexion.ConectarBD;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOproductos {
    private ConectarBD conectar;

    public DAOproductos() {
        conectar = new ConectarBD();
    }

    public String insertarProducto(Producto producto) {
        String sql = "INSERT INTO Productos (Nombre, Descripcion, FechaVencimiento, precio, Stock, ID_categoria, RUC_Prov) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = conectar.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDate(3, new java.sql.Date(producto.getFechaVencimiento().getTime()));
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getStock());
            ps.setInt(6, producto.getID_categoria());
            ps.setString(7, producto.getRuc());
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return "Producto insertado con éxito";
            } else {
                return "Error al insertar el producto";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al insertar el producto: " + e.getMessage();
        }
    }
}
