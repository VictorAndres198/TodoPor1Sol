
package DAO;

import Conexion.ConectarBD;
import Interfaces.CrudRepository;
import Modelo.Item;
import Modelo.Pedido;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DAOItems{
    
    //Metodo para instanciar la cnx a la BD en cada ejecucion de los metodos crud
    private ConectarBD getCnx(){
        return new ConectarBD();
    }

    public List<Item> FindById(long id) {
        List<Item> items = new ArrayList<>();
        //Query a ejecutar
        String query = "SELECT dp.ID_DetallePedido,DP.ID_Producto, p.Nombre,"
                + " dp.Cantidad,dp.SubTotal FROM detalle_pedidos dp" 
                +" INNER JOIN productos p ON (dp.ID_Producto = p.ID_Prod)"
                + " WHERE dp.ID_Pedido=?;";
       
        try( Connection conn = getCnx().getConnection();
             PreparedStatement pst = conn.prepareStatement(query)){
             pst.setLong(1, id);
            //Ejecuta la busqueda
            
            try(ResultSet rs = pst.executeQuery()){
                while(rs.next()){
                    //Obtenemos los proveedores y los agregamos a la lista
                    items.add(this.getItemsFromDB(rs));
                }
            }
        } catch (Exception e) {
            return null;
        }
        return items;
    }
    
        public void Insert(Item item,long idPedido) {
        //Query a ejecutar
        String action = "INSERT INTO detalle_pedidos" 
                +" (ID_Pedido,ID_Producto,Cantidad,SubTotal)" 
                +" VALUES(?,?,?,?);";
        
        try( Connection conn = getCnx().getConnection();
             PreparedStatement pst = conn.prepareStatement(action)){
            
            setItemToDB(pst, item,idPedido);
            pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Metodo para crear un proveedor segun los resultados obtenidos de la consulta
    private Item getItemsFromDB(ResultSet rs) throws SQLException{
        return new Item(
            rs.getInt("ID_DetallePedido"),
            new Producto(rs.getInt("ID_Producto"),rs.getString("Nombre")),
            rs.getInt("Cantidad"),
            rs.getBigDecimal("SubTotal"));  
    }
    
    
    private void setItemToDB(PreparedStatement pst,Item item,long idPedido) throws SQLException{
        pst.setLong(1, idPedido);
        pst.setInt(2, item.getProducto().getID_Prod());
        pst.setInt(3, item.getCantidad());
        pst.setBigDecimal(4, item.getSubtotal());
    }
    
}
