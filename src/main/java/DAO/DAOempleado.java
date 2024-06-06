package DAO;
import Conexion.ConectarBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modelo.Empleado;
import Modelo.EmpleadoHorario;
import Modelo.Usuario;
import java.sql.DriverManager;
import java.sql.SQLException;

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
                empleado.setDni(rs.getString("DNI"));
                empleado.setNombre(rs.getString("Nombre"));
                empleado.setApellidos(rs.getString("Apellidos"));
                empleado.setCorreo(rs.getString("Correo"));
                empleado.setTelefono(rs.getString("Telefono"));
                empleado.setSueldo(rs.getBigDecimal("Sueldo"));
                empleado.setIdFarm(rs.getInt("ID_farm"));
                empleado.setIdHorario(rs.getInt("ID_Horario"));
            }
            
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return empleado;
    }
    
    public List<EmpleadoHorario> obtenerHorariosPorEmpleado(String dni) {
        List<EmpleadoHorario> empleadoHorarios = new ArrayList<>();
        ConectarBD conectarBD = new ConectarBD();
        Connection con = conectarBD.getConnection();
        
        try {
            String query = "SELECT e.Nombre, e.Apellidos, h.Fecha, h.Hentrada, h.Hsalida " +
                           "FROM horarios h " +
                           "INNER JOIN empleados e ON h.ID_HoraEmp = e.ID_Horario " +
                           "WHERE e.DNI = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                EmpleadoHorario empleadoHorario = new EmpleadoHorario();
                empleadoHorario.setNombre(rs.getString("Nombre"));
                empleadoHorario.setApellidos(rs.getString("Apellidos"));
                empleadoHorario.setFecha(rs.getDate("Fecha"));
                empleadoHorario.setHentrada(rs.getTime("Hentrada"));
                empleadoHorario.setHsalida(rs.getTime("Hsalida"));
                empleadoHorarios.add(empleadoHorario);
            }
            
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return empleadoHorarios;
    }
    
  public Usuario validarUsuario(String nombre, String clave) {
        ConectarBD conectarBD = new ConectarBD();
        Connection con = conectarBD.getConnection();
        Usuario usuario = null;

        try {
            String query = "SELECT * FROM usuarios WHERE nombre = ? AND clave = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, clave);
            
            // Registro de la consulta SQL ejecutada
            System.out.println("Ejecutando consulta SQL: " + query);
            System.out.println("Parámetros: nombre = " + nombre + ", clave = " + clave);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setDniEmpleado(rs.getString("DNI_empleado"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setClave(rs.getString("clave"));
                
                // Registro de los datos obtenidos de la base de datos
                System.out.println("Datos del usuario obtenidos de la base de datos:");
                System.out.println("nombre: " + usuario.getNombre());
                System.out.println("clave: " + usuario.getClave());
            } else {
                // Registro si no se encuentra ningún usuario con las credenciales proporcionadas
                System.out.println("No se encontró ningún usuario con los datos proporcionados.");
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            // Manejo de excepciones y registro de errores
            System.out.println("Error al ejecutar la consulta SQL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return usuario;
    }
    
    
public boolean probarConexionBD() {
    ConectarBD conectarBD = new ConectarBD();
    Connection con = conectarBD.getConnection();
    
    if (con != null) {
        System.out.println("Conexión exitosa a la base de datos.");
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
        }
        return true;
    } else {
        System.out.println("Error al conectar a la base de datos.");
        return false;
    }
}   
}
