/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Andres
 */
import java.time.LocalDate;
public class Productos {
    private  int ID_Prod ;
    private String Nombre; 
    private String Descripcion; 
    private LocalDate FechaVencimiento;
    private double precio;
    private int Stock;
    private int ID_categoria; 
    private String RUC_Prov;

    public Productos() {
    }

    public Productos(int ID_Prod, String Nombre, String Descripcion, LocalDate FechaVencimiento, double precio, int Stock, int ID_categoria, String RUC_Prov) {
        this.ID_Prod = ID_Prod;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.FechaVencimiento = FechaVencimiento;
        this.precio = precio;
        this.Stock = Stock;
        this.ID_categoria = ID_categoria;
        this.RUC_Prov = RUC_Prov;
    }

    public int getID_Prod() {
        return ID_Prod;
    }

    public void setID_Prod(int ID_Prod) {
        this.ID_Prod = ID_Prod;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public LocalDate getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getID_categoria() {
        return ID_categoria;
    }

    public void setID_categoria(int ID_categoria) {
        this.ID_categoria = ID_categoria;
    }

    public String getRUC_Prov() {
        return RUC_Prov;
    }

    public void setRUC_Prov(String RUC_Prov) {
        this.RUC_Prov = RUC_Prov;
    }
    
    
    
    
    
}
