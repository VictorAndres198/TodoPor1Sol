
package DAO;

import Conexion.ConectarBD;
import Interfaces.CrudRepository;
import Modelo.Categoria;
import Modelo.Pedido;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOCategorias{
    
    //Metodo para instanciar la cnx a la BD en cada ejecucion de los metodos crud
    private ConectarBD getCnx(){
        return new ConectarBD();
    }

    public List<Categoria> FindAll() {
                List<Categoria> categorias = new ArrayList<>();
        //Query a ejecutar
        String query = "SELECT * FROM bdbotica.categorias;";
       
        try( Connection conn = getCnx().getConnection();
             Statement st = conn.createStatement()){
            
            //Ejecuta la busqueda
            st.execute(query);
            try(ResultSet rs = st.getResultSet()){
                while(rs.next()){
                    //Obtenemos los proveedores y los agregamos a la lista
                    categorias.add(this.getCategoriaFromDB(rs));
                }
            }
        } catch (Exception e) {
            return null;
        }
        return categorias;
    }
    
    //Metodo para crear un proveedor segun los resultados obtenidos de la consulta
    private Categoria getCategoriaFromDB(ResultSet rs) throws SQLException{
        return new Categoria(
            rs.getInt("ID_categoria"),
            rs.getString("Nombre"));  
    }
    
}
