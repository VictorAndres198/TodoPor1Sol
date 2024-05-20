package DAO;

import Conexion.*;
import Modelo.Producto;
import DAO.*;
import Interfaces.CRUDproductos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DAOproductos extends ConectarBD implements CRUDproductos {

    @Override
    public ArrayList<Producto> ListarProductos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto ObtenerProductos(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean RegistrarProductos(Producto pro) {
        
        String SQL = "insert into cargo values(?,?,?,?,?,?,?,?);";
        try{
            ps = super.getConnection().prepareStatement(SQL);
            ps.setInt(1,pro.getID_Prod());
            ps.setString(2,pro.getNombre());
            ps.setString(3, pro.getDescripcion());
            ps.setDate(4, (Date) pro.getFechaVencimiento());
            ps.setDouble(5, pro.getPrecio());
            ps.setInt(6, pro.getStock());
            ps.setInt(7, pro.getID_categoria());
            ps.setString(8, pro.getRUC_Prov());
            ps.executeUpdate();
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null,
                   "ERROR no se puede insertar cargo.."+ex);
       }
        
        return false;
        
    }

    @Override
    public boolean EditarProductos(Producto RegProd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean EliminarProductos(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
