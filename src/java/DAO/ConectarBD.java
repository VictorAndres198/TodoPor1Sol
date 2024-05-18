
package DAO;
/**
 *
 * @author Andres
 */
// Librerías
import java.sql.*;

public class ConectarBD implements Parametros {
    Connection conexion;   // Se asignan nombre de variable
    Statement st;
    ResultSet rs;
    PreparedStatement ps;

    public ConectarBD() {
        try {
            Class.forName(DRIVE);
            conexion = DriverManager.getConnection(RUTA, USUARIO, CLAVE);    // Se realiza la conexión
            st = conexion.createStatement();            
        } catch (Exception ex) {
           
            System.out.println("ERROR: NO SE PUEDE CONECTAR A LA BASE DE DATOS. " + ex);
        }
    }
}

