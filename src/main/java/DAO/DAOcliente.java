
package DAO;

import Conexion.ConectarBD;
import Interfaces.CRUDcliente;
import Modelo.cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


public class DAOcliente extends ConectarBD implements CRUDcliente {
cliente cli;
    @Override
    public ArrayList<cliente> ListarCli() {
        ArrayList<cliente> lista = new ArrayList<>();
        String SQL = "SELECT * FROM clientes;";
        try {
            rs = smt.executeQuery(SQL);
            while (rs.next()) {
                cli = new cliente();
                cli.setId(rs.getInt("ID"));
                lista.add(cli);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR al listar usuarios: " + ex);
        }
        return lista;
    }

    

    @Override
    public cliente ObtenerCliente(int id) {
    String SQL = "SELECT * FROM cliente WHERE id =? ";
        try {
            ps = super.getConnection().prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                cli = new cliente();
                cli.setId(rs.getInt("ID"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR al obtener usuario: " + ex);
        }
        return cli;

    }

    @Override
    public boolean Insert(cliente cli) {
        String SQL = "INSERT INTO cliente (ID) VALUES (?);";
        try {
            ps = super.getConnection().prepareStatement(SQL);
            ps.setInt(1, cli.getId()); 
            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede insertar usuario: " + ex);
        }
        return false;
        
    }

    @Override
    public boolean Update(cliente cli) {
        String SQL = "UPDATE cliente SET ID = ? WHERE ID = ?";
        try {
            ps = super.getConnection().prepareStatement(SQL);
            ps.setInt(1, cli.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede actualizar cliente: " + ex);
        }
        return false;
    }

    @Override
    public boolean Delete(int id) {
        String SQL = "delete ID from clientes where ID= ?";
        try {
            ps = super.getConnection().prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede eliminar usuario: " + ex);
        }
        return false;
    }
}    

