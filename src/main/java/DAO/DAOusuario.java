package DAO;

import Conexion.ConectarBD;
import Interfaces.CRUDusuario;
import Modelo.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DAOusuario extends ConectarBD implements CRUDusuario {

    @Override
    public ArrayList<Usuario> ListarUsuario() {
        ArrayList<Usuario> lista = new ArrayList<>();
        String SQL = "SELECT * FROM usuarios where Estado='A';";
        try {
            ps = super.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setDniEmpleado(rs.getString("dniEmpleado"));
                usu.setNombre(rs.getString("nombre"));
                usu.setClave(rs.getString("clave"));
                lista.add(usu);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR al listar usuarios: " + ex);
        }
        return lista;
    }

    @Override
    public Usuario ObtenerUsuario(String dniEmpleado) {
        Usuario usu = null;
        String SQL = "SELECT * FROM usuarios WHERE dniEmpleado =? and Estado='A'";
        try {
            ps = super.getConnection().prepareStatement(SQL);
            ps.setString(1, dniEmpleado);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usu = new Usuario();
                usu.setDniEmpleado(rs.getString("dniEmpleado"));
                usu.setNombre(rs.getString("nombre"));
                usu.setClave(rs.getString("clave"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR al obtener usuario: " + ex);
        }
        return usu;
    }

    @Override
    public boolean Insert(Usuario usu) {
        String SQL = "INSERT INTO usuarios (dniEmpleado, nombre, clave, Estado) VALUES (?, ?, ?,'A');";
        try {
            ps = super.getConnection().prepareStatement(SQL);
            ps.setString(1, usu.getDniEmpleado()); // Obtiene el DNI del combo box
            ps.setString(2, usu.getNombre());
            ps.setString(3, usu.getClave());

            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede insertar usuario: " + ex);
        }
        return false;
    }

    @Override
    public boolean Update(Usuario usu) {
        String SQL = "UPDATE usuarios SET nombre = ?, clave = ? WHERE dniEmpleado = ?";
        try {
            ps = super.getConnection().prepareStatement(SQL);
            ps.setString(1, usu.getNombre());
            ps.setString(2, usu.getClave());
            ps.setString(3, usu.getDniEmpleado());
            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede actualizar usuario: " + ex);
        }
        return false;
    }

    @Override
    public boolean Delete(String dniEmpleado) {
        String SQL = "update usuarios set Estado='I' where dniEmpleado like ?";
        try {
            ps = super.getConnection().prepareStatement(SQL);
            ps.setString(1, dniEmpleado);
            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede eliminar usuario: " + ex);
        }
        return false;
    }
}
