
package Services;

import DAO.DAOCategorias;
import DAO.DAOComprobantes;
import DAO.DAOclientePersona;
import DAO.DAOempleado;
import DAO.DAOproductos;
import Modelo.Categoria;
import Modelo.ClientePersona;
import Modelo.Comprobante;
import Modelo.Empleado;
import Modelo.Producto;
import java.util.List;


public class ServiceBoleta{
    
    private DAOclientePersona daoCliPersona;
    private DAOCategorias daoCategorias;
    private DAOproductos daoProductos;
    private DAOempleado daoEmpleados;
    private DAOComprobantes daoComprobantes;
    
    
    /*
    ServicePedidos(daoPedidos daoItems)
    */

    //Injeccion de dependencia
    public ServiceBoleta() {
        this.daoCliPersona = new DAOclientePersona();
        this.daoCategorias = new DAOCategorias();
        this.daoProductos = new DAOproductos();
        this.daoEmpleados = new DAOempleado();
        this.daoComprobantes = new DAOComprobantes();
    }
    

    public ClientePersona FindCliPersonaById(String id) {
        return daoCliPersona.FindById(id);
    }
    

    public List<Categoria> FindCategorias(){
        return daoCategorias.FindAll();
    }

    public List<Producto> FindProducts(int id){
        return daoProductos.ListarProductosByCategoria(id);
    }

    public Producto FindProductInfo(int id){
        return daoProductos.obtenerProductoById(id);
    }
    
    public Empleado FindEmpleado(String dni){
        return daoEmpleados.obtenerEmpleadoPorDNI(dni);
    }
    
    public void InsertBoleta(Comprobante comp){
        //al insertar BOLETA el tipoComprobante ES 1
        daoComprobantes.Insert(comp);
    }

    public String CalcIdComprobante(){
        return daoComprobantes.FindLastComprobante();
    }
}
