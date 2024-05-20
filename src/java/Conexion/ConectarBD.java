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
                Class.forName(DRIVE);
                con = DriverManager.getConnection(RUTA, USUARIO, CLAVE);            
                smt = con.createStatement();
                mensaje="Conexion OK!!!!";
            }catch(Exception ex){
                mensaje="ERROR al conectar base de datos";      
       }
     }
     public Connection getConnection(){
        return con;
    }
}
