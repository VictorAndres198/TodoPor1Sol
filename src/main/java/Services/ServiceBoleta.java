
package Services;

import DAO.CrudProveedorIml;
import DAO.DAOclientePersona;
import Interfaces.CrudRepository;
import Modelo.ClientePersona;
import Modelo.Proveedor;
import java.util.List;

public class ServiceBoleta{
    
    private DAOclientePersona daoCliPersona;

    //Injeccion de dependencia
    public ServiceBoleta() {
        this.daoCliPersona = new DAOclientePersona();
    }
    

    public ClientePersona FindCliPersonaById(String id) {
        return daoCliPersona.FindById(id);
    }
    
  
    
}
