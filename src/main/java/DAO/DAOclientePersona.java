
package DAO;

import Conexion.ConectarBD;
import Modelo.ClientePersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DAOclientePersona{
    
    //Metodo para instanciar la cnx a la BD en cada ejecucion de los metodos crud
    private ConectarBD getCnx(){
        return new ConectarBD();
    }
    
    
    public ClientePersona FindById(String id) {
        //Query a ejecutar
        String action = "SELECT * FROM cliente_personas WHERE DNI = (?);";
        ClientePersona cli = null;
        
        try( Connection conn = getCnx().getConnection();
             PreparedStatement pst = conn.prepareStatement(action)){

            pst.setString(1, String.valueOf(id));

            try(ResultSet rs = pst.executeQuery();){
                if(rs.next()){
                    //Obtenemos al proveedor correspondiente
                    cli =  this.getClienteFromDB(rs);       
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cli;
    }
    
  
    
    //Metodo para crear un proveedor segun los resultados obtenidos de la consulta
    private ClientePersona getClienteFromDB(ResultSet rs) throws SQLException{
        return new ClientePersona(
            rs.getString("DNI"), 
            rs.getString("Nombres"), 
            rs.getString("Apellidos"), 
            rs.getString("Telefono"), 
            rs.getString("Correo"));  
    }
}