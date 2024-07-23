
package Services;

import DAO.DAOItems;
import DAO.DAOPedidos;
import Interfaces.CrudRepository;
import Modelo.Item;
import Modelo.Pedido;
import java.util.List;


public class ServicePedidos{

    private DAOPedidos DAOPedido;
    private DAOItems DAOItem;

    //Injeccion de dependencia
    public ServicePedidos(){
        this.DAOPedido = new DAOPedidos();
        this.DAOItem = new DAOItems();
    }
    
    public List<Pedido> FindAll() {
        return DAOPedido.FindAll();
    }

    public List<Item> FindById(long id) {
        return DAOItem.FindById(id);
    }
    
    //al insertar el pedido retornamos el id del pedido insertado para usarlo
    //en el insert item e insert comprobante
    public long InsertPedido(Pedido ped){
        return DAOPedido.Insert(ped);
    }
    
    public void InsertItem(Item item,long idPedido){
        DAOItem.Insert(item, idPedido);
    }
    
    

    
}
