
package Testing;

import DAO.CrudProveedorIml;
import Modelo.Proveedor;


public class Test_CRUD_Proveedor {
    public static void main(String[] args) {
        CrudProveedorIml crudProveedores = new CrudProveedorIml();
        String rucProv="2001928729";
        System.err.println("Existe el proveedor con Ruc = "+rucProv+" ?: "+crudProveedores.FindById(rucProv)); 
        
    }
    
}
