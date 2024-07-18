
package Modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Pedido {
    private int id;
    private LocalDateTime fechaHora;
    private BigDecimal PrecioTotal;
    private BigDecimal IGV;
    private BigDecimal PrecioFinal;
    private List<Item> Items = new ArrayList<>();

    public Pedido(int id, LocalDateTime fechaHora, BigDecimal PrecioTotal, BigDecimal IGV, BigDecimal PrecioFinal) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.PrecioTotal = PrecioTotal;
        this.IGV = IGV;
        this.PrecioFinal = PrecioFinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public BigDecimal getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(BigDecimal PrecioTotal) {
        this.PrecioTotal = PrecioTotal;
    }

    public BigDecimal getIGV() {
        return IGV;
    }

    public void setIGV(BigDecimal IGV) {
        this.IGV = IGV;
    }

    public BigDecimal getPrecioFinal() {
        return PrecioFinal;
    }

    public void setPrecioFinal(BigDecimal PrecioFinal) {
        this.PrecioFinal = PrecioFinal;
    }

    public List<Item> getItems() {
        return Items;
    }

    public void setItems(List<Item> Items) {
        this.Items = Items;
    }


    
}
