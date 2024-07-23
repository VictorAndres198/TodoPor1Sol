
package DAO;

import Conexion.ConectarBD;
import Modelo.Comprobante;
import Modelo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;


public class DAOComprobantes {
    
    //Metodo para instanciar la cnx a la BD en cada ejecucion de los metodos crud
    private ConectarBD getCnx(){
        return new ConectarBD();
    }
    
    public String FindLastComprobante() {
        String idLastComprobante="";
        //Query a ejecutar
        String query = "SELECT ID FROM comprobantes ORDER BY Fecha_Hora DESC LIMIT 1;";
       
        try( Connection conn = getCnx().getConnection();
             Statement st = conn.createStatement()){
            
            //Ejecuta la busqueda
            st.execute(query);
            try(ResultSet rs = st.getResultSet()){
                if(rs.next()){
                    //Obtenemos los proveedores y los agregamos a la lista
                    return rs.getString("ID");
                }
            }
        } catch (Exception e) {
            return null;
        }
        return idLastComprobante;
    }
   
    //Este metodo puede usarse para insertar tanto comprobantes boletas como facturas
    public void Insert(Comprobante comp) {
        //Query a ejecutar
        String action = "INSERT INTO comprobantes(ID,Fecha_Hora,ID_pedido,ID_cliente,"
                        + " DNI_empleado,ID_tipoComprobante)" 
                        +" VALUES (?,?,?,?,?,?);";
        
        try( Connection conn = getCnx().getConnection();
             PreparedStatement pst = conn.prepareStatement(action)){
            
            setComprobanteToDB(pst, comp);
            pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setComprobanteToDB(PreparedStatement pst,Comprobante comp) throws SQLException{
        pst.setString(1, comp.getId());
        pst.setTimestamp(2, Timestamp.valueOf(comp.getFechaHora()));
        pst.setInt(3, comp.getPedido().getId());
        pst.setString(4, comp.getCliente().getId());
        pst.setString(5, comp.getEmpleado().getDni());
        pst.setInt(6, comp.getTipoComprobante());
    }
    
    
}
