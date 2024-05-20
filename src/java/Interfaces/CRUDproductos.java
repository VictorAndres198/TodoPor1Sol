
package Interfaces;

import java.util.ArrayList;
import Modelo.*;

public interface CRUDproductos {
    public ArrayList<Productos> ListarProductos();
    public Productos ObtenerProductos(String id);
    public boolean RegistrarProductos(Productos pro);
    public boolean EditarProductos(Productos pro);
    public boolean EliminarProductos(String id);
}
