
package Modelo;

import java.time.LocalDateTime;

public class Comprobante {
    private String id;
    private LocalDateTime fechaHora;
    private Pedido pedido;
    private Cliente cliente;
    private Empleado empleado;
    private int tipoComprobante;

    public Comprobante(String id, LocalDateTime fechaHora, Pedido pedido, Cliente cliente, Empleado empleado, int tipoComprobante) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.pedido = pedido;
        this.cliente = cliente;
        this.empleado = empleado;
        this.tipoComprobante = tipoComprobante;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(int tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    @Override
    public String toString() {
        return "Comprobante{" + "id=" + id + ",\n "
                + "fechaHora=" + fechaHora + ", \n"
                + "cliente=" + cliente + ",\n "
                + "empleado=" + empleado + ",\n"
                + "tipoComprobante=" + tipoComprobante + ",\n"
                + "pedido=" + pedido + '}';
    }
    
    
    
}
