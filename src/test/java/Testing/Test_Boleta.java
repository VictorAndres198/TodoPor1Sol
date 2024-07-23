
package Testing;

import DAO.DAOComprobantes;
import DAO.DAOPedidos;
import DAO.DAOproductos;
import Modelo.ClientePersona;
import Modelo.Comprobante;
import Modelo.Pedido;
import Modelo.Producto;
import Services.ServiceBoleta;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Test_Boleta {
    public static void main(String[] args) {
        /*ServiceBoleta serviceBoleta = new ServiceBoleta();
        DAOproductos daoProductos = new DAOproductos();
        String id ="12";
        Producto p= daoProductos.obtenerProductoById(Integer.parseInt(id));
        System.out.println(p);*/
        
        // ESTO PARA GENERAR EL COD DEL COMPROBANTE
        String numBoleta = "003-0001309";
        String ultBoleta = numBoleta.split("-[0]*")[1];
        String ultBoleta2 = numBoleta.split("-[0]*")[0];
        System.out.println("Ultimo digito: "+ultBoleta);
        System.out.println("Ultimo digito: "+ultBoleta2);
        int value = Integer.parseInt(ultBoleta)+1;
        System.out.println("Nuevo digito: "+value);
        
        char[] BoletaBody = numBoleta.split("-")[1].toCharArray();
        String newBody = "003-";
        for(char c:BoletaBody){
            if(c=='0'){
               newBody+="0";
            }else{
                newBody+=String.valueOf(value);
                break;
            }
        }
        System.out.println("Resultado final: "+newBody);
        
        /*
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        DAOPedidos dao = new DAOPedidos();
        Pedido p = new Pedido(1, LocalDateTime.now(), new BigDecimal("29.77"), new BigDecimal("29.77"), new BigDecimal("29.77"));
        
        System.out.println("id recuperado: "+dao.Insert(p));
        */
        
    

    }
    
}
