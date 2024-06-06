package Conexion;

import java.sql.*;

public class ConectarBD implements Parametros {
    private Connection con;
    public PreparedStatement ps;           
    public Statement smt;
    public ResultSet rs;
    public String mensaje;
      
    public ConectarBD(){
       try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(RUTA, USUARIO, CLAVE);            
            smt = con.createStatement();
            mensaje="OK";
        }catch(ClassNotFoundException | SQLException ex){
            mensaje="ERROR";      
    }
    }
      
    public Connection getConnection(){
        return con;
    }
}
