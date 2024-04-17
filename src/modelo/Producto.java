
package modelo;

import java.time.LocalDate;


public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private LocalDate fVencimiento;
    private Float precio;
    private int Stock;
    private Provedor rucProovedor;

    public Producto(int id, String nombre, String descripcion, LocalDate fVencimiento, 
            Float precio, int Stock, Provedor rucProovedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fVencimiento = fVencimiento;
        this.precio = precio;
        this.Stock = Stock;
        this.rucProovedor = rucProovedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getfVencimiento() {
        return fVencimiento;
    }

    public void setfVencimiento(LocalDate fVencimiento) {
        this.fVencimiento = fVencimiento;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public Provedor getRucProovedor() {
        return rucProovedor;
    }

    public void setRucProovedor(Provedor rucProovedor) {
        this.rucProovedor = rucProovedor;
    }

    
    public LocalDate calucloVencimiento(LocalDate fecha){
        return null;
    }

}
