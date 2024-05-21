package DAO;
import Conexion.ConectarBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modelo.Empleado;
import Modelo.Horario;

public class DAOempleado {

    public Empleado obtenerEmpleadoPorDNI(String dni) {
        Empleado empleado = null;
        ConectarBD conectarBD = new ConectarBD();
        Connection con = conectarBD.getConnection();
        
        try {
            String query = "SELECT * FROM empleados WHERE DNI = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                empleado = new Empleado();
                empleado.setDni(rs.getInt("DNI"));
                empleado.setNombre(rs.getString("Nombre"));
                empleado.setApellidos(rs.getString("Apellidos"));
                // Asigna los demás campos
            }
            
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return empleado;
    }
    
    public List<Horario> obtenerHorariosPorEmpleado(String dni) {
        List<Horario> horarios = new ArrayList<>();
        ConectarBD conectarBD = new ConectarBD();
        Connection con = conectarBD.getConnection();
        
        try {
            String query = "SELECT h.* FROM horarios h INNER JOIN empleados e ON h.ID_HoraEmp = e.ID_Horario WHERE e.DNI = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Horario horario = new Horario();
                horario.setIdHoraEmp(rs.getInt("ID_HoraEmp"));
                horario.setFecha(rs.getDate("Fecha"));
                horario.setHentrada(rs.getTime("Hentrada"));
                horario.setHsalida(rs.getTime("Hsalida"));
                // Asigna los demás campos
                horarios.add(horario);
            }
            
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return horarios;
    }
}
