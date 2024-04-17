
package dao;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionDB implements ParametrosBD{
    Connection conexion;   
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    public ConexionDB(){
        try {
            Class.forName(DRIVE);
            conexion = DriverManager.getConnection(RUTA,USUARIO,CLAVE);   
            st=conexion.createStatement();            
            JOptionPane.showMessageDialog(null, "Conexion Exitosa papu");
        } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos");
        }
    }
}
