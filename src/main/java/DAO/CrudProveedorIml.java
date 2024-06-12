
package DAO;

import Interfaces.CrudRepository;
import Conexion.ConectarBD;
import Modelo.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CrudProveedorIml implements CrudRepository<Proveedor>{
     
    //Metodo para instanciar la cnx a la BD en cada ejecucion de los metodos crud
    private ConectarBD getCnx(){
        return new ConectarBD();
    }
    
   
    //Buscar Todos los Proveedores
    @Override
    public List<Proveedor> FindAll() {
        List<Proveedor> proveedores = new ArrayList<>();
        //Query a ejecutar
        String query = "SELECT * FROM proveedores;";
       
        try( Connection conn = getCnx().getConnection();
             Statement st = conn.createStatement()){
            
            //Ejecuta la busqueda
            st.execute(query);
            try(ResultSet rs = st.getResultSet()){
                while(rs.next()){
                    //Obtenemos los proveedores y los agregamos a la lista
                    proveedores.add(this.getProveedorFromDB(rs));
                }
            }
        } catch (Exception e) {
            return null;
        }
        return proveedores;
    }


    //Buscar Proveedor Por ID
    @Override
    public Proveedor FindById(long id) {
        //Query a ejecutar
        String action = "SELECT * FROM proveedores where RUC = (?);";
        Proveedor prov = null;
        
        try( Connection conn = getCnx().getConnection();
             PreparedStatement pst = conn.prepareStatement(action)){

            pst.setString(1, String.valueOf(id));
            
            try(ResultSet rs = pst.executeQuery()){
                if(rs.next()){
                    //Obtenemos al proveedor correspondiente
                    prov =  this.getProveedorFromDB(rs);       
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prov;
    }

    @Override
    public void Insert(Proveedor prov) {
        //Query a ejecutar
        String action = "INSERT INTO proveedores " +
                        "(RUC,Nombre,Pais,Telefono,Correo) " +
                        "VALUES (?,?,?,?,?);";
        
        try( Connection conn = getCnx().getConnection();
             PreparedStatement pst = conn.prepareStatement(action)){
            
            setProveedorToDB(pst, prov);
            pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void Delete(long id) {
                //Query a ejecutar
        String action = "DELETE FROM proveedores WHERE RUC = ?;";
        
        try( Connection conn = getCnx().getConnection();
             PreparedStatement pst = conn.prepareStatement(action)){
            
            
            pst.setString(1, String.valueOf(id));
            pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void Update(long id,Proveedor prov) {
        //Query a ejecutar
        String action = "UPDATE proveedores " +
                        "SET RUC=?,Nombre=?,Pais=?,Telefono=?,Correo=? " +
                        "WHERE RUC = ? ;";
        
        try( Connection conn = getCnx().getConnection();
             PreparedStatement pst = conn.prepareStatement(action)){
            
            this.setProveedorToDB(pst, prov);
            pst.setString(6,String.valueOf(id));
            pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    //Metodo para crear un proveedor segun los resultados obtenidos de la consulta
    private Proveedor getProveedorFromDB(ResultSet rs) throws SQLException{
        return new Proveedor(
            rs.getString("RUC"), 
            rs.getString("Nombre"), 
            rs.getString("Pais"), 
            rs.getString("Telefono"), 
            rs.getString("Correo"));  
    }
    
    private void setProveedorToDB(PreparedStatement pst,Proveedor prov) throws SQLException{
        pst.setString(1, prov.getRuc());
        pst.setString(2, prov.getNombre());
        pst.setString(3, prov.getPais());
        pst.setString(4, prov.getTelefono());
        pst.setString(5, prov.getCorreo());
        
    }
    
    
}
