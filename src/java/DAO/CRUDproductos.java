package DAO;

import Modelo.Productos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUDProductos extends ConectarBD {

    public boolean RegistrarProductos(Productos RegProd) {
        String sql = "INSERT INTO productos (ID_Prod, Nombre, descripcion, FechaVencimiento, Precio, Stock, ID_categoria, RUC_Prov) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = this.conexion;
             PreparedStatement ps = connection.prepareStatement(sql)) {
             
            ps.setInt(1, RegProd.getID_Prod());
            ps.setString(2, RegProd.getNombre());
            ps.setString(3, RegProd.getDescripcion());
            ps.setDate(4, new Date(RegProd.getFechaVencimiento().getTime()));
            ps.setDouble(5, RegProd.getPrecio());
            ps.setInt(6, RegProd.getStock());
            ps.setInt(7, RegProd.getID_categoria());
            ps.setString(8, RegProd.getRUC_Prov());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("ERROR: NO SE PUEDE INSERTAR LOS REGISTROS. " + ex);
            return false;
        }
    }
}
