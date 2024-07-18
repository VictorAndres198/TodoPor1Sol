
package Interfaces;

import Modelo.cliente;
import java.util.ArrayList;

public interface CRUDcliente {
    public ArrayList<cliente> ListarCli();
    public cliente ObtenerCliente(int id);
    public boolean Insert(cliente cli);
    public boolean Update(cliente cli);
    public boolean Delete(int id);
}
