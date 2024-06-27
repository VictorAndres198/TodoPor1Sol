/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Testing;

import DAO.DAOproductos;
import Modelo.Producto;

/**
 *
 * @author Andres
 */
public class TestObtenerProducto {

    public static void main(String[] args) {
        // Supongamos que queremos probar obtener el producto con ID 1
        int idProducto = 2;

        // Crear una instancia del DAO de productos
        DAOproductos daoProductos = new DAOproductos();

        // Llamar al método obtenerProductos para obtener el producto por su ID
        Producto producto = daoProductos.obtenerProductos(idProducto);

        // Verificar si se encontró el producto
        if (producto != null) {
            System.out.println("Producto encontrado:");
            System.out.println("ID: " + producto.getID_Prod());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Descripción: " + producto.getDescripcion());
            System.out.println("Fecha de Vencimiento: " + producto.getFechaVencimiento());
            System.out.println("Stock: " + producto.getStock());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Proveedor: " + producto.getRuc());
            System.out.println("ID Categoría: " + producto.getID_categoria());
        } else {
            System.out.println("No se encontró ningún producto con ID " + idProducto);
        }
    }
    
}
