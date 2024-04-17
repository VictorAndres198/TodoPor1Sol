
package modelo;

public class Item {
    private Producto producto;
    private int cantidad;
    private Float subtotal;

    public Item(Producto producto, int cantidad, Float subtotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
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

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }
    
    public Float calcularSubtotal(Producto prod,int cant){
        return null;
    }
}
