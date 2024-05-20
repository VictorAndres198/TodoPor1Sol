
package Interfaces;

import java.util.ArrayList;
import Modelo.*;

public interface CRUDproductos {
    public ArrayList<Producto> ListarProductos();
    public Producto ObtenerProductos(String id);
    public boolean RegistrarProductos(Producto pro);
    public boolean EditarProductos(Producto pro);
    public boolean EliminarProductos(String id);
}
