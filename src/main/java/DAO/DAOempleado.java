package DAO;
import Conexion.ConectarBD;
import Interfaces.CRUDempleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modelo.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Time;
import java.time.LocalTime;

public class DAOempleado extends ConectarBD implements CRUDempleado {
Empleado empleado;
Farmacias farm;


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
                LocalTime horarioE = (rs.getTime("horarioE")).toLocalTime();
                empleado.setHorarioE(horarioE);
                LocalTime horarioS = (rs.getTime("horarioS")).toLocalTime();
                empleado.setHorarioS(horarioS);
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
    
  public Usuario validarUsuario(String dni, String nombre, String clave) {
        ConectarBD conectarBD = new ConectarBD();
        Connection con = conectarBD.getConnection();
        Usuario usuario = null;

        try {
            String query = "SELECT * FROM usuarios WHERE DNI_empleado = ? AND nombre = ? AND clave = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, clave);
            
            // Registro de la consulta SQL ejecutada
            System.out.println("Ejecutando consulta SQL: " + query);
            System.out.println("Parámetros: dni = " + dni +", nombre = " + nombre + ", clave = " + clave);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setDniEmpleado(rs.getString("DNI_empleado"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setClave(rs.getString("clave"));
                
                // Registro de los datos obtenidos de la base de datos
                System.out.println("Datos del usuario obtenidos de la base de datos:");
                System.out.println("dni: " + usuario.getDniEmpleado());
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


    public DAOempleado(){}
    @Override
    public ArrayList<Empleado> ListarEmpleado() {
        ArrayList<Empleado> Lista = new ArrayList();
       String SQL = "SELECT * from empleados  where Estado='A';";
       try{
           rs = smt.executeQuery(SQL);
           while(rs.next()){
               empleado = new Empleado();
               empleado.setDni(rs.getString("DNI"));
               empleado.setNombre(rs.getString("Nombre"));
               empleado.setApellidos(rs.getString("Apellidos"));
               empleado.setCorreo(rs.getString("Correo"));
               empleado.setTelefono(rs.getString("Telefono"));
               empleado.setSueldo(rs.getBigDecimal("Sueldo"));
               empleado.setIdFarm(rs.getInt("ID_farm"));
               LocalTime horarioE = (rs.getTime("horarioE")).toLocalTime();
               empleado.setHorarioE(horarioE);
               LocalTime horarioS = (rs.getTime("horarioS")).toLocalTime();
               empleado.setHorarioS(horarioS);
               Lista.add(empleado);
           }
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null,
                   "ERROR no se puede recuperar los empleados.."+ex);
       }
       return Lista;  
    }
    
    


    @Override
    public Empleado ObtenerEmpleado(String dni) {
        String SQL = "select * from empleados where DNI=? and Estado='A'";
        try{
            ps = super.getConnection().prepareStatement(SQL);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            if(rs.next()){
               empleado = new Empleado();
               empleado.setDni(rs.getString("DNI"));
               empleado.setNombre(rs.getString("Nombre"));
               empleado.setApellidos(rs.getString("Apellidos"));
               empleado.setCorreo(rs.getString("Correo"));
               empleado.setTelefono(rs.getString("Telefono"));
               empleado.setSueldo(rs.getBigDecimal("Sueldo"));
               empleado.setIdFarm(rs.getInt("ID_farm"));
               LocalTime horarioE = (rs.getTime("horarioE")).toLocalTime();
               empleado.setHorarioE(horarioE);
               LocalTime horarioS = (rs.getTime("horarioS")).toLocalTime();
               empleado.setHorarioS(horarioS);
            }
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null,
                   "ERROR no se puede recuperar los Empleados.."+ex);
       }
       return empleado;
    }

    @Override
    public boolean Insert(Empleado emp) {
        String SQL = "insert into empleados values(?,?,?,?,?,?,?,?,?,'A');";
        try{
            ps = super.getConnection().prepareStatement(SQL);
            ps.setString(1,emp.getDni());
            ps.setString(2,emp.getNombre());
            ps.setString(3, emp.getApellidos());
            ps.setString(4, emp.getCorreo());
            ps.setString(5, emp.getTelefono());
            ps.setBigDecimal(6, emp.getSueldo());
            ps.setInt(7, emp.getIdFarm());
            Time HorarioE = Time.valueOf(emp.getHorarioE());
            ps.setTime(8, HorarioE);
            Time HorarioS = Time.valueOf(emp.getHorarioS());
            ps.setTime(9, HorarioS);
            ps.executeUpdate();
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null,
                   "ERROR no se puede insertar empleados.."+ex);
       }
        return false;
    }

    @Override
    public boolean Update(Empleado emp) {
    String SQL = "UPDATE empleados SET Nombre=?, Apellidos=?, Correo=?, Telefono=?, Sueldo=?, ID_farm=?, horarioE=?, horarioS=? WHERE DNI=?";
    
    try {
        ps = super.getConnection().prepareStatement(SQL);
        ps.setString(1, emp.getNombre());
        ps.setString(2, emp.getApellidos());
        ps.setString(3, emp.getCorreo());
        ps.setString(4, emp.getTelefono());
        ps.setBigDecimal(5, emp.getSueldo());
        ps.setInt(6, emp.getIdFarm());
        Time HorarioE = Time.valueOf(emp.getHorarioE());
        ps.setTime(7, HorarioE);
        Time HorarioS = Time.valueOf(emp.getHorarioS());
        ps.setTime(8, HorarioS);
        ps.setString(9, emp.getDni());
        
        ps.executeUpdate();
        // Retorna verdadero si al menos una fila fue actualizada
  }   catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, 
             "ERROR al actualizar empleado: " + ex);
        
    }return false;
}


    @Override
    public boolean Delete(String dni) {
        String SQL = "update empleados set Estado='I' where DNI like ?";
        try{
            ps= super.getConnection().prepareStatement(SQL);
            ps.setString(1, dni);
            ps.executeUpdate();
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null,
                              "ERROR no se puede eliminar empleado.."+ex);
       }
        return false;
    }//fin eliminar  




}

