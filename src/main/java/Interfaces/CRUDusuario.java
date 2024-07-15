
package Interfaces;

import Modelo.*;
import java.util.ArrayList;


public interface CRUDusuario {
    public ArrayList<Usuario> ListarUsuario();
    public Usuario ObtenerUsuario(String dniEmpleado);
    public boolean Insert(Usuario usu);
    public boolean Update(Usuario usu);
    public boolean Delete(String dniEmpleado);
    
}
