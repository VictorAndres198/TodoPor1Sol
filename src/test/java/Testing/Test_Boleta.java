
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
        String lastIdComp = "003-0000009";
        String Header = lastIdComp.split("-[0]*")[0];
        char[] Body = lastIdComp.split("-")[1].toCharArray();

        String oldNumSec = lastIdComp.split("-[0]*")[1];
        int newNumSec = Integer.parseInt(oldNumSec)+1;
        if(oldNumSec.length()<String.valueOf(newNumSec).length()){
            /*
            si la longitud del numSecuencia antiguo es menor al nuevo
            entonces el numero aumentó en una cifra
            por consiguiente la cadena de 0's disminuye en 1
            para conservarse en 7 cifras*/
            Body=lastIdComp.split("-0")[1].toCharArray();
            System.out.println(lastIdComp.split("-0")[1].toCharArray());
        }
        
        
        String idComprobante = Header+"-";
        
        for(char c:Body){
            if(c=='0'){
               idComprobante+="0";
            }else{
                idComprobante+=String.valueOf(newNumSec);
                break;
            }
        }
        
        System.out.println("Resultado final: "+idComprobante);
        
        /*
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        DAOPedidos dao = new DAOPedidos();
        Pedido p = new Pedido(1, LocalDateTime.now(), new BigDecimal("29.77"), new BigDecimal("29.77"), new BigDecimal("29.77"));
        
        System.out.println("id recuperado: "+dao.Insert(p));
        */
        
    

    }
    
}
