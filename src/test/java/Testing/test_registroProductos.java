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
public class test_registroProductos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            // Formateador de fecha
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            // Convertir cadena a Date
            Date fechaVencimiento = dateFormat.parse("15/06/2024");
            
            // Crear un objeto Producto
            Producto produc = new Producto(3, "prednisona", "hola", fechaVencimiento, 123, 1, 1, "1100228989"); 
            DAOproductos  prod = new DAOproductos();
            
            
            prod.RegistrarProductos(produc);
            
            // Mostrar información del producto
            System.out.println("Producto: " + produc.getNombre() + ", Fecha de Vencimiento: " + dateFormat.format(produc.getFechaVencimiento()) );
            
       
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
        
     
       
    }
    

