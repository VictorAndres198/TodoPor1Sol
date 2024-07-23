
package Interfaces;

import Modelo.Cliente;
import java.util.ArrayList;

public interface CRUDcliente {
    public ArrayList<Cliente> ListarCli();
    public Cliente ObtenerCliente(int id);
    public boolean Insert(Cliente cli);
    public boolean Update(Cliente cli);
    public boolean Delete(int id);
}
