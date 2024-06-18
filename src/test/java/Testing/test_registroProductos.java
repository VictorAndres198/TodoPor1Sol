package Testing;

import DAO.DAOproductos;
import Modelo.Producto;
import java.text.SimpleDateFormat;
import java.util.Date;
//PRUEBA DE INSERTAR REGISTROS EN LA TABLA PRODUCTOS
public class test_registroProductos {
    public static void main(String[] args) {
        // Crear una instancia de ProductoDAO
        DAOproductos productoDAO = new DAOproductos();

        // Formateador de fecha "CONVIERTE LA FECHA STRING A DATE"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaVencimiento = null;
        
        try {
            // Formatear fecha de vencimiento
            fechaVencimiento = sdf.parse("2025-12-31");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insertar productos
        Producto producto = new Producto( "Aspirina","Medicamento para el dolor de cabeza",fechaVencimiento,15.5,100,1,  "1112223334" );

        // Insertar el producto en la base de datos
        String resultado = productoDAO.insertarProducto(producto);
        System.out.println(resultado);
        

        
        
    }
}
