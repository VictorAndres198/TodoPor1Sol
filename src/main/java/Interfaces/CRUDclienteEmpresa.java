
package Interfaces;

import Modelo.ClienteEmpresa;
import java.util.ArrayList;


public interface CRUDclienteEmpresa {
    public ArrayList<ClienteEmpresa> ListarCliEmpresa();
    public ClienteEmpresa ObtenerEmpleado(String ruc);
    public boolean Insert(ClienteEmpresa cliE);
    public boolean Update(ClienteEmpresa cliE);
    public boolean Delete(String ruc);
}
