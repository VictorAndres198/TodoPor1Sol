
package DAO;

import Conexion.ConectarBD;
import Interfaces.CrudRepository;
import Modelo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DAOPedidos {
    
    //Metodo para instanciar la cnx a la BD en cada ejecucion de los metodos crud
    private ConectarBD getCnx(){
        return new ConectarBD();
    }
    
    

    public List<Pedido> FindAll() {
                List<Pedido> pedidos = new ArrayList<>();
        //Query a ejecutar
        String query = "SELECT * FROM bdbotica.pedidos;";
       
        try( Connection conn = getCnx().getConnection();
             Statement st = conn.createStatement()){
            
            //Ejecuta la busqueda
            st.execute(query);
            try(ResultSet rs = st.getResultSet()){
                while(rs.next()){
                    //Obtenemos los proveedores y los agregamos a la lista
                    pedidos.add(this.getPedidoFromDB(rs));
                }
            }
        } catch (Exception e) {
            return null;
        }
        return pedidos;
    }



    public long Insert(Pedido ped) {
        
        long idPedidoInsertado=0;
        //Query a ejecutar
        String sql = "INSERT INTO pedidos(Fecha_Hora,PrecioTotal,IGV,Precio_Final)" 
                +" VALUES (?,?,?,?);";
        
        try( Connection conn = getCnx().getConnection();
             PreparedStatement pst = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)){
            
            setPedidoToDB(pst, ped);
            int affectedRows = pst.executeUpdate();
            
            if (affectedRows > 0) {
                // Obtener las claves generadas
                try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getLong(1);
                    }
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idPedidoInsertado;
    }

    
    //Metodo para crear un proveedor segun los resultados obtenidos de la consulta
    private Pedido getPedidoFromDB(ResultSet rs) throws SQLException{
        return new Pedido(
            rs.getInt("ID_Pedido"),
            rs.getObject("Fecha_Hora",LocalDateTime.class),
            rs.getBigDecimal("PrecioTotal"), 
            rs.getBigDecimal("IGV"), 
            rs.getBigDecimal("Precio_Final"));  
    }
    
    
    private void setPedidoToDB(PreparedStatement pst,Pedido ped) throws SQLException{
        pst.setTimestamp(1, Timestamp.valueOf(ped.getFechaHora()));
        pst.setBigDecimal(2, ped.getPrecioTotal());
        pst.setBigDecimal(3, ped.getIGV());
        pst.setBigDecimal(4, ped.getPrecioFinal());
    }
    
    
}
