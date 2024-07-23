
package Modelo;

import java.math.BigDecimal;

public class Item {
    private int id;
    private Producto producto;
    private int cantidad;
    private BigDecimal subtotal;

    public Item(int id, Producto producto, int cantidad, BigDecimal subtotal) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public Item(Producto producto, int cantidad, BigDecimal subtotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", subtotal=" + subtotal + "}\n";
    }
    
    
}
