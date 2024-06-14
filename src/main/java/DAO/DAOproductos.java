package DAO;

import Conexion.*;
import Modelo.Producto;
import Interfaces.CRUDproductos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class DAOproductos  {

 private Connection con;
        
        public DAOproductos() {
        ConectarBD conexion = new ConectarBD();
        con = conexion.getConnection();
    }
        
       
    public String RegistrarProductos(Producto pro){
        String result = "PRODUCTO CARGADO";
        String sql = "INSERT INTO productos (ID_Prod, Nombre, descripcion, FechaVencimiento,Precio,Stock,ID_categoria,RUC_Prov) "
                + "VALUES (?, ?, ?, ?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getID_Prod());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getDescripcion());
            ps.setDate(4, new Date ( pro.getFechaVencimiento().getTime() ));
            ps.setDouble(5, pro.getPrecio());
            ps.setInt(6, pro.getStock());
            ps.setInt(7, pro.getID_Prod());
            ps.setString(8, pro.getRuc());
            ps.executeUpdate();
        } catch (SQLException e) {
            result = "ERROR AL REGISTRAR PRODUCTO: " + e.getMessage();
        }

        return result;
    }
    
    
}
