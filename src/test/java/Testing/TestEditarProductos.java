/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Testing;

import DAO.DAOproductos;
import Modelo.Producto;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Andres
 */
public class TestEditarProductos {

    /**
     * @param args the command line arguments
     */
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
        Producto producto = new Producto( 4,"PARACETAMOL MAX","Medicamento para el dolor de cabeza",fechaVencimiento,15.5,100,1,  "1112223334" );

        // Insertar el producto en la base de datos
        String resultado = productoDAO.ActualizarProductos(producto);
        System.out.println(resultado);
        
        
        
        
        
        
        
        
        
    }
    
}
