
package DAO;

import Conexion.ConectarBD;
import Interfaces.CrudRepository;
import Modelo.Pedido;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOPedidos implements CrudRepository<Pedido>{
    
    //Metodo para instanciar la cnx a la BD en cada ejecucion de los metodos crud
    private ConectarBD getCnx(){
        return new ConectarBD();
    }

    @Override
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

    @Override
    public Pedido FindById(long id) {
        return null;
    }

    @Override
    public void Insert(Pedido element) {
    }

    @Override
    public void Delete(long id) {
    }

    @Override
    public void Update(long id, Pedido element) {
    }
    
    
    //Metodo para crear un proveedor segun los resultados obtenidos de la consulta
    private Pedido getPedidoFromDB(ResultSet rs) throws SQLException{
        return new Pedido(
            rs.getInt("ID_Pedido"),
            rs.getTime("Fecha_Hora").toLocalTime().atDate(java.time.LocalDate.of(1970, 1, 1)),
            rs.getBigDecimal("PrecioTotal"), 
            rs.getBigDecimal("IGV"), 
            rs.getBigDecimal("Precio_Final"));  
    }
    
}
