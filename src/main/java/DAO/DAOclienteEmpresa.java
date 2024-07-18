
package DAO;

import Conexion.ConectarBD;
import Interfaces.CRUDclienteEmpresa;
import Modelo.ClienteEmpresa;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Omar
 */
public class DAOclienteEmpresa extends ConectarBD implements CRUDclienteEmpresa {
    
    ClienteEmpresa cliEmp;

    @Override
    public ArrayList<ClienteEmpresa> ListarCliEmpresa() {
        ArrayList<ClienteEmpresa> lista = new ArrayList<>();
        String SQL = "SELECT * FROM cliente_empresa;";
        try {
            rs = smt.executeQuery(SQL);
            while (rs.next()) {
                cliEmp = new ClienteEmpresa();
                cliEmp.setRuc(rs.getString("RUC"));
                cliEmp.setRazonSocial(rs.getString("RazonSocial"));
                cliEmp.setDireccion(rs.getString("Direccion"));
                cliEmp.setTelefono(rs.getString("Telefono"));
                cliEmp.setCorreo(rs.getString("Correo"));
                lista.add(cliEmp);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al listar clientes empresa: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public ClienteEmpresa ObtenerEmpleado(String ruc) {
        String SQL = "SELECT * FROM cliente_empresa WHERE RUC = ?";
        try {
            ps = super.getConnection().prepareStatement(SQL);
            ps.setString(1, ruc);
            rs = ps.executeQuery();
            if (rs.next()) {
                cliEmp = new ClienteEmpresa();
                cliEmp.setRuc(rs.getString("RUC"));
                cliEmp.setRazonSocial(rs.getString("RazonSocial"));
                cliEmp.setDireccion(rs.getString("Direccion"));
                cliEmp.setTelefono(rs.getString("Telefono"));
                cliEmp.setCorreo(rs.getString("Correo"));
                return cliEmp;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al obtener cliente empresa: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean Insert(ClienteEmpresa cliE) {
        String SQL = "INSERT INTO cliente_empresa (RUC, RazonSocial, Direccion, Telefono, Correo) VALUES (?, ?, ?, ?, ?)";
        try {
            ps = super.getConnection().prepareStatement(SQL);
            ps.setString(1, cliE.getRuc());
            ps.setString(2, cliE.getRazonSocial());
            ps.setString(3, cliE.getDireccion());
            ps.setString(4, cliE.getTelefono());
            ps.setString(5, cliE.getCorreo());

            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al insertar cliente empresa: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean Update(ClienteEmpresa cliE) {
        String SQL = "UPDATE cliente_empresa SET RazonSocial = ?, Direccion = ?, Telefono = ?, Correo = ? WHERE RUC = ?";
        try {
            ps = super.getConnection().prepareStatement(SQL);
            ps.setString(1, cliE.getRazonSocial());
            ps.setString(2, cliE.getDireccion());
            ps.setString(3, cliE.getTelefono());
            ps.setString(4, cliE.getCorreo());
            ps.setString(5, cliE.getRuc());

            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar cliente empresa: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean Delete(String ruc) {
        String SQL = "DELETE FROM cliente_empresa WHERE RUC = ?";
        try {
            ps = super.getConnection().prepareStatement(SQL);
            ps.setString(1, ruc);

            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al eliminar cliente empresa: " + ex.getMessage());
        }
        return false;
    }
}