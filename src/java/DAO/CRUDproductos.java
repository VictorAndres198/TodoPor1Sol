package DAO;

import Conexion.ConectarBD;
import Modelo.Productos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUDProductos extends ConectarBD {

    public boolean RegistrarProductos(Productos RegProd) {
        String sql = "INSERT INTO productos (Nombre, descripcion, FechaVencimiento, Precio, Stock, ID_categoria, RUC_Prov) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = this.conexion;
             PreparedStatement ps = connection.prepareStatement(sql)) {
             
        
            ps.setString(1, RegProd.getNombre());
            ps.setString(2, RegProd.getDescripcion());
            ps.setDate(3, new Date(RegProd.getFechaVencimiento().getTime()));
            ps.setDouble(4, RegProd.getPrecio());
            ps.setInt(5, RegProd.getStock());
            ps.setInt(6, RegProd.getID_categoria());
            ps.setString(7, RegProd.getRUC_Prov());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("ERROR: NO SE PUEDE INSERTAR LOS REGISTROS. " + ex);
            return false;
        }
    }
}
