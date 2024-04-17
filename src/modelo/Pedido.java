
package modelo;

import java.util.ArrayList;

public class Pedido {
    
    private ArrayList<Item> items;
    private Float subtotal;
    private Float igv;
    private Float precioFinal;

    public Pedido(ArrayList<Item> items, Float subtotal, Float igv, Float precioFinal) {
        this.items = items;
        this.subtotal = subtotal;
        this.igv = igv;
        this.precioFinal = precioFinal;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Float getIgv() {
        return igv;
    }

    public void setIgv(Float igv) {
        this.igv = igv;
    }

    public Float getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Float precioFinal) {
        this.precioFinal = precioFinal;
    }
    
    public Float calcularSubtotal(){
        return null;
    }
    
    public Float calcularIgv(){
        return null;
    }
    
    public Float calcularPrecioFinal(){
        return null;
    }
    
}
