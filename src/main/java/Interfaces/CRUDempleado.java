
package Interfaces;

import Modelo.*;
import java.util.ArrayList;

public interface CRUDempleado {
    public ArrayList<Empleado> ListarEmpleado();
    public Empleado ObtenerEmpleado(String dni);
    public boolean Insert(Empleado emp);
    public boolean Update(Empleado emp);
    public boolean Delete(String dni);
}
