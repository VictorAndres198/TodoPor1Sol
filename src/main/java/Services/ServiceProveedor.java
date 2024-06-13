
package Services;

import DAO.CrudProveedorIml;
import Interfaces.CrudRepository;
import Modelo.Proveedor;
import java.util.List;

public class ServiceProveedor implements WebService<Proveedor>{
    
    private CrudRepository<Proveedor> crudProveedor;

    //Injeccion de dependencia
    public ServiceProveedor() {
        this.crudProveedor = new CrudProveedorIml();
    }
    
    @Override
    public List<Proveedor> FindAll() {
        return crudProveedor.FindAll();
    }

    @Override
    public Proveedor FindById(long id) {
        return crudProveedor.FindById(id);
    }
    
    public boolean FindById(String id) {
        return ((CrudProveedorIml)crudProveedor).FindById(id);
    }

    @Override
    public void Insert(Proveedor prov) {
        crudProveedor.Insert(prov);
    }

    @Override
    public void Delete(long id) {
        crudProveedor.Delete(id);
    }

    @Override
    public void Update(long id,Proveedor prov) {
        crudProveedor.Update(id, prov);
    }
    
}
