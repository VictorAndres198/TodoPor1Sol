
package Testing;

import DAO.CrudProveedorIml;
import Modelo.Proveedor;


public class Test_CRUD_Proveedor {
    public static void main(String[] args) {
        CrudProveedorIml crudProveedores = new CrudProveedorIml();
        
        System.out.println(crudProveedores.FindAll());
        
        System.out.println("\n"+crudProveedores.FindById(3242348234L));
        
//        Proveedor prov = new Proveedor("38219485", "Coney Park", "Mexico", "38420983", "con@gm.com");
//        crudProveedores.Insert(prov);
//        System.out.println("Comrpobando elemento agregado"+crudProveedores.FindAll());
//        
//        Proveedor provB = new Proveedor("5515022", "eMPT 2", "Luna", "213543", "em1@gm.com");
//        crudProveedores.Insert(provA);
//        crudProveedores.Insert(provB);
//        System.out.println("Comrpobando elementos agregados\n"+crudProveedores.FindAll());
        
//         crudProveedores.Delete(38219485);
        
        Proveedor provA = new Proveedor("6990882", "empresa 1", "Canada", "099172", "29ssq@gm.com");
         crudProveedores.Update(6990182,provA);
        System.out.println(crudProveedores.FindAll());
         
        
        
        
    }
    
}
